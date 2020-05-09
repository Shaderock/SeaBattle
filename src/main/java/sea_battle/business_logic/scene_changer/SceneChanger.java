package sea_battle.business_logic.scene_changer;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.business_logic.scene_loader.SceneLoaderFactory;
import sea_battle.models.Constants;

public class SceneChanger implements ISceneChanger
{
    private final Stage primaryStage;
    private Parent root;

    public SceneChanger(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void setScene(SceneType sceneType) throws Exception
    {
        ISceneLoader sceneLoader = SceneLoaderFactory.build(sceneType);
        root = sceneLoader.loadScene();

        primaryStage.setScene(new Scene(root, Constants.SCENE_INIT_WIDTH, Constants.SCENE_INIT_HEIGHT));
        primaryStage.show();
    }

    public Parent getRoot()
    {
        return root;
    }
}
