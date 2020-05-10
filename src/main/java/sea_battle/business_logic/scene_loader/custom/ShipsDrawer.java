package sea_battle.business_logic.scene_loader.custom;

import javafx.scene.layout.Pane;
import sea_battle.business_logic.drawers.ShipDrawer;
import sea_battle.models.Constants;
import sea_battle.models.Ship;

public class ShipsDrawer
{
    private ShipDrawer shipDrawer;

    public void draw(Pane root, double x, double y)
    {
        if (shipDrawer == null)
        {
            throw new RuntimeException("ShipDrawer should be given");
        }

        for (int i = 4; i > 0; i--)
        {
            shipDrawer.setSize(i);
            for (int j = 0; j < 5 - i; j++)
            {
                Ship ship = (Ship) shipDrawer.draw();
                ship.setManaged(false);
                ship.relocate(Constants.TILE_SIZE * j * (i + 1) + x,
                        Constants.TILE_SIZE * (3 - i + 1) * 2 + y);
                root.getChildren().add(ship);
            }
        }
    }

    public void setShipDrawer(ShipDrawer shipDrawer)
    {
        this.shipDrawer = shipDrawer;
    }
}
