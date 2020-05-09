package sea_battle;

import javafx.stage.Stage;
import sea_battle.business_logic.controller.custom.CustomController;

import java.util.ArrayList;

public class Context
{
    private static final Context instance = new Context();

    private final ArrayList<CustomController> customControllers;

    private Context()
    {
        customControllers = new ArrayList<>();
    }

    private static Stage stage;

    public static Stage getStage()
    {
        return stage;
    }

    protected static void setStage(Stage stage)
    {
        Context.stage = stage;
    }

    public void addCustomController(CustomController customController)
    {
        customControllers.add(customController);
    }

    public ArrayList<CustomController> getCustomControllers()
    {
        return customControllers;
    }

    public static Context getInstance()
    {
        return instance;
    }
}
