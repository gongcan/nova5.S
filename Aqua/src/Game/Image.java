package Game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Image extends JFrame{

	 public void setImage() {
			Container cPane;
			ImageIcon img;
			JLabel ImgBox; 

	       

			 // 화면 패널 얻어오기.
		  	 cPane= getContentPane();
			 cPane.setLayout( null );
			 
			 //이미지 불러오기
			 img = new ImageIcon( "D:\\imageFile\\수족관.jpg");
			 
			 
			 ImgBox = new JLabel( img );
			 
			 ImgBox.setBounds( 0, 0, img.getIconWidth(), img.getIconHeight() );

			 // 패널에 컴퍼넌트 등록
			 cPane.add( ImgBox );  
			
	 }
}

