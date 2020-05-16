package sea_battle.business_logic.controller.fxml;

import javafx.fxml.Initializable;
import sea_battle.business_logic.controller.Controller;
import sea_battle.business_logic.controller.IController;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;
import sea_battle.business_logic.scene_changer.SceneChangerType;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController
        extends Controller
        implements Initializable,
        IController
{
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setSceneChanger(new SceneChangerFactory().buildSceneChanger(SceneChangerType.DEFAULT));
    }
}
