package sea_battle.business_logic.scene_changer;

import javafx.beans.value.ChangeListener;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sea_battle.business_logic.scene_loader.SceneLoader;
import sea_battle.business_logic.scene_loader.SceneLoaderFactory;
import sea_battle.business_logic.SceneType;

public class SceneChanger
{
    private final Stage primaryStage;
    private static final int INIT_WIDTH = 1080;
    public static final int INIT_HEIGHT = 720;

    public SceneChanger(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void setScene(SceneType sceneType) throws Exception
    {
        SceneLoader sceneLoader = SceneLoaderFactory.build(sceneType);
        Parent root = sceneLoader.loadScene();

        primaryStage.setScene(new Scene(root, INIT_WIDTH, INIT_HEIGHT));
        primaryStage.show();
    }
}
