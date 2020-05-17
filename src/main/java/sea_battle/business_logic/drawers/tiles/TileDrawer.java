package sea_battle.business_logic.drawers.tiles;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import sea_battle.business_logic.drawers.IDrawer;
import sea_battle.models.Constants;
import sea_battle.models.PlaceTile;

public class TileDrawer implements IDrawer
{
    private Color fillColor;
    private Color strokeColor;

    @Override
    public Node draw()
    {
        checkGivenColors();
        return drawTile();
    }

    protected Node drawTile()
    {
        PlaceTile placeTile = new PlaceTile(Constants.TILE_SIZE, Constants.TILE_SIZE);

        placeTile.setInitColor(fillColor);
        placeTile.setFill(fillColor);
        placeTile.setStroke(strokeColor);

        return placeTile;
    }

    private void checkGivenColors()
    {
        if (fillColor == null || strokeColor == null)
        {
            throw new RuntimeException("Fill color and stroke colors should be given");
        }
    }

    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
    }

    public void setStrokeColor(Color strokeColor)
    {
        this.strokeColor = strokeColor;
    }

    protected Color getFillColor()
    {
        return fillColor;
    }

    protected Color getStrokeColor()
    {
        return strokeColor;
    }
}
