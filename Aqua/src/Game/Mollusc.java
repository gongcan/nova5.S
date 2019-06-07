package Game;


public class Mollusc extends SeaAnimal{ //연체류
	
	static int powerTime;
	
	Mollusc () {
		this.type = "연체류";

	}

	public static void power() {
		try {
			Thread.sleep(powerTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
