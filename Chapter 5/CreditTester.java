
public class CreditTester {
	public static void main(String[] args) {
		CreditAccount c1 = new CreditAccount("Bob Jones", 10000.00, 0.12);
		
		System.out.println(c1);
		
		c1.makeCharge(1000.00);
		c1.makeCharge(3000.00);
		
		System.out.println(c1);
		
		System.out.println(c1.calculateMinimumMonthlyPayment());
		
		c1.makePayment(13000.00);
		System.out.println(c1);
		
		System.out.println(c1.calculateMinimumMonthlyPayment());
		System.out.println(c1.calculateInterestAmountForMonth());
		System.out.println(c1.howManyMonthsUsingConstantPayment(100.00));
		
		RewardsCreditAccount c2 = new RewardsCreditAccount("Special Sue", 500.00, 0.0254);
		System.out.println(c2);
		
		c2.makeCharge(100.00);
		System.out.println(c2);
	}
}
