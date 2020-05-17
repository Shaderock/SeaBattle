package sea_battle.business_logic.utils;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.models.Constants;
import sea_battle.models.PlaceTile;
import sea_battle.models.Ship;
import sea_battle.models.Tile;
import sea_battle.models.abstractions.Accessible;

import java.awt.*;

public class AccessibleHandler
{
    public static boolean eventInsideElementArea(Accessible accessibleElement, MouseEvent mouseEvent)
    {
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

        for (Tile tile : placingHandler.getPlaceTiles())
        {
            if (AccessibleHandler.pointInsideElementArea(tile, focusedShip.getMinX(),
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

    private static void checkTiles(PlacingHandler placingHandler, Ship focusedShip, Tile placeTile)
    {
        if (focusedShip.isHorizontal())
        {
            if (10 - focusedShip.getSize() >= placeTile.getColumn() &&
                    checkNeighboringTiles(placingHandler, focusedShip, placeTile))
            {
                for (int i = 0; i < focusedShip.getSize(); i++)
                {
                    PlaceTile placeTileToHighlight =
                            (PlaceTile) placingHandler.getTilesMap().get(placeTile.getRow()).get(placeTile.getColumn() + i);
                    placeTileToHighlight.onHighlight();
                    placingHandler.addFocusedTile(placeTileToHighlight);
                }
            }
        }
        else
        {
            if (10 - focusedShip.getSize() >= placeTile.getRow() &&
                    checkNeighboringTiles(placingHandler, focusedShip, placeTile))
            {
                for (int i = 0; i < focusedShip.getSize(); i++)
                {
                    PlaceTile placeTileToHighlight =
                            (PlaceTile) placingHandler.getTilesMap().get(placeTile.getRow() + i).get(placeTile.getColumn());
                    placeTileToHighlight.onHighlight();
                    placingHandler.addFocusedTile(placeTileToHighlight);
                }
            }
        }
    }

    private static void unHighlightTiles(PlacingHandler placingHandler)
    {
        for (Tile anotherPlaceTile : placingHandler.getPlaceTiles())
        {
            PlaceTile placeTile = (PlaceTile) anotherPlaceTile;
            placeTile.onUnHighlight();
        }
        placingHandler.getFocusedPlaceTiles().clear();
    }

    private static boolean checkNeighboringTiles(PlacingHandler placingHandler, Ship focusedShip, Tile placeTile)
    {
        boolean[][] map = placingHandler.getBattleArea();

        for (int i = 0; i < focusedShip.getSize(); i++)
        {
            if (placeTile.getColumn() + i > 9)
            {
                continue;
            }
            Tile placeTileToCheck;

            if (focusedShip.isHorizontal())
            {
                placeTileToCheck = placingHandler.getTilesMap().get(placeTile.getRow()).get(placeTile.getColumn() + i);
            }
            else
            {
                placeTileToCheck = placingHandler.getTilesMap().get(placeTile.getRow() + i).get(placeTile.getColumn());
            }

            if (tileIsOccupied(placeTileToCheck.getRow(), placeTileToCheck.getColumn(), map))
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
        for (PlaceTile focusedPlaceTile : placingHandler.getFocusedPlaceTiles())
        {
            focusedPlaceTile.onUnHighlight();
        }
        placingHandler.getFocusedPlaceTiles().clear();

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
