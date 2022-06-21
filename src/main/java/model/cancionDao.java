package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;


public class cancionDao {
    
    //Atributos para las operacinones 

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int filas;

    public int registrar(cancionVo cancion) throws SQLException{
        sql="INSERT INTO cancion(nombreCancion, fechaGrabacion, duracionCancion, estadoCancion) VALUES (?,?,?,?)";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cancion.getNombreCancion());
            ps.setString(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.getEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro la cancion correctamente");
        }catch(Exception e){
            System.out.println("Error al momento de registar la cancion "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;//retornar numero de filas
    }
    public List<cancionVo> cancionList() throws SQLException{
        List<cancionVo> cancion= new ArrayList<>();
        sql="SELECT * FROM cancion";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                cancionVo filas=new cancionVo();
                //Escribir en el setter cada valor encontrado
                filas.setIdCancion(rs.getInt("idCancion"));//peticion de id
                filas.setNombreCancion(rs.getString("nombreCancion"));//peticion de nombre
                filas.setFechaGrabacion(rs.getString("fechaGrabacion"));//peticion de nombre
                filas.setDuracionCancion(rs.getString("duracionCancion"));//peticion de nombre
                filas.setEstadoCancion(rs.getBoolean("estadoCancion"));//peticion de estado
                cancion.add(filas);
            }
            ps.close();
            System.out.println("Consulta exitosa");
        }catch (Exception e){
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return cancion;//retorna array con los datos de la tabla
    }

    public void eliminar(int id) throws SQLException{
        sql = "DELETE FROM cancion WHERE idCancion="+id;//variable para el sql
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino correctamente"); 
        }catch(Exception e){
            System.out.println("Error en la eliminación "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }
    public void estado(Boolean estado, int id) throws SQLException{
        sql="UPDATE cancion SET estadoCancion="+estado+" WHERE idCancion="+id;//variable para el sql
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estado+" correctamente");
        }catch(Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }
    public List<cancionVo> cancionList(int id) throws SQLException{
        List<cancionVo> cancion=new ArrayList<>();
        sql="SELECT * FROM cancion WHERE idCancion="+id;//variable para la BD
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                cancionVo filas=new cancionVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdCancion(rs.getInt("idCancion"));//peticion de id
                filas.setNombreCancion(rs.getString("nombreCancion"));//peticion de nombre
                filas.setFechaGrabacion(rs.getString("fechaGrabacion"));//peticion de nombre
                filas.setDuracionCancion(rs.getString("duracionCancion"));//peticion de nombre
                filas.setEstadoCancion(rs.getBoolean("estadoCancion"));//peticion de estado
                cancion.add(filas);
            }
            ps.close();
            System.out.println("Genero especifico consultado exitosamente ");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return cancion;//retorna array con los datos de la tabla
    }
    public int actualizar(cancionVo cancion) throws SQLException{
        sql="UPDATE cancion SET nombreCancion=?, fechaGrabacion=?, duracionCancion=?, estadoCancion=? WHERE idCancion=?";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, cancion.getNombreCancion());
            ps.setString(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.getEstadoCancion());
            ps.setInt(5, cancion.getIdCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito la cancion correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;//retornar numero de filas
    }
}
