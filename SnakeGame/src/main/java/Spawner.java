
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 *
 * @author nicol
 */
public class Spawner {
    
    public int timer = 0;
    
    public List<RectObj> rectangles = new ArrayList<RectObj>();
    
    public void update(){
        timer++;
        
        if(timer%60 == 0){
            rectangles.add(new RectObj(0, new Random().nextInt(480-80), 40,40));
        }
        
        for(int i = 0; i< rectangles.size(); i++){
            
            RectObj current = rectangles.get(i);
            
            rectangles.get(i).update();
            
            if(current.x > Game.WIDTH){
                rectangles.remove(current);
                Game.vida--;
                
            }
        }
        
    }
    
    public void render(Graphics g){
        
        for(int i = 0; i < rectangles.size(); i++){
            RectObj current = rectangles.get(i);
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(Math.toRadians(current.rotation), current.x+current.width/2, current.y+current.height/2);
            g2.setColor(current.color);
            g2.fillRect(current.x, current.y, current.width ,current.height);
            g2.rotate(Math.toRadians(-current.rotation), current.x+current.width/2, current.y+current.height/2);
        }
    }
    
}

