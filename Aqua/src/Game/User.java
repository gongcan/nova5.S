package Game;

import java.util.Scanner;

public class User {

	Scanner sc = new Scanner(System.in);
	static String name;
	static int money;
	static String useWeapon;
	static String useShip;
	static int damage;
	static int avoidLess;
	static int stamina;

	User() {
		this.name=null;
		this.money=10000;
		this.useWeapon="대나무낚시대";
		this.useShip="나룻배";
		this.damage=10;
		this.avoidLess=0;
		this.stamina=10;
	}
	
	public void info() {

			System.out.println("\n		유저상태입니다."
					+ "\n	이름 : "  + name
					+ "\n	소지금 : "+ money
					+ "\n	낚시대 : " + useWeapon
					+ "\n	배 : " + useShip
					+ "\n	공격력(당기는 힘) : " + damage
					+ "\n	스테미나 : " + stamina
					
						);
		
	}
	public void attack() {
	
	}
	public void userNameSet() {
		System.out.println("당신의 이름을 알려주세요");
		name= sc.next();
	}
}
