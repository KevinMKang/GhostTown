/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Skull extends Enemy
/*    */ {
/*    */   javax.swing.ImageIcon[] tp;
/*    */   int t;
/*    */   boolean tping;
/*    */   int tpc;
/*    */   int prevx;
/*    */   int prevy;
/*    */   
/*    */   public Skull()
/*    */   {
/* 14 */     this.t = 50;
/* 15 */     this.rect = new Rectangle(800, 300, 50, 50);
/* 16 */     this.images = new java.awt.Image[5];
/* 17 */     for (int a = 0; a < 5; a++) {
/* 18 */       this.images[a] = new javax.swing.ImageIcon("enemies\\Skull" + (a + 1) + ".png").getImage();
/*    */     }
/*    */     
/* 21 */     this.tp = new javax.swing.ImageIcon[5];
/*    */     
/* 23 */     for (int a = 1; a < 6; a++) {
/* 24 */       this.tp[(a - 1)] = new javax.swing.ImageIcon("tp/tp" + a + ".png");
/*    */     }
/*    */     
/* 27 */     this.tpc = 0;
/* 28 */     this.tping = false;
/* 29 */     this.prevy = this.rect.y;
/*    */   }
/*    */   
/*    */   public void draw(java.awt.Graphics g) {
/* 33 */     if (!this.tping) {
/* 34 */       g.drawImage(this.images[this.frame], this.rect.x, this.rect.y, null);
/*    */     }
/* 36 */     if (this.tping) {
/* 37 */       g.drawImage(this.tp[this.tpc].getImage(), this.prevx, this.prevy, null);
/* 38 */       g.drawImage(this.tp[(4 - this.tpc)].getImage(), this.prevx, this.rect.y, null);
/*    */     }
/*    */   }
/*    */   
/*    */   public void update(Player p) {
/* 43 */     if (collide(p)) {
/* 44 */       effect(p);
/*    */     }
/* 46 */     for (Entity e : p.stuff) {
/* 47 */       if (this.rect.intersects(e.rect)) {
/* 48 */         System.out.println("Remove");
/* 49 */         this.exist = false;
/* 50 */         return;
/*    */       }
/*    */     }
/*    */     
/* 54 */     if (++this.frame > 4) {
/* 55 */       this.frame = 0;
/*    */     }
/* 57 */     this.t -= 1;
/* 58 */     if (!this.tping) {
/* 59 */       this.rect.x -= 2;
/*    */     }
/* 61 */     if (this.tping) {
/* 62 */       this.tpc += 1;
/*    */     }
/* 64 */     if (this.tpc > 4) {
/* 65 */       this.tping = false;
/*    */     }
/* 67 */     if (this.t < 0) {
/* 68 */       this.prevx = this.rect.x;
/* 69 */       this.prevy = this.rect.y;
/* 70 */       this.tping = true;
/* 71 */       this.tpc = 0;
/* 72 */       this.rect.y = ((int)(Math.random() * 320.0D));
/* 73 */       this.t = 50;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Skull.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */