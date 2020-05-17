package sea_battle.models;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;

public class Tile
        extends Rectangle
        implements Accessible
{
    private Paint initColor;
    private int column;
    private int row;

    public Tile(double width, double height)
    {
        super(width, height);
    }

    @Override
    public double getMinX()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinX();
    }

    @Override
    public double getMaxX()
    {
        return this.localToScene(this.getBoundsInLocal()).getMaxX();
    }

    @Override
    public double getMinY()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinY();
    }

    @Override
    public double getMaxY()
    {
        return this.localToScene(this.getBoundsInLocal()).getMaxY();
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setInitColor(Paint initColor)
    {
        this.initColor = initColor;
    }

    protected Paint getInitColor()
    {
        return initColor;
    }
}
