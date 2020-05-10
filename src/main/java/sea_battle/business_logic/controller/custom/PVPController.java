package sea_battle.business_logic.controller.custom;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.ShipDrawer;
import sea_battle.business_logic.placing_handler.IPlacingHandler;
import sea_battle.business_logic.placing_handler.OnAllShipsPlacedListener;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.models.Constants;
import sea_battle.models.Ship;

public class PVPController
        extends ShipsPlacingController
        implements OnAllShipsPlacedListener
{
    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        StackPane stackPaneRoot = (StackPane) root;
        drawShips(stackPaneRoot);
        IPlacingHandler placingHandler = new PlacingHandler(root);
        placingHandler.setOnAllShipsPlacedListener(this);
        placingHandler.handlePlacing();
    }

    private void drawShips(StackPane root)
    {
        ShipDrawer shipDrawer = (ShipDrawer) DrawerFactory.build(DrawerType.SHIP);

        for (int i = 4; i > 0; i--)
        {
            shipDrawer.setSize(i);
            for (int j = 0; j < 5 - i; j++)
            {
                Ship ship = (Ship) shipDrawer.draw();
//                ship.setLayoutX(Constants.TILE_SIZE * j * (i + 1));
                ship.setTranslateX(Constants.TILE_SIZE * j * (i + 1));
                ship.setTranslateY(Constants.TILE_SIZE * (3 - i + 1) * 2);
//                ship.setLayoutY(Constants.TILE_SIZE * (3 - i + 1) * 2);
                ship.setManaged(false);
//                ship.relocate(Constants.TILE_SIZE * j * (i + 1),
//                        Constants.TILE_SIZE * (3 - i + 1) * 2);
                root.getChildren().add(ship);
            }
        }
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
