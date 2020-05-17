package sea_battle.business_logic.game;

public class Player
        implements IPlayer
{
    private boolean[][] shipsArea;
    private boolean[][] battleArea;
    private PlayerNumber number;

    public Player(boolean[][] shipsArea, PlayerNumber number)
    {
        this.shipsArea = shipsArea;
        this.number = number;
        battleArea = new boolean[10][10];
    }

    @Override
    public boolean[][] getShipsArea()
    {
        return shipsArea;
    }

    @Override
    public void setShipsArea(boolean[][] shipsArea)
    {
        this.shipsArea = shipsArea;
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
}
