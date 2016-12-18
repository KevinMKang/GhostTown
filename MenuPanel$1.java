/*    */ import java.awt.event.MouseAdapter;
/*    */ import java.awt.event.MouseEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MenuPanel$1
/*    */   extends MouseAdapter
/*    */ {
/*    */   MenuPanel$1(MenuPanel paramMenuPanel) {}
/*    */   
/*    */   public void mousePressed(MouseEvent e)
/*    */   {
/* 27 */     for (int a = 0; a < 4; a++) {
/* 28 */       int x1 = 241 + a % 2 * 168;int x2 = x1 + 150;int y1 = 410 + 80 * (a / 2);int y2 = y1 + 60;
/* 29 */       if ((e.getX() >= x1) && (e.getX() <= x2) && (e.getY() >= y1) && (e.getY() <= y2)) {
/* 30 */         this.this$0.pressed = a;
/* 31 */         this.this$0.repaint();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/* 36 */   public void mouseReleased(MouseEvent e) { if (this.this$0.pressed == 0) {
/* 37 */       this.this$0.parent.startGame();
/* 38 */       this.this$0.pressed = -1;
/*    */     }
/* 40 */     else if (this.this$0.pressed == 1) {
/* 41 */       this.this$0.parent.openOption();
/* 42 */       this.this$0.pressed = -1;
/*    */     }
/* 44 */     else if (this.this$0.pressed == 2) {
/* 45 */       this.this$0.parent.openInstruct();
/* 46 */       this.this$0.pressed = -1;
/*    */     }
/* 48 */     else if (this.this$0.pressed == 3) {
/* 49 */       this.this$0.parent.openScores();
/* 50 */       this.this$0.pressed = -1;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\MenuPanel$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */