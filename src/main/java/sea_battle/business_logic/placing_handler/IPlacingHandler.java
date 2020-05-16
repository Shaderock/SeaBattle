package sea_battle.business_logic.placing_handler;

public interface IPlacingHandler
{
    void handlePlacing();

    void setBattleArea(boolean[][] battleArea);

    void setOnAllShipsPlacedListener(OnAllShipsPlacedListener listener);
}
