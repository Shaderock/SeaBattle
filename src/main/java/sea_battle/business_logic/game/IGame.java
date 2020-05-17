package sea_battle.business_logic.game;

import java.awt.*;
import java.util.ArrayList;

public interface IGame
{
    void shoot(IPlayer target, Point point);

    void setPlayers(ArrayList<IPlayer> players);

    PlayerNumber randomFirstTurn();

    PlayerNumber getTurn();

    PlayerNumber nextTurn();
}
