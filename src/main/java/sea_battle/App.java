package sea_battle;

import javafx.application.Application;
import javafx.stage.Stage;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.ControllerFactory;
import sea_battle.business_logic.controller.ControllerType;
import sea_battle.business_logic.controller.custom.PVPController;
import sea_battle.business_logic.scene_changer.ISceneChanger;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;
import sea_battle.business_logic.scene_changer.SceneChangerType;

public class App extends Application
{
    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        Context.setStage(primaryStage);

        primaryStage.setTitle("Sea Battle");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();

        ISceneChanger sceneChanger = SceneChangerFactory.build(SceneChangerType.DEFAULT);

        sceneChanger.setScene(SceneType.MAIN);

        initControllers();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public void initControllers()
    {
        Context context = Context.getInstance();
        context.addCustomController((PVPController) ControllerFactory.build(ControllerType.PVP_PLACING));
    }
}
