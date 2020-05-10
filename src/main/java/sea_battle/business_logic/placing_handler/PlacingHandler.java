package sea_battle.business_logic.placing_handler;

import javafx.scene.Parent;
import sea_battle.business_logic.placing_handler.mouse_event_handlers.MousePressedHandler;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.util.ArrayList;

public class PlacingHandler     // Facade
        implements IPlacingHandler
{
    private final Parent root;
    private ArrayList<Ship> ships;
    private ArrayList<Tile> tiles;
    private OnAllShipsPlacedListener listener;
    private final MousePressedHandler mousePressedHandler;

    public PlacingHandler(Parent root)
    {
        this.root = root;
        mousePressedHandler = new MousePressedHandler();
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
                System.out.println("onDragDetected X:" + event.getX() + " Y:" + event.getY()));

        root.setOnMouseReleased(event ->
                System.out.println("onMouseReleased X:" + event.getX() + " Y:" + event.getY()));
    }

    private void convertRootToElements()
    {
        Converter converter = new Converter();
        tiles = converter.getTiles(root);
        ships = converter.getShips(root);
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
}
