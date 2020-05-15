package sea_battle.business_logic.controller.custom.game;

import javafx.scene.Parent;
import sea_battle.Context;
import sea_battle.business_logic.controller.custom.NavigationController;

public abstract class GameController extends NavigationController
        implements IGameController
{
    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        Context context = Context.getInstance();
//        boolean[][] battleArea1 = context.getBattleArea1();
//        boolean[][] battleArea2 = context.getBattleArea2();
//
//        placeBattleAreas(battleArea1, battleArea2);
//        placeShips(battleArea1, battleArea2);
    }

    @Override
    public void placeBattleAreas(boolean[][] battleArea1, boolean[][] battleArea2)
    {

    }

    @Override
    public void placeShips(boolean[][] battleArea1, boolean[][] battleArea2)
    {

    }
}