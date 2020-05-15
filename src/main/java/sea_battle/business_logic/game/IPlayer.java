package sea_battle.business_logic.game;

public interface IPlayer
{
    boolean[][] getBattleArea();

    void setBattleArea(boolean[][] battleArea);

    void setPlayerNumber(PlayerNumber playerNumber);

    PlayerNumber getPlayerNumber();
}
