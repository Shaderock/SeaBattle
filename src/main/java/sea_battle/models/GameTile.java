package sea_battle.models;

import javafx.scene.paint.Color;
import sea_battle.models.abstractions.Target;

public class GameTile
        extends Tile
        implements Target
{
    public GameTile(double width, double height)
    {
        super(width, height);
    }

    boolean isShot = false;

    @Override
    public void onMiss()
    {
//        setStroke(Color.YELLOW);
        setFill(Color.YELLOW);
        isShot = true;
    }

    @Override
    public void onHit()
    {
        setFill(Color.BLACK);
//        setStroke(Color.BLACK);
        isShot = true;
    }

    public boolean isShot()
    {
        return isShot;
    }
}
