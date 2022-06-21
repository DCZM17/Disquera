package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.generoDao;
import model.generoVo;

public class generoController extends HttpServlet{

    generoVo r=new generoVo();
    generoDao rd=new generoDao();

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
            generoList(req, resp);
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
            req.getRequestDispatcher("views/Genero/insertarGenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("nombreGenero")!=null){
            r.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setEstadoGenero(true);
        } else {
            r.setEstadoGenero(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            generoList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void generoList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List <generoVo> generoL = rd.generoList();
            req.setAttribute("generoList", generoL);
            req.getRequestDispatcher("views/Genero/consultarGenero.jsp").forward(req, resp);
            System.out.println("Datos listados de manera correcta");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("id")));
        }
        try {
            rd.eliminar(r.getIdGenero());;
            System.out.println("El registro se elimino exitosamente");
            generoList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la eliminacion"+e.getMessage().toString());
        }
    }

    private void estado(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("id")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("id")));
        }
        if(req.getParameter("estado")!=null){
            r.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estado")));
        }
        try{
            rd.estado(r.getEstadoGenero(), r.getIdGenero());
            System.out.println("El estado se cambio correctamente");
            generoList(req, resp);
        }catch(Exception e){
            System.out.println("Error en el cambio de estado"+e.getMessage().toString());
        }
    }
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try {
            List <generoVo> generoL = rd.listarGenero(r.getIdGenero());
            req.setAttribute("generoList", generoL);
            req.getRequestDispatcher("views/Genero/editarGenero.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente, preparados para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
   private void edit(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idGenero")!=null){
        r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
    }
    if(req.getParameter("nombreGenero")!=null){
        r.setNombreGenero(req.getParameter("nombreGenero"));
    }
    if(req.getParameter("estadoGenero")!=null){
        r.setEstadoGenero(true);
    }
    else{
       r.setEstadoGenero(false);
    }
    try {
        rd.actualizar(r);
        System.out.println("Editar el registro de genero");
        generoList(req, resp);
    } catch (Exception e) {
        System.out.println("Error al editar del registro "+e.getMessage().toString());
    }
  }
}