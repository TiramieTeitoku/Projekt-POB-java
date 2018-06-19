class Sheep extends Producent{
	static int BuyingPrice = 70;
	static int Amount = 0;
	
	public void Produce(){
		pmng.AddWool();
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