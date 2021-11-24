package models;

import java.util.Date;

public class Historio_prestamos {
	private int id_prestamo;
	private String dni_alumno;
	private int codigo_libro;
	private Date fecha_prestamo;
	private Date fecha_devolucion;
	
	public Historio_prestamos(int id_prestamo, String dni_alumno, int codigo_libro, Date fecha_prestamo,
			Date fecha_devolucion) {
		super();
		this.id_prestamo = id_prestamo;
		this.dni_alumno = dni_alumno;
		this.codigo_libro = codigo_libro;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
	}
	
	public int getId_prestamo() {
		return id_prestamo;
	}
	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}
	public String getDni_alumno() {
		return dni_alumno;
	}
	public void setDni_alumno(String dni_alumno) {
		this.dni_alumno = dni_alumno;
	}
	public int getCodigo_libro() {
		return codigo_libro;
	}
	public void setCodigo_libro(int codigo_libro) {
		this.codigo_libro = codigo_libro;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	
	
}
