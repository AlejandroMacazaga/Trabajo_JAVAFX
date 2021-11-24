package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Alumno;
import models.Prestamo;

public class PrestamosDAO {
	
	public static ArrayList<Prestamo> getAllPrestamos() {
		String sql = "select id_prestamo, dni_alumno, codigo_libro, fecha_presamo from prestamos";
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Prestamo(rs.getInt("id_prestamo"), rs.getString("dni_alumno"), rs.getInt("codigo_libro"), rs.getDate("fecha_prestamo")));
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

	
	public static boolean addPrestamo(Prestamo p) {
		String sql = "insert into prestamos (dni_alumno, codigo_libro, fecha_prestamo) values(?, ?, ?)";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(0, p.getDni_alumno());
			ps.setInt(1, p.getCodigo_libro());
			ps.setDate(2, new java.sql.Date(p.getFecha_prestamo().getTime()));
			if(ps.executeUpdate() <= 0) { estado = false; }
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return estado;
	}
	
	public static boolean removePrestamo(Prestamo p) {
		String sql = "delete from prestamos where id_prestamo = ?";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(0, p.getId_prestamo());
			if(ps.executeUpdate() <= 0) { estado = false; }
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return estado;
	}
}
