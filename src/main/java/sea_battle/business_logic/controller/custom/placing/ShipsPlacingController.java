package sea_battle.business_logic.controller.custom.placing;

import javafx.scene.Parent;
import sea_battle.business_logic.PVP_PVC.Factory;
import sea_battle.business_logic.controller.custom.NavigationController;

public abstract class ShipsPlacingController extends NavigationController
{
    private Factory factory;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);
    }

    public Factory getFactory()
    {
        return factory;
    }

    public void setFactory(Factory factory)
    {
        this.factory = factory;
    }
}
