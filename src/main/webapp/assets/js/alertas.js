function alerta()
    {
    var mensaje;
    var opcion = confirm("Desea eliminar el usuario");
    if (opcion == true) {
        mensaje = "Genero eliminado correctamente ";
	} else {
	    mensaje = "";
	}
	document.getElementById("ejemplo").innerHTML = mensaje;
}