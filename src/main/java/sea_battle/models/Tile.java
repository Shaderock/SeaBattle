package sea_battle.models;


import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;
import sea_battle.models.abstractions.Element;
import sea_battle.models.abstractions.Focusable;

public class Tile
        extends Element
        implements Focusable, Accessible
{
    private final Rectangle tile;
    private Paint initColor;

    public Tile(Rectangle tile)
    {
        this.tile = tile;
    }

    public Rectangle getTile()
    {
        return tile;
    }

    @Override
    public void onFocus()
    {
        super.onFocus();
        initColor = tile.getFill();
        tile.setFill(Color.LIGHTGREEN);
    }

    @Override
    public void onUnFocus()
    {
        super.onUnFocus();
        tile.setFill(initColor);
    }

    @Override
    public double getMinX()
    {
        return tile.getX();
    }

    @Override
    public double getMaxX()
    {
        return tile.getX() + Constants.TILE_SIZE;
    }

    @Override
    public double getMinY()
    {
        return tile.getY();
    }

    @Override
    public double getMaxY()
    {
        return tile.getY() + Constants.TILE_SIZE;
    }
}
