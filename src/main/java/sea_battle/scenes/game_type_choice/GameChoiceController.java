package sea_battle.scenes.game_type_choice;

import javafx.scene.input.MouseEvent;
import sea_battle.business_logic.PVP_PVC.PVCFactory;
import sea_battle.business_logic.PVP_PVC.PVPFactory;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controllers.Controller;

public class GameChoiceController extends Controller
{
    public void moveToMainMenu(MouseEvent mouseEvent)
    {
        setFXMLScene(SceneType.MAIN);
    }

    public void moveToPVP(MouseEvent mouseEvent)
    {
        setScene(new PVPFactory(), SceneType.SHIPS_PLACING);
    }

    public void moveToPVC(MouseEvent mouseEvent)
    {
        setScene(new PVCFactory(), SceneType.SHIPS_PLACING);
    }
}
