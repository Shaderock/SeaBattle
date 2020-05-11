package sea_battle.business_logic.utils;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.models.Constants;
import sea_battle.models.Ship;
import sea_battle.models.Tile;
import sea_battle.models.abstractions.Accessible;

public class ElementHandler
{
    public static boolean eventInsideElementArea(Accessible accessibleElement, MouseEvent mouseEvent)
    {
//        System.out.println("---------");
//        System.out.println("mouseX= " + mouseEvent.getX() +
//                " mouseY= " + mouseEvent.getY());
//        System.out.println("elemMinX= " + accessibleElement.getMinX());
//        System.out.println("elemMaxX= " + accessibleElement.getMaxX());
//        System.out.println("elemMinY= " + accessibleElement.getMinY());
//        System.out.println("elemMaxY= " + accessibleElement.getMaxY());
//        System.out.println("-----------");

        return pointInsideElementArea(accessibleElement, mouseEvent.getX(), mouseEvent.getY());
    }

    public static boolean pointInsideElementArea(Accessible accessibleElement, double x, double y)
    {
        return x >= accessibleElement.getMinX() &&
                x <= accessibleElement.getMaxX() &&
                y >= accessibleElement.getMinY() &&
                y <= accessibleElement.getMaxY();
    }

    public static void highlightTiles(PlacingHandler placingHandler, Ship focusedShip)
    {
        for (Tile tile : placingHandler.getTiles())
        {
            if (ElementHandler.pointInsideElementArea(tile, focusedShip.getMinX(),
                    focusedShip.getMinY() + (Constants.TILE_SIZE >> 1)))
            {
                unHighlightTiles(placingHandler);
                checkTiles(placingHandler, focusedShip, tile);
            }
        }
    }

    private static void checkTiles(PlacingHandler placingHandler, Ship focusedShip, Tile tile)
    {
        if (10 - focusedShip.getSize() >= tile.getColumn() &&
                checkNeighboringTiles(placingHandler, focusedShip, tile))
        {
            for (int i = 0; i < focusedShip.getSize(); i++)
            {
                Tile tileToHighlight =
                        placingHandler.getTilesMap().get(tile.getRow()).get(tile.getColumn() + i);
                tileToHighlight.onHighlight();
                placingHandler.addFocusedTile(tileToHighlight);
            }
        }
    }

    private static void unHighlightTiles(PlacingHandler placingHandler)
    {
        for (Tile anotherTile : placingHandler.getTiles())
        {
            anotherTile.onUnHighlight();
        }
        placingHandler.getFocusedTiles().clear();
    }

    private static boolean checkNeighboringTiles(PlacingHandler placingHandler, Ship focusedShip, Tile tile)
    {
        boolean[][] map = placingHandler.getBattleArea();

        for (int i = 0; i < focusedShip.getSize(); i++)
        {
            if (tile.getColumn() + i > 9)
            {
                continue;
            }
            Tile tileToCheck = placingHandler.getTilesMap().get(tile.getRow()).get(tile.getColumn() + i);
            if (checkTile(tileToCheck, map))
            {
                return false;
            }
        }

        return true;
    }

    private static boolean checkTile(Tile tile, boolean[][] map)
    {
        for (int row = tile.getRow() - 1; row < tile.getRow() + 2; row++)
        {
            for (int column = tile.getColumn() - 1; column < tile.getColumn() + 2; column++)
            {
                if (row < 0 || row > 9 || column < 0 || column > 9)
                {
                    continue;
                }
                if (map[row][column])
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void unHighlightAllElements(PlacingHandler placingHandler)
    {
        for (Tile focusedTile : placingHandler.getFocusedTiles())
        {
            focusedTile.onUnHighlight();
        }
        placingHandler.getFocusedTiles().clear();

        for (Ship ship : placingHandler.getShips())
        {
            ship.onUnHighlight();
        }
        placingHandler.setHighlightedShip(null);
    }
}
