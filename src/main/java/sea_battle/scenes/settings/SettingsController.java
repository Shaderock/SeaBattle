package sea_battle.scenes.settings;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.fxml.FXMLController;

public class SettingsController extends FXMLController
{
    public void moveToMainMenu(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.MAIN);
    }
}
