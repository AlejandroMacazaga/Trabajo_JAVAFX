package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Alumno;

public class AlumnosDAO {
		
	public static ArrayList<Alumno> getAllAlumnos() {
		String sql = "select dni, nombre, apellido1, apellido2 from alumnos";
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Alumno(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2")));
			}
			rs.close();
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return null;
		}
		return lista;
	}
	
	public static boolean addAlumno(Alumno a) {
		String sql = "insert into alumnos (dni, nombre, apellido1, apellido2) values (?, ?, ?, ?)";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(0, a.getDni());
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getApellido1());
			ps.setString(3, a.getApellido2());
			if(ps.executeUpdate() <= 0) {
				estado = false;
			}
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return estado;
	}
	
	public static boolean modifyAlumno(Alumno a) {
		String sql = "update alumnos set nombre = ?, apellido1 = ?, apellido2 = ? where dni = ?";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(3, a.getDni());
			ps.setString(0, a.getNombre());
			ps.setString(1, a.getApellido1());
			ps.setString(2, a.getApellido2());
			if(ps.executeUpdate() <= 0) {
				estado = false;
			}
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return estado;
	}
}
