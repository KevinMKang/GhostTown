/*    */ import javax.sound.sampled.Clip;
/*    */ 
/*    */ public class AudioPlayer
/*    */ {
/*    */   Clip clip;
/*    */   
/*    */   public AudioPlayer(String file)
/*    */   {
/*    */     try
/*    */     {
/* 11 */       javax.sound.sampled.AudioInputStream ais = javax.sound.sampled.AudioSystem.getAudioInputStream(getClass().getResourceAsStream(file));
/* 12 */       this.clip = javax.sound.sampled.AudioSystem.getClip();
/* 13 */       this.clip.open(ais);
/*    */     }
/*    */     catch (Exception e) {
/* 16 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public void play() {
/* 21 */     if (!this.clip.isRunning()) {
/* 22 */       this.clip.setFramePosition(0);
/* 23 */       this.clip.start();
/*    */     }
/*    */   }
/*    */   
/*    */   public void stop() {
/* 28 */     if (this.clip.isRunning())
/* 29 */       this.clip.stop();
/*    */   }
/*    */   
/*    */   public void loop() {
/* 33 */     if (!this.clip.isRunning()) {
/* 34 */       this.clip.setFramePosition(0);
/* 35 */       this.clip.loop(999);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\AudioPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */