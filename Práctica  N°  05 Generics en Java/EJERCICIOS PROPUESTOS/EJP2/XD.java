package EJP2;

public class XD {

	public static void main(String[] args) {
		Par<Integer,Integer> parEnteros = new Par<> (10,20);
		
		Par<Integer,Integer> par2 = new Par<> (50,20);
		
		Par<Integer,Integer> parEnteros2 = new Par<> (10,20);
		
		System.out.println(parEnteros.toString());
		System.out.print("  CASO DE ERROR(10.20 - 50.20):");
		System.out.print(parEnteros.esIgual(par2));
		System.out.print("  CASO DE EXITO (10.20 - 10.20):");
		System.out.print(parEnteros.esIgual(parEnteros2));
	}

}
