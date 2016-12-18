/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class OptionPanel extends JPanel implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   Main mf;
/*     */   Image bg;
/*     */   Image wasd;
/*     */   Image udlr;
/*     */   Image menuD;
/*     */   Image menuU;
/*     */   Image selectU;
/*     */   Image selectD;
/*     */   Image wasds;
/*     */   Image udlrs;
/*     */   javax.swing.JButton[] controls;
/*  21 */   boolean mPress = false;
/*  22 */   int controlscheme = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public OptionPanel(Main frame)
/*     */   {
/*  29 */     addMouseListener(this);
/*  30 */     addMouseMotionListener(this);
/*  31 */     this.mf = frame;
/*     */     
/*  33 */     this.bg = new ImageIcon("images/options.png").getImage();
/*  34 */     this.wasd = new ImageIcon("images/wasd.png").getImage();
/*  35 */     this.udlr = new ImageIcon("images/udlr.png").getImage();
/*  36 */     this.menuD = new ImageIcon("images/menuD.png").getImage();
/*  37 */     this.menuU = new ImageIcon("images/menuU.png").getImage();
/*  38 */     this.selectU = new ImageIcon("images/selectU.png").getImage();
/*  39 */     this.selectD = new ImageIcon("images/selectD.png").getImage();
/*  40 */     this.udlrs = new ImageIcon("images/udlrs.png").getImage();
/*  41 */     this.wasds = new ImageIcon("images/wasds.png").getImage();
/*     */   }
/*     */   
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*  46 */     super.paintComponent(g);
/*  47 */     g.setColor(java.awt.Color.white);
/*  48 */     g.drawImage(this.bg, 0, 0, null);
/*     */     
/*  50 */     if (!this.mPress) {
/*  51 */       g.drawImage(this.menuU, 25, 530, null);
/*     */     } else {
/*  53 */       g.drawImage(this.menuD, 25, 530, null);
/*     */     }
/*  55 */     if (this.controlscheme == 0) {
/*  56 */       g.drawImage(this.udlrs, 200, 250, null);
/*  57 */       g.drawImage(this.wasd, 450, 250, null);
/*  58 */       g.drawImage(this.selectD, 225, 360, null);
/*  59 */       g.drawImage(this.selectU, 475, 360, null);
/*     */     }
/*     */     
/*  62 */     if (this.controlscheme == 1) {
/*  63 */       g.drawImage(this.udlr, 200, 250, null);
/*  64 */       g.drawImage(this.wasds, 450, 250, null);
/*  65 */       g.drawImage(this.selectU, 225, 360, null);
/*  66 */       g.drawImage(this.selectD, 475, 360, null);
/*     */     }
/*     */   }
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
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/*  92 */     int x = e.getX();
/*  93 */     int y = e.getY();
/*     */     
/*  95 */     if ((x > 225) && (x < 325) && (y > 360) && (y < 420) && (this.controlscheme != 0)) {
/*  96 */       this.controlscheme = 0;
/*  97 */       this.mf.keyN = 0;
/*  98 */       this.mf.select.play();
/*     */     }
/*     */     
/*     */ 
/* 102 */     if ((x > 475) && (x < 575) && (y > 360) && (y < 420) && (this.controlscheme != 1)) {
/* 103 */       this.mf.select.play();
/* 104 */       this.mf.keyN = 1;
/* 105 */       this.controlscheme = 1;
/*     */     }
/*     */     
/* 108 */     if ((x > 25) && (x < 125) && (y > 530) && (y < 590)) {
/* 109 */       this.mPress = true;
/*     */     }
/*     */     
/*     */ 
/* 113 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */   public void mouseReleased(MouseEvent e)
/*     */   {
/* 119 */     if (this.mPress) {
/* 120 */       this.mf.openMenu();
/* 121 */       this.mPress = false;
/*     */     }
/* 123 */     repaint();
/*     */   }
/*     */   
/*     */   public void mouseDragged(MouseEvent arg0) {}
/*     */   
/*     */   public void mouseMoved(MouseEvent arg0) {}
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\OptionPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */