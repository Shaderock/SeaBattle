package sea_battle.business_logic.game;

public class Player
        implements IPlayer
{
    private boolean[][] battleArea;
    private PlayerNumber number;

    @Override
    public boolean[][] getBattleArea()
    {
        return battleArea;
    }

    @Override
    public void setBattleArea(boolean[][] battleArea)
    {
        this.battleArea = battleArea;
    }

    @Override
    public void setPlayerNumber(PlayerNumber playerNumber)
    {
        number = playerNumber;
    }

    @Override
    public PlayerNumber getPlayerNumber()
    {
        return number;
    }
}
