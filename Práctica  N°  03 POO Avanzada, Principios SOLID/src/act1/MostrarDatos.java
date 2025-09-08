package act1;

public class MostrarDatos {
	public void mostrarDatos(Empleado empleado,double SalarioNet) {
		System.out.println("El Empleado: "+empleado.getNombre()+" Tiene un salario de: "+SalarioNet+" y se encuentra en el departamento de: "+empleado.getDepartamento());
	}
}
