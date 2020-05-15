package sea_battle.business_logic.game;

public class PlayerFactory
{
    public static IPlayer buildPlayer(PlayerNumber playerNumber, boolean[][] battleArea)
    {
        Player player = new Player();
        player.setBattleArea(battleArea);
        player.setPlayerNumber(playerNumber);
        return player;
    }
}
