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
    private final boolean[][] battleArea;
    private final ArrayList<ArrayList<Tile>> tilesMap;

    private Ship highlightedShip = null;
    private final ArrayList<Tile> focusedTiles;
    private double diffX;
    private double diffY;

    private final IMouseEventHandler mousePressedHandler;
    private final IMouseEventHandler mouseDraggedHandler;
    private final IMouseEventHandler mouseReleasedHandler;

    public PlacingHandler(Parent root)
    {
        this.root = (Pane) root;

        focusedTiles = new ArrayList<>();
        battleArea = new boolean[10][10];
        tilesMap = new ArrayList<>();

        mousePressedHandler = EventHandlerFactory.build(EventHandlerType.PRESSED);
        mouseDraggedHandler = EventHandlerFactory.build(EventHandlerType.DRAGGED);
        mouseReleasedHandler = EventHandlerFactory.build(EventHandlerType.RELEASED);
    }

    public void handlePlacing()
    {
        convertRootToElements();

        root.setOnMousePressed(event ->
        {
//            System.out.println("onMousePressed X:" + event.getX() + " Y:" + event.getY());
            mousePressedHandler.handleMouseEvent(this, event);
        });

        root.setOnMouseDragged(event ->
        {
//            System.out.println("onDragDetected X:" + event.getX() + " Y:" + event.getY());
            mouseDraggedHandler.handleMouseEvent(this, event);
        });

        root.setOnMouseReleased(event ->
        {
//            System.out.println("onMouseReleased X:" + event.getX() + " Y:" + event.getY())
            mouseReleasedHandler.handleMouseEvent(this, event);
        });
    }

    private void convertRootToElements()
    {
        Converter converter = new Converter();
        tiles = converter.getTiles(root);
        ships = converter.getShips(root);

        for (int i = 0; i < 10; i++)
        {
            tilesMap.add(new ArrayList<>());
            for (int j = 0; j < 10; j++)
            {
                tilesMap.get(i).add(tiles.get(i + j * 10));
            }
        }

        for (Ship ship : ships)
        {
            ship.setInitX(ship.getMinX());
            ship.setInitY(ship.getMinY());
        }
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

    public Ship getHighlightedShip()
    {
        return highlightedShip;
    }

    public void setHighlightedShip(Ship focusedShip)
    {
        this.highlightedShip = focusedShip;
    }

    public ArrayList<Tile> getFocusedTiles()
    {
        return focusedTiles;
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
