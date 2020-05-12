package sea_battle;

import javafx.application.Application;
import javafx.stage.Stage;
import sea_battle.business_logic.PVP_PVC.PVCFactory;
import sea_battle.business_logic.PVP_PVC.PVPFactory;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.ControllerFactory;
import sea_battle.business_logic.controller.ControllerType;
import sea_battle.business_logic.controller.IControllerFactory;
import sea_battle.business_logic.controller.custom.CustomController;
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

        IControllerFactory controllerFactory = new PVPFactory();

        context.addCustomController((CustomController) controllerFactory.buildController(ControllerType.PVP_PLACING));

        controllerFactory = new PVCFactory();

        context.addCustomController((CustomController) controllerFactory.buildController(ControllerType.PVE_PLACING));

        controllerFactory = new ControllerFactory();

        context.addCustomController((CustomController) controllerFactory.buildController(ControllerType.GAME));
    }
}
