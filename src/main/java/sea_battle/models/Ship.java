package sea_battle.models;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;
import sea_battle.models.abstractions.Element;
import sea_battle.models.abstractions.Highlightable;
import sea_battle.models.abstractions.Rotational;

import java.awt.*;
import java.util.ArrayList;

public class Ship   // Prototype
        extends Group
        implements Highlightable, Accessible, Element, Rotational
{
    private Paint strokeInitColor;
    private double initStrokeWidth;
    private boolean isPlaced = false;
    private final ArrayList<Point> tiles = new ArrayList<>();
    private boolean isHighlighted;
    private boolean isHorizontal = true;
    private boolean isShowingRotateWarning = false;
    private double initX;
    private double initY;

    @Override
    public void onHighlight()
    {
        if (!isHighlighted)
        {
            isHighlighted = true;
            highlight();
        }
    }

    @Override
    public void onUnHighlight()
    {
        if (isHighlighted)
        {
            isHighlighted = false;
            setInitColor();
        }
    }

    @Override
    public void setRotateWarning()
    {
        if (!isShowingRotateWarning)
        {
            isShowingRotateWarning = true;
            showRotateWarning();
        }
    }

    private void showRotateWarning()
    {
        modifyStroke(Constants.TILE_SIZE * 0.07, Color.RED);
    }

    @Override
    public void removeRotateWarning()
    {
        if (isShowingRotateWarning)
        {
            if (isHighlighted)
            {
                highlight();
            }
            else
            {
                setInitColor();
            }
        }

        isShowingRotateWarning = false;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Object clone()
    {
        Ship ship = new Ship();

        ship.strokeInitColor = this.strokeInitColor;
        ship.initStrokeWidth = this.initStrokeWidth;
        ship.isPlaced = this.isPlaced;
        ship.isHighlighted = this.isHighlighted;
        ship.isHorizontal = this.isHorizontal;
        ship.isShowingRotateWarning = this.isShowingRotateWarning;
        ship.initX = this.initX;
        ship.initY = this.initY;
        ship.tiles.addAll(this.tiles);

        return ship;
    }

    @Override
    public boolean isHighlighted()
    {
        return isHighlighted;
    }

    private void highlight()
    {
        modifyStroke(Constants.TILE_SIZE * 0.07, Color.GREEN);
    }

    private void setInitColor()
    {
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

    public void switchOrientation()
    {
        int i = 0;
        onUnHighlight();
        if (isHorizontal)
        {
            for (Node child : getChildren())
            {
                child.relocate(0, i * Constants.TILE_SIZE);
                i++;
            }
            isHorizontal = false;
        }
        else
        {
            for (Node child : getChildren())
            {
                child.relocate(i * Constants.TILE_SIZE, 0);
                i++;
            }
            isHorizontal = true;
        }
        onHighlight();
    }

    public void relocateOnInitPos()
    {
        if (!isHorizontal)
        {
            switchOrientation();
        }
        if (isHighlighted)
        {
            onUnHighlight();
        }
        isPlaced = false;
        tiles.clear();
        relocate(initX, initY);
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

    public boolean isHorizontal()
    {
        return isHorizontal;
    }

    public boolean isShowingRotateWarning()
    {
        return isShowingRotateWarning;
    }

    public void setHorizontal(boolean horizontal)
    {
        isHorizontal = horizontal;
    }
}
