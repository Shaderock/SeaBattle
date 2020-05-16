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
    public void tileArrayTo2DArray(ArrayList<Tile> tiles, ArrayList<ArrayList<Tile>> tilesMap)
    {
        for (int i = 0; i < 10; i++)
        {
            tilesMap.add(new ArrayList<>());
            for (int j = 0; j < 10; j++)
            {
                tilesMap.get(i).add(tiles.get(i + j * 10));
            }
        }
    }

    public ArrayList<Tile> getTiles(Parent root)
    {
        Group battleArea = (Group) NodeFinder.findNodeById(root, Constants.PLACING_BATTLE_AREA_ID);
        ArrayList<Tile> tiles = new ArrayList<>();

        for (Node node : battleArea.getChildren())
        {
            tiles.add((Tile) node);
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
            }
        }

        return ships;
    }
}
