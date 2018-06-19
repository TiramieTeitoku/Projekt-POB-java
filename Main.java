public class Main{
	static Manager mng = new Manager();
	public static void main(String[] args){
		mng.Menu();
		while(mng.GameIsOn()){
			mng.DrawGame();
		}
	}
}