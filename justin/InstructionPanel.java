
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class InstructionPanel extends JPanel implements ActionListener{
	private Frame mf;
	
	JButton re,back,forth;
	int scroll = 0;
	JButton b, b2, b3;
	static BufferedImage arrow,i1,i2,i3= null;
	int maxPages = 1; 
	ImageIcon bg = new ImageIcon("arrow.png");
	JLabel l = new JLabel(bg);
	JPanel p= new JPanel();
	public InstructionPanel(Frame frame){
		mf = frame;
		re = new JButton(bg);
		back = new JButton(bg);
		forth = new JButton(bg);
		this.setLayout(null);
		add(re);
		add(back);
		add(forth);
		try {
			arrow = ImageIO.read(new File("arrow.png"));
			i1 = ImageIO.read(new File("i1.png"));
			i2 = ImageIO.read(new File("i2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		re.setBounds(350, 50, 100, 100);
		re.addActionListener(this);
		back.setBounds(50, 450, 100, 100);
		back.addActionListener(this);
		forth.setBounds(650, 450, 100, 100);
		
		forth.addActionListener(this);


		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		if (scroll == 0){
			g.drawImage(i1, 0,0,800,600,null);
		}
		if (scroll == 1){
			g.drawImage(i2, 0,0,800,600,null);
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (e.getSource() == re){
			
			scroll =0;
			mf.Start();
		}
		else if (e.getSource() == forth){
			
			if(scroll< maxPages){
			scroll++;
			}
		
		}
		else if (e.getSource() == back){
			
			if(scroll>0){
			scroll--;
			}
		
		}
	}
}