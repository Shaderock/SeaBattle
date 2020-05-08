package sea_battle.business_logic.drawers;

public class DrawerFactory
{
    public static IDrawer build(DrawerType drawerType)
    {
        switch (drawerType)
        {
            case HOME_BUTTON:
                return new HomeButtonDrawer();
            default:
                return new BattleAreaDrawer();
        }
    }
}
