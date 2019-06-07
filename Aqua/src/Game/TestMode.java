package Game;

public class TestMode {
	boolean isTest=false;
	
	
	
	public void test() {
		if(!isTest) {
			isTest=true;
		Control.scroll();
		System.out.println("시연모드로 진입했습니다.");
		System.out.println("낚시시간 대폭감소");
		SeaAnimal.S = 100;
		System.out.println("유저 돈 99999999");
		User.money = 99999999;
		System.out.println("유저 공격력 1000");
		User.damage = 1000;
		System.out.println("유저 스테미나 1000");
		User.stamina = 1000;
		System.out.println("수족관 크기 무한대 물고기 100마리씩 추가");
		Aquarium.aquaSize=99999999;
		Aquarium.putAquaTest();
		System.out.println("번식장 크기 무한대 물고기 100마리씩 추가");
		Breed.breedSize=99999999;
		Breed.putBreedTest();
		System.out.println("보상주기 10초로 변경");
		Guest.T=10000;
		}
		else if (isTest) {
			isTest=false;
			Control.scroll();
			System.out.println("시연모드를 종료합니다.");
			System.out.println("낚시시간 복구");
			SeaAnimal.S = 500;
			System.out.println("유저 공격력 복구");
			User.damage = 10;
			System.out.println("유저 스테미나 복구");
			User.stamina = 10;
			System.out.println("유저 돈 복구");
			User.money = 10000;
			System.out.println("수족관 복구");
			Aquarium.aquaSize=5;
			Aquarium.putAquaTestReset();
			System.out.println("번식장 복구");
			Breed.breedSize=2;
			Breed.putBreedTestReset();
			System.out.println("보상주기 복구");
			Guest.T=60000;
		}
	}
}
