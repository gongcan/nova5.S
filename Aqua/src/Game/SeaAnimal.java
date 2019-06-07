package Game;

import java.util.Random;

public class SeaAnimal { // 해양생물
	public int num;
	public String name;
	public int price;
	public int HP;
	public String type;
	public String typeEffect;
	public String effect;
	public int showValue;
	public int avoid;

	CustomPlayer player3 = new CustomPlayer();
	CustomPlayer player4 = new CustomPlayer();
	CustomPlayer player5 = new CustomPlayer();
	CustomPlayer player6 = new CustomPlayer();

	int T;// 랜덤 기다리는 시간
	int C;// 랜덤 물고기 잡을 확률
	static int S = 500;// 쓰레드 대기시간
	int R; // 랜덤하게 물고기가 당겨지거나 끌려감

	SeaAnimal() {
		this.num = num;
		this.name = name;
		this.price = price;
		this.HP = HP;
		this.type = type;
		this.typeEffect = typeEffect;
		this.effect = effect;
		this.showValue = showValue;
		this.avoid = avoid; // 도망칠 확률
	}

	public void showPrice() {
		System.out.println("가격 : " + price * 100);
	}

	public void fight() throws InterruptedException {
		Random random = new Random();
		if (User.stamina > 0) {
			User.stamina--;
			player3.setPath("d:\\wavFile\\Hook.mp3");
			player4.setPath("d:\\wavFile\\casting.mp3");
			player5.setPath("d:\\wavFile\\CatchFish.mp3");
			player6.setPath("d:\\wavFile\\fail.mp3");
			player3.play(-1);
			Control.scroll();
			System.out.print("▶낚시대를 던집니다.");
			System.out.println("	남은 스태미나 : " + (User.stamina + 1));
			Thread.sleep(S);
			player4.play(-1);
			T = random.nextInt(10);
			System.out.println("-▶물고기를 기다립니다.");
			Thread.sleep(T * S);

//		System.out.println(name+"가 나타났습니다.");
			System.out.println("--▶낚시대에 무언가 걸렸습니다.");
			if (this.type.equals("연체류")) {
				if (this.name.equals("쭈꾸미")) {
//				System.out.println(name + "가 돌에 붙어서 버티는 것 같습니다.");
					System.out.println("무언가 돌에 붙어서 버티는 것 같습니다.");
					WebfootOctopus.power();
					System.out.println("-----------------------");
				}
				if (this.name.equals("오징어")) {
//				System.out.println(name + "가 돌에 붙어서 버티는 것 같습니다.");
					System.out.println("무언가 돌에 붙어서 버티는 것 같습니다.");
					Squid.power();
					System.out.println("-----------------------");
				}
				if (this.name.equals("문어")) {
//				System.out.println(name + "가 돌에 붙어서 버티는 것 같습니다.");
					System.out.println("무언가 돌에 붙어서 버티는 것 같습니다.");
					Octopus.power();
					System.out.println("-----------------------");
				}
				if (this.name.equals("크라켄")) {
//				System.out.println(name + "가 돌에 붙어서 버티는 것 같습니다.");
					System.out.println("무언가 돌에 붙어서 버티는 것 같습니다.");
					Craken.power();
					System.out.println("-----------------------");
				}
			} else {
				Thread.sleep(S * 2);
			}
			do {
				Thread.sleep(S);
//		System.out.println(name + "가 발버둥칩니다.");
				Control.scroll();
				System.out.println("---▶끌어올리는 중...");
				R = random.nextInt(11);

				if (this.type.equals("갑각류")) {
					if (R < 8) {
						this.HP = this.HP - User.damage;
					} else if (R == 8 || R== 9) {
						this.HP = this.HP + (User.damage/2);
					} else if (R == 10) {
						this.HP = -9999;
					}

				} else {
					if (R < 8) {
						this.HP = this.HP - User.damage;
					} else if (R >= 8) {
						this.HP = this.HP + (User.damage/2);
					}
				}
//		System.out.println("물고기와의 거리  : " + HP);
				if (HP > 0) {
					System.out.println("남은 거리  : " + HP);
				}
			} while (HP > 0);

			if(this.HP==-9999) {
				System.out.println("무언가가 줄을 끊고 도망쳤습니다." + name + " 였던 것 같은데...");
			}
			else {
				C = random.nextInt(10) - User.avoidLess; // 잡을 수치. 높을수록 안잡힌다.
				if (avoid < C) {
					System.out.println("----▶ 아쉽지만 걸려온 것이 없습니다." + name + " 였던 것 같은데...");
					player6.play(-1);
				} else {
					System.out.println("----▶			★" + name + "를 잡았습니다.★");

					Aquarium.isOver();
					if (!Aquarium.over) {
						Aquarium.ht.put(name, Aquarium.ht.get(name) + 1);
						System.out.println("현재 수족관 물고기 수 : " + (Aquarium.nowSize + 1));
						player5.play(-1);
					} else if (Aquarium.over) {
						System.out.println("수족관이 가득찼습니다. 물고기를 방생합니다.");
						player5.play(-1);
					}
				}
			} 
		} else if (User.stamina <= 0) {
			System.out.println("스테미나가 부족합니다. 내일 다시오시거나 스테미나를 회복하여 주세요");
		}

	}
}