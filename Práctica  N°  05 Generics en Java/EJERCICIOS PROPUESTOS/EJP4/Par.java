package EJP4;

public class Par<F , S> {

	private final F tipoObjeto1;
	private final S tipoObjeto2;
	
	public Par(F tipoObjeto1, S tipoObjeto2) {
		super();
		this.tipoObjeto1 = tipoObjeto1;
		this.tipoObjeto2 = tipoObjeto2;
	}

	public F getTipoObjeto1() {
		return tipoObjeto1;
	}

	public S getTipoObjeto2() {
		return tipoObjeto2;
	}
	
    @Override
    public String toString() {
        return "Persona{tipo=>'" + tipoObjeto1 + "', tipo=>=" + tipoObjeto2 + "}";
    }
	

	
	
}
