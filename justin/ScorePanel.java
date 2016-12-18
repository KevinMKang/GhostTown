

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ScorePanel extends JPanel implements ActionListener{
	BufferedReader br;
	private Frame mf;
	String line;
	JButton re;
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> scores = new ArrayList<Integer>();
	
	public ScorePanel(Frame frame){
		try {
		    File file = new File("score.txt");
		    br = new BufferedReader(new FileReader(file));

		    
		    while ((line = br.readLine()) != null) {
		    	names.add(line.substring(0,line.indexOf(":")));
		    	scores.add(Integer.parseInt(line.substring(line.indexOf(":")+2),line.length()-1));
		        
		    }
		    

		} catch (IOException e) {
		    e.printStackTrace();
		} 
		 
		mf = frame;
		re = new JButton("Return");
		re.addActionListener(this);
		add(re);
		Collections.sort(scores);
	}


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
			for(int i = 0; i<scores.size();i++){
				g.drawString((i+1)+". "+names.get(i)+": "+scores.get(scores.size()-i-1), 350, 150+i*35);
			}
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == re){
			
			
			mf.Start();
			}
	}
	
}