package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.ElementHandler;
import sea_battle.models.Ship;

public class MousePressedHandler implements IMouseEventHandler
{
    private PlacingHandler placingHandler;
    private MouseEvent mouseEvent;

    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        this.placingHandler = placingHandler;
        this.mouseEvent = mouseEvent;

        Ship ship = findPressedShip();

        if (ship != null)
        {
            ship.onFocus();
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
