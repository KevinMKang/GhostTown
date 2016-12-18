/*     */ import java.awt.Container;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ class Main extends JFrame implements java.awt.event.KeyListener
/*     */ {
/*     */   public int[][] keys;
/*   8 */   public int keyN = 1;
/*     */   
/*     */   MenuPanel menu;
/*     */   
/*     */   GamePanel game;
/*     */   OptionPanel option;
/*     */   InstructionPanel instruct;
/*     */   ScorePanel score;
/*     */   GameOverPanel over;
/*     */   AudioPlayer select;
/*     */   AudioPlayer selectback;
/*     */   
/*     */   public Main()
/*     */   {
/*  22 */     super("Game");
/*  23 */     addKeyListener(this);
/*     */     
/*  25 */     this.select = new AudioPlayer("/select.wav");
/*  26 */     this.selectback = new AudioPlayer("/selectback.wav");
/*     */     
/*  28 */     new Skull();
/*  29 */     new Enemy();
/*  30 */     new Player();
/*  31 */     new Bullet(0, 0);
/*  32 */     new Fist(0, 0);
/*  33 */     new Slime();
/*  34 */     new Slime2();
/*  35 */     new Blooper(1);
/*  36 */     new Blooper2();
/*  37 */     new Coin();
/*  38 */     new Brick();
/*  39 */     new Fire();
/*  40 */     new Saw();
/*     */     
/*  42 */     this.keys = new int[][] { { 37, 38, 39 }, { 65, 87, 68 } };
/*     */     
/*  44 */     this.menu = new MenuPanel(this);
/*  45 */     this.game = new GamePanel(this);
/*  46 */     this.option = new OptionPanel(this);
/*  47 */     this.instruct = new InstructionPanel(this);
/*  48 */     this.score = new ScorePanel(this);
/*     */     
/*  50 */     this.game.setFocusable(true);
/*     */     
/*  52 */     this.menu.setBounds(0, 0, getWidth(), getHeight());
/*  53 */     this.game.setBounds(0, 0, getWidth(), getHeight());
/*  54 */     this.option.setBounds(0, 0, getWidth(), getHeight());
/*  55 */     this.instruct.setBounds(0, 0, getWidth(), getHeight());
/*  56 */     this.score.setBounds(0, 0, getWidth(), getHeight());
/*     */     
/*  58 */     setResizable(false);
/*  59 */     this.menu.setPreferredSize(new java.awt.Dimension(800, 600));
/*  60 */     getContentPane().add(this.menu);
/*  61 */     setVisible(true);
/*  62 */     pack();
/*     */   }
/*     */   
/*     */   public void openMenu()
/*     */   {
/*  67 */     setTitle("Menu");
/*  68 */     setContentPane(this.menu);
/*  69 */     revalidate();
/*  70 */     repaint();
/*     */   }
/*     */   
/*     */   public void startGame() {
/*  74 */     setTitle("Game");
/*  75 */     setContentPane(this.game);
/*  76 */     this.game.restart();
/*  77 */     revalidate();
/*  78 */     repaint();
/*  79 */     this.game.requestFocusInWindow();
/*     */   }
/*     */   
/*     */   public void openOption() {
/*  83 */     setTitle("Options");
/*  84 */     setContentPane(this.option);
/*  85 */     revalidate();
/*  86 */     repaint();
/*     */   }
/*     */   
/*     */   public void openInstruct()
/*     */   {
/*  91 */     setTitle("How to Play");
/*  92 */     setContentPane(this.instruct);
/*  93 */     revalidate();
/*  94 */     repaint();
/*     */   }
/*     */   
/*     */   public void openScores() {
/*  98 */     setTitle("Scores");
/*  99 */     setContentPane(this.score);
/* 100 */     revalidate();
/* 101 */     repaint();
/*     */   }
/*     */   
/*     */   public void openOver(Player p) {
/* 105 */     setTitle("Game Over");
/* 106 */     this.over = new GameOverPanel(this, p);
/* 107 */     setContentPane(this.over);
/* 108 */     revalidate();
/* 109 */     repaint();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 113 */     new Main();
/*     */   }
/*     */   
/*     */ 
/*     */   public void keyPressed(KeyEvent e)
/*     */   {
/* 119 */     if (e.getKeyCode() == 27) {
/* 120 */       dispose();
/*     */     }
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent arg0) {}
/*     */   
/*     */   public void keyTyped(KeyEvent arg0) {}
/*     */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */