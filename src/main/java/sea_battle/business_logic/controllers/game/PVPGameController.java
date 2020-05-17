package sea_battle.business_logic.controllers.game;

import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.game.IPlayer;
import sea_battle.business_logic.game.PlayerNumber;
import sea_battle.business_logic.utils.AccessibleHandler;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.PlayerHandler;
import sea_battle.models.Constants;
import sea_battle.models.Tile;

import java.awt.*;
import java.util.ArrayList;

public class PVPGameController extends GameController
{
    private Pane root;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);
        this.root = (Pane) root;
    }

    @Override
    protected boolean onClickAction(MouseEvent event)
    {
        if (super.onClickAction(event))
        {
            Converter converter = new Converter();
            ArrayList<Tile> player1PlaceTiles = converter.getTiles(root, Constants.PLAYING_BATTLE_AREA1_ID);
            ArrayList<Tile> player2PlaceTiles = converter.getTiles(root, Constants.PLAYING_BATTLE_AREA2_ID);

            if (getTurn() == PlayerNumber.TWO)
            {
                Tile tile = getClickedTile(player1PlaceTiles, event);
                checkTileOfPlayer(tile, PlayerNumber.ONE);
            }
            else
            {
                Tile placeTile = getClickedTile(player2PlaceTiles, event);
                checkTileOfPlayer(placeTile, PlayerNumber.TWO);
            }
            return true;
        }
        return false;
    }

    private void checkTileOfPlayer(Tile tile, PlayerNumber playerNumber)
    {
        if (tile != null)
        {
            IPlayer player = PlayerHandler.findPlayer(getPlayers(), playerNumber);

            assert player != null;
            shoot(tile, player);
        }
    }

    private void shoot(Tile tile, IPlayer player)
    {
        assert player != null;
        if (!player.getBattleArea()[tile.getRow()][tile.getColumn()])
        {
            getGame().shoot(player, new Point(tile.getRow(), tile.getColumn()));
        }
    }

    private Tile getClickedTile(ArrayList<Tile> tiles, MouseEvent event)
    {
        for (Tile player1PlaceTile : tiles)
        {
            if (AccessibleHandler.eventInsideElementArea(player1PlaceTile, event))
            {
                return player1PlaceTile;
            }
        }
        return null;
    }

}
