package sea_battle.business_logic.utils;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.models.Constants;
import sea_battle.models.Ship;
import sea_battle.models.Tile;
import sea_battle.models.abstractions.Accessible;

import java.awt.*;

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
        boolean isTileFound = false;

        for (Tile tile : placingHandler.getTiles())
        {
            if (ElementHandler.pointInsideElementArea(tile, focusedShip.getMinX(),
                    focusedShip.getMinY() + (Constants.TILE_SIZE >> 1)))
            {
                isTileFound = true;
                unHighlightTiles(placingHandler);
                checkTiles(placingHandler, focusedShip, tile);
            }
        }

        if (!isTileFound)
        {
            unHighlightTiles(placingHandler);
        }
    }

    private static void checkTiles(PlacingHandler placingHandler, Ship focusedShip, Tile tile)
    {
        if (focusedShip.isHorizontal())
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
        else
        {
            if (10 - focusedShip.getSize() >= tile.getRow() &&
                    checkNeighboringTiles(placingHandler, focusedShip, tile))
            {
                for (int i = 0; i < focusedShip.getSize(); i++)
                {
                    Tile tileToHighlight =
                            placingHandler.getTilesMap().get(tile.getRow() + i).get(tile.getColumn());
                    tileToHighlight.onHighlight();
                    placingHandler.addFocusedTile(tileToHighlight);
                }
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
            Tile tileToCheck;

            if (focusedShip.isHorizontal())
            {
                tileToCheck = placingHandler.getTilesMap().get(tile.getRow()).get(tile.getColumn() + i);
            }
            else
            {
                tileToCheck = placingHandler.getTilesMap().get(tile.getRow() + i).get(tile.getColumn());
            }

            if (tileIsOccupied(tileToCheck.getRow(), tileToCheck.getColumn(), map))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean tileIsOccupied(int row, int column, boolean[][] map)
    {
        for (int r = row - 1; r < row + 2; r++)
        {
            for (int col = column - 1; col < column + 2; col++)
            {
                if (r >= 0 && r <= 9 && col >= 0 && col <= 9 && map[r][col])
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

    public static void removeShipPlacing(boolean[][] battleArea, Ship pressedShip)
    {
        if (pressedShip.isPlaced())
        {
            pressedShip.setPlaced(false);

            for (Point tile : pressedShip.getTiles())
            {
                battleArea[tile.x][tile.y] = false;
            }

            pressedShip.getTiles().clear();
        }
    }
}
