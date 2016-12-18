/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Fire extends Enemy {
/*    */   java.awt.Image[] ss;
/*    */   
/*    */   Fire() {
/*  7 */     this.rect = new Rectangle(800, 320, 50, 50);
/*    */     
/*  9 */     this.ss = new java.awt.Image[2];
/* 10 */     for (int i = 0; i < 2; i++) {
/* 11 */       this.ss[i] = new javax.swing.ImageIcon("obstacles/fire" + (i + 1) + ".png").getImage();
/*    */     }
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 16 */     g.drawImage(this.ss[this.frame], this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 20 */     if (++this.frame > 1)
/* 21 */       this.frame = 0;
/* 22 */     this.rect.x -= 2;
/* 23 */     if (collide(p)) {
/* 24 */       p.damage();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Fire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */