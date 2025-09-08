package act4;

public class PruebaEquipos {

	public static void main(String[] args) {
		Impresora docSimple = new Impresora();
		docSimple.imprimir();
		
		ImpresoraMultifuncional pruebaFunciones = new ImpresoraMultifuncional();
		
		pruebaFunciones.escanear();
		pruebaFunciones.imprimir();
		
	}

}
