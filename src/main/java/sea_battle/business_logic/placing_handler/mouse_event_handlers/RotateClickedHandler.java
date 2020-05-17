package sea_battle.business_logic.placing_handler.mouse_event_handlers;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.AccessibleHandler;
import sea_battle.business_logic.utils.ArrayHandler;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.awt.*;

public class RotateClickedHandler implements IMouseEventHandler
{
    @Override
    public void handleMouseEvent(PlacingHandler placingHandler, MouseEvent mouseEvent)
    {
        Ship ship = placingHandler.getHighlightedShip();

        if (ship != null && ship.isPlaced())
        {
            if (!rotateShip(placingHandler, ship))
            {
                ship.setRotateWarning();
            }
        }
    }

    private boolean rotateShip(PlacingHandler placingHandler, Ship ship)
    {
        Ship clonedShip = (Ship) ship.clone();
        boolean[][] battleArea = placingHandler.getBattleArea();
        boolean[][] clonedBattleArea = ArrayHandler.deepCopy2DArray(placingHandler.getBattleArea());
        int minX = clonedShip.getTiles().get(0).x;
        int minY = clonedShip.getTiles().get(0).y;
        int shipSize = ship.getSize();
        boolean isHorizontal = ship.isHorizontal();
        AccessibleHandler.removeShipPlacing(clonedBattleArea, clonedShip);

        for (int i = 0; i < 2; i++)
        {
            int minAxis;
            int maxAxis;

            if (isHorizontal)
            {
                minAxis = getAxis(shipSize, i, minX - shipSize);
                maxAxis = getAxis(shipSize, i, minX);
            }
            else
            {
                minAxis = getAxis(shipSize, i, minY - shipSize);
                maxAxis = getAxis(shipSize, i, minY);
            }

            if (canRotate(clonedBattleArea, minX, minY, isHorizontal, minAxis, maxAxis))
            {
                AccessibleHandler.removeShipPlacing(battleArea, ship);
                updateAxisContext(ship, battleArea, minX, minY, shipSize, isHorizontal, minAxis);

                Tile placeTile = getTile(placingHandler, minX, minY, isHorizontal, minAxis);
                placeShip(ship, placeTile);

                return true;
            }
        }
        return false;
    }

    private boolean canRotate(boolean[][] clonedBattleArea, int minX, int minY, boolean isHorizontal, int minAxis, int maxAxis)
    {
        for (int axis = minAxis; axis < maxAxis; axis++)
        {
            if (isHorizontal)
            {
                if (isOccupied(clonedBattleArea, minY, axis, axis < 0, axis > 9))
                {
                    return false;
                }
            }
            else
            {
                if (isOccupied(clonedBattleArea, axis, minX, axis < 0, axis > 9))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateAxisContext(Ship ship, boolean[][] battleArea, int minX, int minY, int shipSize, boolean isHorizontal, int minAxis)
    {
        for (int axis = minAxis; axis < minAxis + shipSize; axis++)
        {
            if (isHorizontal)
            {
                updateRealContext(ship, battleArea, minY, axis);
            }
            else
            {
                updateRealContext(ship, battleArea, axis, minX);
            }
        }
    }

    private Tile getTile(PlacingHandler placingHandler, int minX, int minY, boolean isHorizontal, int minAxis)
    {
        Tile tile;
        if (isHorizontal)
        {
            tile = getTile(placingHandler, minAxis, minY);
        }
        else
        {
            tile = getTile(placingHandler, minX, minAxis);
        }
        return tile;
    }

    private void placeShip(Ship ship, Tile placeTile)
    {
        ship.setPlaced(true);
        ship.relocate(placeTile.getMinX(), placeTile.getMinY());
        ship.switchOrientation();
    }

    private Tile getTile(PlacingHandler placingHandler, int minX, int minCol)
    {
        return placingHandler.getTilesMap().get(minX).get(minCol);
    }

    private void updateRealContext(Ship ship, boolean[][] battleArea, int col, int row)
    {
        battleArea[row][col] = true;
        ship.getTiles().add(new Point(row, col));
    }

    private boolean isOccupied(boolean[][] clonedBattleArea, int col, int row, boolean b, boolean b2)
    {
        return AccessibleHandler.tileIsOccupied(row, col, clonedBattleArea) ||
                b || b2;
    }

    private int getAxis(int shipSize, int i, int axis)
    {
        return axis + 1 + i * (shipSize - 1);
    }
}
