package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Alumno;
import models.Libro;

public class LibrosDAO {
	
	public static ArrayList<Libro> getAllLibros() {
		String sql = "select codigo, Titulo, Autor, Editorial, Estado, Baja from libros";
		ArrayList<Libro> lista = new ArrayList<Libro>();
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Libro(rs.getInt("codigo"), rs.getString("Titulo"), 
									rs.getString("Autor"), rs.getString("Editorial"),
									rs.getString("Estado"), rs.getInt("Baja")));
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
	
	public static boolean addLibro(Libro l) {
		String sql = "insert into alumnos (codigo, Titulo, Autor, Editorial, Estado, Baja) values (?, ?, ?, ?, ? , ?)";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(0, l.getCodigo());
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getAutor());
			ps.setString(3, l.getEditorial());
			ps.setString(4, l.getEstado());
			ps.setInt(5, l.getBaja());
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
	
	public static boolean removeLibro(int codigo) {
		String sql = "update alumnos set baja = 1 where codigo = ?";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(0, codigo);
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
	
	public static boolean modifyLibro(Libro l) {
		String sql = "update libros set Titulo = ?, Autor = ?, Editorial = ?, Estado = ? where codigo = ?";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(4, l.getCodigo());
			ps.setString(0, l.getTitulo());
			ps.setString(1, l.getAutor());
			ps.setString(2, l.getEditorial());
			ps.setString(3, l.getEstado());
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
	
	public static boolean modifyEstadoLibro(int codigo, String strEstado) {
		String sql = "update libros set Estado = ? where codigo = ?";
		boolean estado = true;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, codigo);
			ps.setString(0, strEstado);
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
