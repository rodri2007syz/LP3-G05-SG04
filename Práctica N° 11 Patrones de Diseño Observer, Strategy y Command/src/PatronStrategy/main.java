package PatronStrategy;

public class main {
	 public static void main(String[] args) {
	 PriceCalculator calculator = new PriceCalculator();

	 
	 calculator.setDiscountStrategy(new NoDiscount());
	 System.out.println("Precio sin descuento: " +
	calculator.calculatePrice(200.0));

	 
	 calculator.setDiscountStrategy(new TenPercentDiscount());
	 System.out.println("Precio con 10% de descuento: " +
	calculator.calculatePrice(200.0));

	 
	 calculator.setDiscountStrategy(new SpecialDiscount());
	 System.out.println("Precio con descuento especial: " +
	calculator.calculatePrice(200.0));
	 
	 
	 calculator.setDiscountStrategy(new SpecialDiscount());
	 System.out.println("Precio para clientes mienbros del club " +
	calculator.calculatePrice(200.0));
	 }
	} 
