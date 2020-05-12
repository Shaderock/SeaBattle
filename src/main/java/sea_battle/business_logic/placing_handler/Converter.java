package sea_battle.business_logic.placing_handler;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.util.ArrayList;

public class Converter
{
    public ArrayList<Tile> getTiles(Parent root)
    {
        Group battleArea = (Group) NodeFinder.findNodeById(root, Constants.BATTLE_AREA_ID);
        ArrayList<Tile> tiles = new ArrayList<>();

        for (Node node : battleArea.getChildren())
        {
            Tile tile = (Tile) node;
            tiles.add(tile);
//            System.out.println("tile: x=" + tile.getMinX() + " y=" + tile.getMinY());
        }

        return tiles;
    }

    public ArrayList<Ship> getShips(Parent root)
    {
        ArrayList<Ship> ships = new ArrayList<>();

        for (Node child : root.getChildrenUnmodifiable())
        {
            if (child instanceof Ship)
            {
                ships.add((Ship) child);

//                Ship ship = (Ship) child;
//                System.out.println("ship: x=" + ship.getMinX() + " y=" + ship.getMinY());
            }
        }

        return ships;
    }
}
