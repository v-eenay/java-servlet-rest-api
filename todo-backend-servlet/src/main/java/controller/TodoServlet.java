package controller;

import model.Todo;
import model.TodoDAO;
import com.google.gson.Gson;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.sql.Date;
import java.util.List;

@WebServlet("/api/todos")
public class TodoServlet extends HttpServlet {

    private static final Gson gson = new Gson();

    // GET: Fetch all todos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Todo> todos = TodoDAO.getAllTodos();
        String jsonResponse = gson.toJson(todos);

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);
    }

    // POST: Add a new todo
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Get the todo data from request body
        Todo todo = gson.fromJson(request.getReader(), Todo.class);

        boolean success = TodoDAO.addTodo(todo);
        if (success) {
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("{\"message\": \"Todo added successfully\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"Failed to add Todo\"}");
        }
    }

    // PUT: Update an existing todo
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Get the todo data from request body
        Todo todo = gson.fromJson(request.getReader(), Todo.class);

        boolean success = TodoDAO.updateTodo(todo);
        if (success) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Todo updated successfully\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"Failed to update Todo\"}");
        }
    }

    // DELETE: Delete a todo by ID
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        boolean success = TodoDAO.deleteTodo(id);
        if (success) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Todo deleted successfully\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"Failed to delete Todo\"}");
        }
    }

    // PATCH: Toggle the completion status of a todo
    @Override
    protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        boolean success = TodoDAO.toggleStatus(id);
        if (success) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Todo status toggled successfully\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"message\": \"Failed to toggle Todo status\"}");
        }
    }
}