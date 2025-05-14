package bom_.mapObject;

import java.awt.Image;
import javax.swing.ImageIcon;

//lớp cha của các phần không di chuyển: wall, brick,..
public class MapObject
{
    public static int GRASS = 0;
    public static int BRICK = 1;
    public static int WALL = 2;
    public static int BOMB = 3;
    public static int FIRE_SHORT = 4;
    public static int FIRE_LONG = 5;
    public static int BOMBER = 6;
    public static int ACTOR = 9;
    
    public static int ITEM_1 = 10;
    public static int ITEM_2 = 12;

    public static int MAP_W = 40;
    public static int MAP_H = 40;
    
    public int x;
    public int y;
    public Image image;
    public int type;
    
    public MapObject(int x, int y, String image, int type)
    {
        this.x = x;
        this.y = y;
        ImageIcon image_icon = new ImageIcon(image);
        this.image = image_icon.getImage();
        this.type = type;
    }
    
    
    public void setImage(String image)
    {
        ImageIcon image_icon = new ImageIcon(image);
        this.image = image_icon.getImage();
    }
}
