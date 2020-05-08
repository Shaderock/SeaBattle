package sea_battle;

import javafx.application.Application;
import javafx.stage.Stage;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_changer.SceneChanger;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;

public class App extends Application
{
    @Override
    public void start(final Stage primaryStage) throws Exception
    {
        Context.setStage(primaryStage);
        primaryStage.setTitle("Sea Battle");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        SceneChanger sceneChanger = SceneChangerFactory.build();
        sceneChanger.setScene(SceneType.MAIN);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
