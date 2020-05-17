package sea_battle.business_logic.game;

public interface IPlayer
{
    boolean[][] getShipsArea();

    void setShipsArea(boolean[][] shipsArea);

    void setPlayerNumber(PlayerNumber playerNumber);

    PlayerNumber getPlayerNumber();

    boolean[][] getBattleArea();

    void setBattleArea(boolean[][] battleArea);
}
