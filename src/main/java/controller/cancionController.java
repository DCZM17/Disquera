package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cancionDao;
import model.cancionVo;

public class cancionController extends HttpServlet{
    cancionVo r=new cancionVo();
    cancionDao rd=new cancionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("action");
        System.out.println(a);
        switch(a){
            case "ingresar"://casos del doGet
            ingresar(req, resp);
            break;
        case "listar":
            cancionList(req, resp);
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
            req.getRequestDispatcher("views/Cancion/insertarCancion.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreCancion")!=null){
            r.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            r.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
            r.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            r.setEstadoCancion(true);
        } else {
            r.setEstadoCancion(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            cancionList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void cancionList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List <cancionVo> cancionL = rd.cancionList();
            req.setAttribute("cancionList", cancionL);
            req.getRequestDispatcher("views/Cancion/consultarCancion.jsp").forward(req, resp);//Redireccionamiento a la vista
            System.out.println("Datos listados de manera correcta");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("id")));//solicitud de id
        }
        try {
            rd.eliminar(r.getIdCancion());;
            System.out.println("El registro se elimino exitosamente");
            cancionList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la eliminacion"+e.getMessage().toString());
        }
    }

    private void estado(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("id")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("id")));//solicitud de id 
        }
        if(req.getParameter("estado")!=null){
            r.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estado")));
        }
        try{
            rd.estado(r.getEstadoCancion(), r.getIdCancion());
            System.out.println("El estado se cambio correctamente");
            cancionList(req, resp);
        }catch(Exception e){
            System.out.println("Error en el cambio de estado"+e.getMessage().toString());
        }
    }
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            List <cancionVo> cancionL = rd.cancionList(r.getIdCancion());
            req.setAttribute("cancionList", cancionL);
            req.getRequestDispatcher("views/Cancion/editarCancion.jsp").forward(req, resp);//redireccionamiento a la vista
            System.out.println("Datos listados correctamente, preparados para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
   private void edit(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idCancion")!=null){
        r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));//Cambiar de string a int
    }
    if(req.getParameter("nombreCancion")!=null){
        r.setNombreCancion(req.getParameter("nombreCancion"));
    }
    if(req.getParameter("fechaGrabacion")!=null){
        r.setFechaGrabacion(req.getParameter("fechaGrabacion"));
    }
    if(req.getParameter("duracionCancion")!=null){
        r.setDuracionCancion(req.getParameter("duracionCancion"));
    }
    if(req.getParameter("estadoCancion")!=null){
        r.setEstadoCancion(true);
    }
    else{
       r.setEstadoCancion(false);
    }
    try {
        rd.actualizar(r);
        System.out.println("Editar el registro de Cancion");
        cancionList(req, resp);
    } catch (Exception e) {
        System.out.println("Error al editar del registro "+e.getMessage().toString());
    }
  }
}
