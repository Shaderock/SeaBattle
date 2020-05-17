package sea_battle.business_logic.utils;

import sea_battle.models.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ShipPlacingRandomizer
{
    public static boolean[][] randomizePlacing(ArrayList<Ship> ships)
    {
        boolean[][] map = new boolean[10][10];

        ArrayList<Ship> shipsToPlace = new ArrayList<>(ships);

        while (shipsToPlace.size() > 0)
        {
            Ship shipToPlace = shipsToPlace.get((int) Math.floor(Math.random() * shipsToPlace.size()));

            while (!shipToPlace.isPlaced())
            {
                keepPlacing(map, shipToPlace);
            }

            shipsToPlace.remove(shipToPlace);
        }

        return map;
    }

    private static void keepPlacing(boolean[][] map, Ship shipToPlace)
    {
        shipToPlace.getTiles().clear();
        int row = (int) Math.floor(Math.random() * 10);
        int column = (int) Math.floor(Math.random() * 10);
        boolean isHorizontal = new Random().nextBoolean();
        int shipSize = shipToPlace.getSize();

        if (isHorizontal)
        {
            if (!shipToPlace.isHorizontal())
            {
                shipToPlace.switchOrientation();
            }

            if (shipSize + column > 9)
            {
                return;
            }

            for (int i = column; i < column + shipToPlace.getSize(); i++)
            {
                shipToPlace.addTile(new Point(row, i));
            }
        }
        else
        {
            if (shipToPlace.isHorizontal())
            {
                shipToPlace.switchOrientation();
            }

            if (shipSize + row > 9)
            {
                return;
            }

            for (int i = row; i < row + shipToPlace.getSize(); i++)
            {
                shipToPlace.addTile(new Point(i, column));
            }
        }

        shipToPlace.setHorizontal(isHorizontal);
        shipToPlace.onUnHighlight();

        if (shipPlacingAllowed(map, shipToPlace))
        {
            shipToPlace.setPlaced(true);
            for (Point tile : shipToPlace.getTiles())
            {
                map[tile.x][tile.y] = true;
            }
        }
    }

    private static boolean shipPlacingAllowed(boolean[][] battleArea, Ship ship)
    {
        for (Point tile : ship.getTiles())
        {
            if (!tilePlacingAllowed(battleArea, tile.x, tile.y))
            {
                return false;
            }
        }

        return true;
    }

    private static boolean tilePlacingAllowed(boolean[][] battleArea, int x, int y)
    {
        for (int row = x - 1; row < x + 2; row++)
        {
            for (int column = y - 1; column < y + 2; column++)
            {
                if (row < 0 || row > 9 || column < 0 || column > 9)
                {
                    continue;
                }
                if (battleArea[row][column])
                {
                    return false;
                }
            }
        }

        return true;
    }
}
