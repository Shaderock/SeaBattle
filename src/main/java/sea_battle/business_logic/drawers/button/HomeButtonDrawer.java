package sea_battle.business_logic.drawers.button;

import javafx.scene.Node;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.IDrawer;

public class HomeButtonDrawer implements IDrawer
{
    @Override
    public Node draw()
    {
        ButtonDrawer buttonDrawer = (ButtonDrawer) DrawerFactory.build(DrawerType.BUTTON);

        buttonDrawer.setText("Back to main menu");

        return buttonDrawer.draw();
    }
}
