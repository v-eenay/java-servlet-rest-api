<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Server Started Successfully</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      background: linear-gradient(45deg, #1a1a2e, #16213e);
      font-family: 'Arial', sans-serif;
    }

    .container {
      text-align: center;
      padding: 40px;
      background: rgba(255, 255, 255, 0.05);
      border-radius: 20px;
      box-shadow: 0 0 30px rgba(0, 255, 152, 0.2);
      backdrop-filter: blur(10px);
      border: 1px solid rgba(255, 255, 255, 0.1);
    }

    h1 {
      color: #00ff98;
      font-size: 48px;
      margin: 0;
      text-transform: uppercase;
      letter-spacing: 2px;
      animation: glow 2s ease-in-out infinite alternate;
    }

    .success-icon {
      font-size: 100px;
      color: #00ff98;
      margin-bottom: 20px;
      animation: bounce 1.5s infinite;
    }

    .status-text {
      color: #ffffff;
      font-size: 24px;
      margin-top: 20px;
      opacity: 0;
      animation: fadeIn 1s ease-in 0.5s forwards;
    }

    /* Animations */
    @keyframes glow {
      from {
        text-shadow: 0 0 10px #00ff98, 0 0 20px #00ff98, 0 0 30px #00ff98;
      }
      to {
        text-shadow: 0 0 20px #00ff98, 0 0 30px #00ff98, 0 0 40px #00ff98;
      }
    }

    @keyframes bounce {
      0%, 20%, 50%, 80%, 100% {
        transform: translateY(0);
      }
      40% {
        transform: translateY(-30px);
      }
      60% {
        transform: translateY(-15px);
      }
    }

    @keyframes fadeIn {
      from {
        opacity: 0;
        transform: translateY(20px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    /* Particle Background */
    .particles {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      pointer-events: none;
      z-index: -1;
    }

    .particle {
      position: absolute;
      background: #00ff98;
      border-radius: 50%;
      opacity: 0.3;
      animation: float 15s infinite;
    }

    @keyframes float {
      0% {
        transform: translateY(100vh) scale(0);
      }
      100% {
        transform: translateY(-10vh) scale(1);
        opacity: 0;
      }
    }
  </style>
</head>
<body>
<div class="container">
  <div class="success-icon">✓</div>
  <h1>Server Started Successfully</h1>
  <div class="status-text">System is now operational</div>
</div>

<div class="particles">
  <% for(int i = 0; i < 20; i++) { %>
  <div class="particle"
       style="left: <%= (int)(Math.random() * 100) %>%;
               width: <%= (int)(Math.random() * 5 + 2) %>px;
               height: <%= (int)(Math.random() * 5 + 2) %>px;
               animation-delay: <%= (int)(Math.random() * 10) %>s;">
  </div>
  <% } %>
</div>
</body>
</html>