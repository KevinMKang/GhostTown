/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Blooper extends Enemy {
/*    */   int accel;
/*    */   int vy;
/*    */   
/*    */   Blooper(int d) {
/*  8 */     this.accel = 1;
/*  9 */     this.vy = (-17 * d);
/* 10 */     this.rect = new Rectangle(800, 160, 50, 50);
/* 11 */     this.images = new java.awt.Image[4];
/* 12 */     for (int a = 0; a < 4; a++) {
/* 13 */       this.images[a] = new javax.swing.ImageIcon("enemies\\Blooper" + (a + 1) + ".png").getImage();
/*    */     }
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 18 */     g.drawImage(this.images[this.frame], this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 22 */     if (collide(p)) {
/* 23 */       effect(p);
/*    */     }
/* 25 */     for (Entity e : p.stuff) {
/* 26 */       if (this.rect.intersects(e.rect)) {
/* 27 */         System.out.println("Remove");
/* 28 */         this.exist = false;
/* 29 */         return;
/*    */       }
/*    */     }
/*    */     
/* 33 */     if (++this.frame > 3) {
/* 34 */       this.frame = 0;
/*    */     }
/*    */     
/* 37 */     if (Math.abs(this.vy + this.accel) > 17) {
/* 38 */       this.accel = (-this.accel);
/*    */     }
/* 40 */     this.rect.x -= 4;
/* 41 */     this.rect.y += this.vy;
/* 42 */     this.vy += this.accel;
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Blooper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */