package sea_battle.business_logic.drawers;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sea_battle.models.Constants;

public class BattleAreaDrawer implements IDrawer
{
    @Override
    public Node draw()
    {
        Group group = new javafx.scene.Group();
        int amountOfTiles = Constants.TILES_AMOUNT;
        for (int x = 0; x < amountOfTiles; x++)
        {
            for (int y = 0; y < amountOfTiles; y++)
            {
                Rectangle tile = new Rectangle((double) x * Constants.SCENE_INIT_HEIGHT / 15,
                        (double) y * Constants.SCENE_INIT_HEIGHT / 15,
                        (double) Constants.SCENE_INIT_HEIGHT / 15,
                        (double) Constants.SCENE_INIT_HEIGHT / 15);
                tile.setFill(Color.WHITESMOKE);
                tile.setStroke(Color.AQUAMARINE);

                group.getChildren().add(tile);
            }
        }
        return group;
    }
}
