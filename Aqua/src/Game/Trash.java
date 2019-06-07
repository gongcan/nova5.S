package Game;

import java.util.Random;

public class Trash {
	String name;
	int HP;
	int avoid;
	int T;
	int C;
	CustomPlayer player3 = new CustomPlayer();
	CustomPlayer player4 = new CustomPlayer();
	CustomPlayer player5 = new CustomPlayer();
	CustomPlayer player6 = new CustomPlayer();
	
	Trash() {
		this.name=name;
		this.HP=HP;
		this.avoid=avoid;
	}
	public void fight () throws InterruptedException {
		Random random = new Random();

		player3.setPath("d:\\wavFile\\Hook.mp3");
		player4.setPath("d:\\wavFile\\casting.mp3");
		player5.setPath("d:\\wavFile\\CatchFish.mp3");
		player6.setPath("d:\\wavFile\\fail.mp3");
		player3.play(-1);
		System.out.println("▶낚시대를 던집니다.");

		Thread.sleep(500);
		player4.play(-1);
		T = random.nextInt(10);
		System.out.println("-▶물고기를 기다립니다.");
		Thread.sleep(T*500);
		
//		System.out.println(name+"가 나타났습니다.");
		System.out.println("--▶낚시대에 무언가 걸렸습니다.");

		Thread.sleep(1000); 
		do {
		Thread.sleep(500);
//		System.out.println(name + "가 발버둥칩니다.");
		System.out.println("---▶끌어올리는 중...");
		this.HP = this.HP-User.damage;
//		System.out.println("물고기와의 거리  : " + HP);
		if(HP>0) {
		System.out.println("남은 거리  : " + HP);
		}
		} while(HP>0);
		
		
		C = random.nextInt(10)-User.avoidLess; //잡을 수치. 높을수록 안잡힌다.
		if(avoid < C) {
			System.out.println("----▶아쉽지만 걸려온 것이 없습니다." + name + " 였던 것 같은데...");
			player6.play(-1);
		}
		else {
			System.out.println("----▶" +name + "가 올라왔습니다... 쓰레기라니...");
			player6.play(-1);
		}
	}
}
