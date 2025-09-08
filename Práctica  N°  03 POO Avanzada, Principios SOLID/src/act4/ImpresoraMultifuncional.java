package act4;

public class ImpresoraMultifuncional implements Imprimible, Escaneable{

	public ImpresoraMultifuncional() {}
	
	@Override
	public void imprimir() {
		System.out.println("ImpresoraMultifuncional modo impresion");
	}
	@Override
	public void escanear() {
		System.out.println("ImpresoraMultifuncional modo escaner");
	}

	
	

}
