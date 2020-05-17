package sea_battle.business_logic.controllers.game;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.game.PlayerNumber;
import sea_battle.business_logic.utils.Converter;
import sea_battle.models.Constants;
import sea_battle.models.Tile;

import java.util.ArrayList;

public class PVPGameController extends GameController
{
    @Override
    protected boolean onClickAction(MouseEvent event)
    {
        if (super.onClickAction(event))
        {
            Converter converter = new Converter();
            ArrayList<Tile> player1Tiles = converter.getTiles(getRoot(), Constants.PLAYING_BATTLE_AREA1_ID);
            ArrayList<Tile> player2Tiles = converter.getTiles(getRoot(), Constants.PLAYING_BATTLE_AREA2_ID);

            if (getTurn() == PlayerNumber.TWO)
            {
                Tile tile = getClickedTile(player1Tiles, event);
                checkTileOfPlayer(tile, PlayerNumber.ONE);
            }
            else
            {
                Tile tile = getClickedTile(player2Tiles, event);
                checkTileOfPlayer(tile, PlayerNumber.TWO);
            }
            return true;
        }
        return false;
    }
}
