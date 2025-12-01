package ControlRemoto;

public class Main{
	 public static void main(String[] args) {
	 TV tv = new TV();
	 Command turnOn = new TVONCommand(tv);
	 Command turnOff = new TVOFFCommand(tv);
	 Command youtube = new TVTecladoRapido1(tv);
	 Command Netflix = new TVTecladoRapido2(tv);
	 Command Meutv = new TVMenuCommand(tv);
	 
	 
	 
	 
	 
	 RemoteControl remote = new RemoteControl();
	 
	 
	 
	 
	 // Turn light on
	 remote.setCommand(turnOn);
	 remote.pressButton();
	 // Turn light off
	 remote.setCommand(turnOff);//aqui no apretamos el boton
	 //menu de la tv 
	 remote.setCommand(Meutv);
	 remote.pressButton();
	 //youtube
	 remote.setCommand(youtube);
	 remote.pressButton();
	 //netflix
	 remote.setCommand(Netflix);
	 remote.pressButton();
	 //apagar
	 remote.setCommand(turnOff);
	 remote.pressButton();
	 
	 
	 }
	}