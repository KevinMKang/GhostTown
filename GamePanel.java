/*     */ import java.awt.Graphics;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ class GamePanel extends javax.swing.JPanel
/*     */ {
/*     */   Main parent;
/*   8 */   java.awt.Image[] bg = new java.awt.Image[5];
/*   9 */   java.awt.Image[] menu = new java.awt.Image[2];
/*  10 */   java.awt.Image heart1 = new ImageIcon("Sprites\\Life1.png").getImage(); java.awt.Image heart2 = new ImageIcon("Sprites\\Life2.png").getImage();
/*  11 */   java.awt.Image coin = new ImageIcon("Sprites\\coin.png").getImage();
/*     */   
/*     */   java.awt.Image pause;
/*     */   
/*     */   javax.swing.Timer timer;
/*     */   ArrayList<Entity> things;
/*     */   Player player;
/*     */   boolean paused;
/*     */   boolean pressed;
/*     */   
/*     */   public GamePanel(Main main)
/*     */   {
/*  23 */     this.parent = main;
/*  24 */     this.player = new Player();
/*     */     
/*  26 */     for (int a = 0; a < 5; a++) {
/*  27 */       this.bg[a] = new ImageIcon("Sprites\\BG" + (a + 1) + ".png").getImage();
/*     */     }
/*  29 */     this.menu[0] = new ImageIcon("Sprites\\MenuU.png").getImage();
/*  30 */     this.menu[1] = new ImageIcon("Sprites\\MenuD.png").getImage();
/*  31 */     this.pause = new ImageIcon("Sprites\\Pause.png").getImage();
/*     */     
/*  33 */     addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mousePressed(java.awt.event.MouseEvent e) {
/*  35 */         if ((GamePanel.this.paused) && (e.getX() >= 350) && (e.getX() <= 450) && (e.getY() >= 360) && (e.getY() <= 420)) {
/*  36 */           GamePanel.this.pressed = true;
/*  37 */           GamePanel.this.repaint();
/*     */         }
/*     */       }
/*     */       
/*     */       public void mouseReleased(java.awt.event.MouseEvent e) {
/*  42 */         if (GamePanel.this.pressed) {
/*  43 */           GamePanel.this.timer.stop();
/*  44 */           GamePanel.this.parent.openMenu();
/*     */         }
/*     */         
/*     */       }
/*  48 */     });
/*  49 */     addKeyListener(new java.awt.event.KeyAdapter()
/*     */     {
/*     */       public void keyPressed(java.awt.event.KeyEvent e) {
/*  52 */         if (e.getKeyCode() == 27) {
/*  53 */           GamePanel.this.parent.dispose();
/*     */         }
/*  55 */         if (e.getKeyCode() == 80) {
/*  56 */           GamePanel.this.paused = (!GamePanel.this.paused);
/*  57 */           if (GamePanel.this.paused) {
/*  58 */             GamePanel.this.timer.stop();
/*     */           }
/*     */           else {
/*  61 */             GamePanel.this.timer.start();
/*     */           }
/*  63 */           GamePanel.this.repaint();
/*     */         }
/*  65 */         if (!GamePanel.this.paused) {
/*  66 */           if (e.getKeyCode() == GamePanel.this.parent.keys[GamePanel.this.parent.keyN][0]) {
/*  67 */             GamePanel.this.player.setKeyDown(0, true);
/*     */           }
/*  69 */           if (e.getKeyCode() == GamePanel.this.parent.keys[GamePanel.this.parent.keyN][1]) {
/*  70 */             GamePanel.this.player.setKeyDown(2, true);
/*     */           }
/*  72 */           if (e.getKeyCode() == GamePanel.this.parent.keys[GamePanel.this.parent.keyN][2]) {
/*  73 */             GamePanel.this.player.setKeyDown(1, true);
/*     */           }
/*  75 */           if (e.getKeyCode() == 32)
/*  76 */             if (GamePanel.this.player.getPower() == 1) {
/*  77 */               GamePanel.this.player.useItem();
/*  78 */               GamePanel.this.player.add(new Bullet(GamePanel.this.player.getX() + 50, GamePanel.this.player.getY()));
/*     */             }
/*  80 */             else if (GamePanel.this.player.getPower() == 2) {
/*  81 */               GamePanel.this.player.useItem();
/*  82 */               GamePanel.this.player.add(new Fist(GamePanel.this.player.getX() + 50, GamePanel.this.player.getY()));
/*     */             }
/*     */         }
/*     */       }
/*     */       
/*     */       public void keyReleased(java.awt.event.KeyEvent e) {
/*  88 */         if (e.getKeyCode() == GamePanel.this.parent.keys[GamePanel.this.parent.keyN][0]) {
/*  89 */           GamePanel.this.player.setKeyDown(0, false);
/*     */         }
/*  91 */         if (e.getKeyCode() == GamePanel.this.parent.keys[GamePanel.this.parent.keyN][1]) {
/*  92 */           GamePanel.this.player.setKeyDown(2, false);
/*     */         }
/*  94 */         if (e.getKeyCode() == GamePanel.this.parent.keys[GamePanel.this.parent.keyN][2]) {
/*  95 */           GamePanel.this.player.setKeyDown(1, false);
/*     */         }
/*     */         
/*     */       }
/*  99 */     });
/* 100 */     this.timer = new javax.swing.Timer(20, new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent e) {
/* 102 */         if (GamePanel.this.player.getKeyDown(1)) {
/* 103 */           GamePanel.this.player.setMoveX(5);
/*     */         }
/* 105 */         else if (GamePanel.this.player.getKeyDown(0)) {
/* 106 */           GamePanel.this.player.setMoveX(-5);
/*     */         }
/*     */         else {
/* 109 */           GamePanel.this.player.setMoveX(0);
/*     */         }
/* 111 */         if ((GamePanel.this.player.getY() == 320) && 
/* 112 */           (GamePanel.this.player.getKeyDown(2))) {
/* 113 */           GamePanel.this.player.setMoveY(-20);
/*     */         }
/*     */         
/* 116 */         GamePanel.this.player.setMoveY(GamePanel.this.player.getMoveY() + 1);
/* 117 */         GamePanel.this.player.move();
/* 118 */         if (++GamePanel.this.dx1 > 3198) {
/* 119 */           GamePanel.this.dx1 = 0;
/*     */         }
/* 121 */         GamePanel.this.dx2 += 2;
/* 122 */         if (GamePanel.this.dx2 > 3198) {
/* 123 */           GamePanel.this.dx2 = 0;
/*     */         }
/* 125 */         GamePanel.this.dx3 += 3;
/* 126 */         if (GamePanel.this.dx3 > 3198) {
/* 127 */           GamePanel.this.dx3 = 0;
/*     */         }
/* 129 */         if (++GamePanel.this.n > 100) {
/* 130 */           int q = (int)(Math.random() * 9.0D);
/* 131 */           if (q == 0) {
/* 132 */             GamePanel.this.things.add(new Coin());
/* 133 */           } else if (q == 1) {
/* 134 */             GamePanel.this.things.add(new Skull());
/* 135 */           } else if (q == 2) {
/* 136 */             GamePanel.this.things.add(new Slime());
/* 137 */           } else if (q == 3) {
/* 138 */             GamePanel.this.things.add(new Slime2());
/* 139 */           } else if (q == 4) {
/* 140 */             GamePanel.this.things.add(new Blooper(1));
/* 141 */             GamePanel.this.things.add(new Blooper(-1));
/*     */           }
/* 143 */           else if (q == 5) {
/* 144 */             GamePanel.this.things.add(new Blooper2());
/* 145 */           } else if (q == 6) {
/* 146 */             GamePanel.this.things.add(new Fire());
/* 147 */           } else if (q == 7) {
/* 148 */             GamePanel.this.things.add(new Saw());
/* 149 */           } else if (q == 8) {
/* 150 */             GamePanel.this.things.add(new Brick()); }
/* 151 */           GamePanel.this.n = ((int)(Math.random() * 100.0D));
/*     */         }
/* 153 */         if (++GamePanel.this.n2 > 200) {
/* 154 */           GamePanel.this.things.add(new Carrot((int)(Math.random() * 3.0D)));
/* 155 */           GamePanel.this.n2 = 0;
/*     */         }
/*     */         
/* 158 */         GamePanel.this.player.tick();
/*     */         
/* 160 */         GamePanel.this.repaint(); } }); }
/*     */   
/*     */   boolean end;
/*     */   int dx1;
/*     */   int dx2;
/*     */   
/* 166 */   public void restart() { this.player.restart();
/* 167 */     this.paused = false;
/* 168 */     this.pressed = false;
/* 169 */     this.dx1 = 0;
/* 170 */     this.dx2 = 0;
/* 171 */     this.dx3 = 0;
/* 172 */     this.n = 0;
/* 173 */     this.n2 = 0;
/* 174 */     this.end = false;
/* 175 */     this.things = new ArrayList();
/* 176 */     this.timer.restart(); }
/*     */   
/*     */   int dx3;
/*     */   
/* 180 */   public void paintComponent(Graphics g) { super.paintComponent(g);
/* 181 */     g.drawImage(this.bg[0], 0, 0, 800, 600, null);
/*     */     
/* 183 */     g.drawImage(this.bg[1], -this.dx1, 0, 3198, 600, null);
/* 184 */     g.drawImage(this.bg[1], 3198 - this.dx1, 0, 3198, 600, null);
/*     */     
/* 186 */     g.drawImage(this.bg[2], -this.dx2, 0, 3198, 600, null);
/* 187 */     g.drawImage(this.bg[2], 3198 - this.dx2, 0, 3198, 600, null);
/*     */     
/* 189 */     g.drawImage(this.bg[3], -this.dx3, 0, 3198, 600, null);
/* 190 */     g.drawImage(this.bg[3], 3198 - this.dx3, 0, 3198, 600, null);
/*     */     
/* 192 */     g.drawImage(this.bg[4], 0, 0, 800, 600, null);
/*     */     
/* 194 */     for (int a = 0; a < this.things.size(); a++) {
/* 195 */       Entity thing = (Entity)this.things.get(a);
/* 196 */       thing.draw(g);
/* 197 */       thing.update(this.player);
/* 198 */       if (!thing.exist) {
/* 199 */         this.things.remove(thing);
/* 200 */         this.player.addMoney(100);
/*     */       }
/* 202 */       else if (thing.rect.x + thing.rect.getWidth() < 0.0D) {
/* 203 */         this.things.remove(thing);
/*     */       }
/*     */     }
/*     */     
/* 207 */     this.player.draw(g);
/*     */     
/* 209 */     for (int a = 0; a < this.player.getHP(); a++) {
/* 210 */       g.drawImage(this.heart1, a * 50, 0, 50, 50, null);
/*     */     }
/* 212 */     for (int a = this.player.getHP(); a < 3; a++) {
/* 213 */       g.drawImage(this.heart2, a * 50, 0, 50, 50, null);
/*     */     }
/*     */     
/* 216 */     g.drawImage(this.coin, 0, 100, 50, 50, null);
/* 217 */     g.drawString(this.player.getMoney(), 60, 110);
/*     */     
/* 219 */     if (this.player.getHP() <= 0) {
/* 220 */       this.parent.openOver(this.player);
/*     */     }
/*     */     
/* 223 */     if (this.paused) {
/* 224 */       g.drawImage(this.pause, 200, 150, 400, 300, null);
/* 225 */       if (this.pressed) {
/* 226 */         g.drawImage(this.menu[1], 350, 360, 100, 60, null);
/*     */       }
/*     */       else {
/* 229 */         g.drawImage(this.menu[0], 350, 360, 100, 60, null);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   int n;
/*     */   int n2;
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\GamePanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */