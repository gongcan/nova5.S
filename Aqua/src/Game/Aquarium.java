package Game;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Aquarium extends Thread{
	static Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
	Scanner sc= new Scanner(System.in);
	static int aquaSize = 5;
	static int nowSize;
	static boolean over=false;
	
	
	
	
	
	Aquarium() {

		ht.put("피라미", 0);
		ht.put("잉어", 0);
		ht.put("참치", 0);
		ht.put("상어", 0);
		ht.put("고래", 0);
		ht.put("새우", 0);
		ht.put("꽃게", 0);
		ht.put("가재", 0);
		ht.put("거대소라게",0);
		ht.put("쭈꾸미",0);
		ht.put("오징어",0);
		ht.put("문어", 0);
		ht.put("크라켄", 0);
		
				
				
	}
	
	public synchronized static void isOver() {
		nowSize= 
				ht.get("피라미") +
				ht.get("잉어") +
				ht.get("참치") +
				ht.get("상어") +
				ht.get("고래") +
				ht.get("새우") +
				ht.get("꽃게") +
				ht.get("가재") +
				ht.get("거대소라게") +
				ht.get("쭈꾸미") +
				ht.get("오징어") +
				ht.get("문어") +
				ht.get("크라켄") ;
		
		if(nowSize+1>aquaSize) {
			over=true;
		}
		else if(nowSize+1<=aquaSize) {
			over=false;
		}
	}

	
	public static void putAquaTest() {
		ht.put("피라미", ht.get("피라미")+100);
		ht.put("잉어", ht.get("잉어")+100);
		ht.put("참치", ht.get("참치")+100);
		ht.put("상어", ht.get("상어")+100);
		ht.put("고래", ht.get("고래")+100);
		ht.put("새우", ht.get("새우")+100);
		ht.put("꽃게", ht.get("꽃게")+100);
		ht.put("가재", ht.get("가재")+100);
		ht.put("거대소라게", ht.get("거대소라게")+100);
		ht.put("쭈꾸미", ht.get("쭈꾸미")+100);
		ht.put("오징어", ht.get("오징어")+100);
		ht.put("문어", ht.get("문어")+100);
		ht.put("크라켄", ht.get("크라켄")+100);
	
	}
	public static void putAquaTestReset() {
		ht.put("피라미", 0);
		ht.put("잉어", 0);
		ht.put("참치", 0);
		ht.put("상어", 0);
		ht.put("고래", 0);
		ht.put("새우", 0);
		ht.put("꽃게", 0);
		ht.put("가재", 0);
		ht.put("거대소라게",0);
		ht.put("쭈꾸미",0);
		ht.put("오징어",0);
		ht.put("문어", 0);
		ht.put("크라켄", 0);
	}
	public synchronized void showAqua() throws InterruptedException {
		System.out.println("------------------------------");
		System.out.println("수족관 크기 : "+ aquaSize);
		System.out.print("현재 수족관 물고기 수 : ");
		isOver();
		System.out.println(nowSize);
		Enumeration en = ht.keys();
		while(en.hasMoreElements())
		{
		String key = en.nextElement().toString();
		System.out.println("	" + key + " : "+ ht.get(key));
		}
	}
	

	
	@Override
	public void run() {
	
	}




}
