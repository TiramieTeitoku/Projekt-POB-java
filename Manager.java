import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Manager{
	static Scanner scn = new Scanner(System.in);
	int money, turnCount, maxAction, actionCount;
	boolean gameOn, toMenu;
	List<Cow> cowList = new ArrayList<Cow>();
	List<Hen> henList = new ArrayList<Hen>();
	List<Sheep> sheepList = new ArrayList<Sheep>();
	List<Wheet> wheetList = new ArrayList<Wheet>();
	List<Corn> cornList = new ArrayList<Corn>();
	enum Producers{
		COW,
		HEN,
		SHEEP,
		WHEET,
		CORN
	}
	enum Products {
		MILK,
		EGG,
		WOOL,
		CORNGRAIN,
		WHEETGRAIN
	}
	public Manager(){
		money = 100;
		turnCount = 1;
		maxAction = 3;
		actionCount = maxAction;
		toMenu = true;
	}
	public void DrawGame(){
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Aktualna tura: " + turnCount);
		System.out.println("Gotowka: " + money);
		System.out.println("Pozostale akcje: " + actionCount + "/" + maxAction);
		int op;
		if(toMenu){
			System.out.println("1. Kup");
			System.out.println("2. Sprzedaj");
			System.out.println("3. Stan farmy");
			System.out.println("4. Koniec tury");
			toMenu = false;
		}
		op = scn.nextInt();
		switch(op){
			case 1:
				int opBuy;
				System.out.println("1. Pole");
				System.out.println("2. Zwierzeta");
				System.out.println("0. Powrot");
				opBuy = scn.nextInt();
				switch(opBuy){
					case 1:
						int opGrain;
						System.out.println("1. Pszenica");
						System.out.println("2. Kukurydza");
						System.out.println("0. Powrot");
						opGrain = scn.nextInt();
						switch(opGrain){
							case 1:
								Buy(Producers.WHEET);
								toMenu = true;
								break;
							case 2:
								Buy(Producers.CORN);
								toMenu = true;
								break;
							default:
								toMenu = true;
								break;
						}
						break;
					case 2:
						int opAnimal;
						System.out.println("1. Kury");
						System.out.println("2. Krowy");
						System.out.println("3. Owce");
						System.out.println("0. Powrot");
						opAnimal = scn.nextInt();
						switch(opAnimal){
							case 1:
								Buy(Producers.HEN);
								toMenu = true;
								break;
							case 2:
								Buy(Producers.COW);
								toMenu = true;
								break;
							case 3:
								Buy(Producers.SHEEP);
								toMenu = true;
								break;
							default:
								toMenu = true;
								break;
						}
						break;
					default:
						System.out.println("1. Pole");
						System.out.println("2. Zwierzeta");
						System.out.println("0. Powrot");
						break;
				}
				break;
			case 2:
				System.out.println("1. Zboze");
				System.out.println("2. Produkty zwierzece");
				System.out.println("0. Powrot");
				int opSell = scn.nextInt();
				switch(opSell){
					case 1:
						System.out.println("1. Worki pszenicy");
						System.out.println("2. Worki kukurydzy");
						System.out.println("0. Powrot");
						int opGrain = scn.nextInt();
						switch(opGrain){
							case 1:
								Sell(Products.WHEETGRAIN);
								toMenu = true;
								break;
							case 2:
								Sell(Products.CORNGRAIN);
								toMenu = true;
								break;
							default:
							System.out.println("1. Worki pszenicy");
							System.out.println("2. Worki kukurydzy");
							System.out.println("0. Powrot");
							break;
						}
						break;
					case 2:
						System.out.println("1. Jajka");
						System.out.println("2. Mleko");
						System.out.println("3. Welna");
						System.out.println("0. Powrot");
						int opAniProd = scn.nextInt();
						switch(opAniProd){
							case 1:
								Sell(Products.EGG);
								toMenu = true;
								break;
							case 2:
								Sell(Products.MILK);
								toMenu = true;
								break;
							case 3:
								Sell(Products.WOOL);
								toMenu = true;
								break;
							default:
								break;
						}
					default:
						System.out.println("1. Zboze");
						System.out.println("2. Produkty zwierzece");
						System.out.println("0. Powrot");
						break;
				}
				break;
			case 3:
				System.out.println("Kury - " + Hen.GetAmount());
				System.out.println("Krowy - " + Cow.GetAmount());
				System.out.println("Owce - " + Sheep.GetAmount());
				System.out.println("Pola pszenicy - " + Wheet.GetAmount());
				System.out.println("Pola kukurydzy - " + Corn.GetAmount());
				System.out.println("Jajka - " + Producent.GetEgg());
				System.out.println("Mleko - " + Producent.GetMilk());
				System.out.println("Welna - " + Producent.GetWool());
				System.out.println("Worki pszenicy - " + Producent.GetWheet());
				System.out.println("Worki kukurydzy - " + Producent.GetCorn());
				break;
			case 4:
				NextTurn();
				System.out.println("Nowa tura rozpoczeta!");
				break;
			default:
				break;
		}
	}
	public void Menu(){
		System.out.println("Witem w symulatorze farmera! Wybierz opcje ");
		System.out.println("1. Nowa gra");
		System.out.println("2. Wyjscie");
		int opcja;
		boolean repeat;
		do{
			repeat = false;
			opcja = scn.nextInt();
			switch(opcja){
				case 1:
					gameOn = true;
					break;
				case 2:
					gameOn = false;
					break;
				default:
					System.out.println("Wybierz jedna z podanych opcji.");
					break;
			}
		}while(repeat);
	}
	public boolean GameIsOn(){
		return gameOn;
	}
	public void Buy(Producers P){
		if(actionCount > 0){
			switch(P){
				case COW:
					if(money >= Cow.GetBuyingPrice()){
						money -= Cow.GetBuyingPrice();
						Cow C = new Cow();
						cowList.add(C);
						actionCount--;
						Cow.IncrAmount();
					}
					else{
						System.out.println("Brak pieniedzy.");
					}
					break;
				case HEN:
					if(money >= Hen.GetBuyingPrice()){
						money -= Hen.GetBuyingPrice();
						Hen H = new Hen();
						henList.add(H);
						actionCount--;
						Hen.IncrAmount();
					}
					else{
						System.out.println("Brak pieniedzy.");
					}
					break;
				case SHEEP:
					if(money >= Sheep.GetBuyingPrice()){
						money -= Sheep.GetBuyingPrice();
						Sheep S = new Sheep();
						sheepList.add(S);
						actionCount--;
						Sheep.IncrAmount();
					}
					else{
						System.out.println("Brak pieniedzy.");
					}
					break;
				case WHEET:
					if(money >= Wheet.GetBuyingPrice()){
						money -= Wheet.GetBuyingPrice();
						Wheet W = new Wheet();
						wheetList.add(W);
						actionCount--;
						Wheet.IncrAmount();
					}
					else{
						System.out.println("Brak pieniedzy.");
					}
					break;
				case CORN:
					if(money >= Corn.GetBuyingPrice()){
						money -= Corn.GetBuyingPrice();
						Corn C = new Corn();
						cornList.add(C);
						actionCount--;
						Corn.IncrAmount();
					}
					else{
						System.out.println("Brak pieniedzy.");
					}
					break;
				default:
					break;
			}
		}
		else{
			System.out.println("Koniec punktow akcji.");
		}
	}
	public void Sell(Products P){
		if(actionCount > 0){
			switch(P){
				case MILK:
					if(Producent.GetMilk() > 0){
						money += (Producent.GetMilk()*ProductManager.milkPrice);
						Producent.SellMilk(Producent.GetMilk());
						actionCount--;
					}
					else{
						System.out.println("Brak mleka.");
					}
					break;
				case EGG:
					if(Producent.GetEgg() > 0){
						money += (Producent.GetEgg()*ProductManager.eggPrice);
						Producent.SellEgg(Producent.GetEgg());
						actionCount--;
					}
					else{
						System.out.println("Brak jajek.");
					}
					break;
				case WOOL:
					if(Producent.GetWool() > 0){
						money += (Producent.GetWool()*ProductManager.woolPrice);
						Producent.SellWool(Producent.GetWool());
						actionCount--;
					}
					else{
						System.out.println("Brak welny.");
					}
					break;
				case CORNGRAIN:
					if(Producent.GetCorn() > 0){
						money += (Producent.GetCorn()*ProductManager.cornGrainPrice);
						Producent.SellCorn(Producent.GetCorn());
						actionCount--;
					}
					else{
						System.out.println("Brak kukurydzy.");
					}
					break;
				case WHEETGRAIN:
					if(Producent.GetWheet() > 0){
						money += (Producent.GetWheet()*ProductManager.wheetGrainPrice);
						Producent.SellWheet(Producent.GetWheet());
						actionCount--;
					}
					else{
						System.out.println("Brak pszenicy.");
					}
					break;
			}
		}
		else{
			System.out.println("Koniec punktow akcji.");
		}
	}
	public void NextTurn(){
		if(!cowList.isEmpty()){
			for (Cow element : cowList){
				element.Produce();
			}
		}
		if(!henList.isEmpty()){
			for (Hen element : henList){
				element.Produce();
			}
		}
		if(!sheepList.isEmpty()){
			for (Sheep element : sheepList){
				element.Produce();
			}
		}
		if(!cornList.isEmpty()){
			for (Corn element : cornList){
				element.Produce();
			}
		}
		if(!wheetList.isEmpty()){
			for (Wheet element : wheetList){
				element.Produce();
			}
		}
		actionCount = maxAction;
		toMenu = true;
		turnCount++;
	}
}