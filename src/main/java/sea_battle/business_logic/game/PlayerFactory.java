package sea_battle.business_logic.game;

public class PlayerFactory
{
    public static IPlayer buildPlayer(PlayerNumber playerNumber, boolean[][] ships)
    {
        return new Player(ships, playerNumber);
    }
}
