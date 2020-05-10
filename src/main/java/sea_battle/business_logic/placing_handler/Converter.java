package sea_battle.business_logic.placing_handler;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;
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
            Rectangle rectangle = (Rectangle) node;
            tiles.add(new Tile(rectangle));
        }

        return tiles;
    }

    public ArrayList<Ship> getShips(Parent root)
    {
        Group shipsAsGroup = (Group) NodeFinder.findNodeById(root, Constants.SHIPS_ID);
        ArrayList<Ship> ships = new ArrayList<>();

        for (Node node : shipsAsGroup.getChildren())
        {
            Group shipAsGroup = (Group) node;
            ships.add(new Ship(shipAsGroup));
        }

        return ships;
    }
}
