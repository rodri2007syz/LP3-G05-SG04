package act1;

public class Empleado {
	private String Nombre;
	private double Salario;
	private String Departamento;
	
	public Empleado(String Nombre, double Salario, String Departamento) {
		this.Nombre=Nombre;
		this.Salario=Salario;
		this.Departamento=Departamento;
	}
	
	public String  getNombre() {
		return Nombre;
	}
	public double getSalario() {
		return Salario;
	}
	public String getDepartamento() {
		return Departamento;
	}
}
