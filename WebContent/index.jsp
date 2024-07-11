<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> ITBank </title>

  <link rel="stylesheet" type="text/css" href="CSS//bootstrap.css" />

  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <link href="CSS/font-awesome.min.css" rel="stylesheet" />

  <link href="CSS/style2.css" rel="stylesheet" />
  <link href="CSS/responsive.css" rel="stylesheet" />

</head>

<body>

  <div class="hero_area">

    <div class="hero_bg_box">
      <div class="bg_img_box">
        <img src="images/hero-bg.png" alt="">
      </div>
    </div>

    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
            <span>
              ITBank 
            </span>
          </a>
          

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class=""> </span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  ">
              <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#Nosotros"> Sobre Nosotros</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#Servicios">Servicios</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#Clientes">Clientes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#team_java">Team</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="Login.jsp"> <i class="fa fa-user" aria-hidden="true"></i> Login</a>
              </li>
              <form class="form-inline">
                <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                  <i class="fa fa-search" aria-hidden="true"></i>
                </button>
              </form>
            </ul>
          </div>
        </nav>
      </div>
    </header>

    <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">
              <div class="row">
                <div class="col-md-6 ">
                  <div class="detail-box">
                    <h1>
                      Software <br>
                      ITBank
                    </h1>
                    <p>
                      Para la gestión integral de tu banco, te presentamos nuestro software, el cual ofrece a tus clientes la funcionalidad de Home Banking, permitiéndoles realizar una amplia variedad de operaciones de manera fácil y segura
                    </p>
                    
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/slider-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item ">
            <div class="container ">
              <div class="row">
                <div class="col-md-6 ">
                  <div class="detail-box">
                    <h1>
                      Pedi tu préstamo<br>
                      ITBank
                    </h1>
                    <p>
                      Solicita tu préstamo hoy mismo y descubrí cómo nuestro software puede ayudarte a cumplir tu sueño.
                    </p>
                    
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/slider2-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container ">
              <div class="row">
                <div class="col-md-6 ">
                  <div class="detail-box">
                    <h1>
                      Una bienvenida a tus cuentas <br>
                      
                    </h1>
                    <p>
                      Para la gestión integral de tus cuentas, te presentamos nuestro software. Solicitá unirte a IT Bank y recibí $10.000 de bienvenida.
                    </p>
                    
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/slider3-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <ol class="carousel-indicators">
          <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
          <li data-target="#customCarousel1" data-slide-to="1"></li>
          <li data-target="#customCarousel1" data-slide-to="2"></li>
        </ol>
      </div>

    </section>
  </div>


 

  <section class="service_section layout_padding">
    <div class="service_container" id="Servicios">
      <div class="container ">
        <div class="heading_container heading_center">
          <h2>
            Nuestro <span>Servicios</span>
          </h2>
          <p>
            El software ITBank se personaliza segun las necesidades de nuestros clientes
          </p>
        </div>
        <div class="row">
          <div class="col-md-4 ">
            <div class="box ">
              <div class="img-box">
                <img src="images/s1.png" alt="">
              </div>
              <div class="detail-box">
                <h5>
                  Cuentas Bancarias
                </h5>
                <p>
                  Cada cliente puede gestionar sus cuentas, solicitar préstamos, realizar transferencias y mucho más. ¡Solicita tu cuenta hoy mismo!
                </p>
                
              </div>
            </div>
          </div>
          <div class="col-md-4 ">
            <div class="box ">
              <div class="img-box">
                <img src="images/s2.png" alt="">
              </div>
              <div class="detail-box">
                <h5>
                  Seguridad
                </h5>
                <p>
                  Fue realizado por Alumnos de la carrera de Programacion de la UTN, para la Materia Laboratorio 4. Descubrí la experiencia de IT Bank.
                </p>
                
              </div>
            </div>
          </div>
          <div class="col-md-4 ">
            <div class="box ">
              <div class="img-box">
                <img src="images/s3.png" alt="">
              </div>
             <div class="detail-box">
  <h5>
    Soporte Experto
  </h5>
  <p>
    Nuestros expertos están disponibles para brindarte apoyo y resolver tus dudas, asegurando una experiencia fluida y eficiente.
  </p>
  
</div>

            </div>
          </div>
        </div>
        
      </div>
    </div>
  </section>



<section class="about_section layout_padding">
  <div class="container" id="Nosotros">
    <div class="heading_container heading_center">
      <h2>
        Sobre <span>Nosotros</span>
      </h2>
      <p>
        En ITBank, nos dedicamos a ofrecer soluciones bancarias innovadoras y seguras para optimizar la gestión de tus finanzas.
      </p>
    </div>
    <div class="row">
      <div class="col-md-6">
        <div class="img-box">
          <img src="images/about-img.png" alt="">
        </div>
      </div>
      <div class="col-md-6">
        <div class="detail-box">
          <h3>
            Somos ITBank
          </h3>
          <p>
            En ITBank, ofrecemos una amplia variedad de soluciones financieras diseñadas para satisfacer tus necesidades. Nos comprometemos a proporcionar un servicio de alta calidad, con la transparencia y seguridad que mereces.
          </p>
          <p>
            Nuestro equipo de expertos está listo para ayudarte a alcanzar tus objetivos financieros, ofreciendo asesoría personalizada y un soporte continuo.
          </p>
          
        </div>
      </div>
    </div>
  </div>
</section>




  <section class="why_section layout_padding">
    <div class="container">
        <div class="heading_container heading_center">
            <h2>
                Por qué elegir <span>IT Bank</span>
            </h2>
        </div>
        <div class="why_container">
            <div class="box">
                <div class="img-box">
                    <img src="images/w1.png" alt="">
                </div>
                <div class="detail-box">
                    <h5>
                        Experiencia
                    </h5>
                    <p>
                        Nuestro equipo de gestión está compuesto por expertos con años de experiencia en la industria financiera. Nos aseguramos de que cada decisión esté bien informada y orientada a maximizar el valor para nuestros clientes. Con nosotros, tu dinero está en manos seguras y profesionales.
                    </p>
                </div>
            </div>
            <div class="box">
                <div class="img-box">
                    <img src="images/w2.png" alt="">
                </div>
                <div class="detail-box">
                    <h5>
                        Seguridad
                    </h5>
                    <p>
                        Ofrecemos oportunidades de inversión seguras y confiables, diseñadas para proteger tu capital mientras generas rendimientos significativos. Nuestro enfoque en la seguridad y la estabilidad te brinda la tranquilidad que necesitas para invertir con confianza.
                    </p>
                </div>
            </div>
            <div class="box">
                <div class="img-box">
                    <img src="images/w3.png" alt="">
                </div>
                <div class="detail-box">
                    <h5>
                        Transacciones
                    </h5>
                    <p>
                        Con nuestras plataformas de trading instantáneo, puedes realizar transacciones rápidamente y sin complicaciones. Ya sea que estés comprando o vendiendo, nuestra tecnología avanzada asegura que tus operaciones se ejecuten al instante y con precisión.
                    </p>
                </div>
            </div>
            <div class="box">
                <div class="img-box">
                    <img src="images/w4.png" alt="">
                </div>
                <div class="detail-box">
                    <h5>
                        Clientes
                    </h5>
                    <p>
                        La satisfacción de nuestros clientes es nuestra mayor prioridad. Nos enorgullecemos de ofrecer un servicio excepcional y de construir relaciones duraderas basadas en la confianza y el respeto. Escuchamos tus necesidades y trabajamos incansablemente para superar tus expectativas.
                    </p>
                </div>
            </div>
        </div>
        
    </div>
</section>


  <section class="team_section layout_padding">
    <div class="container-fluid" id="team_java">
      <div class="heading_container heading_center">
        <h2 class="">
          Nuestro <span> Team Operación Java</span>
        </h2>
      </div>

      <div class="team_container">
    <div class="row justify-content-center">
        <div class="col-lg-2 col-sm-6">
            <div class="box">
                <div class="img-box">
                    <img src="images/team-1.jpg" class="img1" alt="">
                </div>
                <div class="detail-box">
                    <h5>Gonzalo Ligero</h5>
                    <p>Programador UTN</p>
                </div>
                <div class="social_box">
                    <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-2 col-sm-6">
            <div class="box">
                <div class="img-box">
                    <img src="images/team-2.jpg" class="img1" alt="">
                </div>
                <div class="detail-box">
                    <h5>Emmanuel Dearmas</h5>
                    <p>Programador UTN</p>
                </div>
                <div class="social_box">
                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-2 col-sm-6">
            <div class="box">
                <div class="img-box">
                    <img src="images/team-4.jpg" class="img1" alt="">
                </div>
                <div class="detail-box">
                    <h5>Ariel Rodriguez</h5>
                    <p>Programador UTN</p>
                </div>
                <div class="social_box">
                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-2 col-sm-6">
            <div class="box">
                <div class="img-box">
                    <img src="images/team-3.jpg" class="img1" alt="">
                </div>
                <div class="detail-box">
                    <h5>Maximiliano Soria</h5>
                    <p>Programador UTN</p>
                </div>
                <div class="social_box">
                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
        <div class="col-lg-2 col-sm-6">
            <div class="box">
                <div class="img-box">
                    <img src="images/team-5.jpg" class="img1" alt="">
                </div>
                <div class="detail-box">
                    <h5>Gaston Garcia</h5>
                    <p>Programador UTN</p>
                </div>
                <div class="social_box">
                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
    </div>
</div>
      
    </div>
  </section>


  <section class="client_section layout_padding" id="Clientes">
    <div class="container">
      <div class="heading_container heading_center psudo_white_primary mb_45">
        <h2>
          Nuestros Clientes <span>Que confiaron en nuestro Software</span>
        </h2>
      </div>
      <div class="carousel-wrap ">
        <div class="owl-carousel client_owl-carousel">
          <div class="item">
            <div class="box">
              <div class="img-box">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFZmuHKpMH0xCoJ7T0pW_d5idFXwZezdqNZg&s" alt="" class="box-img">
              </div>
              <div class="detail-box">
                <div class="client_id">
                  <div class="client_info">
                    <h6>
                      Lionel Messi
                    </h6>
                    <p>
                      Jugador legendario de fútbol
                    </p>
                  </div>
                  <i class="fa fa-quote-left" aria-hidden="true"></i>
                </div>
                <p>
                  Mi vida cambió desde el momento en que conocí este servicio. Su equipo de desarrollo es más fuerte que la defensa del Barcelona de Guardiola. Agradezco en especial al muchacho Ariel por sus clases de tenis </p>
              </div>
            </div>
          </div>
          <div class="item">
            <div class="box">
              <div class="img-box">
                <img src="images/client2.jpg" alt="" class="box-img">
              </div>
              <div class="detail-box">
                <div class="client_id">
                  <div class="client_info">
                    <h6>
                      Carlos Javier
                    </h6>
                    <p>
                      Profesor de Laboratorio 4
                    </p>
                  </div>
                  <i class="fa fa-quote-left" aria-hidden="true"></i>
                </div>
                <p>
                 Desde que empezamos a usar el software de ITBank, la gestión de nuestras cuentas bancarias ha sido mucho más eficiente y segura. Nos encanta la facilidad de uso y la atención personalizada que recibimos. </p>
              </div>
            </div>
          </div>
          <div class="item">
            <div class="box">
              <div class="img-box">
                <img src="images/client1.jpg" alt="" class="box-img">
              </div>
              <div class="detail-box">
                <div class="client_id">
                  <div class="client_info">
                    <h6>
                      Tamara Herrera
                    </h6>
                    <p>
                      Profesora de Laboratorio 4
                    </p>
                  </div>
                  <i class="fa fa-quote-left" aria-hidden="true"></i>
                </div>
                <p>
                 El HomeBanking de ITBank ha transformado la forma en que manejamos nuestras finanzas. Las transferencias y solicitudes de préstamos son rápidas y sencillas, y el soporte técnico siempre está disponible para ayudarnos </p>
              </div>
            </div>
          </div>
          <div class="item">
            <div class="box">
              <div class="img-box">
                <img src="https://www.clarin.com/img/2024/03/27/3NmJkWINw_600x600__1.jpg" alt="" class="box-img">
              </div>
              <div class="detail-box">
                <div class="client_id">
                  <div class="client_info">
                    <h6>
                      Guillermo Francella
                    </h6>
                    <p>
                      Actor argentino
                    </p>
                  </div>
                  <i class="fa fa-quote-left" aria-hidden="true"></i>
                </div>
                <p>
                  Conocí IT Bank luego de un partido de Racing. Estaba deprimido porque perdimos 3 a 1 contra Excursionistas, y este software me alegró de inmediato. Le agradezco mucho a los chicos y claramente merecen aprobar </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>



  <section class="info_section layout_padding2">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-lg-3 info_col">
          <div class="info_contact">
            <h4>
              Direccion 
            </h4>
            <div class="contact_link_box">
              <a href="">
                <i class="fa fa-map-marker" aria-hidden="true"></i>
                <span>
                  Avenida Klostertown 2000
                </span>
              </a>
              <a href="">
                <i class="fa fa-phone" aria-hidden="true"></i>
                <span>
                  +01 1234567890
                </span>
              </a>
              <a href="">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <span>
                  proyectoitbank@gmail.com
                </span>
              </a>
            </div>
          </div>
          <div class="info_social">
            <a href="">
              <i class="fa fa-facebook" aria-hidden="true"></i>
            </a>
            <a href="">
              <i class="fa fa-twitter" aria-hidden="true"></i>
            </a>
            <a href="">
              <i class="fa fa-linkedin" aria-hidden="true"></i>
            </a>
            <a href="">
              <i class="fa fa-instagram" aria-hidden="true"></i>
            </a>
          </div>
        </div>
        <div class="col-md-6 col-lg-3 info_col">
          <div class="info_detail">
            <h4>
              Bienvenidos
            </h4>
            <p>
              Somos un equipo de programadores de la UTN con energía y ganas de crecer en el ambiente IT
            </p>
          </div>
        </div>
        <div class="col-md-6 col-lg-2 mx-auto info_col">
          <div class="info_link_box">
            <h4>
              Links
            </h4>
            <div class="info_links">
              <a class="active" href="index.html">
                Home
              </a>
              <a class="" href="about.html">
                Sobre nosotros
              </a>
              <a class="" href="service.html">
                Servicios
              </a>
              <a class="" href="why.html">
                Contáctanos
              </a>
              <a class="" href="team.html">
                Equipo
              </a>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3 info_col ">
          <h4>
            Suscribite
          </h4>
          <form action="#">
            <input type="text" placeholder="Ingresa tu email" />
            <button type="submit">
              Suscribite
            </button>
          </form>
        </div>
      </div>
    </div>
  </section>


  <section class="footer_section">
    <div class="container">
      <p>
        &copy; <span id="displayYear"></span> Todos los Derechos Reservados
        <a href="https://html.design/">Team Operacion Java</a>
      </p>
    </div>
  </section>

  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <script type="text/javascript" src="js/custom.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
  </script>

</body>

</html>