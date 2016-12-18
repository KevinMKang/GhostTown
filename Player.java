/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ 
/*     */ class Player extends Entity
/*     */ {
/*   6 */   Image[] frames = new Image[5];
/*   7 */   Image[] shield = new Image[15];
/*   8 */   Image[] gun = new Image[4];
/*   9 */   Image[] punch = new Image[5];
/*     */   java.util.ArrayList<Entity> stuff;
/*     */   Rectangle rect;
/*     */   private int hp;
/*     */   private int money;
/*     */   private int moveX;
/*     */   private int moveY;
/*     */   private int frame;
/*     */   private int frame2;
/*     */   private boolean[] keyDown;
/*     */   private boolean animate;
/*     */   private boolean punching;
/*  21 */   private int powerUp; private int time; private int invin; private int n = 5;
/*     */   
/*     */   public Player() {
/*  24 */     for (int a = 0; a < 5; a++) {
/*  25 */       this.frames[a] = new javax.swing.ImageIcon("Sprites\\Player" + (a + 1) + ".png").getImage();
/*     */     }
/*  27 */     for (int a = 0; a < 15; a++) {
/*  28 */       this.shield[a] = new javax.swing.ImageIcon("Sprites\\shield" + (a + 1) + ".png").getImage();
/*     */     }
/*  30 */     for (int a = 0; a < 4; a++) {
/*  31 */       this.gun[a] = new javax.swing.ImageIcon("Sprites\\Gun" + (a + 1) + ".png").getImage();
/*     */     }
/*  33 */     for (int a = 0; a < 5; a++) {
/*  34 */       this.punch[a] = new javax.swing.ImageIcon("Sprites\\Punch" + (a + 1) + ".png").getImage();
/*     */     }
/*  36 */     restart();
/*     */   }
/*     */   
/*     */   public int getX()
/*     */   {
/*  41 */     return this.rect.x;
/*     */   }
/*     */   
/*     */   public int getY() {
/*  45 */     return this.rect.y;
/*     */   }
/*     */   
/*     */   public int getHP() {
/*  49 */     return this.hp;
/*     */   }
/*     */   
/*     */   public int getMoveX() {
/*  53 */     return this.moveX;
/*     */   }
/*     */   
/*     */   public int getMoveY() {
/*  57 */     return this.moveY;
/*     */   }
/*     */   
/*     */   public boolean getKeyDown(int n) {
/*  61 */     return this.keyDown[n];
/*     */   }
/*     */   
/*     */   public int getPower() {
/*  65 */     return this.powerUp;
/*     */   }
/*     */   
/*     */   public boolean isPunching() {
/*  69 */     return this.punching;
/*     */   }
/*     */   
/*     */   public int getMoney() {
/*  73 */     return this.money;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setKeyDown(int n, boolean b)
/*     */   {
/*  79 */     this.keyDown[n] = b;
/*     */   }
/*     */   
/*     */   public void setMoveX(int dx) {
/*  83 */     this.moveX = dx;
/*     */   }
/*     */   
/*     */   public void setMoveY(int dy) {
/*  87 */     this.moveY = dy;
/*     */   }
/*     */   
/*     */   public int getScore() {
/*  91 */     return this.money;
/*     */   }
/*     */   
/*     */ 
/*     */   public void restart()
/*     */   {
/*  97 */     this.stuff = new java.util.ArrayList();
/*  98 */     this.rect = new Rectangle(0, 320, 50, 50);
/*  99 */     this.hp = 3;
/* 100 */     this.moveX = 0;
/* 101 */     this.moveY = 0;
/* 102 */     this.frame = 0;
/* 103 */     this.powerUp = -1;
/* 104 */     this.time = 0;
/* 105 */     this.keyDown = new boolean[3];
/* 106 */     this.animate = false;
/* 107 */     this.invin = 0;
/* 108 */     this.punching = false;
/* 109 */     this.money = 0;
/*     */   }
/*     */   
/*     */   public void move() {
/* 113 */     this.rect.x += this.moveX;
/* 114 */     this.rect.y += this.moveY;
/* 115 */     if (this.rect.x < 0) {
/* 116 */       this.rect.x = 0;
/*     */     }
/* 118 */     else if (this.rect.x > 750) {
/* 119 */       this.rect.x = 750;
/*     */     }
/* 121 */     if (this.rect.y > 320) {
/* 122 */       this.moveY = 0;
/* 123 */       this.rect.y = 320;
/*     */     }
/* 125 */     if (++this.frame / this.n > 4) {
/* 126 */       this.frame = 0;
/*     */     }
/* 128 */     if ((this.powerUp == 0) && (++this.frame2 / this.n > 14)) {
/* 129 */       this.frame2 = 0;
/*     */     }
/* 131 */     else if ((this.powerUp == 1) && (this.animate) && (++this.frame2 / this.n > 3)) {
/* 132 */       this.frame2 = 0;
/* 133 */       this.animate = false;
/*     */     }
/* 135 */     else if ((this.powerUp == 2) && (this.animate) && (++this.frame2 / this.n > 4)) {
/* 136 */       this.frame2 = 0;
/* 137 */       this.animate = false;
/* 138 */       this.punching = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void changePower(int n) {
/* 143 */     this.powerUp = n;
/* 144 */     this.frame2 = 0;
/* 145 */     this.time = 150;
/* 146 */     if (this.powerUp == 2) {
/* 147 */       this.punching = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void tick() {
/* 152 */     if ((this.powerUp != -1) && (--this.time <= 0)) {
/* 153 */       this.powerUp = -1;
/*     */     }
/* 155 */     this.invin -= 1;
/*     */   }
/*     */   
/*     */   public void useItem() {
/* 159 */     this.animate = true;
/*     */   }
/*     */   
/*     */   public void damage() {
/* 163 */     if ((this.powerUp != 0) && (this.invin <= 0)) {
/* 164 */       this.hp -= 1;
/* 165 */       this.invin = 50;
/*     */     }
/*     */   }
/*     */   
/*     */   public void add(Entity e) {
/* 170 */     this.stuff.add(e);
/*     */   }
/*     */   
/*     */   public void addMoney(int n) {
/* 174 */     this.money += n;
/*     */   }
/*     */   
/*     */   public void draw(java.awt.Graphics g) {
/* 178 */     if ((this.invin <= 0) || (this.invin % 4 != 0)) {
/* 179 */       g.drawImage(this.frames[(this.frame / this.n)], this.rect.x, this.rect.y, 50, 50, null);
/* 180 */       if (this.powerUp == 0) {
/* 181 */         g.drawImage(this.shield[(this.frame2 / this.n)], this.rect.x, this.rect.y, 50, 50, null);
/*     */       }
/* 183 */       else if (this.powerUp == 1) {
/* 184 */         g.drawImage(this.gun[(this.frame2 / this.n)], this.rect.x, this.rect.y, 50, 50, null);
/*     */       }
/* 186 */       else if (this.powerUp == 2) {
/* 187 */         g.drawImage(this.punch[(this.frame2 / this.n)], this.rect.x, this.rect.y, 50, 50, null);
/*     */       }
/*     */     }
/* 190 */     for (int a = 0; a < this.stuff.size(); a++) {
/* 191 */       Entity e = (Entity)this.stuff.get(a);
/* 192 */       e.draw(g);
/* 193 */       e.update(this);
/* 194 */       if ((e.rect.x > 800) || (!e.exist)) {
/* 195 */         this.stuff.remove(e);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */