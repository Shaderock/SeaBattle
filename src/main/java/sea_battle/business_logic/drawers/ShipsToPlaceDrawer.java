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
//            shipDrawer.setSize(4);
//            Group ship4_0 = (Group) shipDrawer.draw();
//            ship4_0.relocate(0, 0);
//
//            shipDrawer.setSize(3);
//            Group ship3_0 = (Group) shipDrawer.draw();
//            ship3_0.relocate(0, Constants.TILE_SIZE * 2);
//
//            Group ship3_1 = (Group) shipDrawer.draw();
//            ship3_1.relocate(Constants.TILE_SIZE * 4, Constants.TILE_SIZE * 2);
//
//            shipDrawer.setSize(2);
//            Group ship2_0 = (Group) shipDrawer.draw();
//            ship2_0.relocate(0, Constants.TILE_SIZE * 4);
//
//            Group ship2_1 = (Group) shipDrawer.draw();
//            ship2_1.relocate(Constants.TILE_SIZE * 3, Constants.TILE_SIZE * 4);
//
//            Group ship2_2 = (Group) shipDrawer.draw();
//            ship2_2.relocate(Constants.TILE_SIZE * 6, Constants.TILE_SIZE * 4);
        }
        return group;
    }

    public void setShipDrawer(ShipDrawer shipDrawer)
    {
        this.shipDrawer = shipDrawer;
    }
}
