package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.ElementHandler;
import sea_battle.models.Ship;

import java.awt.*;

public class MousePressedHandler extends MouseEventHandler
{
    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        super.handleMouseEvent(placingHandler, mouseEvent);

        Ship pressedShip = findPressedShip();

        if (pressedShip != null)
        {
            if (placingHandler.getHighlightedShip() != null)
            {
                Ship highlightedShip = placingHandler.getHighlightedShip();

                if (highlightedShip == pressedShip)
                {
                    if (highlightedShip.isPlaced())
                    {
                        highlightedShip.setPlaced(false);

                        for (Point tile : placingHandler.getHighlightedShip().getTiles())
                        {
                            placingHandler.getBattleArea()[tile.x][tile.y] = false;
                        }

                        placingHandler.getHighlightedShip().getTiles().clear();
                    }
                }
                else
                {
                    if (highlightedShip.isHighlighted())
                    {
                        highlightedShip.onUnHighlight();
                    }
                }
            }

            if (pressedShip.isPlaced())
            {
                pressedShip.setPlaced(false);

                for (Point tile : pressedShip.getTiles())
                {
                    placingHandler.getBattleArea()[tile.x][tile.y] = false;
                }

                pressedShip.getTiles().clear();
            }

            pressedShip.onHighlight();
            ElementHandler.highlightTiles(placingHandler, pressedShip);
            placingHandler.setHighlightedShip(pressedShip);
            placingHandler.setDiffX(mouseEvent.getSceneX() - pressedShip.getMinX());
            placingHandler.setDiffY(mouseEvent.getSceneY() - pressedShip.getMinY());
        }
        else
        {
            ElementHandler.unHighlightAllElements(placingHandler);
        }
    }

    private Ship findPressedShip()
    {
        for (Ship ship : placingHandler.getShips())
        {
            if (ElementHandler.eventInsideElementArea(ship, mouseEvent))
            {
                return ship;
            }
        }
        return null;
    }
}
