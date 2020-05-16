package sea_battle.business_logic.controller.custom.game;

import javafx.scene.Node;
import javafx.scene.Parent;
import sea_battle.Context;
import sea_battle.business_logic.controller.custom.NavigationController;
import sea_battle.business_logic.game.IPlayer;
import sea_battle.business_logic.game.PlayerNumber;

import java.util.ArrayList;

public abstract class GameController extends NavigationController
        implements IGameController
{
    private Node battleArea1;
    private Node battleArea2;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        Context context = Context.getInstance();
        ArrayList<IPlayer> players = context.getPlayers();
        IPlayer player1 = findPlayerByNumber(players, PlayerNumber.ONE);
        IPlayer player2 = findPlayerByNumber(players, PlayerNumber.TWO);

        placeShipsOnAreas(player1.getBattleArea(), player2.getBattleArea());
    }

    @Override
    public void placeShipsOnAreas(boolean[][] battleArea1, boolean[][] battleArea2)
    {

    }

    protected IPlayer findPlayerByNumber(ArrayList<IPlayer> players, PlayerNumber playerNumber)
    {
        for (IPlayer player : players)
        {
            if (player.getPlayerNumber() == playerNumber)
            {
                return player;
            }
        }

        return null;
    }
}