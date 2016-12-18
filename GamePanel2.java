/*    */ import java.awt.event.KeyAdapter;
/*    */ import java.awt.event.KeyEvent;
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
/*    */ class GamePanel$2
/*    */   extends KeyAdapter
/*    */ {
/*    */   GamePanel$2(GamePanel paramGamePanel) {}
/*    */   
/*    */   public void keyPressed(KeyEvent e)
/*    */   {
/* 52 */     if (e.getKeyCode() == 27) {
/* 53 */       this.this$0.parent.dispose();
/*    */     }
/* 55 */     if (e.getKeyCode() == 80) {
/* 56 */       this.this$0.paused = (!this.this$0.paused);
/* 57 */       if (this.this$0.paused) {
/* 58 */         this.this$0.timer.stop();
/*    */       }
/*    */       else {
/* 61 */         this.this$0.timer.start();
/*    */       }
/* 63 */       this.this$0.repaint();
/*    */     }
/* 65 */     if (!this.this$0.paused) {
/* 66 */       if (e.getKeyCode() == this.this$0.parent.keys[this.this$0.parent.keyN][0]) {
/* 67 */         this.this$0.player.setKeyDown(0, true);
/*    */       }
/* 69 */       if (e.getKeyCode() == this.this$0.parent.keys[this.this$0.parent.keyN][1]) {
/* 70 */         this.this$0.player.setKeyDown(2, true);
/*    */       }
/* 72 */       if (e.getKeyCode() == this.this$0.parent.keys[this.this$0.parent.keyN][2]) {
/* 73 */         this.this$0.player.setKeyDown(1, true);
/*    */       }
/* 75 */       if (e.getKeyCode() == 32)
/* 76 */         if (this.this$0.player.getPower() == 1) {
/* 77 */           this.this$0.player.useItem();
/* 78 */           this.this$0.player.add(new Bullet(this.this$0.player.getX() + 50, this.this$0.player.getY()));
/*    */         }
/* 80 */         else if (this.this$0.player.getPower() == 2) {
/* 81 */           this.this$0.player.useItem();
/* 82 */           this.this$0.player.add(new Fist(this.this$0.player.getX() + 50, this.this$0.player.getY()));
/*    */         }
/*    */     }
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {
/* 88 */     if (e.getKeyCode() == this.this$0.parent.keys[this.this$0.parent.keyN][0]) {
/* 89 */       this.this$0.player.setKeyDown(0, false);
/*    */     }
/* 91 */     if (e.getKeyCode() == this.this$0.parent.keys[this.this$0.parent.keyN][1]) {
/* 92 */       this.this$0.player.setKeyDown(2, false);
/*    */     }
/* 94 */     if (e.getKeyCode() == this.this$0.parent.keys[this.this$0.parent.keyN][2]) {
/* 95 */       this.this$0.player.setKeyDown(1, false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\GamePanel$2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */