package sea_battle.business_logic.placing_handler;

public interface OnAllShipsPlacedListener   // Observer
{
    void onAllShipsPlaced(boolean[][] battleArea);

    void onShipDisplacement();
}
