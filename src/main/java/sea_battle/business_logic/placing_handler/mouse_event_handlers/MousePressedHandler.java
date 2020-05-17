package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.AccessibleHandler;
import sea_battle.models.Ship;

public class MousePressedHandler extends MouseEventHandler
{
    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        super.handleMouseEvent(placingHandler, mouseEvent);

        Ship pressedShip = findPressedShip();

        if (pressedShip != null)
        {
            handleShipPressed(placingHandler, mouseEvent, pressedShip);
        }
        else
        {
            AccessibleHandler.unHighlightAllElements(placingHandler);
        }
    }

    private void handleShipPressed(PlacingHandler placingHandler, MouseEvent mouseEvent, Ship pressedShip)
    {
        if (placingHandler.getHighlightedShip() != null)
        {
            handleHighlightedShipExists(placingHandler, pressedShip);
        }

        AccessibleHandler.removeShipPlacing(placingHandler.getBattleArea(), pressedShip);

//        pressedShip.onHighlight();
        if (pressedShip.isShowingRotateWarning())
        {
            pressedShip.removeRotateWarning();
        }
        AccessibleHandler.highlightTiles(placingHandler, pressedShip);
        pressedShip.onHighlight();
        placingHandler.setHighlightedShip(pressedShip);
        placingHandler.setDiffX(mouseEvent.getSceneX() - pressedShip.getMinX());
        placingHandler.setDiffY(mouseEvent.getSceneY() - pressedShip.getMinY());
    }

    private void handleHighlightedShipExists(PlacingHandler placingHandler, Ship pressedShip)
    {
        Ship highlightedShip = placingHandler.getHighlightedShip();

        if (highlightedShip == pressedShip)
        {
            AccessibleHandler.removeShipPlacing(placingHandler.getBattleArea(), highlightedShip);
        }
        else
        {
            if (highlightedShip.isHighlighted())
            {
                highlightedShip.onUnHighlight();
            }
        }
    }

    private Ship findPressedShip()
    {
        for (Ship ship : placingHandler.getShips())
        {
            if (AccessibleHandler.eventInsideElementArea(ship, mouseEvent))
            {
                return ship;
            }
        }
        return null;
    }
}
