package Game;


import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Guest implements Runnable{
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
	CustomPlayer player7 = new CustomPlayer();
	CustomPlayer player8 = new CustomPlayer();
	Image image = new Image();
	static int T=60000;
	int sum = 0;
	static boolean isAd=false;
public synchronized void Reward() {

    sum = (	(Aquarium.ht.get("피라미")*minnow.showValue) +
    		(Aquarium.ht.get("잉어")*carp.showValue) +
    		(Aquarium.ht.get("참치")*tuna.showValue) +
    		(Aquarium.ht.get("상어")*shark.showValue) +
    		(Aquarium.ht.get("고래")*whale.showValue) +
    		(Aquarium.ht.get("새우")*shrimp.showValue) +
    		(Aquarium.ht.get("꽃게")*crab.showValue) +
    		(Aquarium.ht.get("가재")*lobster.showValue) + 
    		(Aquarium.ht.get("거대소라게")*GiantHermitCrab.showValue) +
    		(Aquarium.ht.get("쭈꾸미")*webfootOctopus.showValue) +
    		(Aquarium.ht.get("오징어")*squid.showValue) +
    		(Aquarium.ht.get("문어")*octopus.showValue) +
    		(Aquarium.ht.get("크라켄") *craken.showValue)
    		);
    if(!isAd) {
    	System.out.print(" " + sum*100);
    User.money=User.money+sum*100;
    }
    else if(isAd) {
    	System.out.print(" " + sum*200);
    	User.money=User.money+(sum*200);
    }
    
}

// public void setImage() {
//		Container cPane;
//		ImageIcon img;
//		JLabel ImgBox; 
//		 // 화면 패널 얻어오기.
//	  	 cPane= getContentPane();
//		 cPane.setLayout( null );
//		 
//		 //이미지 불러오기
//		 img = new ImageIcon( "D:\\imageFile\\수족관.jpg");
//		 
//		 ImgBox = new JLabel( img );
//		 
//		 ImgBox.setBounds( 0, 0, img.getIconWidth(), img.getIconHeight() );
//		 
//		 // 패널에 컴퍼턴트 등록
//		 cPane.add( ImgBox );  
//		
// }

 
 
	@Override
	public synchronized void run() {
		for (int i = 0; i < 99999999; i++) {
		try {

			Thread.sleep(T);	


			 final int FRAME_WIDTH = 720;
			 final int FRAME_HEIGHT = 403;
			image.setImage();
			Image frame = new Image();
			player7.setPath("d:\\wavFile\\Talk.mp3");
			player8.setPath("d:\\wavFile\\Coin.mp3");
//			player7.play(-1);
			player8.play(-1);
		    //이미지 설정
			frame.setImage();
			 frame.setTitle( "오늘도 많은 손님들이 찾아왔습니다. 관람료가 지급됩니다." );
			 frame.setSize( FRAME_WIDTH, FRAME_HEIGHT );
			 frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
			 frame.setVisible( true );
			//콘솔 출력
			 if(isAd) { System.out.println("			★광고효과가 진행중입니다.(보상두배)");}
			 System.out.println("			--------------------------------------");
			 System.out.println("			   ★공지★  오늘도 많은 손님들이 찾아왔습니다.");
			 System.out.print("			  <");
			Reward();
			System.out.println(" >   만큼의 관람료가 지급되었습니다.");
			System.out.println("			스테미나가  10 회복되었습니다.");
			System.out.println("			--------------------------------------");
			User.stamina=User.stamina+10;

} catch (Exception e) {
			// TODO: handle exception
		}
		
		}
		
		
	}

	
}
