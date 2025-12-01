package PatronObserver;

public class main {

	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer observer1 = new NotifUsuarios("Departamento de red");
		Observer observer2 = new NotifUsuarios("pedartamento de gestion");
		Observer observer3 = new NotifUsuarios("departamento de administracion");


		subject.attach(observer1);
		subject.attach(observer2);
		subject.attach(observer3);
		
		subject.notifObservers("Se enviara un supervisor a partir de medio dia");
		

	}

}
