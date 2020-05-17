package sea_battle.business_logic.drawers.ships;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.IDrawer;
import sea_battle.business_logic.drawers.tiles.TileDrawer;
import sea_battle.models.Constants;
import sea_battle.models.PlaceTile;
import sea_battle.models.Ship;

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

        TileDrawer tileDrawer = (TileDrawer) DrawerFactory.build(DrawerType.PLACE_TILE);
        tileDrawer.setFillColor(Color.LIGHTGRAY);
        tileDrawer.setStrokeColor(Color.DARKBLUE);

        Ship ship = new Ship();
        ship.setStrokeInitColor(Color.DARKBLUE);
        ship.setInitStrokeWidth(Constants.TILE_SIZE * 0.03);

        for (int i = 0; i < size; i++)
        {
            PlaceTile shipPart = (PlaceTile) tileDrawer.draw();
            shipPart.relocate(Constants.TILE_SIZE * i, 0);
            shipPart.setStrokeWidth(Constants.TILE_SIZE * 0.03);
            ship.getChildren().add(shipPart);
        }

        return ship;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
}
