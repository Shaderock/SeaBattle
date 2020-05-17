package sea_battle;

import javafx.stage.Stage;
import sea_battle.business_logic.controllers.OnInitializeListener;
import sea_battle.business_logic.game.IPlayer;

import java.util.ArrayList;

public class Context
{
    private static final Context instance = new Context();

    private final ArrayList<OnInitializeListener> onInitializeListeners;

    private static Stage stage;

    private final ArrayList<IPlayer> players;

    private Context()
    {
        onInitializeListeners = new ArrayList<>();
        players = new ArrayList<>();
    }

    public static Stage getStage()
    {
        return stage;
    }

    protected static void setStage(Stage stage)
    {
        Context.stage = stage;
    }

    public void addOnInitializeListener(OnInitializeListener onInitializeListener)
    {
        onInitializeListeners.add(onInitializeListener);
    }

    public ArrayList<OnInitializeListener> getOnInitializeListeners()
    {
        return onInitializeListeners;
    }

    public void addPlayer(IPlayer player)
    {
        boolean playerAlreadyExists = false;

        for (IPlayer p : players)
        {
            if (p.getPlayerNumber() == player.getPlayerNumber())
            {
                playerAlreadyExists = true;
                break;
            }
        }

        if (!playerAlreadyExists)
        {
            players.add(player);
        }
    }

    public ArrayList<IPlayer> getPlayers()
    {
        return players;
    }

    public static Context getInstance()
    {
        return instance;
    }
}
