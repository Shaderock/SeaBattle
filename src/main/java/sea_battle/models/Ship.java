package sea_battle.models;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;
import sea_battle.models.abstractions.Element;
import sea_battle.models.abstractions.HighLightable;

public class Ship
        extends Group
        implements HighLightable, Accessible, Element
{
    private Paint initColor;
    private double initStrokeWidth;
    private boolean isPlaced = false;
    private boolean isHighLighted;
    private double initX;
    private double initY;

    @Override
    public void onHighLight()
    {
        isHighLighted = true;
        modifyStroke(Constants.TILE_SIZE * 0.07, Color.GREEN);
    }

    @Override
    public void onUnHighLight()
    {
        isHighLighted = false;
        modifyStroke(initStrokeWidth, initColor);
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

    private Rectangle getFirstShipPart()
    {
        return (Rectangle) getChildren().get(0);
    }

    private Rectangle getLastShipPart()
    {
        int size = getChildren().size();
        return (Rectangle) getChildren().get(size - 1);
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
    public boolean isHighLighted()
    {
        return isHighLighted;
    }

    public void setInitColor(Paint initColor)
    {
        this.initColor = initColor;
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
}
