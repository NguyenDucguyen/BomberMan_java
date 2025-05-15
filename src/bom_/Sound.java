package bom_;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class Sound extends Thread {
    public static final String Song_bom = "source\\sound\\newbomb_1.mp3";
    public static final String Song_bom_bang = "source\\sound\\bomb_bang_1.mp3";
    public static final String Song_enemy = "source\\sound\\monster_die_1.mp3";
    public static final String Song_item = "source\\sound\\item_1.mp3";
    public static final String Song_play = "source\\sound\\playgame.mp3";
    public static final String Song_lose = "source\\sound\\lose.mp3";
    public static final String Song_win = "source\\sound\\win_1.mp3";

    public static final int MENU = 1;
    public static final int BOM = 2;
    public static final int BOM_BANG = 3;
    public static final int ENEMY = 4;
    public static final int PLAY_GAME = 5;
    public static final int ITEM = 6;
    public static final int LOSE = 7;
    public static final int WIN = 8;
    int name;

    public static void Play_Sound(int name)
    {
        switch(name)
        {

            case BOM:
            {
                MP3Player bom = new MP3Player(new File(Song_bom));
                bom.play();
            }
            break;
            case BOM_BANG:
            {
                MP3Player bom_bang = new MP3Player(new File(Song_bom_bang));
                bom_bang.play();
            }
            break;
            case ENEMY:
            {
                MP3Player enemy = new MP3Player(new File(Song_enemy));
                enemy.play();
            }
            break;

            case ITEM:
            {
                MP3Player item = new MP3Player(new File(Song_item));
                item.play();
            }
            break;
            case LOSE:
            {
                MP3Player lose = new MP3Player(new File(Song_lose));
                lose.play();
            }
            break;
            case WIN:
            {
                MP3Player win = new MP3Player(new File(Song_win));
                win.play();
            }
            break;
            default: break;

        }
    }
}
