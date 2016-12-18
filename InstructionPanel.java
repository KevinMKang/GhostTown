/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class InstructionPanel
/*     */   extends JPanel implements MouseListener, MouseMotionListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Main mf;
/*  16 */   int scroll = 0;
/*     */   
/*  18 */   int maxPages = 1;
/*  19 */   ImageIcon bg = new ImageIcon("arrow.png");
/*     */   Image backU;
/*     */   Image backD;
/*     */   Image nextU;
/*     */   
/*     */   public InstructionPanel(Main frame)
/*     */   {
/*  26 */     this.mf = frame;
/*  27 */     addMouseListener(this);
/*  28 */     addMouseMotionListener(this);
/*  29 */     setLayout(null);
/*     */     
/*  31 */     this.backU = new ImageIcon("images\\backU.png").getImage();
/*  32 */     this.backD = new ImageIcon("images\\backD.png").getImage();
/*  33 */     this.nextU = new ImageIcon("images\\nextU.png").getImage();
/*  34 */     this.nextD = new ImageIcon("images\\nextD.png").getImage();
/*  35 */     this.menuU = new ImageIcon("images\\menuU.png").getImage();
/*  36 */     this.menuD = new ImageIcon("images\\menuD.png").getImage();
/*  37 */     this.htp = new ImageIcon("images\\htp.png").getImage();
/*  38 */     this.tswt = new ImageIcon("images\\tswt.png").getImage();
/*  39 */     this.story = new ImageIcon("images\\story.png").getImage();
/*     */   }
/*     */   
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*  44 */     super.paintComponent(g);
/*  45 */     g.setColor(Color.red);
/*  46 */     g.drawImage(this.tswt, 0, 0, null);
/*     */     
/*     */ 
/*  49 */     if (this.scroll == 0) {
/*  50 */       g.drawImage(this.story, 0, 0, 800, 600, null);
/*     */     }
/*  52 */     if (this.scroll == 1) {
/*  53 */       g.drawImage(this.htp, 0, 0, 800, 600, null);
/*     */     }
/*  55 */     if ((!this.bPress) && (this.scroll == 1))
/*  56 */       g.drawImage(this.backU, 450, 450, null);
/*  57 */     if ((this.bPress) && (this.scroll == 1)) {
/*  58 */       g.drawImage(this.backD, 450, 450, null);
/*     */     }
/*  60 */     if ((!this.nPress) && (this.scroll == 0))
/*  61 */       g.drawImage(this.nextU, 570, 450, null);
/*  62 */     if ((this.nPress) && (this.scroll == 0)) {
/*  63 */       g.drawImage(this.nextD, 570, 450, null);
/*     */     }
/*  65 */     if (!this.mPress)
/*  66 */       g.drawImage(this.menuU, 25, 530, null);
/*  67 */     if (this.mPress) {
/*  68 */       g.drawImage(this.menuD, 25, 530, null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   Image nextD;
/*     */   
/*     */   Image menuU;
/*     */   
/*     */   Image menuD;
/*     */   
/*     */   Image htp;
/*     */   
/*     */   Image story;
/*     */   
/*     */   Image tswt;
/*     */   
/*     */   boolean nPress;
/*     */   
/*     */   boolean bPress;
/*     */   
/*     */   boolean mPress;
/*     */   
/*     */   public void mouseDragged(MouseEvent arg0) {}
/*     */   
/*     */   public void mouseMoved(MouseEvent arg0) {}
/*     */   
/*     */   public void mouseClicked(MouseEvent arg0) {}
/*     */   
/*     */   public void mouseEntered(MouseEvent arg0) {}
/*     */   
/*     */   public void mouseExited(MouseEvent arg0) {}
/*     */   
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/* 103 */     System.out.println(this.scroll);
/*     */     
/* 105 */     int x = e.getX();
/* 106 */     int y = e.getY();
/*     */     
/* 108 */     if ((x > 450) && (x < 550) && (y > 450) && (y < 510) && (this.scroll > 0))
/* 109 */       this.bPress = true;
/* 110 */     if ((x > 570) && (x < 670) && (y > 450) && (y < 510) && (this.scroll < 1))
/* 111 */       this.nPress = true;
/* 112 */     if ((x > 25) && (x < 125) && (y > 530) && (y < 590))
/* 113 */       this.mPress = true;
/* 114 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void mouseReleased(MouseEvent e)
/*     */   {
/* 121 */     if ((this.bPress) && (this.scroll > 0)) {
/* 122 */       this.scroll -= 1;
/* 123 */       this.bPress = false;
/* 124 */       this.mf.selectback.play();
/*     */     }
/* 126 */     if ((this.nPress) && (this.scroll < 1)) {
/* 127 */       this.scroll += 1;
/* 128 */       this.nPress = false;
/* 129 */       this.mf.select.play();
/*     */     }
/* 131 */     if (this.mPress) {
/* 132 */       this.mf.openMenu();
/* 133 */       this.mPress = false;
/* 134 */       this.scroll = 0;
/*     */     }
/*     */     
/* 137 */     repaint();
/*     */   }
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\InstructionPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */