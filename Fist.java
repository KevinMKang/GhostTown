/*    */ import java.awt.Graphics;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ class Fist extends Entity
/*    */ {
/*  6 */   java.awt.Image image = new ImageIcon("Sprites\\Bullet.png").getImage();
/*    */   
/*    */   public Fist(int x, int y) {
/*  9 */     this.rect = new java.awt.Rectangle(x, y, 50, 50);
/* 10 */     this.exist = true;
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 14 */     this.rect.x = (p.getX() + 50);
/* 15 */     this.exist = p.isPunching();
/*    */   }
/*    */   
/*    */   public void draw(Graphics g) {}
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Fist.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */