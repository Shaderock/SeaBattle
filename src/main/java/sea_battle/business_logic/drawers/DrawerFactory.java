package sea_battle.business_logic.drawers;

import sea_battle.business_logic.drawers.ships.ShipDrawer;
import sea_battle.business_logic.drawers.tiles.GameTileDrawer;
import sea_battle.business_logic.drawers.tiles.TileDrawer;

public class DrawerFactory
{
    public static IDrawer build(DrawerType drawerType)
    {
        switch (drawerType)
        {
            case SHIP:
                return new ShipDrawer();
            case PLACE_TILE:
                return new TileDrawer();
            case GAME_TILE:
                return new GameTileDrawer();
            case BUTTON:
                return new ButtonDrawer();
            default:
                return new BattleAreaDrawer();
        }
    }
}
