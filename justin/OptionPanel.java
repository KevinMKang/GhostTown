
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

//

public class OptionPanel extends JPanel implements ActionListener,KeyListener{
	
	private Frame mf;
	
	JButton re;
	
	JButton[] controls;//left,right,crouch,jump,action
					   //left,right,down,up,space
	
	public OptionPanel(Frame frame){
		
		addKeyListener(this);
		mf = frame;
		re = new JButton("Return");
		re.addActionListener(this);
		add(re);
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == re){
			
			
			mf.Start();
			}		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		//39,37,40,38

		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
