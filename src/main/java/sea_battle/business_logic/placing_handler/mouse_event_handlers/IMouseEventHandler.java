package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;

public interface IMouseEventHandler
{
    void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent);
}
