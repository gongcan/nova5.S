package Game;

public class Bakcas extends Item{
	int heal;
	Bakcas() {
		this.name="박카스";
		this.price=1000;
		this.heal=10;
	}
	

	public void SelledBakcas() {
		
		if(User.money>=this.price) {
			User.money=User.money-this.price;
			User.stamina=User.stamina+this.heal;
			System.out.println("스테미나가 10 회복되었습니다");
		}
		else if(User.money<this.price) {
			System.out.println("소지금이 부족합니다");
		}
	}

	public void showBakcas() {
		System.out.println("이름 : "+name);
		System.out.println("가격 : "+price);
		System.out.println("효과 : 스테미나 10 회복");
	}
}
