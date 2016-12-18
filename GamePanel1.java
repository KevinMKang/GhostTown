/*    */ import java.awt.event.MouseAdapter;
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.Timer;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GamePanel$1
/*    */   extends MouseAdapter
/*    */ {
/*    */   GamePanel$1(GamePanel paramGamePanel) {}
/*    */   
/*    */   public void mousePressed(MouseEvent e)
/*    */   {
/* 35 */     if ((this.this$0.paused) && (e.getX() >= 350) && (e.getX() <= 450) && (e.getY() >= 360) && (e.getY() <= 420)) {
/* 36 */       this.this$0.pressed = true;
/* 37 */       this.this$0.repaint();
/*    */     }
/*    */   }
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {
/* 42 */     if (this.this$0.pressed) {
/* 43 */       this.this$0.timer.stop();
/* 44 */       this.this$0.parent.openMenu();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\GamePanel$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */