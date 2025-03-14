
package bom_.actor;

import static bom_.actor.ActorObject.DOWN;
import static bom_.actor.ActorObject.LEFT;
import static bom_.actor.ActorObject.RIGHT;
import static bom_.actor.ActorObject.UP;
import static bom_.mapObject.MapObject.FIRE_LONG;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import bom_.mapObject.Fire;
import bom_.mapObject.MapObject;


public class Enemy extends ActorObject
{
    public Image enemy_1,enemy_2;
    public static int Enemy_count = 0;
    public Enemy(int x, int y, String image, int direction, int type) {
        super(x, y, image, direction ,type);
        type = ENEMY_1;
    }
    
    @Override
    public void changeDirection(int direction) {  //hàm in hình vẽ enemy khi thay đổi hướng đi
        super.changeDirection(direction);
        
        switch(direction)
        {
            case DOWN:
                {
                    if(type == ENEMY_1){  
                      ImageIcon enemy_1 = new ImageIcon("monster_down.png");
                      this.image = enemy_1.getImage();
                    }
                    else if(type == ENEMY_2)
                    {
                      ImageIcon enemy_2 = new ImageIcon("boss_down.png");
                      this.image = enemy_2.getImage();
                    }
                }
                break;
            case UP:
                {
                    if(type == ENEMY_1){  
                      ImageIcon enemy_1 = new ImageIcon("monster_up.png");
                      this.image = enemy_1.getImage();
                    }
                    else if(type == ENEMY_2)
                    {
                      ImageIcon enemy_2 = new ImageIcon("boss_up.png");
                      this.image = enemy_2.getImage();
                    }
                }
                break;
            case LEFT:
                {
                    if(type == ENEMY_1){  
                      ImageIcon enemy_1 = new ImageIcon("monster_left.png");
                      this.image = enemy_1.getImage();
                    }
                    else if(type == ENEMY_2)
                    {
                      ImageIcon enemy_2 = new ImageIcon("boss_left.png");
                      this.image = enemy_2.getImage();
                    }
                }
                break;
            case RIGHT:
                {
                    if(type == ENEMY_1){  
                      ImageIcon enemy_1 = new ImageIcon("monster_right.png");
                      this.image = enemy_1.getImage();
                    }
                    else if(type == ENEMY_2)
                    {
                      ImageIcon enemy_2 = new ImageIcon("boss_right.png");
                      this.image = enemy_2.getImage();
                    }
                }
                break;
            
        }
    }

//         public void move(MapObject[][] map) //hàm di chuyển enemy
//    {
//        switch(direction)
//        {
//            case DOWN:
//                {
//                     int check = checkMapVsActor(map);
//
//                         if(check == 0) //nếu không va chạm
//                         { y=y+2;}
//                         //trái
//                         if(check < 0 && check != -40)
//                         {x = x + check;
//                         y = y +2;
//                         
//                         }
//                         if(check > 0) 
//                         {  x = x + check;
//                             y = y + 2;}
//                         if(check == -40)
//                         {
//                             changeDirection(ActorObject.RIGHT);
//                             x = x + 2;
//                             System.err.println("x = " + x);
//                             break;
//                         }
//                     break;
//                 }
//                   
//            case UP:
//                {
//                     int check = checkMapVsActor(map);
//                            if(check == 0) y = y - 2;
//                            if(check < 0 && check != -41)
//                            {x = x + check;
//                             y = y - 2;
//                            }
//                            if(check > 0) {
//                                x = x + check;
//                                y = y - 2;
//                            }
//                            if(check == -41)
//                            {
//                                changeDirection(ActorObject.LEFT);
//                                x = x - 2;
//                                break;
//                            }
//                     break;   
//                }
//            case LEFT:
//                {
//                     int check = checkMapVsActor(map);
//                            if(check == 0) x = x - 2;
//                            else if(check < 0 && check != -42) {
//                                y = y + check;
//                                 x = x - 2;
//                            }
//                            else if(check > 0){
//                                y = y + check;
//                                 x = x - 2;
//                            }
//                            else if(check == -42)
//                            {
//                                changeDirection(ActorObject.DOWN);
//                                y = y + 2;
//                                break;
//                            }
//                     
//                 break;
//                }
//                   
//            case RIGHT:
//                {
//                    int check = checkMapVsActor(map);
//                            if(check == 0) x = x + 2;
//                            else if(check < 0 && check != -43){
//                                y = y + check;
//                                 x = x + 2;
//                            }
//                            else if(check > 0){
//                                y = y + check;
//                                 x = x + 2;
//                            }
//                            else if(check == -43)
//                            {
//                                changeDirection(ActorObject.UP);
//                                y = y - 2;
//                                break;
//                            }
//                     
//                     break;
//                }
//                  
//        }
//    }
//    
     public void move(MapObject[][] map) //hàm di chuyển enemy
    {
        switch(direction)
        {
            case DOWN:
                   {
                        int check = checkMapVsActor(map);
                        switch (check) {
                            case 0: //nếu không va chạm
                                y=y+2;
                                break;
                            case 1: //nếu va chạm trái
                                x=x+2;
                                break;
                            case -1: //nếu va chạm phải
                                x=x-2;
                                break;
                            case -11: // nếu va chạm toàn bộ
                                changeDirection(ActorObject.RIGHT);
                                x=x+2;
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                   
            case UP:
                {
                     int check = checkMapVsActor(map);
                     switch (check) {
                         case 0:
                             y=y-2;
                             break;
                         case 2:
                             x=x+2;
                             break;
                         case -2:
                             x=x-2;
                             break;
                         case -22:
                             changeDirection(ActorObject.LEFT);
                             x=x-2;
                             break;
                         default:
                             break;
                     }
                 break;
                }
                   
            case LEFT:
                {
                     int check = checkMapVsActor(map);
                     switch (check) {
                         case 0:
                             x=x-2;
                             break;
                         case 3:
                             y=y+2;
                             break;
                         case -3:
                             y=y-2;
                             break;
                         case -33:
                             changeDirection(ActorObject.DOWN);
                             y=y+2;
                             break;
                         default:
                             break;
                     }
                 break;
                }
                   
            case RIGHT:
                {
                    int check = checkMapVsActor(map);
                    switch (check) {
                        case 0:
                            x=x+2;
                            break;
                        case 4:
                            y=y+2;
                            break;
                        case -4:
                            y=y-2;
                            break;
                        case -44:
                            changeDirection(ActorObject.UP);
                            y=y-2;
                            break;
                        default:
                            break;
                    }
                     break;
                }
                  
        }
    }
     
     public boolean checkEnemyVsFire(int x_enemy, int y_enemy,Fire fire) //va chạm giữa enemy với tia lửa
     {
          int l = 80;
        if(type == FIRE_LONG)
        {
            l = 120;
        }  
        Rectangle rec1 = new Rectangle(fire.x + 40, fire.y, l, 40); //phải
        Rectangle rec2 = new Rectangle(fire.x - l, fire.y, l, 40);  //trái
        Rectangle rec3 = new Rectangle(fire.x, fire.y + 40, 40, l); //dưới
        Rectangle rec4 = new Rectangle(fire.x, fire.y - l, 40, l);  //trên
        Rectangle rec5 = new Rectangle(x_enemy + 10 , y_enemy + 10, ACTOR_W - 20, ACTOR_H - 20); //enemy
        if(rec5.intersects(rec1) || rec5.intersects(rec2) || rec5.intersects(rec3) || rec5.intersects(rec4))
        {
            //đưa thuộc tính của enemy về 0 và null để xóa enemy
            this.setImage(null);
            this.direction = 0;
            this.x = 0;
            this.y = 0;
            return true;
        }
        return false;
     }
     
     public boolean checkEnemyVsBomber(Bomber bomber) //va chạm giữa enemy với bomber
     {
         Rectangle rec_enemy = new Rectangle(x + 10, y + 10, ACTOR_W - 20, ACTOR_H - 20);
         Rectangle rec_bomber = new Rectangle(bomber.x +10, bomber.y +10, ACTOR_W - 20, ACTOR_H - 20);
         if(rec_enemy.intersects(rec_bomber))
         {
            //đưa thuộc tính của bomber về 0 và null -> gameover
            this.x = this.x + 0;
            this.y = this.y + 0;
            this.direction = 0;
            bomber.x = bomber.x + 0;
            bomber.y = bomber.y + 0;
            bomber.direction = 0;
            return true;
         }
         
         return false;
     }
}
