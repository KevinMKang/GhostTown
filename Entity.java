/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Entity
/*    */ {
/*    */   Image image;
/*    */   Rectangle rect;
/*    */   boolean exist;
/*    */   
/*    */   public void draw(Graphics g) {}
/*    */   
/*    */   public void update(Player p) {}
/*    */   
/*    */   public void effect(Player p) {}
/*    */   
/*    */   public boolean collide(Entity e)
/*    */   {
/* 27 */     return this.rect.intersects(e.rect);
/*    */   }
/*    */ }


/* Location:              C:\Users\Hoon\Documents\GitHub\GhostTown\GhostTown.jar!\Entity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */