package sea_battle.business_logic.game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game
        implements IGame
{
    private ArrayList<IPlayer> players;
    private PlayerNumber turn;
    private ShootActionListener listener;

    @Override
    public void shoot(IPlayer target, Point point)
    {
        target.getBattleArea()[point.x][point.y] = true;

        if (listener != null)
        {
            if (target.getShipsArea()[point.x][point.y])
            {
                listener.onShipPartHit(point, target.getPlayerNumber());

                ArrayList<Point> ship = checkShipDestroyed(target, point);

                if (ship != null)
                {
                    listener.onShipDestroyed(ship, target.getPlayerNumber());
                }
            }
            else
            {
                listener.onMiss(point, target.getPlayerNumber());
                turn = target.getPlayerNumber();
                listener.onNextTurn(turn);
                System.out.println(turn);
            }
        }
    }

    private ArrayList<Point> checkShipDestroyed(IPlayer target, Point point)
    {
        int row = point.x;
        int col = point.y;

        boolean[][] shipsArea = target.getShipsArea();
        ArrayList<Point> ship = new ArrayList<>();
        ship.add(point);

        addVerticalParts(point, row, shipsArea, ship);
        addHorizontalParts(point, col, shipsArea, ship);

        if (allShipPartsHit(ship, target))
        {
            return ship;
        }

        return null;
    }

    private void addHorizontalParts(Point point, int col, boolean[][] shipsArea, ArrayList<Point> ship)
    {
        int incrementDecrement;
        incrementDecrement = 1;
        while (true)
        {
            if (col + incrementDecrement > 9)
            {
                incrementDecrement = -1;
            }
            if (col + incrementDecrement < 0)
            {
                break;
            }

            col += incrementDecrement;

            if (shipsArea[point.x][col])
            {
                addShipPart(point.x, ship, col);
            }
            else
            {
                if (incrementDecrement != -1)
                {
                    incrementDecrement = -1;
                }
                else
                {
                    break;
                }
            }
        }
    }

    private void addVerticalParts(Point point, int row, boolean[][] shipsArea, ArrayList<Point> ship)
    {
        int incrementDecrement;
        incrementDecrement = 1;
        while (true)
        {
            if (row + incrementDecrement > 9)
            {
                incrementDecrement = -1;
            }
            if (row + incrementDecrement < 0)
            {
                break;
            }

            row += incrementDecrement;

            if (shipsArea[row][point.y])
            {
                addShipPart(row, ship, point.y);
            }
            else
            {
                if (incrementDecrement != -1)
                {
                    incrementDecrement = -1;
                }
                else
                {
                    break;
                }
            }
        }
    }

    private void addShipPart(int row, ArrayList<Point> ship, int y)
    {
        if (!ship.contains(new Point(row, y)))
        {
            ship.add(new Point(row, y));
        }
    }

    private boolean allShipPartsHit(ArrayList<Point> ship, IPlayer target)
    {
        for (Point p : ship)
        {
            if (!target.getBattleArea()[p.x][p.y])
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setPlayers(ArrayList<IPlayer> players)
    {
        this.players = players;
    }

    @Override
    public PlayerNumber randomFirstTurn()
    {
        if (new Random().nextBoolean())
        {
            turn = PlayerNumber.ONE;
        }
        else
        {
            turn = PlayerNumber.TWO;
        }

        return turn;
    }

    @Override
    public PlayerNumber getTurn()
    {
        return turn;
    }

    @Override
    public PlayerNumber nextTurn()
    {
        if (turn == PlayerNumber.ONE)
        {
            turn = PlayerNumber.TWO;
        }
        else
        {
            turn = PlayerNumber.ONE;
        }

        return turn;
    }

    public void setonActionListener(ShootActionListener listener)
    {
        this.listener = listener;
    }
}
