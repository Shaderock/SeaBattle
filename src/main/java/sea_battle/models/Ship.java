package sea_battle.models;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;
import sea_battle.models.abstractions.Element;
import sea_battle.models.abstractions.Highlightable;

import java.awt.*;
import java.util.ArrayList;

public class Ship
        extends Group
        implements Highlightable, Accessible, Element
{
    private Paint strokeInitColor;
    private double initStrokeWidth;
    private boolean isPlaced = false;
    private final ArrayList<Point> tiles = new ArrayList<>();
    private boolean isHighlighted;
    private double initX;
    private double initY;

    @Override
    public void onHighlight()
    {
        isHighlighted = true;
        modifyStroke(Constants.TILE_SIZE * 0.07, Color.GREEN);
    }

    @Override
    public void onUnHighlight()
    {
        isHighlighted = false;
        modifyStroke(initStrokeWidth, strokeInitColor);
    }

    private void modifyStroke(double newWidth, Paint newColor)
    {
        for (Node shipPart : getChildren())
        {
            Rectangle part = (Rectangle) shipPart;
            part.setStrokeWidth(newWidth);
            part.setStroke(newColor);
        }
    }

    public double getMinX()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinX();
    }

    public double getMaxX()
    {
        return this.localToScene(this.getBoundsInLocal()).getMaxX();
    }

    public double getMinY()
    {
        return this.localToScene(this.getBoundsInLocal()).getMinY();
    }

    public double getMaxY()
    {
        return this.localToScene(this.getBoundsInLocal()).getMaxY();
    }

    public boolean isPlaced()
    {
        return isPlaced;
    }

    public void setPlaced(boolean placed)
    {
        isPlaced = placed;
    }

    public void relocateOnInitPos()
    {
        relocate(initX, initY);
    }

    @Override
    public boolean isHighlighted()
    {
        return isHighlighted;
    }

    public void setStrokeInitColor(Paint strokeInitColor)
    {
        this.strokeInitColor = strokeInitColor;
    }

    public void setInitStrokeWidth(double initStrokeWidth)
    {
        this.initStrokeWidth = initStrokeWidth;
    }

    public void setInitX(double initX)
    {
        this.initX = initX;
    }

    public void setInitY(double initY)
    {
        this.initY = initY;
    }

    public int getSize()
    {
        return getChildren().size();
    }

    public ArrayList<Point> getTiles()
    {
        return tiles;
    }

    public void addTile(Point point)
    {
        tiles.add(point);
    }
}
