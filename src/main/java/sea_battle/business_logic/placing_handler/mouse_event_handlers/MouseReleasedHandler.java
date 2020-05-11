package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.ElementHandler;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.awt.*;

public class MouseReleasedHandler extends MouseEventHandler
{
    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        Ship ship = placingHandler.getHighlightedShip();
        if (ship == null)
        {
            ElementHandler.unHighlightAllElements(placingHandler);
            return;
        }

        if (placingHandler.getFocusedTiles().size() > 0)
        {
            ship.relocate(placingHandler.getFocusedTiles().get(0).getMinX(),
                    placingHandler.getFocusedTiles().get(0).getMinY());

            for (Tile focusedTile : placingHandler.getFocusedTiles())
            {
                placingHandler.getBattleArea()[focusedTile.getRow()][focusedTile.getColumn()] = true;
                ship.setPlaced(true);
                ship.addTile(new Point(focusedTile.getRow(), focusedTile.getColumn()));
                focusedTile.onUnHighlight();
            }

            placingHandler.getFocusedTiles().clear();
            return;
        }

        if (ship.isPlaced() && placingHandler.getFocusedTiles().size() == 0)
        {
            ship.setPlaced(false);
            ship.onUnHighlight();
            for (Point tile : ship.getTiles())
            {
                placingHandler.getBattleArea()[tile.x][tile.y] = false;
            }
            ship.relocateOnInitPos();
        }
    }

}
