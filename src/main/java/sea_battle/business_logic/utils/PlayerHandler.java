package sea_battle.business_logic.utils;

import sea_battle.business_logic.game.IPlayer;
import sea_battle.business_logic.game.PlayerNumber;

import java.util.ArrayList;

public class PlayerHandler
{
    public static IPlayer findPlayer(ArrayList<IPlayer> players, PlayerNumber playerNumber)
    {
        for (IPlayer player : players)
        {
            if (player.getPlayerNumber() == playerNumber)
            {
                return player;
            }
        }

        return null;
    }
}
