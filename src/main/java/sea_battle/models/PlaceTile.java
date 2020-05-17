package sea_battle.models;


import javafx.scene.paint.Color;
import sea_battle.models.abstractions.Element;

public class PlaceTile
        extends Tile
        implements Element
{
//    private Paint initColor;
    private boolean isHighlighted;

    public PlaceTile(double width, double height)
    {
        super(width, height);
    }
//    private int column;
//    private int row;

//    public PlaceTile(double width, double height)
//    {
//        super(width, height);
//    }

    @Override
    public void onHighlight()
    {
        isHighlighted = true;
        setFill(Color.LIGHTGREEN);
    }

    @Override
    public void onUnHighlight()
    {
        isHighlighted = false;
//        setFill(initColor);
        setFill(getInitColor());
    }

    @Override
    public boolean isHighlighted()
    {
        return isHighlighted;
    }

//    @Override
//    public double getMinX()
//    {
//        return this.localToScene(this.getBoundsInLocal()).getMinX();
//    }
//
//    @Override
//    public double getMaxX()
//    {
//        return this.localToScene(this.getBoundsInLocal()).getMaxX();
//    }
//
//    @Override
//    public double getMinY()
//    {
//        return this.localToScene(this.getBoundsInLocal()).getMinY();
//    }
//
//    @Override
//    public double getMaxY()
//    {
//        return this.localToScene(this.getBoundsInLocal()).getMaxY();
//    }

//    public int getColumn()
//    {
//        return column;
//    }

//    public void setColumn(int column)
//    {
//        this.column = column;
//    }

//    public int getRow()
//    {
//        return row;
//    }

//    public void setRow(int row)
//    {
//        this.row = row;
//    }

//    public void setInitColor(Paint initColor)
//    {
//        this.initColor = initColor;
//    }
//
//    protected Paint getInitColor()
//    {
//        return initColor;
//    }
}
