package bom_.mapObject;

import javax.swing.*;
import java.awt.*;

public class Item extends MapObject {
    public  static int TIME_SHOW_ITEM = 5000;
    public int timeline;
    public Item(int x, int y, String image) {
        super(x, y, image, ITEM_1);
        timeline = TIME_SHOW_ITEM;
    }

    public Image get_Image_Item(int type)
    {
        if(type == ITEM_1)
        {
            ImageIcon item_1 = new ImageIcon("source/image/item.png");
            return image = item_1.getImage();
        }
        else if(type == ITEM_2)
        {
            ImageIcon item_1 = new ImageIcon("source/image/item2.png");
            return image = item_1.getImage();
        }
        return null;
    }
}
