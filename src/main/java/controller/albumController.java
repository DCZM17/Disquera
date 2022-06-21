package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.albumDao;
import model.albumVo;

public class albumController extends HttpServlet{
    albumVo r=new albumVo();
    albumDao rd=new albumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("action");
        System.out.println(a);
        switch(a){
            case "ingresar":
            ingresar(req, resp);
            break;
        case "listar":
            albumList(req, resp);
            break;
        case "eliminar":
            eliminar(req, resp);
            break;
        case "estado":
            estado(req, resp);
            break;
        case "editar":
            editar(req, resp);
            break;
    }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("action");

        switch(a){
            case "add":
                add(req,resp);
            break;
            case "edit":
                edit(req,resp);
            break;
        }
    }
    private void ingresar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Album/insertarAlbum.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreAlbum")!=null){
            r.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("anioPublicacion")!=null){
            r.setAnioPublicacion(req.getParameter("anioPublicacion"));
        }
        if(req.getParameter("estadoAlbum")!=null){
            r.setEstadoAlbum(true);
        } else {
            r.setEstadoAlbum(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            albumList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void albumList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List <albumVo> albumL = rd.albumList();
            req.setAttribute("albumList", albumL);
            req.getRequestDispatcher("views/Album/consultarAlbum.jsp").forward(req, resp);
            System.out.println("Datos listados de manera correcta");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("id")));
        }
        try {
            rd.eliminar(r.getIdAlbum());;
            System.out.println("El registro se elimino exitosamente");
            albumList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la eliminacion"+e.getMessage().toString());
        }
    }

    private void estado(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("id")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("id")));
        }
        if(req.getParameter("estado")!=null){
            r.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estado")));
        }
        try{
            rd.estado(r.getEstadoAlbum(), r.getIdAlbum());
            System.out.println("El estado se cambio correctamente");
            albumList(req, resp);
        }catch(Exception e){
            System.out.println("Error en el cambio de estado"+e.getMessage().toString());
        }
    }
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        try {
            List <albumVo> albumL = rd.albumList(r.getIdAlbum());
            req.setAttribute("albumList", albumL);
            req.getRequestDispatcher("views/Album/editarAlbum.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente, preparados para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
   private void edit(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idAlbum")!=null){
        r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
    }
    if(req.getParameter("nombreAlbum")!=null){
        r.setNombreAlbum(req.getParameter("nombreAlbum"));
    }
    if(req.getParameter("anioPublicacion")!=null){
        r.setAnioPublicacion(req.getParameter("anioPublicacion"));
    }
    if(req.getParameter("estadoAlbum")!=null){
        r.setEstadoAlbum(true);
    }
    else{
       r.setEstadoAlbum(false);
    }
    try {
        rd.actualizar(r);
        System.out.println("Editar el registro de Album");
        albumList(req, resp);
    } catch (Exception e) {
        System.out.println("Error al editar del registro "+e.getMessage().toString());
    }
  }
}
