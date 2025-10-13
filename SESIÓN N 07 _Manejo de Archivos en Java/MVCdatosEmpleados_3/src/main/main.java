package main;

import Controlador.ControladorEmp;
import Modelo.EmpleadoArchivo;
import Vista.EmpleadoMenu;

public class main {
    public static void main(String[] args) {
        
        EmpleadoArchivo modelo = new EmpleadoArchivo(); 
        
        EmpleadoMenu vista = new EmpleadoMenu();
        

        ControladorEmp controlador = new ControladorEmp(modelo, vista);

        controlador.iniciar(); 
    }
}