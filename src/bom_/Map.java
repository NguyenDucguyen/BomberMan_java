package bom_;
import bom_.actor.*;
import bom_.mapObject.*;
import jaco.mp3.player.MP3Player;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends JPanel implements Runnable {
    public String levelTxt;
    public int level;
    public int score;

    public MapObject[][] map;
    public ArrayList<Enemy> enemys;

    public void Map_matrix(String levelTxt) //đọc file lưu vào 1 ma trận chứa các object (wall,brick,bomber,...)
    {
        try{
            File pr = new File(levelTxt);
            Scanner sc = new Scanner(pr);
            int j = 0;
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] temp = line.split(" ");
                for (int i = 0; i < temp.length; i++)
                {
                    int type = Integer.parseInt(temp[i]);
                    switch (type) {
                        case 6:
                        {
                            String image = "source/image/brick_blue.png";
                            map[j][i] = new MapObject(i*MapObject.MAP_W, j*MapObject.MAP_H, image, MapObject.BRICK);
                            break;
                        }
                        case 5:
                        {
                            String image = "source/image/brick_red.png";
                            map[j][i] = new MapObject(i*MapObject.MAP_W, j*MapObject.MAP_H, image, MapObject.BRICK);
                            break;
                        }
                        case 8:
                        {
                            String image = "source/image/wall1.png";
                            map[j][i] = new MapObject(i*MapObject.MAP_W, j*MapObject.MAP_H, image, MapObject.WALL);
                            break;
                        }
                        case 2:
                        {
                            String image = "source/image/background_Play.png";
                            Enemy.Enemy_count = Enemy.Enemy_count + 1 ;
                            map[j][i] = new MapObject(i*MapObject.MAP_W, j*MapObject.MAP_H, image, MapObject.GRASS);
                            enemys.add(new Enemy(i*MapObject.MAP_W, j*MapObject.MAP_H, "monster_down.png", ActorObject.DOWN, Enemy.ENEMY_1));
                            break;
                        }
                        case 3:
                        {
                            String image = "source/image/background_Play.png";
                            Enemy.Enemy_count = Enemy.Enemy_count + 1 ;
                            map[j][i] = new MapObject(i*MapObject.MAP_W, j*MapObject.MAP_H, image, MapObject.GRASS);
                            enemys.add(new Enemy(i*MapObject.MAP_W, j*MapObject.MAP_H, "boss_down.png", ActorObject.DOWN, Enemy.ENEMY_2));
                            break;
                        }
                        default:
                        {
                            String image = "source/image/background_Play.png";
                            map[j][i] = new MapObject(i*MapObject.MAP_W, j*MapObject.MAP_H, image, MapObject.GRASS);
                            break;
                        }
                    }
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public Map(String levelTxt, int level, int score) {
        this.levelTxt = levelTxt;
        this.level = level;
        this.score = score;
        this.map = new MapObject[16][16];
        this.enemys = new ArrayList<>();
        Map_matrix(levelTxt);

        setFocusable(true);
        requestFocusInWindow(true);
    }

    protected void paintComponent(Graphics g) {
        //vẽ map
        for (int i = 0; i < 16; i++) {
            for (int ji = 0; ji < 16; ji++) {
                MapObject object = map[i][ji];
                g.drawImage(object.image, object.x, object.y, this);
            }
        }
    }

    public void run() {
        repaint();
    }
}
