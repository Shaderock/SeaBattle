package sea_battle.scenes.main_menu;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.fxml.FXMLController;

public class MainMenuController extends FXMLController
{
    public Button settingsBtn;

    public void moveToSettings(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.SETTINGS);
    }

    public void moveToGameChoice(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.GAME_TYPE_CHOICE);
    }
}

