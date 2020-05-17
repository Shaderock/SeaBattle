package sea_battle.business_logic.drawers.tiles;

import javafx.scene.Node;
import sea_battle.models.Constants;
import sea_battle.models.GameTile;

public class GameTileDrawer extends TileDrawer
{
    @Override
    protected Node drawTile()
    {
        GameTile gameTile = new GameTile(Constants.TILE_SIZE, Constants.TILE_SIZE);

        gameTile.setInitColor(getFillColor());
        gameTile.setFill(getFillColor());
        gameTile.setStroke(getStrokeColor());

        return gameTile;
    }
}
