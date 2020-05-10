package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.ElementHandler;
import sea_battle.models.Ship;

public class MousePressedHandler extends MouseEventHandler
{
    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        super.handleMouseEvent(placingHandler, mouseEvent);

        Ship ship = findPressedShip();

        if (ship != null)
        {
            ship.onHighLight();
            placingHandler.setFocusedShip(ship);
            placingHandler.setInitPressedX(mouseEvent.getX());
            placingHandler.setInitPressedY(mouseEvent.getY());
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
