class Cow extends Producent{
	static int BuyingPrice = 100;
	static int Amount;
	
	public void Produce(){
		pmng.AddMilk();
	}
	public static int GetBuyingPrice(){
		return BuyingPrice;
	}
	public static int GetAmount(){
		return Amount;
	}
	public static void IncrAmount(){
		Amount++;
	}
}