package Game;


import java.util.Scanner;


public class Control {

	Scanner sc = new Scanner(System.in);
	
	Control() {
	}

	public static void scroll() {
		for (int i = 0; i < 50; i++) {
			System.out.println();

		}
	}

	public void logo() {

		System.out.println(
			
				"   █████╗   ██████╗  ██╗   ██╗  █████╗          \r\n" + 
				"  ██╔══██╗ ██╔═══██╗ ██║   ██║ ██╔══██╗         \r\n" + 
				"  ███████║ ██║   ██║ ██║   ██║ ███████║         \r\n" + 
				"  ██╔══██║ ██║▄▄ ██║ ██║   ██║ ██╔══██║         \r\n" + 
				"  ██║  ██║ ╚██████╔╝ ╚██████╔╝ ██║  ██║         \r\n" + 
				"  ╚═╝  ╚═╝  ╚══▀▀═╝   ╚═════╝  ╚═╝  ╚═╝         \r\n" + 
				"                                             \r\n" + 
				"  ███████╗ ████████╗  ██████╗  ██████╗  ██╗   ██╗\r\n" + 
				"  ██╔════╝ ╚══██╔══╝ ██╔═══██╗ ██╔══██╗ ╚██╗ ██╔╝\r\n" + 
				"  ███████╗    ██║    ██║   ██║ ██████╔╝  ╚████╔╝ \r\n" + 
				"  ╚════██║    ██║    ██║   ██║ ██╔══██╗   ╚██╔╝  \r\n" + 
				"  ███████║    ██║    ╚██████╔╝ ██║  ██║    ██║   \r\n" + 
				"  ╚══════╝    ╚═╝     ╚═════╝  ╚═╝  ╚═╝    ╚═╝   \r\n" + 
				"                                           ");
	}

	public void menu() {
		System.out.println("\n---------------------------------------------------");
		System.out.println("		메뉴를 선택하여주세요");
		System.out.println("	0 : 상태보기");
		System.out.println("	1 : 낚시하기");
		System.out.println("	2 : 수족관 관리");
		System.out.println("	3 : 아이템구매");
		System.out.println("	4 : 번식장 관리");
		System.out.println("	5 : 배경음악 on/off");
		System.out.println("---------------------------------------------------");

	}
}
