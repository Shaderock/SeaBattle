package sea_battle.business_logic.utils;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import sea_battle.models.Constants;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.util.ArrayList;

public class Converter
{
    public void tileArrayTo2DArray(ArrayList<Tile> placeTiles, ArrayList<ArrayList<Tile>> tilesMap)
    {
        for (int i = 0; i < 10; i++)
        {
            tilesMap.add(new ArrayList<>());
            for (int j = 0; j < 10; j++)
            {
                tilesMap.get(i).add(placeTiles.get(i + j * 10));
            }
        }
    }

    public ArrayList<Tile> getTiles(Parent root)
    {
        Group battleArea = (Group) NodeFinder.findNodeById(root, Constants.PLACING_BATTLE_AREA_ID);
        return getTiles(battleArea);
    }

    public ArrayList<Tile> getTiles(Parent root, String id)
    {
        Group battleArea = (Group) NodeFinder.findNodeById(root, id);
        return getTiles(battleArea);
    }

    private ArrayList<Tile> getTiles(Group battleArea)
    {
        ArrayList<Tile> placeTiles = new ArrayList<>();

        for (Node node : battleArea.getChildren())
        {
            placeTiles.add((Tile) node);
        }

        return placeTiles;
    }

    public ArrayList<Ship> getShips(Parent root)
    {
        ArrayList<Ship> ships = new ArrayList<>();

        for (Node child : root.getChildrenUnmodifiable())
        {
            if (child instanceof Ship)
            {
                ships.add((Ship) child);
            }
        }

        return ships;
    }
}
