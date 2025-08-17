package ejercicio5;
import java.util.Scanner;

public class java5 {
	public static double Calcularcargo(int horas) {
		double cargo=3.00;
		if(horas>1) {
			cargo+=(horas-1)*0.5;
		}
		if(cargo>=12) {
			cargo=12;
		}
		return cargo;
	}
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		System.out.println("Introduzca las horas : ");
		int horas= input.nextInt();
		System.out.println("El cargo calculado para sus "+horas+" horas es: S/ "+Calcularcargo(horas));
		
	}

}
