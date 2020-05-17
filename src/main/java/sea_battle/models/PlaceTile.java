package sea_battle.models;


import javafx.scene.paint.Color;
import sea_battle.models.abstractions.Element;

public class PlaceTile
        extends Tile
        implements Element
{
    private boolean isHighlighted;

    public PlaceTile(double width, double height)
    {
        super(width, height);
    }

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
        setFill(getInitColor());
    }

    @Override
    public boolean isHighlighted()
    {
        return isHighlighted;
    }
}
