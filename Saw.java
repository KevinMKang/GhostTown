/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Saw extends Enemy
/*    */ {
/*  5 */   java.awt.Image[] ss = new java.awt.Image[3];
/*    */   
/*    */   Saw() {
/*  8 */     for (int i = 0; i < 3; i++) {
/*  9 */       this.ss[i] = new javax.swing.ImageIcon("obstacles/saw" + (i + 1) + ".png").getImage();
/*    */     }
/* 11 */     this.rect = new Rectangle(800, 325, 50, 50);
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g)
/*    */   {
/* 16 */     g.drawImage(this.ss[this.frame], this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 20 */     if (++this.frame > 2) {
/* 21 */       this.frame = 0;
/*    */     }
/* 23 */     this.rect.x -= 2;
/* 24 */     if (collide(p)) {
/* 25 */       p.damage();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Saw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */