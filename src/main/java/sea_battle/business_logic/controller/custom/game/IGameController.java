package sea_battle.business_logic.controller.custom.game;

public interface IGameController
{
    void placeBattleAreas(boolean[][] battleArea1, boolean[][] battleArea2);

    void placeShips(boolean[][] battleArea1, boolean[][] battleArea2);

    void startGame();

    void endGame();
}

