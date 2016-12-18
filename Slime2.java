/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Slime2 extends Enemy {
/*    */   int vy;
/*    */   
/*    */   Slime2() {
/*  7 */     this.vy = -20;
/*  8 */     this.rect = new Rectangle(800, 320, 50, 50);
/*  9 */     this.images = new java.awt.Image[4];
/* 10 */     for (int a = 0; a < 4; a++) {
/* 11 */       this.images[a] = new javax.swing.ImageIcon("enemies\\Slime" + (a + 1) + ".png").getImage();
/*    */     }
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 16 */     g.drawImage(this.images[this.frame], this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 20 */     if (collide(p)) {
/* 21 */       effect(p);
/*    */     }
/* 23 */     for (Entity e : p.stuff) {
/* 24 */       if (this.rect.intersects(e.rect)) {
/* 25 */         System.out.println("Remove");
/* 26 */         this.exist = false;
/* 27 */         return;
/*    */       }
/*    */     }
/*    */     
/* 31 */     if (++this.frame > 3) {
/* 32 */       this.frame = 0;
/*    */     }
/*    */     
/* 35 */     this.rect.x -= 3;
/* 36 */     this.rect.y += this.vy;
/* 37 */     this.vy += 1;
/* 38 */     if (this.rect.y > 320) {
/* 39 */       this.rect.y = 320;
/* 40 */       this.vy = -20;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Slime2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */