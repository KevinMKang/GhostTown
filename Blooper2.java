/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Blooper2 extends Enemy {
/*    */   int accel;
/*    */   int t;
/*    */   int vy;
/*    */   
/*  8 */   Blooper2() { this.t = 5;
/*  9 */     this.accel = 1;
/* 10 */     this.vy = -50;
/* 11 */     this.rect = new Rectangle(800, 300, 50, 50);
/* 12 */     this.images = new java.awt.Image[4];
/* 13 */     for (int a = 0; a < 4; a++) {
/* 14 */       this.images[a] = new javax.swing.ImageIcon("enemies\\Blooper" + (a + 1) + ".png").getImage();
/*    */     }
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 19 */     g.drawImage(this.images[this.frame], this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 23 */     if (collide(p)) {
/* 24 */       effect(p);
/*    */     }
/* 26 */     for (Entity e : p.stuff) {
/* 27 */       if (this.rect.intersects(e.rect)) {
/* 28 */         System.out.println("Remove");
/* 29 */         this.exist = false;
/* 30 */         return;
/*    */       }
/*    */     }
/*    */     
/* 34 */     if (++this.frame > 3) {
/* 35 */       this.frame = 0;
/*    */     }
/*    */     
/* 38 */     this.t -= 1;
/* 39 */     this.rect.x -= 4;
/* 40 */     if (this.t > 0)
/* 41 */       this.rect.y += this.vy;
/* 42 */     if (this.t < -5) {
/* 43 */       this.t = ((int)(Math.random() * 3.0D + 2.0D));
/* 44 */       this.vy = (-this.vy);
/*    */     }
/* 46 */     if (this.rect.y < 0) {
/* 47 */       this.rect.y = 0;
/*    */     }
/* 49 */     else if (this.rect.y > 320) {
/* 50 */       this.rect.y = 320;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Blooper2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */