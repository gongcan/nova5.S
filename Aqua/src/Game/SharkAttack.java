package Game;

public class SharkAttack implements Runnable {
	CustomPlayer player9 = new CustomPlayer();
	int sharkT=59900;
	public synchronized void sharkAttack() {

		if (Aquarium.ht.get("상어") > 0) {
			player9.setPath("d:\\wavFile\\sharkAttack.mp3");
			player9.play(-1);
			System.out.println("			★공지★ 수족관의 상어가 다른 어류들을 공격하고 있습니다. 상어를 빨리 분양해주세요");
			if (Aquarium.ht.get("피라미") > 0) {
				Aquarium.ht.put("피라미", Aquarium.ht.get("피라미") - 1);
				System.out.println("				피라미 : " + Aquarium.ht.get("피라미"));
			}
			if (Aquarium.ht.get("잉어") > 0) {
				Aquarium.ht.put("잉어", Aquarium.ht.get("잉어") - 1);
				System.out.println("				잉어 : " + Aquarium.ht.get("잉어"));

			}
			if (Aquarium.ht.get("참치") > 0) {
				Aquarium.ht.put("참치", Aquarium.ht.get("참치") - 1);
				System.out.println("				참치 : " + Aquarium.ht.get("참치"));

			}
			if (Aquarium.ht.get("고래") > 0) {
				Aquarium.ht.put("고래", Aquarium.ht.get("고래") - 1);
				System.out.println("				고래 : " + Aquarium.ht.get("고래"));

			}

		}

	}

	@Override
	public void run() {
		for (int i = 0; i < 99999999; i++) {
		try {
			Thread.sleep(sharkT);
			sharkAttack();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}

	}
}
