package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoArchivo;
import Vista.EmpleadoMenu;

import java.io.IOException;

public class ControladorEmp {

    private final EmpleadoArchivo modelo;
    private final EmpleadoMenu vista;
    public ControladorEmp(EmpleadoArchivo modelo, EmpleadoMenu vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.mostrarListaEmpleados(modelo.leerEmpleados());
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = vista.mostrarMenu();

            try {
                switch (opcion) {
                    case 1:
                        listarTodos(); 
                        break;
                    case 2:
                        agregarNuevoEmpleado();
                        break;
                    case 3:
                        buscarPorNumero();
                        break;
                    case 4:
                        eliminarPorNumero();
                        break;
                    case 5:
                        vista.mostrarMensajeExito("Saliendo del programa. Adios!");
                        break;
                    default:
                        if (opcion != -1) { 
                            vista.mostrarMensajeError("Opcion no valida. Ingrese un numero entre 1 y 5.");
                        }
                        break;
                }
            } catch (IOException e) {
                vista.mostrarMensajeError("Error de archivo: " + e.getMessage());
            } catch (Exception e) {
                vista.mostrarMensajeError("Error inesperado: " + e.getMessage());
            }

        } while (opcion != 5);
    }

    private void listarTodos() {
        vista.mostrarListaEmpleados(modelo.leerEmpleados());
    }

    private void agregarNuevoEmpleado() throws IOException {
        Empleado nuevoEmpleado = vista.solicitarDatosNuevoEmpleado(); 
        
        if (nuevoEmpleado != null) { 
            try {
                modelo.agregarEmpleado(nuevoEmpleado); 
                vista.mostrarMensajeExito("Empleado agregado correctamente.");
            } catch (IllegalArgumentException e) {
                vista.mostrarMensajeError(e.getMessage());
            }
        }
    }

    private void buscarPorNumero() {
        int numero = vista.solicitarNumeroEmpleado();
        if (numero != -1) {
            Empleado encontrado = modelo.buscarEmpleado(numero); 
            vista.mostrarEmpleado(encontrado); 
        }
    }

    private void eliminarPorNumero() throws IOException {
        int numero = vista.solicitarNumeroEmpleado();
        if (numero != -1) {
            if (modelo.eliminarEmpleado(numero)) { 
                vista.mostrarMensajeExito("Empleado numero " + numero + " eliminado correctamente.");
            } else {
                vista.mostrarMensajeError("No se encontro el empleado numero " + numero + " para eliminar.");
            }
        }
    }
}