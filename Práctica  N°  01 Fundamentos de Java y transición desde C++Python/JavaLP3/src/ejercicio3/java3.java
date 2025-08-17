package ejercicio3;
import java.util.Random;

public class java3 {
	public static void main (String[] args) {
		int numero=20000, c1=0 , c2=0 , c3=0 , c4=0 ,c5=0 ,c6=0;
		Random random=new Random();
		for (int n=0; n<=numero;n++) {
			int i=random.nextInt(6)+1;
			if (i==1) {
				c1+=1;
			}
			if(i==2) {
				c2+=1;
			}
			if(i==3) {
				c3+=1;
			}
			if(i==4) {
				c4+=1;
			}
			
			if(i==5) {
				c5+=1;
			}
			if(i==6) {
				c6+=1;
			}
		}
		System.out.println("La cantidad de repeticiones de caras fue : 1: "+ c1+ " 2: " +c2 +" 3: "+c3+" 4: "+c4+" 5: "+c5+" 6: "+c6);
		
	}

}
