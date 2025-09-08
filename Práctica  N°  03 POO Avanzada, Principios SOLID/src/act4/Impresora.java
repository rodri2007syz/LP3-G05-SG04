package act4;

public class Impresora implements Imprimible {

	public Impresora() {}
	
	@Override
	public void imprimir() {
		System.out.println("La impresora esta funcionando correctamente");
	}
}
