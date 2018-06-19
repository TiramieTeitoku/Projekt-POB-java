class Hen extends Producent{
	static int BuyingPrice = 20;
	static int Amount = 0;
	
	public void Produce(){
		pmng.AddEgg();
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