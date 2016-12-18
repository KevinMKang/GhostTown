
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartPanel extends JPanel implements ActionListener,MouseMotionListener,MouseListener{
	private Frame mf;
	private Timer myTimer;
	JButton[] btns;

	int x,y;
	boolean press =false;
	boolean PPress,IPress,OPress,SPress = false;
	
	static BufferedImage bg;
	static BufferedImage p,pP,i,iP,o,oP,s,sP= null;
	public StartPanel(Frame frame) {
		myTimer = new Timer(15, this);
		myTimer.addActionListener(this);
		myTimer.start();
		mf = frame;
//		btns = new JButton[5];
		this.setLayout(null);
		try{
			bg = ImageIO.read(new File("images//title.png"));
			p  = ImageIO.read(new File("images//playUP.png"));
			pP  = ImageIO.read(new File("images//playDOWN.png"));
			i  = ImageIO.read(new File("images//howtoplayUP.png"));
			iP  = ImageIO.read(new File("images//howtoplayDOWN.png"));
			o  = ImageIO.read(new File("images//optionsUP.png"));
			oP  = ImageIO.read(new File("images//optionsDOWN.png"));
			s  = ImageIO.read(new File("images//scoresUP.png"));
			sP  = ImageIO.read(new File("images//scoresDOWN.png"));
			
		}
		catch(Exception e){
			
		}
	    	addMouseListener( this );
	      addMouseMotionListener( this );
	      
		
		
		
//		for(int i= 0; i<5;i++){
//			
//			JButton btn = new JButton(new ImageIcon(p));
//			btn.addActionListener(this);
//			btn.setBounds(325,180+75*i,150,60);
//			btns[i]=btn;
//		}
//		for(JButton i : btns){
//			add(i);
//		}
	    
		repaint();
	}
	public void paintComponent(Graphics g) {
	

		super.paintComponent(g);
		
		g.drawImage(bg, 0,0,800,600,null);
		if(PPress == false){	
			g.drawImage(p,241,410,150,60,null);
		}
		else{
			g.drawImage(pP,241,410,150,60,null);
		}
		if(OPress == false){
			g.drawImage(o,409,410,150,60,null);
		}
		else{
			g.drawImage(oP,409,410,150,60,null);
		}
		if(IPress == false){
			g.drawImage(i,241,490,150,60,null);
		}
		else{
			g.drawImage(iP,241,490,150,60,null);
		}
		if(SPress == false){
			g.drawImage(s,409,490,150,60,null);
		}
		else{
			g.drawImage(sP,409,490,150,60,null);
		}
	
			
		
			
		
	
			
	
		
		
	}
	public void actionPerformed(ActionEvent e){
		repaint();
//		if(e.getSource()==btns[1])
//			mf.Instruct();
//		else if(e.getSource()==btns[2])
//			mf.Scores();
//		else if(e.getSource()==btns[3])
//			mf.Option();
//		else if(e.getSource()==btns[4])
//			mf.Shop();
		
	}

	public void mouseClicked(MouseEvent e) {
	
		
	}
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		 //p
	       if((x >241 && x <391)&& (y>410 && y<470)){

	    	   PPress=true;
	       }
	       //o
	       if((x >409 && x <559)&& (y>410 && y<470)){

	    	   OPress=true;

	    	   
	       }
	       //i
	       if((x >241 && x <391)&& (y>490 && y<550)){
	
	    	   IPress=true;
	    	
	       }
	       //s
	       if((x >409 && x <559)&& (y>490 && y<550)){
	    
	    	   SPress=true;
	    	  
	       }
	}
	public void mouseReleased(MouseEvent e) {
		 if((x >241 && x <391)&& (y>410 && y<470)){
	    	   
	       }
		  if((x >409 && x <559)&& (y>410 && y<470)){
	    	   mf.Option();
	    	   
	      }
		  if((x >241 && x <391)&& (y>490 && y<550)){

	    	   mf.Instruct();
	       }
		  if((x >409 && x <559)&& (y>490 && y<550)){
	 
	    	   mf.Scores();
	       }
		PPress=false;
		OPress= false;
		IPress = false;
		SPress = false;
		// TODO Auto-generated method stub.
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	
}