package sea_battle;

import javafx.stage.Stage;

public class Context
{
    private static Stage stage;

    public static Stage getStage()
    {
        return stage;
    }

    protected static void setStage(Stage stage)
    {
        Context.stage = stage;
    }
}
