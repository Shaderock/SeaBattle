package sea_battle.business_logic.game;

import java.awt.*;

public interface IGame
{
    void shoot(Player whoShoots, Point point);

    void setBattleAreas(boolean[][] battleArea1, boolean[][] battleArea2);
}
