package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;


public class albumDao {
    
    //Atributos para las operacinones 

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int filas;

    public int registrar(albumVo album) throws SQLException{
        sql="INSERT INTO album(nombreAlbum, anioPublicacion, estadoAlbum) VALUES (?,?,?)";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, album.getNombreAlbum());
            ps.setString(2, album.getAnioPublicacion());
            ps.setBoolean(3, album.getEstadoAlbum());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el album correctamente");
        }catch(Exception e){
            System.out.println("Error al momento de registar la cancion "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;//retornar numero de filas
    }
    public List<albumVo> albumList() throws SQLException{
        List<albumVo> album= new ArrayList<>();
        sql="SELECT * FROM album";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                albumVo filas=new albumVo();
                //Escribir en el setter cada valor encontrado
                filas.setIdAlbum(rs.getInt("idAlbum"));//peticion de id
                filas.setNombreAlbum(rs.getString("nombreAlbum"));//peticion de nombre
                filas.setAnioPublicacion(rs.getString("anioPublicacion"));//peticion de nombrere
                filas.setEstadoAlbum(rs.getBoolean("estadoAlbum"));//peticion de estado
                album.add(filas);
            }
            ps.close();
            System.out.println("Consulta exitosa");
        }catch (Exception e){
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return album;//retorna array con los datos de la tabla
    }

    public void eliminar(int id) throws SQLException{
        sql = "DELETE FROM album WHERE idAlbum="+id;//variable para el sql
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino el album correctamente"); 
        }catch(Exception e){
            System.out.println("Error en la eliminación "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }
    public void estado(Boolean estado, int id) throws SQLException{
        sql="UPDATE album SET estadoAlbum="+estado+" WHERE idAlbum="+id;//variable para el sql
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
    public List<albumVo> albumList(int id) throws SQLException{
        List<albumVo> album=new ArrayList<>();
        sql="SELECT * FROM album WHERE idAlbum="+id;//variable para la BD
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                albumVo filas=new albumVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdAlbum(rs.getInt("idAlbum"));//peticion de id
                filas.setNombreAlbum(rs.getString("nombreAlbum"));//peticion de nombre
                filas.setAnioPublicacion(rs.getString("anioPublicacion"));//peticion de nombre
                filas.setEstadoAlbum(rs.getBoolean("estadoAlbum"));//peticion de estado
                album.add(filas);
            }
            ps.close();
            System.out.println("Album especifico consultado exitosamente ");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return album;//retorna array con los datos de la tabla
    }
    public int actualizar(albumVo album) throws SQLException{
        sql="UPDATE album SET nombreAlbum=?, anioPublicacion=?, estadoAlbum=? WHERE idAlbum=?";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, album.getNombreAlbum());
            ps.setString(2, album.getAnioPublicacion());
            ps.setBoolean(3, album.getEstadoAlbum());
            ps.setInt(4, album.getIdAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito el album correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;//retornar numero de filas
    }
}
