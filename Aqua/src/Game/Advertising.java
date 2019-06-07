package Game;

public class Advertising implements Runnable {
	int adSleep=60050;
	
	public synchronized void advertising() {
		if(Guest.isAd) {
			System.out.println("			★광고효과가 종료되었습니다.");
			Guest.isAd=false;
		}
		}
	
	@Override
	public void run() {
		for (int i = 0; i < 99999999; i++) {
		try {
			Thread.sleep(adSleep);
			advertising();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
	}
}
