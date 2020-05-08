package sea_battle.scenes.main_menu;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.Controller;
import sea_battle.business_logic.SceneType;

public class MainMenuController extends Controller
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

