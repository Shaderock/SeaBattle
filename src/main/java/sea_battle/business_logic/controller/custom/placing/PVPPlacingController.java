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
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;
import sea_battle.models.Ship;


public class PVPPlacingController
        extends ShipsPlacingController
        implements OnAllShipsPlacedListener
{
    private Button nextBtn;
    private Pane stackPaneRoot;
    private boolean[][] player1BattleArea;
    private boolean[][] player2BattleArea;
    private boolean player1Rdy = false;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);
        stackPaneRoot = (Pane) root;

        nextBtn = (Button) NodeFinder.findNodeById(root, Constants.NEXT_BTN_ID);

        placeShips();
    }

    protected void nextBtnAction()
    {
        if (!player1Rdy)
        {
            player1Rdy = true;
            nextBtn.setText("Start game");
            nextBtn.setDisable(true);

            Converter converter = new Converter();
            for (Ship ship : converter.getShips(stackPaneRoot))
            {
                ship.relocateOnInitPos();
            }

            placeShips();
        }
        else
        {
            Context context = Context.getInstance();
            context.addPlayer(PlayerFactory.buildPlayer(PlayerNumber.ONE, player1BattleArea));
            context.addPlayer(PlayerFactory.buildPlayer(PlayerNumber.TWO, player2BattleArea));

            getSceneChanger().setLoaderFactory(getFactory());
            try
            {
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

    private void placeShips()
    {
        IPlacingHandler placingHandler = new PlacingHandler(stackPaneRoot);
        placingHandler.setOnAllShipsPlacedListener(this);
        placingHandler.handlePlacing();
    }
}
