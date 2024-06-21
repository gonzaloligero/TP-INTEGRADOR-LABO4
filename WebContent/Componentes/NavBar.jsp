<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg bg-azul py-0 fw-bold">
    <a class="navbar-brand ms-3 py-0" href="#">
        <i class="bi bi-bank fs-1 "></i> ITBank
    </a>
    <div class="collapse navbar-collapse py-0 fw-bold" id="navbarNav">
        <ul class="navbar-nav me-auto">
            <li class="nav-item ">
                <a class="btn bg-azul py-3 px-4 d-block text-center fw-bold" disabled href="#">Servicios</a>
            </li>
        </ul>
        <ul class="navbar-nav ms-auto">
                    <% if (session.getAttribute("sessionLogin") == null) { %>
                        <!-- Si no hay usuario en sesión (no logueado) -->
                       
                        <li class="nav-item me-3">
                            <a class="btn bg-azul fw-bold" href="Login.jsp"> <i class="bi bi-person fs-4"></i> Ingresar</a>
                        </li>
                    <% } else { %>
                        <!-- Si hay usuario en sesión (logueado) -->
                        <li class="nav-item me-3">
                            <a class="btn bg-azul fw-bold" href=""> <i class="bi bi-person fs-4"></i> Cliente</a>
                        </li>
                        <li class="nav-item me-3">
                            <a class="btn bg-azul fw-bold" href="MenuAdministrador.jsp"> <i class="bi bi-person fs-4"></i> Admin</a>            
                        </li>
                    <% } %>
                </ul>
    </div>
</nav>
