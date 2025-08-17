package ejercicio6;
import java.util.Scanner;

public class numeroDeHoras {

	
	
	public static void main(String[] args) {
		int horas= -1;
		int minutos= -1;
		int segund= -1;
		int total= 0;
		Scanner ingre = new Scanner(System.in);
		
		
		System.out.println("Ingrese un numero de horas");
		while (horas < 0 ) {
		horas = ingre.nextInt();
		if (horas < 0) {
			System.out.println("Ingrese numeros positivos");
		}else {
			total+= horas * 60 * 60 ;
		}
		
		}
		
		System.out.println("ahora un numero de minutos");
		while (minutos < 0 ) {
		minutos = ingre.nextInt();
		if (minutos < 0) {
			System.out.println("Ingrese numeros positivos");
		}else {
			total+= minutos * 60 ;
		}
		
		}
		System.out.println("y por ultimo un numero de segundos");
		while (segund < 0 ) {
		segund = ingre.nextInt();
		if (segund < 0) {
			System.out.println("Ingrese numeros positivos");
		}else {
			total+= segund ;
		}
		
		
		
		}
		System.out.println("el total de segundoes es de "+ total);
	}
}
