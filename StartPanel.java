/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class StartPanel
/*     */   extends JPanel
/*     */   implements ActionListener, MouseMotionListener, MouseListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Main parent;
/*     */   private Timer myTimer;
/*     */   JButton[] btns;
/*     */   int x;
/*     */   int y;
/*  24 */   boolean press = false;
/*  25 */   boolean PPress; boolean IPress; boolean OPress; boolean SPress = false;
/*     */   static BufferedImage bg;
/*     */   static BufferedImage p;
/*  28 */   static BufferedImage pP; static BufferedImage i; static BufferedImage iP; static BufferedImage o; static BufferedImage oP; static BufferedImage s; static BufferedImage sP = null;
/*     */   
/*  30 */   public StartPanel(Main frame) { this.myTimer = new Timer(15, this);
/*  31 */     this.myTimer.addActionListener(this);
/*  32 */     this.myTimer.start();
/*  33 */     this.parent = frame;
/*     */     
/*  35 */     setLayout(null);
/*     */     try {
/*  37 */       bg = ImageIO.read(new File("images//title.png"));
/*  38 */       p = ImageIO.read(new File("images//playUP.png"));
/*  39 */       pP = ImageIO.read(new File("images//playDOWN.png"));
/*  40 */       i = ImageIO.read(new File("images//howtoplayUP.png"));
/*  41 */       iP = ImageIO.read(new File("images//howtoplayDOWN.png"));
/*  42 */       o = ImageIO.read(new File("images//optionsUP.png"));
/*  43 */       oP = ImageIO.read(new File("images//optionsDOWN.png"));
/*  44 */       s = ImageIO.read(new File("images//scoresUP.png"));
/*  45 */       sP = ImageIO.read(new File("images//scoresDOWN.png"));
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/*     */ 
/*     */ 
/*  51 */     addMouseListener(this);
/*  52 */     addMouseMotionListener(this);
/*     */     
/*  54 */     repaint();
/*     */   }
/*     */   
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*  59 */     super.paintComponent(g);
/*     */     
/*  61 */     g.drawImage(bg, 0, 0, 800, 600, null);
/*  62 */     if (!this.PPress) {
/*  63 */       g.drawImage(p, 241, 410, 150, 60, null);
/*     */     }
/*     */     else {
/*  66 */       g.drawImage(pP, 241, 410, 150, 60, null);
/*     */     }
/*  68 */     if (!this.OPress) {
/*  69 */       g.drawImage(o, 409, 410, 150, 60, null);
/*     */     }
/*     */     else {
/*  72 */       g.drawImage(oP, 409, 410, 150, 60, null);
/*     */     }
/*  74 */     if (!this.IPress) {
/*  75 */       g.drawImage(i, 241, 490, 150, 60, null);
/*     */     }
/*     */     else {
/*  78 */       g.drawImage(iP, 241, 490, 150, 60, null);
/*     */     }
/*  80 */     if (!this.SPress) {
/*  81 */       g.drawImage(s, 409, 490, 150, 60, null);
/*     */     }
/*     */     else
/*  84 */       g.drawImage(sP, 409, 490, 150, 60, null);
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  88 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseClicked(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/* 105 */     this.x = e.getX();
/* 106 */     this.y = e.getY();
/*     */     
/* 108 */     if ((this.x > 241) && (this.x < 391) && (this.y > 410) && (this.y < 470))
/*     */     {
/* 110 */       this.PPress = true;
/*     */     }
/*     */     
/* 113 */     if ((this.x > 409) && (this.x < 559) && (this.y > 410) && (this.y < 470))
/*     */     {
/* 115 */       this.OPress = true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 120 */     if ((this.x > 241) && (this.x < 391) && (this.y > 490) && (this.y < 550))
/*     */     {
/* 122 */       this.IPress = true;
/*     */     }
/*     */     
/*     */ 
/* 126 */     if ((this.x > 409) && (this.x < 559) && (this.y > 490) && (this.y < 550))
/*     */     {
/* 128 */       this.SPress = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {
/* 133 */     if (((this.x <= 241) || (this.x >= 391) || (this.y <= 410)) || (
/*     */     
/*     */ 
/* 136 */       (this.x > 409) && (this.x < 559) && (this.y > 410) && (this.y < 470))) {
/* 137 */       this.parent.openOption();
/*     */     }
/*     */     
/* 140 */     if ((this.x > 241) && (this.x < 391) && (this.y > 490) && (this.y < 550))
/*     */     {
/* 142 */       this.parent.openInstruct();
/*     */     }
/* 144 */     if ((this.x > 409) && (this.x < 559) && (this.y > 490) && (this.y < 550))
/*     */     {
/* 146 */       this.parent.openScores();
/*     */     }
/* 148 */     this.PPress = false;
/* 149 */     this.OPress = false;
/* 150 */     this.IPress = false;
/* 151 */     this.SPress = false;
/*     */   }
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */   public void mouseDragged(MouseEvent e) {}
/*     */   
/*     */   public void mouseMoved(MouseEvent e) {}
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\StartPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */