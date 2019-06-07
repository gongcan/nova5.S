package Game;

public class Ship extends Item{
	int avoidLess;
	Ship() {
		this.avoidLess=avoidLess;
	}
	
	public void SelledShip() {
		
		if(this.isSell==false) {
		if(User.money>=this.price) {
			User.money=User.money-this.price;
			User.avoidLess=this.avoidLess;
			User.useShip=this.name;
			this.isSell=true;
		}
		else if(User.money<this.price) {
			System.out.println("소지금이 부족합니다");
		}
		}
		else if (this.isSell=true) {
			System.out.println("이미 구매한 아이템입니다.");
		}
	}

	public void showShip() {
		System.out.println("이름 : "+name);
		System.out.println("가격 : "+price);
		System.out.println("낚시성공률 : +"+ (avoidLess*10));
		if(isSell) {
		System.out.println("구매여부 : 구매함");
		}
		else if(!isSell) {
			System.out.println("구매여부 : 구매하지 않음");
		}
	}
}