package sea_battle.business_logic.placing_handler;

public interface IPlacingHandler
{
    void handlePlacing();

    void setOnAllShipsPlacedListener(OnAllShipsPlacedListener listener);
}
