/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ class Enemy extends Entity
/*    */ {
/*    */   java.awt.Image[] images;
/*    */   int dx;
/*    */   int frame;
/*    */   
/*    */   public Enemy()
/*    */   {
/* 12 */     this.frame = 0;
/* 13 */     this.exist = true;
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 17 */     this.rect.x -= this.dx;
/* 18 */     if (collide(p)) {
/* 19 */       effect(p);
/*    */     }
/*    */   }
/*    */   
/*    */   public void effect(Player p) {
/* 24 */     p.damage();
/*    */   }
/*    */   
/*    */   public boolean collide(Player p) {
/* 28 */     return this.rect.intersects(p.rect);
/*    */   }
/*    */   
/*    */   public void draw(Graphics g) {
/* 32 */     g.drawImage(this.images[this.frame], this.rect.x, this.rect.y, (int)this.rect.getWidth(), (int)this.rect.getHeight(), null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Enemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */