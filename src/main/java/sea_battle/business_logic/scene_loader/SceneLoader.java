package sea_battle.business_logic.scene_loader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.FileInputStream;
import java.io.IOException;

public class SceneLoader
        extends FXMLLoader
        implements ISceneLoader
{
    private final String fxmlDocPath;

    public SceneLoader(String fxmlDocPath)
    {
        this.fxmlDocPath = fxmlDocPath;
    }

    @Override
    public Parent loadScene() throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("src/main/java/sea_battle/scenes/" + fxmlDocPath);
        return load(fileInputStream);
    }
}
