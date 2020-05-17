package sea_battle.business_logic.controllers.placing;

import sea_battle.Context;
import sea_battle.business_logic.PVP_PVC.PVCFactory;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.game.IPlayer;
import sea_battle.business_logic.game.PlayerFactory;
import sea_battle.business_logic.game.PlayerNumber;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.ShipPlacingRandomizer;
import sea_battle.models.Ship;

import java.util.ArrayList;

public class PVCPlacingController extends ShipsPlacingController
{
    private boolean[][] playerBattleArea;

    @Override
    protected void nextBtnAction()
    {
        Context context = Context.getInstance();
        context.getPlayers().clear();

        context.addPlayer(PlayerFactory.buildPlayer(PlayerNumber.ONE, playerBattleArea));
        IPlayer computer = generateAI();
        context.addPlayer(computer);

        setScene(new PVCFactory(), SceneType.GAME);
    }

    private IPlayer generateAI()
    {
        Converter converter = new Converter();
        ArrayList<Ship> ships = converter.getShips(getRoot());

        for (Ship ship : ships)
        {
            ship.relocateOnInitPos();
        }

        boolean[][] randomizedMap = ShipPlacingRandomizer.randomizePlacing(ships);

        return PlayerFactory.buildPlayer(PlayerNumber.TWO, randomizedMap);
    }

    @Override
    public void onAllShipsPlaced(boolean[][] battleArea)
    {
        playerBattleArea = battleArea;
        getNextButton().setDisable(false);
    }
}
