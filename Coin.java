/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ class Coin extends Enemy
/*    */ {
/*  6 */   java.awt.Image image = new javax.swing.ImageIcon("Sprites\\coin.png").getImage();
/*    */   
/*    */   public Coin() {
/*  9 */     this.rect = new Rectangle(800, (int)(Math.random() * 170.0D) + 150, 50, 50);
/*    */   }
/*    */   
/*    */   public void draw(Graphics g) {
/* 13 */     g.drawImage(this.image, this.rect.x, this.rect.y, null);
/*    */   }
/*    */   
/*    */   public void effect(Player p) {
/* 17 */     p.addMoney(200);
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 21 */     if (collide(p)) {
/* 22 */       effect(p);
/* 23 */       this.exist = false;
/*    */     }
/*    */     
/* 26 */     this.rect.x -= 2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Coin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */