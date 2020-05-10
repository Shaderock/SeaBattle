package sea_battle.business_logic.drawers;

import sea_battle.business_logic.drawers.button.ButtonDrawer;
import sea_battle.business_logic.drawers.button.HomeButtonDrawer;

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
            case BUTTON:
                return new ButtonDrawer();
            default:
                return new BattleAreaDrawer();
        }
    }
}
