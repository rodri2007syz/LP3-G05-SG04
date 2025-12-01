package PatronStrategy;

interface DiscountStrategy {
	 double applyDiscount(double price);
	} 

class NoDiscount implements DiscountStrategy {
	 public double applyDiscount(double price) {
	 return price;
	 }
	} 

class TenPercentDiscount implements DiscountStrategy {
	 public double applyDiscount(double price) {
	 return price * 0.9;
	 }
	}

class SpecialDiscount implements DiscountStrategy {
	 public double applyDiscount(double price) {
	 return price * 0.8;
	 }
	} 

class SpeciaMiembroClubt implements DiscountStrategy {
	 public double applyDiscount(double price) {
	 return price * 0.5 - 10;
	 }
	} 

class PriceCalculator {
	 private DiscountStrategy discountStrategy;

	 public void setDiscountStrategy(DiscountStrategy discountStrategy) {
	 this.discountStrategy = discountStrategy;
	 }
	 public double calculatePrice(double price) {
	 return discountStrategy.applyDiscount(price);
	 }
	} 