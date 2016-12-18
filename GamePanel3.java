/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GamePanel$3
/*     */   implements ActionListener
/*     */ {
/*     */   GamePanel$3(GamePanel paramGamePanel) {}
/*     */   
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 102 */     if (this.this$0.player.getKeyDown(1)) {
/* 103 */       this.this$0.player.setMoveX(5);
/*     */     }
/* 105 */     else if (this.this$0.player.getKeyDown(0)) {
/* 106 */       this.this$0.player.setMoveX(-5);
/*     */     }
/*     */     else {
/* 109 */       this.this$0.player.setMoveX(0);
/*     */     }
/* 111 */     if ((this.this$0.player.getY() == 320) && 
/* 112 */       (this.this$0.player.getKeyDown(2))) {
/* 113 */       this.this$0.player.setMoveY(-20);
/*     */     }
/*     */     
/* 116 */     this.this$0.player.setMoveY(this.this$0.player.getMoveY() + 1);
/* 117 */     this.this$0.player.move();
/* 118 */     if (++this.this$0.dx1 > 3198) {
/* 119 */       this.this$0.dx1 = 0;
/*     */     }
/* 121 */     this.this$0.dx2 += 2;
/* 122 */     if (this.this$0.dx2 > 3198) {
/* 123 */       this.this$0.dx2 = 0;
/*     */     }
/* 125 */     this.this$0.dx3 += 3;
/* 126 */     if (this.this$0.dx3 > 3198) {
/* 127 */       this.this$0.dx3 = 0;
/*     */     }
/* 129 */     if (++this.this$0.n > 100) {
/* 130 */       int q = (int)(Math.random() * 9.0D);
/* 131 */       if (q == 0) {
/* 132 */         this.this$0.things.add(new Coin());
/* 133 */       } else if (q == 1) {
/* 134 */         this.this$0.things.add(new Skull());
/* 135 */       } else if (q == 2) {
/* 136 */         this.this$0.things.add(new Slime());
/* 137 */       } else if (q == 3) {
/* 138 */         this.this$0.things.add(new Slime2());
/* 139 */       } else if (q == 4) {
/* 140 */         this.this$0.things.add(new Blooper(1));
/* 141 */         this.this$0.things.add(new Blooper(-1));
/*     */       }
/* 143 */       else if (q == 5) {
/* 144 */         this.this$0.things.add(new Blooper2());
/* 145 */       } else if (q == 6) {
/* 146 */         this.this$0.things.add(new Fire());
/* 147 */       } else if (q == 7) {
/* 148 */         this.this$0.things.add(new Saw());
/* 149 */       } else if (q == 8) {
/* 150 */         this.this$0.things.add(new Brick()); }
/* 151 */       this.this$0.n = ((int)(Math.random() * 100.0D));
/*     */     }
/* 153 */     if (++this.this$0.n2 > 200) {
/* 154 */       this.this$0.things.add(new Carrot((int)(Math.random() * 3.0D)));
/* 155 */       this.this$0.n2 = 0;
/*     */     }
/*     */     
/* 158 */     this.this$0.player.tick();
/*     */     
/* 160 */     this.this$0.repaint();
/*     */   }
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\GamePanel$3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */