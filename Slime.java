/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Slime extends Enemy
/*    */ {
/*    */   public Slime()
/*    */   {
/*  7 */     this.rect = new Rectangle(800, 320, 50, 50);
/*  8 */     this.images = new java.awt.Image[4];
/*  9 */     for (int a = 0; a < 4; a++) {
/* 10 */       this.images[a] = new javax.swing.ImageIcon("enemies\\Slime" + (a + 1) + ".png").getImage();
/*    */     }
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 15 */     g.drawImage(this.images[this.frame], this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 19 */     if (collide(p)) {
/* 20 */       effect(p);
/*    */     }
/* 22 */     for (Entity e : p.stuff) {
/* 23 */       if (this.rect.intersects(e.rect)) {
/* 24 */         System.out.println("Remove");
/* 25 */         this.exist = false;
/* 26 */         return;
/*    */       }
/*    */     }
/*    */     
/* 30 */     if (++this.frame > 3) {
/* 31 */       this.frame = 0;
/*    */     }
/* 33 */     this.rect.x -= 2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Slime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */