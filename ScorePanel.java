/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class ScorePanel extends JPanel implements java.awt.event.MouseMotionListener, java.awt.event.MouseListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   BufferedReader br;
/*     */   private Main mf;
/*     */   String line;
/*     */   javax.swing.JButton re;
/*  20 */   ArrayList<String> names = new ArrayList();
/*  21 */   ArrayList<Integer> scores = new ArrayList();
/*     */   Image box;
/*  23 */   Image backU; Image backD; boolean bPress = false;
/*     */   Font f;
/*     */   
/*  26 */   public ScorePanel(Main frame) { this.f = new Font("04b03", 100, 15);
/*  27 */     addMouseListener(this);
/*  28 */     addMouseMotionListener(this);
/*     */     try {
/*  30 */       File file = new File("score.txt");
/*  31 */       this.br = new BufferedReader(new java.io.FileReader(file));
/*     */       
/*  33 */       while ((this.line = this.br.readLine()) != null) {
/*  34 */         this.names.add(this.line.substring(0, this.line.indexOf(":")));
/*  35 */         this.scores.add(Integer.valueOf(Integer.parseInt(this.line.substring(this.line.indexOf(":") + 2), this.line.length() - 1)));
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  40 */       e.printStackTrace();
/*     */     }
/*     */     
/*  43 */     this.backU = new ImageIcon("images/menuU.png").getImage();
/*  44 */     this.backD = new ImageIcon("images/menuD.png").getImage();
/*  45 */     this.box = new ImageIcon("images/hs.png").getImage();
/*     */     
/*  47 */     this.mf = frame;
/*  48 */     java.util.Collections.sort(this.scores);
/*     */   }
/*     */   
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*  54 */     super.paintComponent(g);
/*  55 */     g.setColor(Color.white);
/*  56 */     g.setFont(this.f);
/*  57 */     g.drawImage(this.box, 0, 0, null);
/*  58 */     for (int i = 0; i < this.scores.size(); i++) {
/*  59 */       g.drawString(i + 1 + ". " + (String)this.names.get(i) + ": " + this.scores.get(this.scores.size() - i - 1), 350, 150 + i * 35);
/*     */     }
/*  61 */     if (!this.bPress) {
/*  62 */       g.drawImage(this.backU, 25, 530, null);
/*     */     } else {
/*  64 */       g.drawImage(this.backD, 25, 530, null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseClicked(MouseEvent arg0) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseEntered(MouseEvent arg0) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseExited(MouseEvent arg0) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/*  88 */     if ((e.getX() > 25) && (e.getX() < 125)) { if (((e.getY() > 530 ? 1 : 0) & (e.getY() < 590 ? 1 : 0)) != 0) {
/*  89 */         this.bPress = true;
/*  90 */         repaint();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void mouseReleased(MouseEvent e)
/*     */   {
/*  98 */     if (this.bPress)
/*  99 */       this.mf.openMenu();
/* 100 */     this.bPress = false;
/*     */   }
/*     */   
/*     */   public void mouseDragged(MouseEvent arg0) {}
/*     */   
/*     */   public void mouseMoved(MouseEvent arg0) {}
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\ScorePanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */