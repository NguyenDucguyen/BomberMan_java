
package bom_.actor;


import javax.swing.ImageIcon;

public class Bomber extends ActorObject
{
    public static final int STEP_LONG = 6;
    public static final int STEP_SHORT = 4;
    
    
    
    public int step = STEP_SHORT;

    public Bomber(int x, int y, String image, int direction, int type) {
        super(x, y, image, direction,type);
        type = BOMBER;
        step = STEP_SHORT;
        HEART = 3;
    }


    @Override
    public void changeDirection(int direction) { //hàm thay đổi image khi di chuyển
        super.changeDirection(direction);
        
        switch(direction)
        {
            case DOWN:
                {
                    ImageIcon image_icon = new ImageIcon("bomber_down.png");
                    this.image = image_icon.getImage();
                }
                break;
            case UP:
                {
                    ImageIcon image_icon = new ImageIcon("bomber_up.png");
                    this.image = image_icon.getImage();
                }
                break;
            case LEFT:
                {
                    ImageIcon image_icon = new ImageIcon("bomber_left.png");
                    this.image = image_icon.getImage();
                }
                break;
            case RIGHT:
                {
                    ImageIcon image_icon = new ImageIcon("bomber_right.png");
                    this.image = image_icon.getImage();
                }
                break;
            
        }
    }
    
   
    
}
