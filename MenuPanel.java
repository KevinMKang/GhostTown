/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ class MenuPanel extends javax.swing.JPanel
/*    */ {
/*    */   Main parent;
/*  7 */   java.awt.Image[][] buttons = new java.awt.Image[2][4];
/*    */   java.awt.Image title;
/*    */   int pressed;
/*    */   
/*    */   public MenuPanel(Main main) {
/* 12 */     this.parent = main;
/* 13 */     this.title = new ImageIcon("Sprites\\Title.png").getImage();
/* 14 */     for (int a = 0; a < 2; a++) {
/* 15 */       for (int b = 0; b < 4; b++) {
/* 16 */         if (a == 0) {
/* 17 */           this.buttons[a][b] = new ImageIcon("Sprites\\U" + (b + 1) + ".png").getImage();
/*    */         }
/*    */         else {
/* 20 */           this.buttons[a][b] = new ImageIcon("Sprites\\D" + (b + 1) + ".png").getImage();
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 25 */     addMouseListener(new java.awt.event.MouseAdapter() {
/*    */       public void mousePressed(MouseEvent e) {
/* 27 */         for (int a = 0; a < 4; a++) {
/* 28 */           int x1 = 241 + a % 2 * 168;int x2 = x1 + 150;int y1 = 410 + 80 * (a / 2);int y2 = y1 + 60;
/* 29 */           if ((e.getX() >= x1) && (e.getX() <= x2) && (e.getY() >= y1) && (e.getY() <= y2)) {
/* 30 */             MenuPanel.this.pressed = a;
/* 31 */             MenuPanel.this.repaint();
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 36 */       public void mouseReleased(MouseEvent e) { if (MenuPanel.this.pressed == 0) {
/* 37 */           MenuPanel.this.parent.startGame();
/* 38 */           MenuPanel.this.pressed = -1;
/*    */         }
/* 40 */         else if (MenuPanel.this.pressed == 1) {
/* 41 */           MenuPanel.this.parent.openOption();
/* 42 */           MenuPanel.this.pressed = -1;
/*    */         }
/* 44 */         else if (MenuPanel.this.pressed == 2) {
/* 45 */           MenuPanel.this.parent.openInstruct();
/* 46 */           MenuPanel.this.pressed = -1;
/*    */         }
/* 48 */         else if (MenuPanel.this.pressed == 3) {
/* 49 */           MenuPanel.this.parent.openScores();
/* 50 */           MenuPanel.this.pressed = -1;
/*    */         }
/*    */         
/*    */       }
/* 54 */     });
/* 55 */     this.pressed = -1;
/*    */   }
/*    */   
/*    */   public void paintComponent(java.awt.Graphics g) {
/* 59 */     super.paintComponent(g);
/* 60 */     g.drawImage(this.title, 0, 0, 800, 600, null);
/* 61 */     for (int a = 0; a < 4; a++) {
/* 62 */       if (this.pressed == a) {
/* 63 */         g.drawImage(this.buttons[1][a], 241 + a % 2 * 168, 410 + 80 * (a / 2), 150, 60, null);
/*    */       }
/*    */       else {
/* 66 */         g.drawImage(this.buttons[0][a], 241 + a % 2 * 168, 410 + 80 * (a / 2), 150, 60, null);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\MenuPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */