package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.models.Ship;

public class MouseDraggedHandler extends MouseEventHandler
{
    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        super.handleMouseEvent(placingHandler, mouseEvent);

        Ship focusedShip = placingHandler.getFocusedShip();

        if (focusedShip != null)
        {
            focusedShip.relocate(mouseEvent.getSceneX() - placingHandler.getInitPressedX(),
                    mouseEvent.getSceneY() - placingHandler.getInitPressedY());
        }
    }
}
