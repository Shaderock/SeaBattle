package sea_battle.business_logic.controller.custom.placing;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sea_battle.Context;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.game.PlayerFactory;
import sea_battle.business_logic.game.PlayerNumber;
import sea_battle.business_logic.placing_handler.IPlacingHandler;
import sea_battle.business_logic.placing_handler.OnAllShipsPlacedListener;
import sea_battle.business_logic.placing_handler.PlacingHandler;
import sea_battle.business_logic.scene_changer.SceneChangerType;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.business_logic.utils.ShipPlacingRandomizer;
import sea_battle.models.Constants;
import sea_battle.models.Ship;
import sea_battle.models.Tile;

import java.util.ArrayList;


public class PVPPlacingController
        extends ShipsPlacingController
        implements OnAllShipsPlacedListener
{
    private Button nextBtn;
    private Pane root;
    private boolean[][] player1BattleArea;
    private boolean[][] player2BattleArea;
    private boolean player1Rdy;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);
        this.root = (Pane) root;

        nextBtn = (Button) NodeFinder.findNodeById(root, Constants.NEXT_BTN_ID);
        player1Rdy = false;

        placeShips(null);
    }

    @Override
    protected void randomizeBtnAction()
    {
        Converter converter = new Converter();
        ArrayList<Ship> ships = converter.getShips(root);
        ArrayList<Tile> tiles = converter.getTiles(root);
        ArrayList<ArrayList<Tile>> tilesMap = new ArrayList<>();
        converter.tileArrayTo2DArray(tiles, tilesMap);

        for (Ship ship : ships)
        {
            ship.relocateOnInitPos();
        }

        boolean[][] randomizedMap = ShipPlacingRandomizer.randomizePlacing(ships);

        relocateShipsByBattleArea(ships, tilesMap);
        onAllShipsPlaced(randomizedMap);
        placeShips(randomizedMap);
    }

    @Override
    protected void nextBtnAction()
    {
        if (!player1Rdy)
        {
            player1Rdy = true;
            nextBtn.setText("Start game");
            nextBtn.setDisable(true);

            Converter converter = new Converter();
            ArrayList<Ship> ships = converter.getShips(root);

            for (Ship ship : ships)
            {
                ship.relocateOnInitPos();
            }

            placeShips(null);
        }
        else
        {
            Context context = Context.getInstance();
            context.addPlayer(PlayerFactory.buildPlayer(PlayerNumber.ONE, player1BattleArea));
            context.addPlayer(PlayerFactory.buildPlayer(PlayerNumber.TWO, player2BattleArea));

            try
            {
                setSceneChanger(getFactory().buildSceneChanger(SceneChangerType.INITIALIZING));
                getSceneChanger().setScene(SceneType.GAME_PVP);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onAllShipsPlaced(boolean[][] battleArea)
    {
        if (!player1Rdy)
        {
            player1BattleArea = battleArea;
        }
        else
        {
            player2BattleArea = battleArea;
        }

        nextBtn.setDisable(false);
    }

    @Override
    public void onShipDisplacement()
    {
        nextBtn.setDisable(true);
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

    private void placeShips(boolean[][] randomizedMap)
    {
        IPlacingHandler placingHandler = new PlacingHandler(root);
        placingHandler.setOnAllShipsPlacedListener(this);
        if (randomizedMap != null)
        {
            placingHandler.setBattleArea(randomizedMap);
        }
        placingHandler.handlePlacing();
    }
}
