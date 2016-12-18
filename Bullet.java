/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ class Bullet extends Entity
/*    */ {
/*  6 */   java.awt.Image image = new javax.swing.ImageIcon("Sprites\\Bullet.png").getImage();
/*    */   
/*    */   public Bullet(int x, int y) {
/*  9 */     this.rect = new Rectangle(x, y + 30, 4, 2);
/* 10 */     this.exist = true;
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 14 */     this.rect.x += 5;
/*    */   }
/*    */   
/*    */   public void draw(Graphics g) {
/* 18 */     g.drawImage(this.image, this.rect.x, this.rect.y, (int)this.rect.getWidth(), (int)this.rect.getHeight(), null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Bullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */