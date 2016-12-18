/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class GameOverPanel extends JPanel implements ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener, java.awt.event.MouseMotionListener
/*     */ {
/*  19 */   Image goat = new ImageIcon("shopkeep.png").getImage();
/*     */   private Main mf;
/*  21 */   static BufferedImage bg; static BufferedImage b; static BufferedImage bPress = null;
/*  22 */   Font f = new Font("04b03", 100, 50);
/*  23 */   Font f2 = new Font("04b03", 100, 20);
/*  24 */   Color colorRed = new Color(15997522);
/*  25 */   Color colorBlue = new Color(1643829);
/*     */   int score;
/*  27 */   String name = "";
/*     */   int x;
/*     */   int y;
/*  30 */   java.io.BufferedReader br; boolean bPressed = false;
/*     */   String line;
/*  32 */   ArrayList<String> names = new ArrayList();
/*  33 */   ArrayList<Integer> scores = new ArrayList();
/*     */   private java.io.BufferedWriter bw;
/*     */   
/*     */   public GameOverPanel(Main frame, Player p) {
/*  37 */     this.score = p.getScore();
/*  38 */     requestFocus();
/*  39 */     setFocusable(true);
/*     */     
/*  41 */     addKeyListener(this);
/*  42 */     this.mf = frame;
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  47 */       bg = ImageIO.read(new File("images//game over.png"));
/*  48 */       b = ImageIO.read(new File("images//backUP.png"));
/*  49 */       bPress = ImageIO.read(new File("images//backDOWN.png"));
/*     */     }
/*     */     catch (IOException e) {
/*  52 */       e.printStackTrace();
/*     */     }
/*  54 */     java.util.Collections.sort(this.scores);
/*  55 */     requestFocusInWindow();
/*  56 */     addMouseListener(this);
/*  57 */     addMouseMotionListener(this);
/*     */   }
/*     */   
/*     */   public void paintComponent(Graphics g) {
/*  61 */     super.paintComponent(g);
/*  62 */     g.drawImage(bg, 0, 0, 800, 600, null);
/*  63 */     setFont(this.f2);
/*  64 */     g.setColor(this.colorRed);
/*  65 */     g.drawLine(270, 480, 535, 480);
/*  66 */     g.drawString("Final Score", 265, 340);
/*  67 */     g.drawString(this.score, 320, 400);
/*  68 */     g.drawString(this.name, 280, 475);
/*  69 */     if (!this.bPressed) {
/*  70 */       g.drawImage(b, 600, 450, 100, 60, null);
/*     */     }
/*     */     else {
/*  73 */       g.drawImage(bPress, 600, 450, 100, 60, null);
/*     */     }
/*     */     
/*  76 */     setFont(this.f);
/*  77 */     g.drawImage(this.goat, 100, 300, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void actionPerformed(ActionEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void keyPressed(KeyEvent e)
/*     */   {
/*  88 */     if ((e.getKeyCode() == 8) && (this.name.length() > 0))
/*     */     {
/*  90 */       this.name = this.name.substring(0, this.name.length() - 1);
/*     */     }
/*  92 */     else if (((this.name.length() < 8 ? 1 : 0) & ((e.getKeyCode() > 47) && (e.getKeyCode() < 91) ? 1 : 0)) != 0) {
/*  93 */       this.name += e.getKeyChar();
/*     */     }
/*  95 */     repaint();
/*     */   }
/*     */   
/*     */   public boolean checkBounds(int mX, int mY, int x1, int x2, int y1, int y2)
/*     */   {
/* 100 */     if ((mX > x1) && (mX < x2) && (mY > y1) && (mY < y2)) {
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void keyReleased(KeyEvent arg0) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void keyTyped(KeyEvent arg0) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseDragged(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseMoved(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void mouseClicked(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/* 134 */     this.x = e.getX();
/* 135 */     this.y = e.getY();
/* 136 */     if (checkBounds(this.x, this.y, 600, 700, 450, 510)) {
/* 137 */       this.bPressed = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseReleased(MouseEvent e)
/*     */   {
/* 143 */     this.x = e.getX();
/* 144 */     this.y = e.getY();
/* 145 */     this.bPressed = false;
/* 146 */     this.name = "";
/* 147 */     this.mf.openMenu();
/*     */   }
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\GameOverPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */