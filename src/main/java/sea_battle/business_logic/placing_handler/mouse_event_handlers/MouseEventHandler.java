package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;

public class MouseEventHandler implements IMouseEventHandler
{
    protected PlacingHandler placingHandler;
    protected MouseEvent mouseEvent;

    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        this.placingHandler = placingHandler;
        this.mouseEvent = mouseEvent;
    }
}
