
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

//

public class ShopPanel extends JPanel implements ActionListener{
	static BufferedImage shopkeep= null;
	private Frame mf;
	
	JButton re;

	
	
	public ShopPanel(Frame frame) {
		mf = frame;
		re = new JButton("Return");
		re.addActionListener(this);
		add(re);
		try {
			shopkeep = ImageIO.read(new File("shopkeep.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setFocusable(true);
		requestFocus();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == re){
			
			mf.Start();
		}		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(shopkeep,600,200,100,250,null);
	}


}

