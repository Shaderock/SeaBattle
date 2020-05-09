package sea_battle.business_logic.drawers;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sea_battle.models.Constants;

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

        Rectangle tile = new Rectangle(Constants.TILE_SIZE, Constants.TILE_SIZE);

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
