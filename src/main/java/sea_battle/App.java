package sea_battle;

import javafx.application.Application;
import javafx.stage.Stage;
import sea_battle.business_logic.PVP_PVC.Factory;
import sea_battle.business_logic.PVP_PVC.PVCFactory;
import sea_battle.business_logic.PVP_PVC.PVPFactory;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.ControllerType;
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

        Factory factory = new PVPFactory();

        CustomController pvpPlacingController = (CustomController) factory.buildPlacingController(ControllerType.PVP_PLACING);
        context.addCustomController(pvpPlacingController);
        context.addCustomController((CustomController) factory.buildGameController());

        factory = new PVCFactory();
        context.addCustomController((CustomController) factory.buildPlacingController(ControllerType.PVE_PLACING));
        context.addCustomController((CustomController) factory.buildGameController());
    }
}
