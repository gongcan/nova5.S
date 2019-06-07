package Game;

public class Rod extends Item{
	int damage;
	
	Rod() {
		this.damage=damage;
	}
	
	public void SelledRod() {
		
		if(this.isSell==false) {
		if(User.money>=this.price) {
			User.money=User.money-this.price;
			User.damage=this.damage;
			User.useWeapon=this.name;
			this.isSell=true;
		}
		else if(User.money<this.price) {
			System.out.println("소지금이 부족합니다");
		}
		}
		else if (this.isSell=true) {
			System.out.println("이미 구매한 아이템이거나 상위아이템을 이미 구입하였습니다.");
		}
	}

	public void showRod() {
		System.out.println("이름 : "+name);
		System.out.println("가격 : "+price);
		System.out.println("공격력(당기는 힘) : "+(damage-10));
		if(isSell) {
		System.out.println("구매여부 : 구매함");
		}
		else if(!isSell) {
			System.out.println("구매여부 : 구매하지 않음");
		}
	}
}

