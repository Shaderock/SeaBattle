package sea_battle.business_logic.drawers;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import sea_battle.models.Constants;
import sea_battle.models.Tile;

public class TileDrawer implements IDrawer
{
    private Color fillColor;
    private Color strokeColor;

    @Override
    public Node draw()
    {
        if (fillColor == null || strokeColor == null)
        {
            throw new RuntimeException("Fill color and stroke colors should be given");
        }

        Tile tile = new Tile(Constants.TILE_SIZE, Constants.TILE_SIZE);

        tile.setFill(fillColor);
        tile.setStroke(strokeColor);

        return tile;
    }

    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
    }

    public void setStrokeColor(Color strokeColor)
    {
        this.strokeColor = strokeColor;
    }
}
