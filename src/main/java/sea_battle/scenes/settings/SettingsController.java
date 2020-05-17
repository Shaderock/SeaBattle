package sea_battle.scenes.settings;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controllers.Controller;

public class SettingsController extends Controller
{
    public void moveToMainMenu(MouseEvent mouseEvent)
    {
        setFXMLScene(SceneType.MAIN);
    }
}
