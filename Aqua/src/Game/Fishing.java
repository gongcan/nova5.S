package Game;

import java.util.Random;

public class Fishing {
	int F;


	public synchronized void Fishing() {
		Random random = new Random();
		F = random.nextInt(15);  //물고기 선정
//		F=14;
		if (F == 0) {
			Minnow minnow = new Minnow();
			try {
				minnow.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 1) {
			Carp carp = new Carp();
			try {
				carp.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 2) {
			Tuna tuna = new Tuna();
			try {
				tuna.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 3) {
			Shark shark = new Shark();
			try {
				shark.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 4) {
			Whale whale = new Whale();
			try {
				whale.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 5) {
			Shrimp shrimp = new Shrimp();
			try {
				shrimp.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 6) {
			Crab crab = new Crab();
			try {
				crab.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 7) {
			Lobster lobster = new Lobster();
			try {
				lobster.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 8) {
			GiantHermitCrab GiantHermitCrab = new GiantHermitCrab();
			try {
				GiantHermitCrab.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 9) {
			WebfootOctopus webfootOctopus = new WebfootOctopus();
			try {
				webfootOctopus.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 10) {
			Squid squid = new Squid();
			try {
				squid.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 11) {
			Octopus octopus = new Octopus();
			try {
				octopus.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 12) {
			Craken craken = new Craken();
			try {
				craken.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 13) {
			Can can= new Can();
			try {
				can.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (F == 14) {
			Tire tire = new Tire();
			try {
				tire.fight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		}

}