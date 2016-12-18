/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ class Carrot extends Entity
/*    */ {
/*  6 */   java.awt.Image[] images = { new ImageIcon("Sprites\\Carrot1.png").getImage(), new ImageIcon("Sprites\\Carrot2.png").getImage(), new ImageIcon("Sprites\\Carrot3.png").getImage() };
/*    */   int type;
/*    */   
/*    */   public Carrot(int n) {
/* 10 */     this.type = n;
/* 11 */     this.rect = new Rectangle(800, 260, 50, 50);
/* 12 */     this.exist = true;
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 16 */     this.rect.x -= 5;
/* 17 */     if (collide(p)) {
/* 18 */       effect(p);
/*    */     }
/*    */   }
/*    */   
/*    */   public void effect(Player p) {
/* 23 */     p.changePower(this.type);
/* 24 */     this.exist = false;
/*    */   }
/*    */   
/*    */   public boolean collide(Player p) {
/* 28 */     return this.rect.intersects(p.rect);
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 32 */     g.drawImage(this.images[this.type], this.rect.x, this.rect.y, (int)this.rect.getWidth(), (int)this.rect.getHeight(), null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Carrot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */