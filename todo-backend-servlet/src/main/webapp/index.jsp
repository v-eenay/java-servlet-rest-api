<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Server Started Successfully</title>
  <!-- Include Poppins font from Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <!-- Include Tailwind CSS -->
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  <style>
    /* Custom animations */
    .animate-glow {
      animation: glow 2s ease-in-out infinite alternate;
    }

    .animate-bounce {
      animation: bounce 1.5s infinite;
    }

    .animate-fadeIn {
      animation: fadeIn 1s ease-in 0.5s forwards;
    }

    @keyframes glow {
      from {
        text-shadow: 0 0 10px #60a5fa, 0 0 20px #60a5fa, 0 0 30px #60a5fa;
      }
      to {
        text-shadow: 0 0 20px #60a5fa, 0 0 30px #60a5fa, 0 0 40px #60a5fa;
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

    /* Particle styles */
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
      background: #60a5fa; /* Light blue to match Tailwind's blue palette */
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
<body class="font-poppins bg-gray-50 flex justify-center items-center min-h-screen p-5">
<!-- Container with Tailwind styling -->
<div class="bg-white shadow-md rounded-lg p-8 max-w-md w-full text-center">
  <!-- Success icon -->
  <div class="text-green-500 text-8xl mb-4 animate-bounce">✓</div>
  <!-- Heading -->
  <h1 class="text-gray-800 font-semibold text-4xl mb-4 animate-glow">Server Started Successfully</h1>
  <!-- Status text -->
  <div class="text-gray-600 text-xl animate-fadeIn">System is now operational</div>
</div>

<!-- Particle background -->
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