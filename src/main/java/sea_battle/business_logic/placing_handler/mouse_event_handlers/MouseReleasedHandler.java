package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.AccessibleHandler;
import sea_battle.models.PlaceTile;
import sea_battle.models.Ship;

import java.awt.*;

public class MouseReleasedHandler extends MouseEventHandler
{
    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        Ship ship = placingHandler.getHighlightedShip();

        if (ship == null)
        {
            AccessibleHandler.unHighlightAllElements(placingHandler);
            return;
        }

        if (placingHandler.getFocusedPlaceTiles().size() > 0)
        {
            handleShipPlacing(placingHandler, ship);
        }
        else
        {
            handleShipThrowingBack(placingHandler, ship);
        }

        placingHandler.checkPlacedShips();
    }

    private void handleShipThrowingBack(PlacingHandler placingHandler, Ship ship)
    {
        ship.onUnHighlight();
        for (Point tile : ship.getTiles())
        {
            placingHandler.getBattleArea()[tile.x][tile.y] = false;
        }
        ship.relocateOnInitPos();
    }

    private void handleShipPlacing(PlacingHandler placingHandler, Ship ship)
    {
        ship.relocate(placingHandler.getFocusedPlaceTiles().get(0).getMinX(),
                placingHandler.getFocusedPlaceTiles().get(0).getMinY());

        for (PlaceTile focusedPlaceTile : placingHandler.getFocusedPlaceTiles())
        {
            placingHandler.getBattleArea()[focusedPlaceTile.getRow()][focusedPlaceTile.getColumn()] = true;
            ship.setPlaced(true);
            ship.addTile(new Point(focusedPlaceTile.getRow(), focusedPlaceTile.getColumn()));
            focusedPlaceTile.onUnHighlight();
        }

        placingHandler.getFocusedPlaceTiles().clear();
    }

}
