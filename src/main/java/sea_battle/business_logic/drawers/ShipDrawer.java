package sea_battle.business_logic.drawers;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import sea_battle.models.Constants;

public class ShipDrawer implements IDrawer
{
    private int size;

    @Override
    public Node draw()
    {
        if (size < 1 || size > 4)
        {
            throw new RuntimeException("Ship size must be [1..4]");
        }

        TileDrawer tileDrawer = (TileDrawer) DrawerFactory.build(DrawerType.TILE);
        tileDrawer.setFillColor(Color.LIGHTGRAY);
        tileDrawer.setStrokeColor(Color.DARKBLUE);

        Group ship = new Group();

        for (int i = 0; i < size; i++)
        {
            Node shipPart = tileDrawer.draw();
            shipPart.relocate(Constants.TILE_SIZE * i, 0);
            ship.getChildren().add(shipPart);
        }

        return ship;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
}
