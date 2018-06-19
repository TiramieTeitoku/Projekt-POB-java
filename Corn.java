class Corn extends Producent{
	static int BuyingPrice = 300;
	static int Amount = 0;
	
	public void Produce(){
		pmng.AddCGrain();
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