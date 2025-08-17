package ejercicio1;

public class java1 {
	public static int sumaArreglo(int[] arreglo) {
		int total = 0;
        for (int i: arreglo) {
            total += i;
        }
        return total;
	}
	public static void main (String[] args) {
		int[] numeros= {1,2,3,4,5,6,7,8,9,10};
		System.out.println("La suma es: "+ sumaArreglo(numeros));
		
	}

}
