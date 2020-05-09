package sea_battle.business_logic.drawers;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sea_battle.models.Constants;

public class BattleAreaDrawer implements IDrawer
{
    @Override
    public Node draw()
    {
        Group group = new Group();

        int amountOfTiles = Constants.TILES_AMOUNT;

        for (int x = 0; x < amountOfTiles; x++)
        {
            for (int y = 0; y < amountOfTiles; y++)
            {
                TileDrawer tileDrawer = (TileDrawer) DrawerFactory.build(DrawerType.TILE);

                tileDrawer.setFillColor(Color.WHITESMOKE);
                tileDrawer.setStrokeColor(Color.DARKGRAY);

                Rectangle tile = (Rectangle) tileDrawer.draw();

                tile.relocate((double) x * Constants.TILE_SIZE,
                        y * (double) Constants.TILE_SIZE);

                group.getChildren().add(tile);
            }
        }

        return group;
    }
}
