package sea_battle.scenes.game_type_choice;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.Controller;
import sea_battle.business_logic.SceneType;

public class GameChoiceController extends Controller
{
    public void moveToMainMenu(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.MAIN);
    }
}
