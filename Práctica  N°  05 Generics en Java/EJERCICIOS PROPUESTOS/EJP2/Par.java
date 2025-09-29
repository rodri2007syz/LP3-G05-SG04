package EJP2;

public class Par<F,S> {
	private F primer;
	private S segundo;
	
	public Par(F pr,S seg) {
		this.primer=pr;
		this.segundo=seg;
	}
	
	public F getPrimero() {
		return primer;
	}
	
	public S getSegundo() {
		return segundo;
	}
	
	public void setPrimero(F primero2) {
		this.primer=primero2;
	}
	
	public void setSegundo(S segundo2) {
		this.segundo=segundo2;
	}
	
	
	public boolean esIgual(Par<F,S> otroPar) {
		boolean retorno=false;
		if((this.primer==otroPar.primer)&&(this.segundo==otroPar.segundo)) {
			retorno=true;
		}
		return retorno;
	}
	@Override
	public String toString() {
		return ("(Primero: "+primer+" , Segundo: "+segundo+")");
	}
}
