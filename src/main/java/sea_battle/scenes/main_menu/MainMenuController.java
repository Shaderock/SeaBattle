package sea_battle.scenes.main_menu;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controllers.Controller;

public class MainMenuController extends Controller
{
    public Button settingsBtn;

    public void moveToSettings(MouseEvent mouseEvent)
    {
        setFXMLScene(SceneType.SETTINGS);
    }

    public void moveToGameChoice(MouseEvent mouseEvent)
    {
        setFXMLScene(SceneType.GAME_TYPE_CHOICE);
    }
}

