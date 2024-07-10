<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg bg-azul py-0 fw-bold">
    <a class="navbar-brand ms-3 py-0" href="#">
        <i class="bi bi-bank fs-1"></i> ITBank
    </a>
    <div class="collapse navbar-collapse py-0 fw-bold" id="navbarNav">
        <ul class="navbar-nav me-auto">
            <!-- Otras opciones de navegaci�n si las hay -->
        </ul>
        <ul class="navbar-nav ms-auto">
            <% if (session.getAttribute("sessionLogin") == null) { %>
                <!-- Si no hay usuario en sesi�n (no logueado) -->
                <li class="nav-item me-3">
                    <a class="btn bg-azul fw-bold" href="Login.jsp"> <i class="bi bi-person fs-4"></i> Ingresar</a>
                </li>
            <% } else { %>
                <!-- Si hay usuario en sesi�n (logueado) -->
                <li class="nav-item me-3">
                    <a class="btn bg-azul fw-bold" href="Login.jsp"> <i class="bi bi-box-arrow-right fs-4"></i> Salir</a>
                </li>
            <% } %>
        </ul>
    </div>
</nav>
