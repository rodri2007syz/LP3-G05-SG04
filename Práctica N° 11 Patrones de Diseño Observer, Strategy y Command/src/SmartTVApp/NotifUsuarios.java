package SmartTVApp;
import java.util.ArrayList;
import java.util.List;


interface Observer{
	void update(String messaje);
}


public class NotifUsuarios implements Observer{
	private String name;

	public NotifUsuarios(String name) {
		this.name = name;
	}
	
	public void update(String message) {
		System.out.println(name  +" Recibio : " + message);
	}
}

class Subject{
	private List<Observer> observers = new ArrayList<>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);		
	}
	
	public void notifObservers(String message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}
	
}
