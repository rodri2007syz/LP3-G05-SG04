package Modelo;
import java.io.Serializable;

public class Empleado implements Serializable {


    private static final long serialVersionUID = 1L; 

	private int numero;
	private String nombre;
	private double sueldo;
    
	public Empleado(int numero, String nombre, double sueldo) {
		this.numero = numero;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public String toString() {
		return String.format("Num: %-5d | Nombre: %-20s | Sueldo: $%.2f", this.numero, this.nombre, this.sueldo);
	}
}