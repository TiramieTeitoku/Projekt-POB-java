class ProductManager{
	int milkAmount, eggAmount, woolAmount, cGrainAmount, wGrainAmount;
	public static int milkPrice = 20;
	public static int eggPrice = 5;
	public static int woolPrice = 15;
	public static int cornGrainPrice = 50;
	public static int wheetGrainPrice = 100;
	
	public void AddMilk(){
		milkAmount++;
	}
	public void AddEgg(){
		eggAmount++;
	}
	public void AddWool(){
		woolAmount++;
	}
	public void AddCGrain(){
		cGrainAmount++;
	}
	public void AddWGrain(){
		wGrainAmount++;
	}
	
	public int GetMilkAmount(){
		return milkAmount;
	}
	public int GetEggAmount(){
		return eggAmount;
	}
	public int GetWoolAmount(){
		return woolAmount;
	}
	public int GetCGrainAmount(){
		return cGrainAmount;
	}
	public int GetWGrainAmount(){
		
		return wGrainAmount;
	}
	
	public void SellMilk(int x){
		milkAmount -= x;
	}
	public void SellEgg(int x){
		eggAmount -= x;
	}
	public void SellWool(int x){
		woolAmount -= x;
	}
	public void SellCGrain(int x){
		cGrainAmount -= x;
	}
	public void SellWGrain(int x){
		wGrainAmount -= x;
	}
}