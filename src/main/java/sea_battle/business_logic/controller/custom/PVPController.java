package sea_battle.business_logic.controller.custom;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.placing_handler.IPlacingHandler;
import sea_battle.business_logic.placing_handler.OnAllShipsPlacedListener;
import sea_battle.business_logic.placing_handler.PlacingHandler;

public class PVPController
        extends ShipsPlacingController
        implements OnAllShipsPlacedListener
{
    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        Pane stackPaneRoot = (Pane) root;

        IPlacingHandler placingHandler = new PlacingHandler(root);
        placingHandler.setOnAllShipsPlacedListener(this);
        placingHandler.handlePlacing();
    }

    @Override
    public void onAllShipsPlaced()
    {

    }

    @Override
    public void onShipDisplacement()
    {

    }
}
