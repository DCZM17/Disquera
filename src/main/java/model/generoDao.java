package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;


public class generoDao {

    //Atributos para las operacinones 

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int filas;

    public int registrar(generoVo genero) throws SQLException{
        sql="INSERT INTO genero(nombreGenero, estadoGenero) VALUES (?,?)";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el genero completamente");
        }catch(Exception e){
            System.out.println("Error al momento de registar el genero "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;//retornar numero de filas
    }
    public List<generoVo> generoList() throws SQLException{
        List<generoVo> genero= new ArrayList<>();
        sql="SELECT * FROM genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                generoVo filas=new generoVo();
                //Escribir en el setter cada valor encontrado
                filas.setIdGenero(rs.getInt("idGenero"));//peticion de id
                filas.setNombreGenero(rs.getString("nombreGenero"));//peticion de nombre
                filas.setEstadoGenero(rs.getBoolean("estadoGenero"));//peticion de estado
                genero.add(filas);
            }
            ps.close();
            System.out.println("Consulta exitosa");
        }catch (Exception e){
            System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return genero;//retorna array con los datos de la tabla
    }

    public void eliminar(int id) throws SQLException{
        sql = "DELETE FROM genero WHERE idGenero="+id;//variable para el sql
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
        sql="UPDATE genero SET estadoGenero="+estado+" WHERE idGenero="+id;//variable para el sql
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
    public List<generoVo> listarGenero(int id) throws SQLException{
        List<generoVo> genero=new ArrayList<>();
        sql="SELECT * FROM genero WHERE idGenero="+id;//variable para la BD
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                generoVo filas=new generoVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdGenero(rs.getInt("idGenero"));//peticion de id
                filas.setNombreGenero(rs.getString("nombreGenero"));//peticion de nombre
                filas.setEstadoGenero(rs.getBoolean("estadoGenero"));//peticion de estado
                genero.add(filas);
            }
            ps.close();
            System.out.println("Genero especifico consultado exitosamente ");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return genero;//retorna array con los datos de la tabla
    }
    public int actualizar(generoVo genero) throws SQLException{
        sql="UPDATE genero SET nombreGenero=?, estadoGenero=? WHERE idGenero=?";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            ps.setInt(3, genero.getIdGenero());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito el genero correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;//retornar numero de filas
    }
}