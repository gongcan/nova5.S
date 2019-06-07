package Game;

import java.util.Random;
import java.util.Scanner;


public class Nandong{
	Nandong() {
		

	}
public synchronized void nandong() {
	int price=1000;
	int targetCount=6;
	Control.scroll();
	System.out.println("난동을 피우는 손님이 있습니다!\n\n\n");
	System.out.println("어서 손님을 따라가서 진압해주세요!");
	int F;
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
//	for (int i = 0; i < mapper.targetCount; i++) {
//			int a = random.nextInt(24);
//			System.out.print(a + " ");
//	}
	System.out.println("\n\n\n");
	
	String sarray[][] = { // 유저 인터페이스
			{ "1", "2", "3", "4", "6" }, 
			{ "q", "w", "e", "r", "y" }, 
			{ "a", "s", "d", "f", "h" },
			{ "z", "x", "c", "v", "n"} };
	String shot;

	int N = 4;

	int[][] array = new int[N][N];
	char[][] Carray = new char[N][N];

	for (int i = 0; i < N; i++) {

		for (int j = 0; j < N; j++) {

			array[i][j] = (int) (random.nextInt(2));

		}

	}



	do {//표적맵 보여주기
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				if (array[i][j] == 0) {
					Carray[i][j] = ' ';
				} else if(array[i][j] == 1)  {
					Carray[i][j] = '○';
				} else if(array[i][j] > 1)  {
					Carray[i][j] = '●';
				}
				

//					System.out.print(array[i][j] + " ");
				System.out.print(Carray[i][j] + " | ");


			}

			System.out.println();

		}
		System.out.println("					n : 포기하기");
		System.out.println("해당하는 키를 입력 해주시면 손님을 쫓을 수 있습니다");
		System.out.println("1  2  3  4");
		System.out.println("q  w  e  r");
		System.out.println("a  s  d  f");
		System.out.println("z  x  c  v");
		shot = sc.next();
	if (sarray[0][0].equals(shot)) {
		array[0][0] = array[0][0]+6;
	} else if (sarray[0][1].equals(shot)) {
		array[0][1] = array[0][1]+6;
	} else if (sarray[0][2].equals(shot)) {
		array[0][2] = array[0][2]+6;
	} else if (sarray[0][3].equals(shot)) {
		array[0][3] = array[0][3]+6;
	} else if (sarray[1][0].equals(shot)) {
		array[1][0] = array[1][0]+6;
	} else if (sarray[1][1].equals(shot)) {
		array[1][1] = array[1][1]+6;
	} else if (sarray[1][2].equals(shot)) {
		array[1][2] = array[1][2]+6;
	} else if (sarray[1][3].equals(shot)) {
		array[1][3] = array[1][3]+6;
	} else if (sarray[2][0].equals(shot)) {
		array[2][0] = array[2][0]+6;
	} else if (sarray[2][1].equals(shot)) {
		array[2][1] = array[2][1]+6;
	} else if (sarray[2][2].equals(shot)) {
		array[2][2] = array[2][2]+6;
	} else if (sarray[2][3].equals(shot)) {
		array[2][3] = array[2][3]+6;
	} else if (sarray[3][0].equals(shot)) {
		array[3][0] = array[3][0]+6;
	} else if (sarray[3][1].equals(shot)) {
		array[3][1] = array[3][1]+6;
	} else if (sarray[3][2].equals(shot)) {
		array[3][2] = array[3][2]+6;
	} else if (sarray[3][3].equals(shot)) {
		array[3][3] = array[3][3]+6;			
	} else if (sarray[3][4].equals(shot)) {
		targetCount=-5;			
	}	
	{
		Control.scroll();
	if (targetCount!=-5) {
		System.out.println(                                                                                                   
				"                    못맞췄지롱~~~~~~~~~~                                                              \r\n" + 
				"                                                                         ㅋㅋㅋㅋㅋㅋㅋㅋ                            \r\n" + 
		 
				"");	
		
	}
	
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j]==7) {
					Control.scroll();
					System.out.println("좋습니다! 계속 따라가시죠!");
					int D=1; //데미지
					targetCount=targetCount-D;
					array[i][j]=0;
					}
					}	
				}
	
			}
	} while(targetCount>0);
			
		
	
	if (targetCount==0 || targetCount==-1 || targetCount==-2 || targetCount==-3) {
	System.out.println("난동을 진압했습니다.");
	
	System.out.println(price + "만큼 소지금이 증가합니다");
	User.money = User.money+price;
	}
	else {
		System.out.println("난동을 피운 손님이 도망쳤습니다.");
	}
	System.out.println();
}



}
