/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class ShopPanel extends JPanel implements java.awt.event.ActionListener, java.awt.event.MouseListener, java.awt.event.MouseMotionListener
/*     */ {
/*  14 */   static BufferedImage shopkeep = null;
/*     */   private Main mf;
/*  16 */   int selected = 0;
/*  17 */   int money = 1000;
/*  18 */   String item = "Heal";
/*  19 */   Boolean[] inStock = new Boolean[5];
/*  20 */   int cost = 50;
/*  21 */   String desLine1 = "Good olâ€™ fashioned healing potion.";
/*  22 */   String desLine2 = "Restores 1 heart.";
/*     */   private Timer myTimer;
/*  24 */   boolean PPressBool; boolean RPressBool = false;
/*  25 */   static BufferedImage selectItem; static BufferedImage shop; static BufferedImage p; static BufferedImage r; static BufferedImage pPress; static BufferedImage rPress = null;
/*  26 */   static BufferedImage clock; static BufferedImage school; static BufferedImage flies; static BufferedImage heal; static BufferedImage shoe; static BufferedImage ds = null;
/*  27 */   Font f = new Font("04b03", 100, 18);
/*  28 */   Color colorRed = new Color(15997522);
/*  29 */   Color colorBlue = new Color(1643829);
/*     */   int x;
/*     */   int y;
/*     */   
/*     */   public ShopPanel(Main frame) {
/*  34 */     setFont(this.f);
/*  35 */     this.myTimer = new Timer(15, this);
/*  36 */     this.myTimer.addActionListener(this);
/*  37 */     this.myTimer.start();
/*  38 */     this.mf = frame;
/*     */     
/*     */     try
/*     */     {
/*  42 */       shop = ImageIO.read(new File("images//shop.png"));
/*     */       
/*  44 */       p = ImageIO.read(new File("images//purchaseUP.png"));
/*  45 */       pPress = ImageIO.read(new File("images//purchaseDOWN.png"));
/*  46 */       r = ImageIO.read(new File("images//backUP.png"));
/*  47 */       rPress = ImageIO.read(new File("images//backDOWN.png"));
/*     */       
/*  49 */       selectItem = ImageIO.read(new File("images//heal.png"));
/*     */       
/*     */ 
/*  52 */       clock = ImageIO.read(new File("images//clock.png"));
/*  53 */       school = ImageIO.read(new File("images//school.png"));
/*  54 */       flies = ImageIO.read(new File("images//flies.png"));
/*  55 */       heal = ImageIO.read(new File("images//heal.png"));
/*  56 */       shoe = ImageIO.read(new File("images//shoe.png"));
/*  57 */       ds = ImageIO.read(new File("images//ds.png"));
/*     */     } catch (IOException e) {
/*  59 */       e.printStackTrace();
/*     */     }
/*  61 */     setFocusable(true);
/*  62 */     requestFocus();
/*  63 */     addMouseListener(this);
/*  64 */     addMouseMotionListener(this);
/*  65 */     for (int i = 0; i < 5; i++) {
/*  66 */       this.inStock[i] = Boolean.valueOf(false);
/*     */     }
/*     */   }
/*     */   
/*     */   public void actionPerformed(java.awt.event.ActionEvent e) {
/*  71 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/*  77 */     super.paintComponent(g);
/*  78 */     setFont(this.f);
/*  79 */     g.setColor(Color.green);
/*  80 */     g.drawImage(shop, 0, 0, 800, 600, null);
/*  81 */     for (int i = 0; i < 3; i++) {
/*  82 */       for (int z = 0; z < 2; z++)
/*     */       {
/*  84 */         if ((i == 0) && (z == 0)) {
/*  85 */           g.drawImage(heal, 124 + i * 111, 161 + 110 * z, 85, 85, 
/*  86 */             null);
/*     */         }
/*  88 */         if ((i == 1) && (z == 0) && (!this.inStock[0].booleanValue())) {
/*  89 */           g.drawImage(flies, 121 + i * 111, 161 + 110 * z, 90, 90, 
/*  90 */             null);
/*     */         }
/*  92 */         if ((i == 2) && (z == 0) && (!this.inStock[1].booleanValue())) {
/*  93 */           g.drawImage(shoe, 121 + i * 111, 161 + 110 * z, 90, 90, 
/*  94 */             null);
/*     */         }
/*  96 */         if ((i == 0) && (z == 1) && (!this.inStock[2].booleanValue())) {
/*  97 */           g.drawImage(school, 123 + i * 111, 161 + 110 * z, 85, 85, 
/*  98 */             null);
/*     */         }
/* 100 */         if ((i == 1) && (z == 1) && (!this.inStock[3].booleanValue())) {
/* 101 */           g.drawImage(ds, 116 + i * 111, 156 + 110 * z, 100, 100, 
/* 102 */             null);
/*     */         }
/* 104 */         if ((i == 2) && (z == 1) && (!this.inStock[4].booleanValue())) {
/* 105 */           g.drawImage(clock, 124 + i * 111, 157 + 110 * z, 90, 90, 
/* 106 */             null);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 114 */     g.setColor(this.colorRed);
/* 115 */     g.drawString("$" + this.money, 345, 404);
/* 116 */     g.drawString(this.item, 525, 185);
/* 117 */     g.drawString("$" + this.cost, 542, 212);
/* 118 */     g.setColor(this.colorBlue);
/*     */     
/* 120 */     g.drawImage(selectItem, 537, 230, 100, 100, null);
/* 121 */     g.drawString(this.desLine1, 200, 455);
/* 122 */     g.drawString(this.desLine2, 200, 480);
/* 123 */     if (this.selected == 0) {
/* 124 */       g.drawRect(118, 163, 95, 95);
/*     */     }
/* 126 */     if ((this.selected == 1) && (!this.inStock[0].booleanValue())) {
/* 127 */       g.drawRect(229, 163, 95, 95);
/*     */     }
/* 129 */     if ((this.selected == 2) && (!this.inStock[1].booleanValue())) {
/* 130 */       g.drawRect(340, 163, 95, 95);
/*     */     }
/* 132 */     if ((this.selected == 3) && (!this.inStock[2].booleanValue())) {
/* 133 */       g.drawRect(118, 273, 95, 95);
/*     */     }
/* 135 */     if ((this.selected == 4) && (!this.inStock[3].booleanValue())) {
/* 136 */       g.drawRect(229, 273, 95, 95);
/*     */     }
/* 138 */     if ((this.selected == 5) && (!this.inStock[4].booleanValue())) {
/* 139 */       g.drawRect(340, 273, 95, 95);
/*     */     }
/*     */     
/* 142 */     if (this.PPressBool) {
/* 143 */       g.drawImage(pPress, 512, 345, 150, 60, null);
/*     */     } else {
/* 145 */       g.drawImage(p, 512, 345, 150, 60, null);
/*     */     }
/* 147 */     if (this.RPressBool) {
/* 148 */       g.drawImage(rPress, 609, 85, 100, 60, null);
/*     */     } else {
/* 150 */       g.drawImage(r, 609, 85, 100, 60, null);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseClicked(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/* 163 */     this.x = e.getX();
/* 164 */     this.y = e.getY();
/*     */     
/* 166 */     if (checkBounds(this.x, this.y, 609, 709, 85, 145)) {
/* 167 */       this.RPressBool = true;
/*     */     }
/* 169 */     if (checkBounds(this.x, this.y, 512, 662, 345, 405)) {
/* 170 */       this.PPressBool = true;
/*     */     }
/*     */     
/* 173 */     if (checkBounds(this.x, this.y, 116, 220, 151, 251)) {
/* 174 */       System.out.println("hi");
/* 175 */       this.selected = 0;
/*     */       try {
/* 177 */         selectItem = ImageIO.read(new File("images//heal.png"));
/*     */       } catch (IOException q) {
/* 179 */         q.printStackTrace();
/*     */       }
/*     */       
/* 182 */       this.item = "Heal";
/* 183 */       this.desLine1 = "Good olâ€™ fashioned healing potion.";
/* 184 */       this.desLine2 = "Restores 1 heart.";
/* 185 */       this.cost = 50;
/*     */ 
/*     */     }
/* 188 */     else if ((checkBounds(this.x, this.y, 227, 330, 151, 251)) && (!this.inStock[0].booleanValue())) {
/* 189 */       this.selected = 1;
/*     */       try {
/* 191 */         selectItem = ImageIO.read(new File("images//flies.png"));
/*     */       } catch (IOException q) {
/* 193 */         q.printStackTrace();
/*     */       }
/*     */       
/* 196 */       this.item = "Vicious Flies";
/* 197 */       this.desLine1 = "These fireflies are mutated and aggressive.";
/* 198 */       this.desLine2 = "Fire Flies kill on touch.";
/* 199 */       this.cost = 500;
/*     */ 
/*     */     }
/* 202 */     else if ((checkBounds(this.x, this.y, 338, 440, 151, 251)) && (!this.inStock[1].booleanValue())) {
/* 203 */       this.selected = 2;
/*     */       try {
/* 205 */         selectItem = ImageIO.read(new File("images//shoe.png"));
/*     */       } catch (IOException q) {
/* 207 */         q.printStackTrace();
/*     */       }
/*     */       
/* 210 */       this.item = "Shop of Speed";
/* 211 */       this.desLine1 = "You want more speed? Buy a shoe, just one.";
/* 212 */       this.desLine2 = "Increase speed.";
/* 213 */       this.cost = 500;
/*     */ 
/*     */     }
/* 216 */     else if ((checkBounds(this.x, this.y, 116, 220, 261, 361)) && (!this.inStock[2].booleanValue())) {
/* 217 */       this.selected = 3;
/*     */       try {
/* 219 */         selectItem = ImageIO.read(new File("images//school.png"));
/*     */       } catch (IOException q) {
/* 221 */         q.printStackTrace();
/*     */       }
/*     */       
/* 224 */       this.item = "Business School";
/* 225 */       this.desLine1 = "Making your way up in world. Chance to ";
/* 226 */       this.desLine2 = "get a random power up when collecting coins.";
/* 227 */       this.cost = 500;
/*     */ 
/*     */     }
/* 230 */     else if ((checkBounds(this.x, this.y, 227, 330, 261, 361)) && (!this.inStock[3].booleanValue())) {
/* 231 */       this.selected = 4;
/*     */       try {
/* 233 */         selectItem = ImageIO.read(new File("images//ds.png"));
/*     */       } catch (IOException q) {
/* 235 */         q.printStackTrace();
/*     */       }
/*     */       
/* 238 */       this.item = "Double Shot";
/* 239 */       this.desLine1 = "Twice the bullet for the value of one.";
/* 240 */       this.desLine2 = "Shoot two bullets on action.";
/* 241 */       this.cost = 500;
/*     */ 
/*     */     }
/* 244 */     else if ((checkBounds(this.x, this.y, 338, 440, 261, 361)) && (!this.inStock[4].booleanValue())) {
/* 245 */       this.selected = 5;
/*     */       try {
/* 247 */         selectItem = ImageIO.read(new File("images//clock.png"));
/*     */       } catch (IOException q) {
/* 249 */         q.printStackTrace();
/*     */       }
/*     */       
/* 252 */       this.item = "Wind-up Rabbit";
/* 253 */       this.desLine1 = "So many monsters, so little time.";
/* 254 */       this.desLine2 = "Increase duration of all power-ups.";
/* 255 */       this.cost = 1000;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean checkBounds(int mX, int mY, int x1, int x2, int y1, int y2) {
/* 260 */     if ((mX > x1) && (mX < x2) && (mY > y1) && (mY < y2)) {
/* 261 */       return true;
/*     */     }
/* 263 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void mouseReleased(MouseEvent e)
/*     */   {
/* 270 */     if (checkBounds(this.x, this.y, 609, 709, 85, 145)) {
/* 271 */       this.mf.openMenu();
/*     */     }
/* 273 */     this.RPressBool = false;
/* 274 */     this.PPressBool = false;
/* 275 */     if (checkBounds(this.x, this.y, 512, 662, 345, 405))
/*     */     {
/* 277 */       if (this.cost >= this.money) {
/* 278 */         this.desLine1 = "You don't have enough money, scrub";
/* 279 */         this.desLine2 = "";
/*     */       }
/*     */       
/* 282 */       if ((this.selected == 0) && (this.cost <= this.money))
/*     */       {
/* 284 */         this.money -= this.cost;
/* 285 */         this.desLine1 = "Good olâ€™ fashioned healing potion.";
/* 286 */         this.desLine2 = "Restores 1 heart.";
/*     */       }
/* 288 */       if ((this.selected == 1) && (!this.inStock[0].booleanValue()) && (this.cost <= this.money)) {
/* 289 */         this.inStock[0] = Boolean.valueOf(true);
/* 290 */         this.money -= this.cost;
/* 291 */         this.desLine1 = "These fireflies are mutated and aggressive.";
/* 292 */         this.desLine2 = "Fire Flies kill on touch.";
/*     */       }
/*     */       
/* 295 */       if ((this.selected == 2) && (!this.inStock[1].booleanValue()) && (this.cost <= this.money)) {
/* 296 */         this.inStock[1] = Boolean.valueOf(true);
/*     */         
/* 298 */         this.money -= this.cost;
/* 299 */         this.desLine1 = "You want more speed? Buy a shoe, just one.";
/* 300 */         this.desLine2 = "Increase speed.";
/*     */       }
/* 302 */       if ((this.selected == 3) && (!this.inStock[2].booleanValue()) && (this.cost <= this.money)) {
/* 303 */         this.inStock[2] = Boolean.valueOf(true);
/*     */         
/* 305 */         this.money -= this.cost;
/* 306 */         this.desLine1 = "Making your way up in world. Chance to ";
/* 307 */         this.desLine2 = "get a random power up when collecting coins.";
/*     */       }
/* 309 */       if ((this.selected == 4) && (!this.inStock[3].booleanValue()) && (this.cost <= this.money)) {
/* 310 */         this.inStock[3] = Boolean.valueOf(true);
/*     */         
/* 312 */         this.desLine1 = "Twice the bullet for the value of one.";
/* 313 */         this.desLine2 = "Shoot two bullets on action.";
/* 314 */         this.money -= this.cost;
/*     */       }
/* 316 */       if ((this.selected == 5) && (!this.inStock[4].booleanValue()) && (this.cost <= this.money)) {
/* 317 */         this.inStock[4] = Boolean.valueOf(true);
/*     */         
/* 319 */         this.money -= this.cost;
/* 320 */         this.desLine1 = "So many monsters, so little time.";
/* 321 */         this.desLine2 = "Increase duration of all power-ups.";
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */   public void mouseDragged(MouseEvent e) {}
/*     */   
/*     */   public void mouseMoved(MouseEvent e) {}
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\ShopPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */