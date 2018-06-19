class Producent{
	static int totalAmount;
	int cooldownTime;
	protected static ProductManager pmng = new ProductManager();
	
	public static int GetAmount(){
		return totalAmount;
	}
	
	public static int GetMilk(){
		return pmng.GetMilkAmount();
	}
	public static int GetEgg(){
		return pmng.GetEggAmount();
	}
	public static int GetWool(){
		return pmng.GetWoolAmount();
	}
	public static int GetCorn(){
		return pmng.GetCGrainAmount();
	}
	public static int GetWheet(){
		return pmng.GetWGrainAmount();
	}
	
	public static void SellMilk(int x){
		pmng.SellMilk(x);
	}
	public static void SellWool(int x){
		pmng.SellWool(x);
	}
	public static void SellEgg(int x){
		pmng.SellEgg(x);
	}
	public static void SellCorn(int x){
		pmng.SellCGrain(x);
	}
	public static void SellWheet(int x){
		pmng.SellWGrain(x);
	}
}