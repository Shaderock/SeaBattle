package sea_battle;

import javafx.application.Application;
import javafx.stage.Stage;
import sea_battle.business_logic.PVP_PVC.IFactory;
import sea_battle.business_logic.PVP_PVC.PVCFactory;
import sea_battle.business_logic.PVP_PVC.PVPFactory;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controllers.ControllerType;
import sea_battle.business_logic.controllers.OnInitializeListener;
import sea_battle.business_logic.scene_changers.ISceneChanger;
import sea_battle.business_logic.scene_changers.ISceneChangerFactory;
import sea_battle.business_logic.scene_changers.SceneChangerFactory;

public class App extends Application
{
    @Override
    public void start(final Stage primaryStage)
    {
        Context.setStage(primaryStage);

        primaryStage.setTitle("Sea Battle");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();

        setScene(new SceneChangerFactory());

        initControllers();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public void initControllers()
    {
        Context context = Context.getInstance();

        IFactory factory = new PVPFactory();
        context.addOnInitializeListener((OnInitializeListener) factory.buildController(ControllerType.PLACING));
        context.addOnInitializeListener((OnInitializeListener) factory.buildController(ControllerType.GAME));

        factory = new PVCFactory();
        context.addOnInitializeListener((OnInitializeListener) factory.buildController(ControllerType.PLACING));
        context.addOnInitializeListener((OnInitializeListener) factory.buildController(ControllerType.GAME));
    }

    private void setScene(ISceneChangerFactory sceneChangerFactory)
    {
        ISceneChanger sceneChanger = sceneChangerFactory.buildSceneChanger(SceneType.MAIN);
        try
        {
            sceneChanger.setScene();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
