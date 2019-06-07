package Game;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Breed implements Runnable {
	static Hashtable<String, Integer> br = new Hashtable<String, Integer>();
	Scanner sc = new Scanner(System.in);
	String name;
	int choice;
	static int breedSize = 2;
	static int nowSizeB;
	static boolean overB = false;

	public static void putBreedTest() {

		br.put("피라미", br.get("피라미") + 100);
		br.put("잉어", br.get("잉어") + 100);
		br.put("참치", br.get("참치") + 100);
		br.put("상어", br.get("상어") + 100);
		br.put("고래", br.get("고래") + 100);
		br.put("새우", br.get("새우") + 100);
		br.put("꽃게", br.get("꽃게") + 100);
		br.put("가재", br.get("가재") + 100);
		br.put("거대소라게", br.get("거대소라게") + 100);
		br.put("쭈꾸미", br.get("쭈꾸미") + 100);
		br.put("오징어", br.get("오징어") + 100);
		br.put("문어", br.get("문어") + 100);
		br.put("크라켄", br.get("크라켄") + 100);

	}

	public static void putBreedTestReset() {
		br.put("피라미", 0);
		br.put("잉어", 0);
		br.put("참치", 0);
		br.put("상어", 0);
		br.put("고래", 0);
		br.put("새우", 0);
		br.put("꽃게", 0);
		br.put("가재", 0);
		br.put("거대소라게", 0);
		br.put("쭈꾸미", 0);
		br.put("오징어", 0);
		br.put("문어", 0);
		br.put("크라켄", 0);
	}

	Breed() {
		br.put("피라미", 0);
		br.put("잉어", 0);
		br.put("참치", 0);
		br.put("상어", 0);
		br.put("고래", 0);
		br.put("새우", 0);
		br.put("꽃게", 0);
		br.put("가재", 0);
		br.put("거대소라게", 0);
		br.put("쭈꾸미", 0);
		br.put("오징어", 0);
		br.put("문어", 0);
		br.put("크라켄", 0);
	}

	public synchronized static void isOverB() {
		nowSizeB = br.get("피라미") + br.get("잉어") + br.get("참치") + br.get("상어") + br.get("고래") + br.get("새우")
				+ br.get("꽃게") + br.get("가재") + br.get("거대소라게") + br.get("쭈꾸미") + br.get("오징어") + br.get("문어")
				+ br.get("크라켄");

		if (nowSizeB + 1 > breedSize) {
			overB = true;
		} else if (nowSizeB + 1 <= breedSize) {
			overB = false;
		}
	}

	public void showBreed() {

		System.out.println("------------------------------");
		System.out.println("번식장 크기 : " + breedSize);
		System.out.print("현재 번식장 물고기 수 : ");
		isOverB();
		System.out.println(nowSizeB);
		Enumeration en = br.keys();
		while (en.hasMoreElements()) {
			String key = en.nextElement().toString();
			System.out.println("	" + key + " : " + br.get(key));
		}
	}

	public void breedIn() {
		System.out.println("번식장에 넣을 물고기를 입력해주세요");
		name = sc.next();
		if (br.containsKey(name)) {
			if (Aquarium.ht.get(name) >= 2) {
				System.out.println("현재 수족관에 " + Aquarium.ht.get(name) + "마리가 있습니다.");
				System.out.println("2마리를 번식장에 넣으시겠습니까?");
				System.out.println("1 : 넣는다");
				System.out.println("2 : 돌아가기");
				choice = sc.nextInt();
				if (choice == 1) {
					Aquarium.ht.put(name, Aquarium.ht.get(name) - 2);
					br.put(name, br.get(name) + 2);
					System.out.println("번식장에 " + name + "2마리를 넣었습니다.");
					showBreed();
				}
			}

			else if (Aquarium.ht.get(name) < 2) {
				System.out.println("번식을 위해서는 같은종류의 물고기가 2마리 이상 필요합니다.");
			} else if (!br.containsKey(name)) {
				System.out.println("해당하는 물고기가 없습니다.");
			}
		}

	}

	public void breedOut() {
		System.out.println("번식장에서 빼낼 물고기를 입력해주세요");
		name = sc.next();
		if (br.containsKey(name)) {
			if (Aquarium.ht.get(name) >= 2) {
				System.out.println("현재 수족관에 " + Aquarium.ht.get(name) + "마리가 있습니다.");
				System.out.println("몇마리를 번식장에서 수족관으로 옮기시겠습니까?");
				choice = sc.nextInt();
				if (choice >= 2) {
					Aquarium.ht.put(name, Aquarium.ht.get(name) + choice);
					br.put(name, br.get(name) - choice);
					System.out.println("수족관으로 " + name + "을" + choice + "마리를 이동하였습니다.");
					showBreed();
				}			else if (choice < 2) {
					System.out.println("수족관에 해당 물고기가 부족합니다.");
					System.out.println("번식을 위해서는 같은종류의 물고기가 2마리 이상 필요합니다.");
				}
				}
			else if (!br.containsKey(name)) {
				System.out.println("해당하는 물고기가 없습니다.");
			}
		}

	}

	public void breed() {
		if (br.get("피라미") >= 2) {
			System.out.println("	피라미 번식 성공	");
			if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 500;
				Aquarium.ht.put("피라미", Aquarium.ht.get("피라미") + 1);
//				System.out.println("수족관에 피라미가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
			}
		}
		if (br.get("잉어") >= 2) {
			System.out.println("	잉어 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("잉어", Aquarium.ht.get("잉어") + 1);
//				System.out.println("수족관에 잉어가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 1000;
			}
		}
		if (br.get("참치") >= 2) {

			System.out.println("	참치 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("참치", Aquarium.ht.get("참치") + 1);
//				System.out.println("수족관에 참치가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 2000;
			}

		}
		if (br.get("상어") >= 2) {

			System.out.println("	상어 번식 성공");
			if (Aquarium.nowSize + 1<= Aquarium.aquaSize) {
				Aquarium.ht.put("상어", Aquarium.ht.get("상어") + 1);
//				System.out.println("수족관에 상어가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 3000;
			}
		}
		if (br.get("고래") >= 2) {

			System.out.println("	고래 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("고래", Aquarium.ht.get("고래") + 1);
//				System.out.println("수족관에 고래가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 4000;
			}
		}
		if (br.get("새우") >= 2) {

			System.out.println("	새우 번식 성공"	);
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("새우", Aquarium.ht.get("새우") + 1);
//				System.out.println("수족관에 새우가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 1000;
			}
		}
		if (br.get("꽃게") >= 2) {

			System.out.println("	꽃게 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("꽃게", Aquarium.ht.get("꽃게") + 1);
//				System.out.println("수족관에 꽃게가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 2000;
			}
		}
		if (br.get("가재") >= 2) {

			System.out.println("	가재 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("가재", Aquarium.ht.get("가재") + 1);
//				System.out.println("수족관에 가재가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 3000;
			}
		}
		if (br.get("거대소라게") >= 2) {

			System.out.println("	거대소라게 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("거대소라게", Aquarium.ht.get("거대소라게") + 1);
//				System.out.println("수족관에 거대소라게가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 4000;
			}
		}
		if (br.get("쭈꾸미") >= 2) {

			System.out.println("	쭈꾸미 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("쭈꾸미", Aquarium.ht.get("쭈꾸미") + 1);
//				System.out.println("수족관에 쭈꾸미가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 1000;
			}
		}
		if (br.get("오징어") >= 2) {

			System.out.println("	오징어 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("오징어", Aquarium.ht.get("오징어") + 1);
//				System.out.println("수족관에 오징어가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 2000;
			}
		}
		if (br.get("문어") >= 2) {

			System.out.println("	문어 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("문어", Aquarium.ht.get("문어") + 1);
//				System.out.println("수족관에 문어가 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 3000;
			}
		}
		if (br.get("크라켄") >= 2) {

			System.out.println("	크라켄 번식 성공");
			if (Aquarium.nowSize + 1 <= Aquarium.aquaSize) {
				Aquarium.ht.put("크라켄", Aquarium.ht.get("크라켄") + 1);
//				System.out.println("수족관에 크라켄이 추가됩니다.");
			} else if (Aquarium.nowSize + 1 > Aquarium.aquaSize) {
				System.out.println("수족관이 가득 차서 바로 분양되었습니다.");
				User.money = User.money + 4000;
			}
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 99999999; i++) {

			try {
				Thread.sleep(40050);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			breed();
		}
	}
}
