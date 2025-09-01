package sistema;

public class Curso {
    private static int contadorCursos = 0;
    private String codigo;
    private String nombre;
    private int creditos;
    private Profesor profesorAsignado;

    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        Curso.contadorCursos++;
    }

    public static int obtenerTotalCursos() {
        return contadorCursos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setProfesor(Profesor profesor) {
        this.profesorAsignado = profesor;
    }

    public void mostrarInfo() {
        System.out.println("Curso: " + nombre + " (" + codigo + ")");
        System.out.println("Créditos: " + creditos);
        if (profesorAsignado != null) {
            System.out.println("Profesor Asignado: " + profesorAsignado.getNombre());
        } else {
            System.out.println("Profesor Asignado: Ninguno");
        }
    }

}
