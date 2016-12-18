

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

class Global{
	static int[] keys = {39,37,40,38};//up,left,down,right
	static int vx=1;
	static int gv=2;
}

public class Menu {
	public static void main(String[] args){
		new Frame();
	}
	
}

class Frame extends JFrame implements ActionListener{
	StartPanel sp = new StartPanel(this);
	ScorePanel scp = new ScorePanel(this);
	InstructionPanel ip = new InstructionPanel(this);
	OptionPanel op = new OptionPanel(this);
	ShopPanel shp = new ShopPanel(this);
	
	public Frame(){
		add(sp);
		
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Start(){
		setContentPane(sp);
		validate();
		repaint();
		System.out.println("start");
	}
	
	public void Instruct(){
		setContentPane(ip);
		validate();
		repaint();
		System.out.println("instruct");
	}
	
	public void Scores(){
		setContentPane(scp);
		validate();
		repaint();
		System.out.println("score");
	}
	
	public void Option(){
		setContentPane(op);
		validate();
		repaint();
		System.out.println("option");
	}
	public void Shop(){
		setContentPane(shp);
		validate();
		repaint();
		System.out.println("shop");
	}

	
	public void actionPerformed(ActionEvent e) {
				
	}
	
}
