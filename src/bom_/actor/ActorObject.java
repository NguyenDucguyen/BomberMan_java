
package bom_.actor;

import java.awt.Image;
import java.awt.Rectangle;

import bom_.mapObject.Bomb;
import bom_.mapObject.MapObject;

//lớp cha của các phần di chuyển: Bomber, Enemy..
public class ActorObject extends MapObject{
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;
    
    public static final int ACTOR_W = 40;
    public static final int ACTOR_H = 40;
    
    public static final int EAT_FIRE_LONG = 10;
    public static final int EAT_SPEED = 11;
    
    public static int HEART = 3;
    
  //  private int width,height;
    protected Image img;
    public int direction = DOWN;
        
    public ActorObject(int x, int y, String image, int direction , int type) {
        super(x, y, image, ACTOR);
        this.direction = direction;
        this.type = type;
    }

    public void changeDirection(int direction) //hàm thay đổi hướng đi
    {
        this.direction = direction;
    }
   


    public int checkMapVsActor(MapObject[][] map) //check va chạm vật với tường (map)
    {   
        int ACT_W = (ACTOR_W / 2);
        int ACT_H = (ACTOR_H / 2);
        for (int i = 0; i < 16; i++) 
        {
            for (int j = 0; j < 16; j++) 
            {
                MapObject obj = map[i][j];
                if(obj.type == MapObject.WALL || obj.type == MapObject.BRICK)
                {
                    switch(direction)
                    {
                        case DOWN:
                        {
                            if(obj.y >= y)
                            {
                                Rectangle rec1 = new Rectangle(x , y , ACT_W - 18 , ACTOR_H);
                                Rectangle rec2 = new Rectangle(x + ACT_W + 18 , y , ACT_W - 18 , ACTOR_H);
                                Rectangle rec_obj = new Rectangle(obj.x,obj.y ,MAP_W,MAP_H);
                                if(rec1.intersects(rec_obj))
                                {
                                    if((obj.x + MAP_W) <= (x + ACT_W - 18))
                                    {
                                    return 1; //1
                                    }
                                    else return -11;
                                }
                                if(rec2.intersects(rec_obj))
                                {
                                    if((obj.x) >= (x + ACT_W + 18))
                                    {
                                    return -1; //-1
                                    }
                                    else return -11;
                                }
                                else if(rec1.intersects(rec_obj) && rec2.intersects(rec_obj))
                                {
                                    return -11;
                                }
                            }
                            break;
                        }
                        case UP:
                        {
                            if(obj.y <= y)
                            {
                                Rectangle rec1 = new Rectangle(x , y , ACT_W - 18 , ACTOR_H);
                                Rectangle rec2 = new Rectangle(x + ACT_W + 18 , y , ACT_W - 18 , ACTOR_H);
                                Rectangle rec_obj = new Rectangle(obj.x,obj.y,MAP_W,MAP_H);
                                 if(rec1.intersects(rec_obj))
                                {
                                    if((obj.x + MAP_W) <= (x + ACT_W - 18))
                                    {
                                    return 2; //2
                                    }
                                    else return -22;
                                }
                                if(rec2.intersects(rec_obj))
                                {
                                    if((obj.x) >= (x + ACT_W + 18))
                                    {
                                    return -2; //-2
                                    }
                                    else return -22;
                                }
                                else if(rec1.intersects(rec_obj) && rec2.intersects(rec_obj))
                                {
                                    return -22;
                                }
                            }

                            break;
                        }
                        case LEFT:
                        {
                            if(obj.x <= x)
                            {
                                Rectangle rec1 = new Rectangle(x , y , ACTOR_W , ACT_H - 18);
                                Rectangle rec2 = new Rectangle(x , y + ACT_H + 18 , ACTOR_W , ACT_H - 18);
                                Rectangle rec_obj = new Rectangle(obj.x,obj.y,MAP_W,MAP_H);
                                if(rec1.intersects(rec_obj))
                                {
                                    if((obj.y + MAP_H) <= (y + ACT_H - 18))
                                    {
                                    return 3; //3
                                    }
                                    else return -33;
                                }
                                if(rec2.intersects(rec_obj))
                                {
                                    if((obj.y) >= (y + ACT_H + 18))
                                    {
                                    return -3; //-3
                                    }
                                    else return -33;
                                }
                                else if(rec1.intersects(rec_obj) && rec2.intersects(rec_obj))
                                {
                                    return -33;
                                }
                            }

                            break;
                        }
                        case RIGHT:
                        {
                            if(obj.x >= x)
                            {
                                Rectangle rec1 = new Rectangle(x , y , ACTOR_W , ACT_H - 18);
                                Rectangle rec2 = new Rectangle(x , y + ACT_H + 18 , ACTOR_W , ACT_H - 18);
                                Rectangle rec_obj = new Rectangle(obj.x,obj.y,MAP_W,MAP_H);
                                if(rec1.intersects(rec_obj))
                                {
                                    if((obj.y + MAP_H) <= (y + ACT_H - 18))
                                    {
                                    return 4; //4
                                    }
                                    else return -44;
                                }
                                if(rec2.intersects(rec_obj))
                                {
                                    if((obj.y) >= (y + ACT_H + 18))
                                    {
                                    return -4; //-4
                                    }
                                    else return -44;
                                }
                                else if(rec1.intersects(rec_obj) && rec2.intersects(rec_obj))
                                {
                                    return -44;
                                }
                            }

                            break;
                        }
                    }
                }
                else if(obj.type == ITEM_1)  //bomber va chạm với item1 (tăng tia lửa)
                {
                    Rectangle rec1 = new Rectangle(x , y , ACTOR_W , ACTOR_H); //bomber
                    Rectangle rec_obj = new Rectangle(obj.x,obj.y ,MAP_W,MAP_H); //item1
                    if(rec1.intersects(rec_obj))
                    {
                        map[i][j].type = MapObject.GRASS; //gán lại bằng cỏ
                        map[i][j].setImage("background_Play.png"); //làm mất item
                        return EAT_FIRE_LONG;
                    } 
                }
                else if(obj.type == ITEM_2) //bomber va chạm với item2 (tăng tốc độ)
                {
                    Rectangle rec1 = new Rectangle(x , y , ACTOR_W , ACTOR_H);
                    Rectangle rec_obj = new Rectangle(obj.x,obj.y ,MAP_W,MAP_H);
                    if(rec1.intersects(rec_obj))
                    {
                        map[i][j].type = MapObject.GRASS;
                        map[i][j].setImage("background_Play.png");
                        return EAT_SPEED;
                    } 
                }
            }
        }
        
        return 0;
    }
    
    
    public boolean checkActorVsBom(Bomb bom)
    {  
        Rectangle rec1 = new Rectangle(x, y, ACTOR_W, ACTOR_H);
        Rectangle rec2 = new Rectangle(bom.x, bom.y, MAP_W, MAP_H);
           
        if(rec1.intersects(rec2))
        {
              return true;
        }
        
        return false;
    }
    
//    public int getX() {
//            return x;
//    }
//
//    public int getY() {
//            return y;
//    }
//
//    public int getWidth() {
//            return width;
//    }
//
//    public int getHeight() {
//            return height;
//    }
    
}