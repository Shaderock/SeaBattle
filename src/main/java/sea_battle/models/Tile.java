package sea_battle.models;


import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;
import sea_battle.models.abstractions.Element;
import sea_battle.models.abstractions.Highlightable;

public class Tile
        extends Rectangle
        implements Highlightable, Accessible, Element
{
    private Paint initColor;
    private boolean isHighlighted;
    private int column;
    private int row;

    public Tile(double width, double height)
    {
        super(width, height);
    }

    @Override
    public void onHighlight()
    {
        isHighlighted = true;
        this.setFill(Color.LIGHTGREEN);
    }

    @Override
    public void onUnHighlight()
    {
        isHighlighted = false;
        this.setFill(initColor);
    }

    @Override
    public boolean isHighlighted()
    {
        return isHighlighted;
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
}
