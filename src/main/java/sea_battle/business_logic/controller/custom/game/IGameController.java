package sea_battle.business_logic.controller.custom.game;

public interface IGameController
{
    void placeShipsOnAreas(boolean[][] battleArea1, boolean[][] battleArea2);

    void startGame();

    void endGame();
}

