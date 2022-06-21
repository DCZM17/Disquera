<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="esp">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/menu.css">
    <link rel="stylesheet" href="assets/css/stylesDisquera.css">
    <title>Disquera</title>
  </head>
<body>
  <nav id="menu">
    <ul>
      <li><a href="#">Album</a>
        <ul>
          <li><a href="album?action=ingresar">Crear Album</a></li>
          <li><a href="album?action=listar">Consultar Album</a></li>
        </ul>
      </li>
      <li><a href="#">Cancion</a>
        <ul>
          <li><a href="cancion?action=ingresar">Crear Cancion</a></li>
          <li><a href="cancion?action=listar">Consultar Cancion</a></li>
        </ul>
      </li>
      <li><a href="#">Genero</a>
        <ul>
          <li><a href="genero?action=ingresar">Crear Genero</a></li>
          <li><a href="genero?action=listar">Consultar Genero</a></li>
        </ul>
      </li>
    </ul>
    </nav>
  <header class="header">
    <h1>DZ RECORDS </h1>
</header>
<center>
  <div class="container">
    <div class="title">WELCOME</div>
    <div class="content">
      <h1>Mision</h1>
      <p>Construir un espacio destinado a la creación, diseño de sonido, mezcla y 'masterizacion' de música</p>
      <h1>Vision</h1>
      <p>Ser el sello discográfico basado en principios de confianza, trabajo en equipo y talento humano que lidere la industria musical latinoamericana y se caracterice por explorar nuevas experiencias musicales, sonidos, voces, diversidad de instrumentos,</p>
    </div>
  </div>
</body>
</html>