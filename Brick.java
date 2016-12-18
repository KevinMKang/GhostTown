/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Brick extends Enemy
/*    */ {
/*    */   java.awt.Image image;
/*    */   
/*    */   Brick() {
/*  8 */     this.rect = new Rectangle(800, (int)(Math.random() * 170.0D) + 150, 50, 50);
/*  9 */     this.image = new javax.swing.ImageIcon("obstacles/brick.png").getImage();
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 13 */     g.drawImage(this.image, this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 17 */     this.rect.x -= 2;
/* 18 */     if (collide(p)) {
/* 19 */       p.damage();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Brick.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */