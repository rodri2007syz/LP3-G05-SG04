package ejercicio4;
import java.util.Scanner;

public class funcionmenor {
	public static double nunmenor(double a ,double b , double c) {
		double menorPrincipal = a;
		if (menorPrincipal > b) {
			menorPrincipal = a;			
		}
		if (menorPrincipal > c) {
			menorPrincipal = c;
		}
		return menorPrincipal;
	}
	

	public static void main(String[] args) {
		System.out.println("Ingrese 3 numeros");
		Scanner ingre = new Scanner(System.in);
		
		double n1 = ingre.nextDouble();
		double n2 = ingre.nextDouble();
		double n3 = ingre.nextDouble();
		
		
		double resultado = nunmenor(n1,n2,n3);
		System.out.println(resultado);
	}
}