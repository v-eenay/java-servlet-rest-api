package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/TodoApp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // Establish connection to the database
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // CREATE: Add a new Todo to the database
    public static boolean addTodo(Todo todo) {
        String query = "INSERT INTO todos (title, description, priority, due_date, completed) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setString(3, todo.getPriority());
            stmt.setDate(4, todo.getDueDate());
            stmt.setBoolean(5, todo.isCompleted());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // READ: Get all todos from the database
    public static List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        String query = "SELECT * FROM todos";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Todo todo = new Todo(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("priority"),
                        rs.getDate("due_date"),
                        rs.getBoolean("completed"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }
    public static Todo getTodoById(int id) {
        String query = "SELECT * FROM todos WHERE id=?";
        try(Connection conn = getConnection();){
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Todo todo = new Todo(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("priority"),
                        rs.getDate("due_date"),
                        rs.getBoolean("completed"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                return todo;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    // UPDATE: Modify an existing Todo
    public static boolean updateTodo(Todo todo) {
        String query = "UPDATE todos SET title = ?, description = ?, priority = ?, due_date = ?, completed = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, todo.getTitle());
            stmt.setString(2, todo.getDescription());
            stmt.setString(3, todo.getPriority());
            stmt.setDate(4, todo.getDueDate());
            stmt.setBoolean(5, todo.isCompleted());
            stmt.setInt(6, todo.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE: Remove a Todo from the database
    public static boolean deleteTodo(int id) {
        String query = "DELETE FROM todos WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // MARK TODO as completed or pending (Toggle Status)
    public static boolean toggleStatus(int id) {
        String query = "UPDATE todos SET completed = NOT completed WHERE id = ?";
        String query1 = "select completed from todos where id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Connection conn = getConnection()){
            PreparedStatement statement = conn.prepareStatement(query1);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("completed"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}
