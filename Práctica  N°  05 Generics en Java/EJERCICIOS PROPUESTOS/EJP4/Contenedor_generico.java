package EJP4;
import java.util.ArrayList;

public class Contenedor_generico<F , S> {

	private final  ArrayList<Par<F,S>> pares;

	public Contenedor_generico() {
		super();
		this.pares = new ArrayList<>();
	}
	
	public void agregarPar(F primer ,S segundo) {
		pares.add(new Par<>(primer , segundo));
		
	}
	
	public Par <F,S> obtenerinfo(int indice) {
		if(indice >= 0 && indice < pares.size()) {
			return pares.get(indice);
			}
		return null;
	}
	public ArrayList<Par<F,S>> obtenerPares(){
		return new ArrayList<>(pares);
	}
	
	
	public void mostrarDatosPares() {
		System.out.println("los datos de la lista son...");
		for (int i = 0; i < pares.size(); i++) {
			Par<F, S> par = pares.get(i);
			
			System.out.println(par.getTipoObjeto1());
		} 
	}
}
