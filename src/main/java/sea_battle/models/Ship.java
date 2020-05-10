package sea_battle.models;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import sea_battle.models.abstractions.Accessible;
import sea_battle.models.abstractions.Element;
import sea_battle.models.abstractions.Focusable;

public class Ship
        extends Element
        implements Focusable, Accessible
{
    private final Group shipParts;
    private Paint initColor;
    private double initStrokeWidth;
    private boolean isPlaced = false;

    public Ship(Group shipParts)
    {
        this.shipParts = shipParts;
    }

    @Override
    public void onFocus()
    {
        super.onFocus();
        Rectangle firstPart = getFirstShipPart();
        initColor = firstPart.getStroke();
        initStrokeWidth = firstPart.getStrokeWidth();

        modifyStroke(Constants.TILE_SIZE * 0.07, Color.GREEN);
    }

    @Override
    public void onUnFocus()
    {
        super.onUnFocus();
        modifyStroke(initStrokeWidth, initColor);
    }

    private void modifyStroke(double newWidth, Paint newColor)
    {
        for (Node shipPart : shipParts.getChildren())
        {
            Rectangle part = (Rectangle) shipPart;
            part.setStrokeWidth(newWidth);
            part.setStroke(newColor);
        }
    }

    private Rectangle getFirstShipPart()
    {
        return (Rectangle) shipParts.getChildren().get(0);
    }

    private Rectangle getLastShipPart()
    {
        int size = shipParts.getChildren().size();
        return (Rectangle) shipParts.getChildren().get(size - 1);
    }

    public Group getShipParts()
    {
        return shipParts;
    }

    public double getMinX()
    {
        return shipParts.localToScene(shipParts.getBoundsInLocal()).getMinX();
    }

    public double getMaxX()
    {
        return shipParts.localToScene(shipParts.getBoundsInLocal()).getMaxX();
    }

    public double getMinY()
    {
        return shipParts.localToScene(shipParts.getBoundsInLocal()).getMinY();
    }

    public double getMaxY()
    {
        return shipParts.localToScene(shipParts.getBoundsInLocal()).getMaxY();
    }

    public boolean isPlaced()
    {
        return isPlaced;
    }

    public void setPlaced(boolean placed)
    {
        isPlaced = placed;
    }
}
