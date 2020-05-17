package sea_battle.business_logic.controller.custom.game;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import sea_battle.Context;
import sea_battle.business_logic.controller.custom.NavigationController;
import sea_battle.business_logic.game.Game;
import sea_battle.business_logic.game.IPlayer;
import sea_battle.business_logic.game.PlayerNumber;
import sea_battle.business_logic.game.ShootActionListener;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.business_logic.utils.PlayerHandler;
import sea_battle.models.Constants;
import sea_battle.models.GameTile;
import sea_battle.models.Tile;

import java.awt.*;
import java.util.ArrayList;

public abstract class GameController extends NavigationController
        implements IGameController, ShootActionListener
{
    private Node battleArea1;
    private Node battleArea2;
    private ArrayList<IPlayer> players;
    private Game game;
    private PlayerNumber turn;
    private ArrayList<Tile> player1GameTiles;
    private ArrayList<ArrayList<Tile>> player1GameTilesMap;
    private ArrayList<Tile> player2GameTiles;
    private ArrayList<ArrayList<Tile>> player2GameTilesMap;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        Context context = Context.getInstance();
        players = context.getPlayers();
//        players.add(findPlayerByNumber(players, PlayerNumber.ONE));
//        players.add(findPlayerByNumber(players, PlayerNumber.TWO));

        battleArea1 = NodeFinder.findNodeById(root, Constants.PLAYING_BATTLE_AREA1_ID);
        battleArea2 = NodeFinder.findNodeById(root, Constants.PLAYING_BATTLE_AREA2_ID);

        Converter converter = new Converter();
        player1GameTiles = converter.getTiles(root, Constants.PLAYING_BATTLE_AREA1_ID);
        player2GameTiles = converter.getTiles(root, Constants.PLAYING_BATTLE_AREA2_ID);

        player1GameTilesMap = new ArrayList<>();
        player2GameTilesMap = new ArrayList<>();

        converter.tileArrayTo2DArray(player1GameTiles, player1GameTilesMap);
        converter.tileArrayTo2DArray(player2GameTiles, player2GameTilesMap);

        loadGameData();

        game.setonActionListener(this);

        root.setOnMouseClicked(this::onClickAction);
    }

    protected abstract void onClickAction(MouseEvent event);

    @Override
    public void loadGameData()
    {
        game = new Game();
        game.setPlayers(players);
        turn = game.randomFirstTurn();
        System.out.println(turn);
    }

    @Override
    public void onShipPartHit(Point shipPart, PlayerNumber target)
    {
        GameTile gameTile;
        if (target == PlayerNumber.ONE)
        {
            gameTile = getGameTile(shipPart, player1GameTilesMap);
        }
        else
        {
            gameTile = getGameTile(shipPart, player2GameTilesMap);
        }
        gameTile.onHit();
    }

    @Override
    public void onShipDestroyed(ArrayList<Point> shipParts, PlayerNumber target)
    {
        for (Point shipPart : shipParts)
        {
            for (int row = shipPart.x - 1; row < shipPart.x + 2; row++)
            {
                for (int col = shipPart.y - 1; col < shipPart.y + 2; col++)
                {
                    if (row < 0 || row > 9 || col < 0 || col > 9)
                    {
                        continue;
                    }

                    GameTile gameTile;
                    if (target == PlayerNumber.ONE)
                    {
                        gameTile = getGameTile(new Point(row, col), player1GameTilesMap);
                    }
                    else
                    {
                        gameTile = getGameTile(new Point(row, col), player2GameTilesMap);
                    }

                    IPlayer player = PlayerHandler.findPlayer(players, target);
                    assert player != null;
                    player.getBattleArea()[row][col] = true;

                    if (!gameTile.isShot())
                    {
                        gameTile.onMiss();
                    }
                }
            }
        }
    }

    @Override
    public void onMiss(Point tile, PlayerNumber target)
    {
        GameTile gameTile;
        if (target == PlayerNumber.ONE)
        {
            gameTile = getGameTile(tile, player1GameTilesMap);
        }
        else
        {
            gameTile = getGameTile(tile, player2GameTilesMap);
        }
        gameTile.onMiss();
    }

    private GameTile getGameTile(Point shipPart, ArrayList<ArrayList<Tile>> playerGameTilesMap)
    {
        Tile tile = playerGameTilesMap.get(shipPart.x).get(shipPart.y);
        return (GameTile) tile;
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

    protected Node getBattleArea1()
    {
        return battleArea1;
    }

    protected Node getBattleArea2()
    {
        return battleArea2;
    }

    protected ArrayList<IPlayer> getPlayers()
    {
        return players;
    }

    protected Game getGame()
    {
        return game;
    }

    protected PlayerNumber getTurn()
    {
        return turn;
    }

    protected void setTurn(PlayerNumber turn)
    {
        this.turn = turn;
    }
}