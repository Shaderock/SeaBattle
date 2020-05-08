package sea_battle.scenes.game_type_choice;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.Controller;

public class GameChoiceController extends Controller
{
    public void moveToMainMenu(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.MAIN);
    }

    public void moveToPVP(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.SHIPS_PLACING_PVP);
    }

    public void moveToPVC(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.SHIPS_PLACING_PVP);
    }
}
