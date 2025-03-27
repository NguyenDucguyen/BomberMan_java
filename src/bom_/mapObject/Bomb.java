
package bom_.mapObject;

import java.awt.Rectangle;


public class Bomb extends MapObject{
    
    public  static int TIME_SHOW_BOM = 5000;   
    public int timeline;
    public Bomb(int x, int y, String image) {
        super(x, y, image, BOMB);
        timeline = TIME_SHOW_BOM;
    }
    
}
