package sea_battle.business_logic.drawers;

public class DrawerFactory
{
    public static IDrawer build(DrawerType drawerType)
    {
        switch (drawerType)
        {
            case HOME_BUTTON:
                return new HomeButtonDrawer();
            case SHIP:
                return new ShipDrawer();
            case TILE:
                return new TileDrawer();
            case SHIPS_TO_PLACE:
                return new ShipsToPlaceDrawer();
            default:
                return new BattleAreaDrawer();
        }
    }
}
