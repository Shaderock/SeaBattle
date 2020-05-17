package sea_battle.business_logic.game;

public class PlayerFactory
{
    public static IPlayer buildPlayer(PlayerNumber playerNumber, boolean[][] ships)
    {
//        Player player = new Player(battleArea, battleArea, playerNumber);
        //        player.setShipsArea(battleArea);
//        player.setPlayerNumber(playerNumber);
        return new Player(ships, playerNumber);
    }
}
