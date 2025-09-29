package EJP3;

public class Metodo_Generico {
	
	public static <F,S> void imprimirPar(Par<F, S> par) {
		System.out.println("====>" + par.getTipoObjeto1() );
		System.out.println("====>"+ par.getTipoObjeto2());
	}

	public static void main(String[] args) {
		
		Integer cantidad = null;
		Integer cantidad2 = 100;
		Persona hombre = new Persona("Pedro", 40);
		
		Par<String,Integer> par1 = new Par<>("hola",cantidad);
		Par<Double,Boolean> par2 = new Par<>(2.2,true);
		Par<Persona,Integer> par3 = new Par<>(hombre,cantidad2);
			
		
		imprimirPar(par1);
		imprimirPar(par2);
		imprimirPar(par3);
		}



}
