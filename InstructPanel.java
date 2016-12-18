/*    */ import java.awt.Graphics;
/*    */ 
/*    */ class InstructPanel extends javax.swing.JPanel
/*    */ {
/*    */   Main parent;
/*    */   java.awt.Image bg;
/*    */   
/*    */   public InstructPanel(Main main)
/*    */   {
/* 10 */     this.parent = main;
/*    */     
/* 12 */     this.bg = new javax.swing.ImageIcon("Sprites\\Title2.png").getImage();
/*    */     
/* 14 */     addMouseListener(new java.awt.event.MouseAdapter()
/*    */     {
/*    */ 
/*    */       public void mouseClicked(java.awt.event.MouseEvent e) {}
/*    */ 
/* 19 */     });
/* 20 */     addKeyListener(new java.awt.event.KeyAdapter()
/*    */     {
/*    */       public void keyPressed(java.awt.event.KeyEvent e) {}
/*    */     });
/*    */   }
/*    */   
/*    */   public void paintComponent(Graphics g)
/*    */   {
/* 28 */     super.paintComponent(g);
/* 29 */     g.drawImage(this.bg, 0, 0, 800, 600, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\InstructPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */