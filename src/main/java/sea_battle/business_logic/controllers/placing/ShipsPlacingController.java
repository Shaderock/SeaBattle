package sea_battle.business_logic.controllers.placing;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.controllers.NavigationController;
import sea_battle.business_logic.placing_handler.IPlacingHandler;
import sea_battle.business_logic.placing_handler.OnAllShipsPlacedListener;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.business_logic.utils.ShipPlacingRandomizer;
import sea_battle.models.Constants;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.util.ArrayList;

public abstract class ShipsPlacingController
        extends NavigationController
        implements OnAllShipsPlacedListener
{
    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        Button randomizeButton = (Button) NodeFinder.findNodeById(root, Constants.RANDOMIZE_BTN_ID);
        randomizeButton.setOnMouseClicked(event ->
                randomizeBtnAction());

        Converter converter = new Converter();
        ArrayList<Ship> ships = converter.getShips(root);

        for (Ship ship : ships)
        {
            ship.setInitX(ship.getMinX());
            ship.setInitY(ship.getMinY());
        }
    }

    protected void randomizeBtnAction()
    {
        Converter converter = new Converter();
        ArrayList<Ship> ships = converter.getShips(getRoot());
        ArrayList<Tile> tiles = converter.getTiles(getRoot());
        ArrayList<ArrayList<Tile>> tilesMap = new ArrayList<>();
        converter.tileArrayTo2DArray(tiles, tilesMap);

        for (Ship ship : ships)
        {
            ship.relocateOnInitPos();
        }

        boolean[][] randomizedMap = ShipPlacingRandomizer.randomizePlacing(ships);

        relocateShipsByBattleArea(ships, tilesMap);
        onAllShipsPlaced(randomizedMap);
        placeShips(randomizedMap, getRoot());
    }

    protected void placeShips(boolean[][] randomizedMap, Pane root)
    {
        IPlacingHandler placingHandler = new PlacingHandler(root);
        placingHandler.setOnAllShipsPlacedListener(this);
        if (randomizedMap != null)
        {
            placingHandler.setBattleArea(randomizedMap);
        }
        placingHandler.handlePlacing();
    }

    protected void placeShips(Pane root)
    {
        IPlacingHandler placingHandler = new PlacingHandler(root);
        placingHandler.setOnAllShipsPlacedListener(this);
        placingHandler.handlePlacing();
    }

    @Override
    public void onShipDisplacement()
    {
        getNextButton().setDisable(true);
    }

    private void relocateShipsByBattleArea(ArrayList<Ship> ships,
                                           ArrayList<ArrayList<Tile>> tilesMap)
    {
        for (Ship ship : ships)
        {
            double x = tilesMap.get(ship.getTiles().get(0).x).get(ship.getTiles().get(0).y).getMinX();
            double y = tilesMap.get(ship.getTiles().get(0).x).get(ship.getTiles().get(0).y).getMinY();
            ship.relocate(x, y);
        }
    }
}
