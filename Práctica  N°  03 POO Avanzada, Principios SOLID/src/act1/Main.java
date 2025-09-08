package act1;

public class Main {
	public static void main(String[] args) {
		double SalarioNeto;
		Empleado E1=new Empleado("Juan Torres Quispe",1300.00,"Finanzas");
		CalcularPago CP1=new CalcularPago();
		MostrarDatos MD1=new MostrarDatos();
		SalarioNeto=CP1.calPago(E1);
		MD1.mostrarDatos(E1,SalarioNeto);
		
	}
}
