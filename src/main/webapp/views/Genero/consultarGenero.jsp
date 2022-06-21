<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="esp">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/consultar.css">
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
          <li><a href="genero?action=registrar">Crear Genero</a></li>
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
    <div class="title">Consultar Genero</div>
    <div class="content">
      <form action="" method="get">
        <div class="user-details">
          <div class="input-box">

            <input type="text" name="nombreConsulta" placeholder="Nombre">
          </div>

          <button type="submit" class="buttonNConsulta">Buscar</button>
          <a href="genero?action=registrar"><img src="assets/img/user.png" class="user"></a>
      </form>
    </div>
  </div>
  <table id="racetimes">
<tr id="firstrow">
  <th>Id</th>
  <th>Nombre</th>
  <th></th>
  <th>Cambiar Estado</th>
  <th>Funciones</th>
</tr>
<c:forEach var="generoL" items="${generoList}">        
  <tr>
    <td>${generoL.getIdGenero()}</td>
    <td>${generoL.getNombreGenero()}</td>
    <td>
      
    </td>
    <td>
      <c:if test="${generoL.getEstadoGenero() == true}">
        <a href="genero?action=estado&id=${generoL.getIdGenero()}&estado=false"><button class="btn btn-warning" type="button">Inactivar Genero</button> </a> 
</c:if>
<c:if test="${generoL.getEstadoGenero() == false}">
        <a href="genero?action=estado&id=${generoL.getIdGenero()}&estado=true"><button class="btn btn-info"  type="button">Activar Genero</button> </a>
</c:if>
</td>
    <td>
     <a href="genero?action=editar&idGenero=${generoL.getIdGenero()}"  class="accion"><img src="assets/img/edit.png"></a>
     <a href="genero?action=eliminar&id=${generoL.getIdGenero()}" class="accion"><img src="assets/img/garbage.png"></a>
    </td>
    </tr>
  </c:forEach>
</table>
</center>
</div>
<br>
</body>
</html>