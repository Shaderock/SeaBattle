package sea_battle.business_logic.drawers;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import sea_battle.business_logic.drawers.tiles.TileDrawer;
import sea_battle.models.Constants;
import sea_battle.models.Tile;

public class BattleAreaDrawer implements IDrawer
{
    private DrawerType tileType = DrawerType.PLACE_TILE;

    @Override
    public Node draw()
    {
        Group group = new Group();

        int amountOfTiles = Constants.TILES_AMOUNT;

        for (int x = 0; x < amountOfTiles; x++)
        {
            for (int y = 0; y < amountOfTiles; y++)
            {
                TileDrawer tileDrawer = (TileDrawer) DrawerFactory.build(tileType);

                tileDrawer.setFillColor(Color.WHITESMOKE);
                tileDrawer.setStrokeColor(Color.DARKGRAY);

                Tile tile = (Tile) tileDrawer.draw();
                tile.setColumn(x);
                tile.setRow(y);

                tile.relocate((double) x * Constants.TILE_SIZE,
                        y * (double) Constants.TILE_SIZE);

                group.getChildren().add(tile);
            }
        }

        return group;
    }

    public void setTileType(DrawerType tileType)
    {
        this.tileType = tileType;
    }
}
