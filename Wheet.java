class Wheet extends Producent{
	static int BuyingPrice = 200;
	static int Amount = 0;
	
	public void Produce(){
		pmng.AddWGrain();
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