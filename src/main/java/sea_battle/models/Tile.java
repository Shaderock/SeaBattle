package sea_battle.models;


import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;
import sea_battle.models.abstractions.Element;
import sea_battle.models.abstractions.HighLightable;

public class Tile
        extends Rectangle
        implements HighLightable, Accessible, Element
{
    private Paint initColor;
    private boolean isHighLighted;

    public Tile(double width, double height)
    {
        super(width, height);
    }

    @Override
    public void onHighLight()
    {
        isHighLighted = true;
        initColor = this.getFill();
        this.setFill(Color.LIGHTGREEN);
    }

    @Override
    public void onUnHighLight()
    {
        isHighLighted = false;
        this.setFill(initColor);
    }

    @Override
    public boolean isHighLighted()
    {
        return isHighLighted;
    }

    @Override
    public double getMinX()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinX();
    }

    @Override
    public double getMaxX()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinX() + Constants.TILE_SIZE;
    }

    @Override
    public double getMinY()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinY();
    }

    @Override
    public double getMaxY()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinX() + Constants.TILE_SIZE;
    }
}
