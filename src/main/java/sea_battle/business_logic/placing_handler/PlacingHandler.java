package sea_battle.business_logic.placing_handler;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.placing_handler.mouse_event_handlers.EventHandlerFactory;
import sea_battle.business_logic.placing_handler.mouse_event_handlers.EventHandlerType;
import sea_battle.business_logic.placing_handler.mouse_event_handlers.IMouseEventHandler;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;
import sea_battle.models.PlaceTile;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.util.ArrayList;

public class PlacingHandler     // Facade
        implements IPlacingHandler
{
    private final Pane root;
    private OnAllShipsPlacedListener listener;
    private Button rotateButton;

    private ArrayList<Ship> ships;
    private ArrayList<Tile> placeTiles;
    private boolean[][] battleArea;
    private final ArrayList<ArrayList<Tile>> tilesMap;

    private Ship highlightedShip = null;
    private final ArrayList<PlaceTile> focusedPlaceTiles;
    private double diffX;
    private double diffY;

    private final IMouseEventHandler mousePressedHandler;
    private final IMouseEventHandler mouseDraggedHandler;
    private final IMouseEventHandler mouseReleasedHandler;
    private final IMouseEventHandler rotateClickedHandler;

    public PlacingHandler(Parent root)
    {
        this.root = (Pane) root;

        focusedPlaceTiles = new ArrayList<>();
        battleArea = new boolean[10][10];
        tilesMap = new ArrayList<>();

        mousePressedHandler = EventHandlerFactory.build(EventHandlerType.PRESSED);
        mouseDraggedHandler = EventHandlerFactory.build(EventHandlerType.DRAGGED);
        mouseReleasedHandler = EventHandlerFactory.build(EventHandlerType.RELEASED);
        rotateClickedHandler = EventHandlerFactory.build(EventHandlerType.CLICKED);
    }

    public void handlePlacing()
    {
        extractFromRoot();

        root.setOnMousePressed(event ->
                mousePressedHandler.handleMouseEvent(this, event));

        root.setOnMouseDragged(event ->
                mouseDraggedHandler.handleMouseEvent(this, event));

        root.setOnMouseReleased(event ->
                mouseReleasedHandler.handleMouseEvent(this, event));

        rotateButton.setOnMouseClicked(event ->
                rotateClickedHandler.handleMouseEvent(this, event));
    }

    private void extractFromRoot()
    {
        Converter converter = new Converter();
        placeTiles = converter.getTiles(root);
        ships = converter.getShips(root);
        rotateButton = (Button) NodeFinder.findNodeById(root, Constants.ROTATE_BTN_ID);

        converter.tileArrayTo2DArray(placeTiles, tilesMap);
    }

    public void checkPlacedShips()
    {
        if (listener == null)
        {
            return;
        }

        for (Ship ship : ships)
        {
            if (!ship.isPlaced())
            {
                listener.onShipDisplacement();
                return;
            }
        }

        listener.onAllShipsPlaced(battleArea);
    }

    @Override
    public void setBattleArea(boolean[][] battleArea)
    {
        this.battleArea = battleArea;
    }

    public void addFocusedTile(PlaceTile placeTile)
    {
        focusedPlaceTiles.add(placeTile);
    }

    public void setOnAllShipsPlacedListener(OnAllShipsPlacedListener listener)
    {
        this.listener = listener;
    }

    public ArrayList<Ship> getShips()
    {
        return ships;
    }

    public ArrayList<Tile> getPlaceTiles()
    {
        return placeTiles;
    }

    public Ship getHighlightedShip()
    {
        return highlightedShip;
    }

    public void setHighlightedShip(Ship focusedShip)
    {
        this.highlightedShip = focusedShip;
    }

    public ArrayList<PlaceTile> getFocusedPlaceTiles()
    {
        return focusedPlaceTiles;
    }

    public double getDiffX()
    {
        return diffX;
    }

    public void setDiffX(double diffX)
    {
        this.diffX = diffX;
    }

    public double getDiffY()
    {
        return diffY;
    }

    public void setDiffY(double diffY)
    {
        this.diffY = diffY;
    }

    public ArrayList<ArrayList<Tile>> getTilesMap()
    {
        return tilesMap;
    }

    public boolean[][] getBattleArea()
    {
        return battleArea;
    }
}
