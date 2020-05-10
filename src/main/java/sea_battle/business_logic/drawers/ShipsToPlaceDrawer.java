package sea_battle.business_logic.drawers;

import javafx.scene.Group;
import javafx.scene.Node;
import sea_battle.models.Constants;

public class ShipsToPlaceDrawer implements IDrawer
{
    private ShipDrawer shipDrawer;

    @Override
    public Node draw()
    {
        if (shipDrawer == null)
        {
            throw new RuntimeException("ShipDrawer should be given");
        }

        Group group = new Group();

        for (int i = 4; i > 0; i--)
        {
            shipDrawer.setSize(i);
            for (int j = 0; j < 5 - i; j++)
            {
                Node ship = shipDrawer.draw();
                ship.relocate(Constants.TILE_SIZE * j * (i + 1),
                        Constants.TILE_SIZE * (3 - i + 1) * 2);
                group.getChildren().add(ship);
            }
        }
        return group;
    }

    public void setShipDrawer(ShipDrawer shipDrawer)
    {
        this.shipDrawer = shipDrawer;
    }
}
