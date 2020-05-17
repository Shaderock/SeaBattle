package sea_battle.business_logic.controllers.game;

import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;
import sea_battle.business_logic.game.IPlayer;
import sea_battle.business_logic.game.PlayerNumber;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.PlayerHandler;
import sea_battle.models.Constants;
import sea_battle.models.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PVCGameController extends GameController
{
    private IPlayer player;
    private final ArrayList<Pair<Integer, Integer>>
            unusedPairs = new ArrayList<>();

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        player = PlayerHandler.findPlayer(getPlayers(), PlayerNumber.ONE);

        if (player != null)
        {
            for (int i = 0; i < player.getBattleArea().length; i++)
            {
                for (int j = 0; j < player.getBattleArea().length; j++)
                {
                    unusedPairs.add(new Pair<>(i, j));
                }
            }
        }

        Collections.shuffle(unusedPairs);

        while (getTurn() == PlayerNumber.TWO  && gameContinues())
        {
            Point point = generateShot(player);
            if (point != null)
            {
                shoot(point, player);
            }
        }
    }

    @Override
    protected boolean onClickAction(MouseEvent event)
    {
        Converter converter = new Converter();
        ArrayList<Tile> computerTiles = converter.getTiles(getRoot(), Constants.PLAYING_BATTLE_AREA2_ID);

        if (super.onClickAction(event))
        {
            Tile tile = getClickedTile(computerTiles, event);
            checkTileOfPlayer(tile, PlayerNumber.TWO);
            while (getTurn() == PlayerNumber.TWO && gameContinues())
            {
                Point point = generateShot(player);
                if (point != null)
                {
                    shoot(point, player);
                }
            }
            return true;
        }
        return false;
    }


    private Point generateShot(IPlayer target)
    {
        Pair<Integer, Integer> pair = null;
        do
        {
            if (unusedPairs.size() > 0)
            {
                pair = unusedPairs.get(0);
                unusedPairs.remove(pair);
            }
            else
            {
                break;
            }
        }
        while (target.getBattleArea()[pair.getKey()][pair.getValue()]);

        if (pair != null)
        {
            return new Point(pair.getKey(), pair.getValue());
        }
        else
        {
            return null;
        }
    }

    @Override
    protected void announceTheWinner(PlayerNumber winner)
    {
        if (winner == PlayerNumber.ONE)
        {
            getWinnerLabel().setText("Player wins");
        }
        else
        {
            getWinnerLabel().setText("Computer wins");
        }
    }
}
