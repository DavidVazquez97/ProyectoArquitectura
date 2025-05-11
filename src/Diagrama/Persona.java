
package Diagrama;

import ConexionSingleton.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;


public class Persona {
    
    String nombre; 
    String paterno;
    String materno;
    String telefono;
    String fecha_nacimiento;
    int idHabiante;

    public Persona() {
    }

    public Persona(String nombre, String paterno, String materno, String telefono, String fecha_nacimiento, int idHabiante) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.idHabiante = idHabiante;
    }


 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setIdHabiante(int idHabiante) {
        this.idHabiante = idHabiante;
    }

    public int getIdHabiante() {
        return idHabiante;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    
    Conexion conectar = Conexion.getInstace();
    Connection con = conectar.conectar();
    
    public void registrarHabitante (int idDomicilio){
    
        try {
            String sqlString = "insert into dbo.Habitante (nombre, apePaterno, apeMaterno, telefono, fechaNacimiento, " + 
                    "idVivienda) values (?,?,?,?,?,?)";
            
            PreparedStatement ps;
            ps = con.prepareStatement(sqlString);
            ps.setString(1, nombre);
            ps.setString(2, paterno);
            ps.setString(3, materno);
            ps.setString(4, telefono);
            ps.setString(5, fecha_nacimiento);
            ps.setInt(6, idDomicilio);
            ps.executeUpdate();
            conectar.cerrarConexion();
            System.out.println("Habitante Registrado");
        }catch (SQLException ex){ 
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    public void actualizarHabitante (){
        try {
            String sqlString = "update dbo.Habitante set nombre = ?, apePaterno = ?, apeMaterno = ?, telefono = ?, " + 
                    "fechaNacimiento = ? where idHabitante = ?";  
                    
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, nombre);
            ps.setString(2, paterno);
            ps.setString(3, materno);
            ps.setString(4, telefono);
            ps.setString(5, fecha_nacimiento);
            ps.setInt(6, idHabiante);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Habitante modificado");
            conectar.cerrarConexion();
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    
    }
    
    public void eliminarHabitante (){
        try {
            PreparedStatement ps = con.prepareStatement("delete from  dbo.Habitante where idHabitante = ?");
            ps.setInt(1, idHabiante);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Habitante eliminado");
            conectar.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }       
    }


    
    
    
    
}
