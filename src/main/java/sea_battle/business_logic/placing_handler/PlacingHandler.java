package sea_battle.business_logic.placing_handler;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.placing_handler.mouse_event_handlers.EventHandlerFactory;
import sea_battle.business_logic.placing_handler.mouse_event_handlers.EventHandlerType;
import sea_battle.business_logic.placing_handler.mouse_event_handlers.IMouseEventHandler;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.util.ArrayList;

public class PlacingHandler     // Facade
        implements IPlacingHandler
{
    private final Pane root;
    private OnAllShipsPlacedListener listener;

    private ArrayList<Ship> ships;
    private ArrayList<Tile> tiles;

    private Ship focusedShip = null;
    private final ArrayList<Tile> focusedTiles;
    private double initPressedX;
    private double initPressedY;

    private final IMouseEventHandler mousePressedHandler;
    private final IMouseEventHandler mouseDraggedHandler;
    private final IMouseEventHandler mouseReleasedHandler;

    public PlacingHandler(Parent root)
    {
        this.root = (Pane) root;

        focusedTiles = new ArrayList<>();

        mousePressedHandler = EventHandlerFactory.build(EventHandlerType.PRESSED);
        mouseDraggedHandler = EventHandlerFactory.build(EventHandlerType.DRAGGED);
        mouseReleasedHandler = EventHandlerFactory.build(EventHandlerType.RELEASED);
    }

    public void handlePlacing()
    {
        convertRootToElements();

        root.setOnMousePressed(event ->
        {
            System.out.println("onMousePressed X:" + event.getX() + " Y:" + event.getY());
            mousePressedHandler.handleMouseEvent(this, event);
        });

        root.setOnMouseDragged(event ->
        {
            System.out.println("onDragDetected X:" + event.getX() + " Y:" + event.getY());
            mouseDraggedHandler.handleMouseEvent(this, event);
        });

        root.setOnMouseReleased(event ->
                System.out.println("onMouseReleased X:" + event.getX() + " Y:" + event.getY()));
    }

    private void convertRootToElements()
    {
        Converter converter = new Converter();
        tiles = converter.getTiles(root);
        ships = converter.getShips(root);
    }

    public void addFocusedTile(Tile tile)
    {
        focusedTiles.add(tile);
    }

    public void setOnAllShipsPlacedListener(OnAllShipsPlacedListener listener)
    {
        this.listener = listener;
    }

    public ArrayList<Ship> getShips()
    {
        return ships;
    }

    public ArrayList<Tile> getTiles()
    {
        return tiles;
    }

    public Ship getFocusedShip()
    {
        return focusedShip;
    }

    public void setFocusedShip(Ship focusedShip)
    {
        this.focusedShip = focusedShip;
    }

    public ArrayList<Tile> getFocusedTiles()
    {
        return focusedTiles;
    }

    public double getInitPressedX()
    {
        return initPressedX;
    }

    public void setInitPressedX(double initPressedX)
    {
        this.initPressedX = initPressedX;
    }

    public double getInitPressedY()
    {
        return initPressedY;
    }

    public void setInitPressedY(double initPressedY)
    {
        this.initPressedY = initPressedY;
    }
}
