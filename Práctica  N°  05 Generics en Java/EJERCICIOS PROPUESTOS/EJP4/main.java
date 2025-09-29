package EJP4;

public class main {

	public static void main(String[] args) {
		
		Contenedor_generico< Persona , Boolean > miContenedor1 = new Contenedor_generico<>();
		Contenedor_generico<String, Integer > miContenedor2 = new Contenedor_generico<>();

		
		
		Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Ana", 30);
        
        miContenedor2.agregarPar("Edad de Juan", 25);
        miContenedor2.agregarPar("Edad de Ana", 30);
        
        miContenedor1.agregarPar(p1, true );
        miContenedor1.agregarPar(p2, true );
        
        miContenedor1.mostrarDatosPares();
        
        System.out.println(miContenedor1.obtenerPares()); /*muestra todas las ubicaciones de memoria*/
        System.out.println( miContenedor1.obtenerinfo(0));/*muestra la ubicacion exacta*/
	}

}
