package sea_battle.business_logic;

import javafx.fxml.Initializable;
import sea_battle.business_logic.scene_changer.SceneChanger;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private SceneChanger sceneChanger;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        sceneChanger = SceneChangerFactory.build();
    }

    public SceneChanger getSceneChanger()
    {
        return sceneChanger;
    }
}
