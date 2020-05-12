package sea_battle.business_logic.placing_handler.mouse_event_handlers;

public class EventHandlerFactory
{
    public static IMouseEventHandler build(EventHandlerType handlerType)
    {
        switch (handlerType)
        {
            case DRAGGED:
                return new MouseDraggedHandler();
            case RELEASED:
                return new MouseReleasedHandler();
            case CLICKED:
                return new RotateClickedHandler();
            default:
                return new MousePressedHandler();
        }
    }
}
