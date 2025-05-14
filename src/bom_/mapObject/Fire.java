package bom_.mapObject;

import bom_.actor.ActorObject;
import bom_.actor.Bomber;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Fire extends MapObject {
    final int CENTER_FIRE =0;
    final int LERT_FIRE = 1;
    final int RIGHT_FIRE = 2;
    final int DOWN_FIRE = 3;
    final int UP_FIRE = 4;

    final int BRICK_FIRE = 5;
    final int WALL_FIRE = 6;

    Item item;

    public Image img_left, img_right, img_up, img_down, img_center;
    public  static int TIME_SHOW_FIRE = 500;

    public int timeline;
    public int timeline_item;
    public int direction;

    public Fire(int x, int y, String image) {
        super(x, y, image, FIRE_SHORT);
        timeline = TIME_SHOW_FIRE;
    }
    public Image setImage_Fire(int direction) //vẽ tia lửa
    {
        switch (direction)
        {
            case CENTER_FIRE:
                ImageIcon img_center = new ImageIcon("source/image/bombbang.png"); //vẽ bom nổ ở giữa
                return  image = img_center.getImage();
            case LERT_FIRE:
                if(type == FIRE_SHORT){
                    ImageIcon img_left = new ImageIcon("source/image/bombbang_left_1.png"); //vẽ khi chưa ăn item tăng sức mạnh
                    return  image = img_left.getImage();
                }
                else if (type == FIRE_LONG)
                {
                    ImageIcon img_left = new ImageIcon("source/image/bombbang_left_2.png"); //khi đã tăng sức mạnh
                    return  image = img_left.getImage();
                }
                break;
            case RIGHT_FIRE:
                if(type == FIRE_SHORT){
                    ImageIcon img_right = new ImageIcon("source/image/bombbang_right_1.png");
                    return  image = img_right.getImage();
                }
                else if (type == FIRE_LONG)
                {
                    ImageIcon img_right = new ImageIcon("source/image/bombbang_right_2.png");
                    return  image = img_right.getImage();
                }
                break;
            case UP_FIRE :
                if(type == FIRE_SHORT){
                    ImageIcon img_up = new ImageIcon("source/image/bombbang_up_1.png");
                    return  image = img_up.getImage();
                }
                else if (type == FIRE_LONG)
                {
                    ImageIcon img_up = new ImageIcon("source/image/bombbang_up_2.png");
                    return  image = img_up.getImage();
                }
                break;
            case DOWN_FIRE:
                if(type == FIRE_SHORT){
                    ImageIcon img_down = new ImageIcon("source/image/bombbang_down_1.png");
                    return  image = img_down.getImage();
                }
                else if (type == FIRE_LONG)
                {
                    ImageIcon img_down = new ImageIcon("source/image/bombbang_down_2.png");
                    return  image = img_down.getImage();
                }
                break;
            default:
                return null;
        }
        return null;
    }

    public void checkFireVsMap(MapObject[][] map)  //check va chạm tia lửa với tường
    {
        // l là độ dài của tia lửa có thể phá hủy được (tránh trường hợp chạm nhẹ đã chết)
        int l = 40;
        if(type == FIRE_LONG)
        {
            l = 60;
        }
        // 4 tia lửa
        Rectangle rec1 = new Rectangle(x +40, y, l, 40); //phải
        Rectangle rec2 = new Rectangle(x - l, y, l, 40); //trái
        Rectangle rec3 = new Rectangle(x, y + 40, 40, l); //dưới
        Rectangle rec4 = new Rectangle(x, y - l, 40, l); //trên

        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                MapObject obj = map[i][j];
                Rectangle rec5 = new Rectangle(obj.x + 10, obj.y + 10, MAP_W -10, MAP_H -10); //tường hoặc brick

                if(rec1.intersects(rec5) || rec2.intersects(rec5) || rec3.intersects(rec5) || rec4.intersects(rec5) )
                {
                    if(obj.type == MapObject.BRICK)
                    {
                        Random random_item = new Random();  //random xuất hiện item khi cho bom nổ
                        int random = random_item.nextInt(15);
                        switch (random) {
                            // nếu random = 1 và = 10 thì in ra item
                            case 12:
                            case 2:
                            case 4:
                            case 10:
                                map[i][j].type = MapObject.ITEM_1;
                                map[i][j].setImage("item.png");
                                break;
                            // nếu random = 3 và = 15 thì in ra item
                            case 6:
                            case 14:
                            case 3:
                                map[i][j].type = MapObject.ITEM_2;
                                map[i][j].setImage("item2.png");
                                break;

                            default:
                                map[i][j].type = MapObject.GRASS;
                                map[i][j].setImage("background_Play.png");
                                break;
                        }
                    }
                }

            }
        }
    }


    public boolean checkBomberVsFire(Bomber bomber)
    {
        int l = 80;
        if(type == FIRE_LONG)
        {
            l = 120;
        }
        Rectangle rec0 = new Rectangle(x , y , 40 , 40); //giữa
        Rectangle rec1 = new Rectangle(x + 40, y, l, 40);
        Rectangle rec2 = new Rectangle(x - l, y, l, 40);
        Rectangle rec3 = new Rectangle(x, y + 40, 40, l);
        Rectangle rec4 = new Rectangle(x, y - l, 40, l);
        Rectangle rec5 = new Rectangle(bomber.x + 10 , bomber.y + 10, ActorObject.ACTOR_W - 20, ActorObject.ACTOR_H - 20);
        if(rec1.intersects(rec5) || rec2.intersects(rec5) || rec3.intersects(rec5) || rec4.intersects(rec5) || rec0.intersects(rec5))
        {
            return true;
        }

        return false;
    }
}
