<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/stylesDisquera.css">
    <link rel="stylesheet" href="assets/css/menu.css">
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
      <li><a href="../../index.jsp">INICIO</a>
    </ul>
    </nav>
    <header class="header">
      <h1>DZ RECORDS </h1>
      </header>
    <center>
        <div class="container">
          <div class="title">Insertar Genero</div>
          <div class="content">
            <form action="genero" method="post">
              <div class="user-details">     
                <div class="input-box">
                    <span class="details">Nombre Genero</span>
                    <input name="nombreGenero" id="nombre" type="text" placeholder="Nombre">
                  </div>     
                  <div class="input-box">
                    <span class="details">Estado Genero</span>
                    <input type="checkbox" name="estadoGenero" id="estado" checked class="form-check-input">
                    <label for="chkestado"> Activo</label>
                  </div>
              <div class="button">
                <button type="submit" name="action" value="add" >Ingresar</button>
              </div>
            </form>
          </div>
        </div>
      </center>
</body>
</html>