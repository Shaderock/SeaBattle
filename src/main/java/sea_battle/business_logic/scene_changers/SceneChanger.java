package sea_battle.business_logic.scene_changers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sea_battle.business_logic.scene_loaders.ISceneLoader;
import sea_battle.models.Constants;

public class SceneChanger implements ISceneChanger  // Strategy Context
{
    private final Stage primaryStage;
    private final ISceneLoader sceneLoader;
    private Parent root;

    public SceneChanger(Stage primaryStage, ISceneLoader sceneLoader)
    {
        this.primaryStage = primaryStage;
        this.sceneLoader = sceneLoader;
    }

    public void setScene() throws Exception
    {
        root = sceneLoader.loadScene();

        primaryStage.setScene(new Scene(root, Constants.SCENE_INIT_WIDTH, Constants.SCENE_INIT_HEIGHT));
        primaryStage.show();
    }

    public Parent getRoot()
    {
        return root;
    }
}
