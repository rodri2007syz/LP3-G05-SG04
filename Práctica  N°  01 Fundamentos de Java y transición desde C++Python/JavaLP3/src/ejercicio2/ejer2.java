package ejercicio2;
import java.util.Scanner;



public class ejer2 {
		public static void main(String[] args) {
			
			int [] numeros = new int[10];
			
			Scanner nunIngresado = new Scanner(System.in);
			
			System.out.println("ingrese 10 numeros");
			numeros[0]= nunIngresado.nextInt();
			
			
			for (int i = 1 ; i < numeros.length; i++) {
				int num=-100;
				while (num <= numeros[i -1]) {

				num = nunIngresado.nextInt();
		
				if (num < numeros[i-1]) {
					System.out.print("Su numeroes es menor del anterior ingrese nuevamente");
				}else {
					System.out.print("Su numeroes mayor que el anterior bien");
					numeros[i]= num;
				}
						
				}
		
				
			}
	        System.out.println("numeros guardados:");
	        for (int n : numeros) {
	            System.out.print(n + " ");
	        }
		}
		
}
