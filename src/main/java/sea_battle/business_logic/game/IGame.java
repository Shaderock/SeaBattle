package sea_battle.business_logic.game;

import java.awt.*;

public interface IGame
{
    void shoot(IPlayer target, Point point);

    PlayerNumber randomFirstTurn();
}
