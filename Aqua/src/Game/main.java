package Game;

import java.util.Scanner;
import java.util.Random;

public class main extends Thread {

	public static int choice;

	public static void main(String[] args) {
		// 시스템 및 유저설정
		Control control = new Control();
		Scanner sc = new Scanner(System.in);
		User user = new User();
		TestMode test = new TestMode();
		// 아이템설정
		Fishing fishing = new Fishing();
		대나무낚시대 대나무낚시대 = new 대나무낚시대();
		유리낚시대 유리낚시대 = new 유리낚시대();
		카본낚시대 카본낚시대 = new 카본낚시대();
		돛단배 돛단배 = new 돛단배();
		요트 요트 = new 요트();
		원양어선 원양어선 = new 원양어선();
		Bakcas 박카스 = new Bakcas();
		// 물고기 설정
		Minnow minnow = new Minnow();
		Carp carp = new Carp();
		Tuna tuna = new Tuna();
		Shark shark = new Shark();
		Whale whale = new Whale();
		Shrimp shrimp = new Shrimp();
		Crab crab = new Crab();
		Lobster lobster = new Lobster();
		GiantHermitCrab GiantHermitCrab = new GiantHermitCrab();
		WebfootOctopus webfootOctopus = new WebfootOctopus();
		Squid squid = new Squid();
		Octopus octopus = new Octopus();
		Craken craken = new Craken();
		// 수족관설정
		Aquarium aquarium = new Aquarium();
		aquarium.start();
		int upPrice=500;
		//번식장 설정
		Breed breed = new Breed();
		Thread tBreed = new Thread(breed);
		tBreed.start();
		// 손님설정
		Nandong nandong = new Nandong();
		Guest rGuest = new Guest();
		Thread tGuest = new Thread(rGuest);
		tGuest.start();
		
		// 광고설정
		Advertising ad = new Advertising();
		Thread tAd = new Thread(ad);
		tAd.start();
		//상어설정
		SharkAttack sharkAttack = new SharkAttack();
		Thread tSharkAttack = new Thread(sharkAttack);
		tSharkAttack.start();
		// 배경음악설정
		CustomPlayer player1 = new CustomPlayer();
		CustomPlayer player2 = new CustomPlayer();
		player1.setPath("d:\\wavFile\\bgm.mp3");
		player2.setPath("d:\\wavFile\\Sailing.mp3");
		player1.play(-1);

		// 입력받을 선택지
		int choice;

		// 로고 보여주기
		control.scroll();
		control.logo();

		do {
			if (User.name == null) {
				user.userNameSet();
				control.menu();
			}

			choice = sc.nextInt();
			if (choice == 0) {
				control.scroll();
				user.info();
				choice = -1;
			} else if (choice == 1) {
				fishing.Fishing();

				choice = -1;
			} else if (choice == 2) {

				System.out.println("0 : 수족관 상태보기");
				System.out.println("1 : 수족관 사이즈 늘리기");
				System.out.println("2 : 물고기 분양하기");
				System.out.println("3 : 미니게임(난동진압)");
				System.out.println("4 : 수족관 광고하기");
				choice = sc.nextInt();
				if (choice == 0) {
					try {
						aquarium.showAqua();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				 else if (choice == 1) {
						//수족관 크기 늘리기
						System.out.println("현재 수족관의 크기는 " + aquarium.aquaSize + " 입니다.");
						System.out.println(upPrice + "원을 사용하여 수족관 크기를 늘리시겠습니까?");
						System.out.println("1 : 늘린다.");
						System.out.println("2 : 돌아가기");
						choice=sc.nextInt();
						if(choice ==1) {
							if(user.money>=upPrice) {
								user.money=user.money-upPrice;
								aquarium.aquaSize=aquarium.aquaSize+1;
								upPrice=upPrice+500;
								System.out.println("업그레이드 완료");
							}
							else if (user.money < upPrice) {
								System.out.println("소지금이 모자랍니다.");
							}
						}
					 }
				else if (choice == 2) {
					//물고기 분양
					System.out.println("분양하실 물고기 이름을 알려주세요 ");
					String fish;	//어떤물고기를
					int howMany;	//몇마리 팔아서
					int pay = 0;		//얼마를 받을것인가
					
					fish = sc.next();
					
					control.scroll();
					if (aquarium.ht.containsKey(fish)) {
						System.out.println("현재" + aquarium.ht.get(fish) + "마리의" + fish + "가 있습니다.");
						if (fish.equals("피라미")) {
							minnow.showPrice();
						} else if (fish.equals("잉어")) {
							carp.showPrice();
						} else if (fish.equals("참치")) {
							tuna.showPrice();
						} else if (fish.equals("상어")) {
							shark.showPrice();
						} else if (fish.equals("고래")) {
							whale.showPrice();
						} else if (fish.equals("새우")) {
							shrimp.showPrice();
						} else if (fish.equals("꽃게")) {
							crab.showPrice();
						} else if (fish.equals("가재")) {
							lobster.showPrice();
						} else if (fish.equals("거대소라게")) {
							GiantHermitCrab.showPrice();
						} else if (fish.equals("쭈꾸미")) {
							webfootOctopus.showPrice();
						} else if (fish.equals("오징어")) {
							squid.showPrice();
						} else if (fish.equals("문어")) {
							octopus.showPrice();
						} else if (fish.equals("크라켄")) {
							craken.showPrice();
						}
						System.out.println("몇마리를 분양하시겠습니까?");
						howMany = sc.nextInt();
						if (howMany <= aquarium.ht.get(fish)) {
							aquarium.ht.put(fish, aquarium.ht.get(fish) - howMany);
							if (fish.equals("피라미")) {
								User.money = User.money + (minnow.price * howMany * 100);
								pay=(minnow.price * howMany * 100);
							} else if (fish.equals("잉어")) {
								User.money = User.money + (carp.price * howMany * 100);
								pay=(carp.price * howMany * 100);
							} else if (fish.equals("참치")) {
								User.money = User.money + (tuna.price * howMany * 100);
								pay=(tuna.price * howMany * 100);
							} else if (fish.equals("상어")) {
								User.money = User.money + (shark.price * howMany * 100);
								pay=(shark.price * howMany * 100);
							} else if (fish.equals("고래")) {
								User.money = User.money + (whale.price * howMany * 100);
								pay=(whale.price * howMany * 100);
							} else if (fish.equals("새우")) {
								User.money = User.money + (shrimp.price * howMany * 100);
								pay=(shrimp.price * howMany * 100);
							} else if (fish.equals("꽃게")) {
								User.money = User.money + (crab.price * howMany * 100);
								pay=(crab.price * howMany * 100);
							} else if (fish.equals("가재")) {
								User.money = User.money + (lobster.price * howMany * 100);
								pay=(lobster.price * howMany * 100);
							} else if (fish.equals("거대소라게")) {
								User.money = User.money + (GiantHermitCrab.price * howMany * 100);
								pay=(GiantHermitCrab.price * howMany * 100);
							} else if (fish.equals("쭈꾸미")) {
								User.money = User.money + (webfootOctopus.price * howMany * 100);
								pay=(webfootOctopus.price * howMany * 100);
							} else if (fish.equals("오징어")) {
								User.money = User.money + (squid.price * howMany * 100);
								pay=(squid.price * howMany * 100);
							} else if (fish.equals("문어")) {
								User.money = User.money + (octopus.price * howMany * 100);
								pay=(octopus.price * howMany * 100);
								
							} else if (fish.equals("크라켄")) {
								User.money = User.money + (craken.price * howMany * 100);
								pay=(craken.price * howMany * 100);
							}
							System.out.println(pay+" 만큼의 분양비가 지급되었습니다.");

						} else if (howMany > aquarium.ht.get(fish)) {
							System.out.println("물고기가 모자랍니다.");
						}
					} else {
						System.out.println("입력해주신 물고기는 존재하지 않습니다.");
					}

				}
				
				else if (choice == 3) {
					//미니게임
					nandong.nandong();
				}
				else if (choice ==4) {
					System.out.println("수족관을 광고하면 일시적으로(1분) 두배의 보상을 받게 됩니다.");
					System.out.println(" 광고패키지 = 2만원");
					System.out.println(" 1 : 광고하기 ");
					System.out.println(" 2 : 돌아가기 ");
					choice=sc.nextInt();
					if (choice==1) {
						if(User.money>=20000) {
						User.money=User.money-20000;
						System.out.println("광고가 시작됩니다.");
						Guest.isAd=true;
						}
						else if(User.money<20000) {
							System.out.println("소지금이 부족합니다.");
						}
					}
					
				}
				choice = -1;
			} else if (choice == 3) {
				control.scroll();
				System.out.println("구매하실 아이템을 선택해주세요");
				System.out.println("낚시대(당기는 힘 증가)------------------------------");
				System.out.println("0 : 대나무낚시대");
				System.out.println("1 : 유리낚시대");
				System.out.println("2 : 카본낚시대");
				System.out.println("배(물고기잡을 확률 증가)------------------------------");
				System.out.println("3 : 돛단배");
				System.out.println("4 : 요트");
				System.out.println("5 : 원양어선");
				System.out.println("회복아이템(스테미나 회복)--------------------------");
				System.out.println("6 : 박카스");
				choice = sc.nextInt();
				if (choice == 0) {
					control.scroll();
					대나무낚시대.showRod();
					System.out.println("구매하시겠습니까?");
					System.out.println("1 : 구매");
					System.out.println("2 : 나가기");
					choice = sc.nextInt();
					if (choice == 1) {
						대나무낚시대.SelledRod();
					}

				} else if (choice == 1) {
					control.scroll();
					유리낚시대.showRod();
					System.out.println("구매하시겠습니까?");
					System.out.println("1 : 구매");
					System.out.println("2 : 나가기");
					choice = sc.nextInt();
					if (choice == 1) {
						유리낚시대.SelledRod();
						대나무낚시대.isSell = true;
					}
				} else if (choice == 2) {
					control.scroll();
					카본낚시대.showRod();
					System.out.println("구매하시겠습니까?");
					System.out.println("1 : 구매");
					System.out.println("2 : 나가기");
					choice = sc.nextInt();
					if (choice == 1) {
						카본낚시대.SelledRod();
						유리낚시대.isSell = true;
						대나무낚시대.isSell = true;
					}
				} else if (choice == 3) {
					control.scroll();
					돛단배.showShip();
					System.out.println("구매하시겠습니까?");
					System.out.println("1 : 구매");
					System.out.println("2 : 나가기");
					choice = sc.nextInt();
					if (choice == 1) {
						돛단배.SelledShip();
					}
				} else if (choice == 4) {
					control.scroll();
					요트.showShip();
					System.out.println("구매하시겠습니까?");
					System.out.println("1 : 구매");
					System.out.println("2 : 나가기");
					choice = sc.nextInt();
					if (choice == 1) {
						요트.SelledShip();
						돛단배.isSell = true;
					}
				} else if (choice == 5) {
					control.scroll();
					원양어선.showShip();
					System.out.println("구매하시겠습니까?");
					System.out.println("1 : 구매");
					System.out.println("2 : 나가기");
					choice = sc.nextInt();
					if (choice == 1) {
						원양어선.SelledShip();
						요트.isSell = true;
						돛단배.isSell = true;
					}
				} else if (choice == 6) {
					control.scroll();
					박카스.showBakcas();
					System.out.println("구매하시겠습니까?");
					System.out.println("1 : 구매");
					System.out.println("2 : 나가기");
					choice = sc.nextInt();
					if (choice == 1) {
						박카스.SelledBakcas();
					}
				}

				choice = -1;
			} else if (choice == 4) {
				
					//번식장

					control.scroll();
					System.out.println("무엇을 하시겠습니까?");
					System.out.println("0 : 번식장 상태보기 " );
					System.out.println("1 : 번식장에 물고기 넣기");
					System.out.println("2 : 번식장에서 물고기 빼기");
					System.out.println("3 : 번식장 크기 증가");
					
					choice = sc.nextInt();
					if(choice==0) {
						System.out.println("현재 번식장 상태입니다.");
						breed.showBreed();
					}
					else if(choice==1) {
						breed.breedIn();
					}
					else if(choice==2) {
						breed.breedOut();
					}
					else if(choice==3) {
						//번식장 크기 늘리기
						System.out.println("현재 번식장의 크기는 " + breed.breedSize + " 입니다.");
						System.out.println(upPrice + "원을 사용하여 번식장 크기를 늘리시겠습니까?");
						System.out.println("1 : 늘린다.");
						System.out.println("2 : 돌아가기");
						choice=sc.nextInt();
						if(choice ==1) {
							if(user.money>=upPrice) {
								user.money=user.money-upPrice;
								breed.breedSize=breed.breedSize+2;
								upPrice=upPrice+500;
								System.out.println("업그레이드 완료");
							}
							else if (user.money < upPrice) {
								System.out.println("소지금이 모자랍니다.");
							}
						}
					}
					choice=-1;
				}
			 else if (choice == 5) {
//				System.out.println(player2.canResume);
				if (player1.canResume == false) {
					player1.pause();
					control.scroll();
					System.out.println("배경음악 일시정지");
				} else if (player1.canResume == true) {
					player1.resume();
					control.scroll();
					System.out.println("배경음악 다시시작");
				}
				choice = -1;
			} else if (choice == 99) {
				test.test();
			} else {
				control.scroll();
				System.out.println("인식하지 못했습니다.");
			}

			control.menu();
			choice = -1;
//			Thread.sleep(60000);
		} // do 문 종료
		while (true);

	}

}
