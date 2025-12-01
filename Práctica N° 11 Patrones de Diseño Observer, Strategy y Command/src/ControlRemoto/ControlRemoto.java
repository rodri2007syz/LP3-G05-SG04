package ControlRemoto;

interface Command {
	 void execute();
	}

class TV {
	 public void On() {
		 System.out.println("TV prendida");
	 	 }
	 public void Off() {
		 System.out.println("TV apagada");
	 	 }
	 public void TeclaRapida1() {
		 System.out.println("Boton rapido Youtube");
		 }
	 public void TeclaRapida2() {
		 System.out.println("baton  rapido Netflix");
		 }
	 public void MenuDeApp() {
		 System.out.println("MENU de apps");
		 System.out.println("store");
		 System.out.println("youtube");
		 System.out.println("Deportes");
		 System.out.println("Twich");
		 
	 }
	 
	 
	 
	 
	 
	 
	} 

class TVONCommand implements Command {
	 private TV ontv;
	 public TVONCommand(TV ontv) {
	 this.ontv = ontv;
	 }
	 public void execute() {
		 ontv.On();
	 }
	}
class TVOFFCommand implements Command {
		private TV offtv;
		public TVOFFCommand(TV offtv) {
		this.offtv = offtv;
		}
	public void execute() {
			 offtv.Off();
		}
	}
class TVTecladoRapido1 implements Command {
	private TV rapido1;
	public TVTecladoRapido1 (TV rapido1) {
	this.rapido1 = rapido1;
	}
public void execute() {
		rapido1.TeclaRapida1();
	}
}
class TVTecladoRapido2 implements Command {
	private TV rapido2;
	public TVTecladoRapido2 (TV rapido2) {
	this.rapido2 = rapido2;
	}
public void execute() {
		rapido2.TeclaRapida2();
	}
}

class TVMenuCommand implements Command {
	private TV Gui;
	public TVMenuCommand (TV Gui) {
	this.Gui = Gui;
	}
public void execute() {
		Gui.MenuDeApp();
	}
}

	
	class RemoteControl {
		 private Command command;
		 public void setCommand(Command command) {
		 this.command = command;
		 }
		 public void pressButton() {
		 command.execute();
		 }
		} 
