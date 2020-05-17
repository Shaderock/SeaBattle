package sea_battle.business_logic.controllers.placing;

import javafx.scene.Parent;
import sea_battle.Context;
import sea_battle.business_logic.PVP_PVC.PVPFactory;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.game.PlayerFactory;
import sea_battle.business_logic.game.PlayerNumber;
import sea_battle.business_logic.utils.Converter;
import sea_battle.models.Ship;

import java.util.ArrayList;


public class PVPPlacingController
        extends ShipsPlacingController
{
    private boolean[][] player1BattleArea;
    private boolean[][] player2BattleArea;
    private boolean player1Rdy;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);
        player1Rdy = false;

        placeShips(getRoot());
    }

    @Override
    protected void nextBtnAction()
    {
        if (!player1Rdy)
        {
            player1Rdy = true;
            getNextButton().setText("Start game");
            getNextButton().setDisable(true);

            Converter converter = new Converter();
            ArrayList<Ship> ships = converter.getShips(getRoot());

            for (Ship ship : ships)
            {
                ship.relocateOnInitPos();
            }

            placeShips(getRoot());
        }
        else
        {
            Context context = Context.getInstance();
            context.getPlayers().clear();
            context.addPlayer(PlayerFactory.buildPlayer(PlayerNumber.ONE, player1BattleArea));
            context.addPlayer(PlayerFactory.buildPlayer(PlayerNumber.TWO, player2BattleArea));

            setScene(new PVPFactory(), SceneType.GAME);
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

        getNextButton().setDisable(false);
    }

}
