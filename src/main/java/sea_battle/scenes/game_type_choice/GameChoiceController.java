package sea_battle.scenes.game_type_choice;

import javafx.scene.input.MouseEvent;
import sea_battle.Context;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.custom.CustomController;
import sea_battle.business_logic.controller.custom.OnInitializeListener;
import sea_battle.business_logic.controller.custom.ShipsPlacingController;
import sea_battle.business_logic.controller.fxml.FXMLController;
import sea_battle.business_logic.scene_changer.InitializingSceneChanger;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;
import sea_battle.business_logic.scene_changer.SceneChangerType;

import java.net.URL;
import java.util.ResourceBundle;

public class GameChoiceController extends FXMLController
{
    private InitializingSceneChanger initializingSceneChanger;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        super.initialize(location, resources);
        initializingSceneChanger = (InitializingSceneChanger) SceneChangerFactory.build(SceneChangerType.INITIALIZING);
    }

    public void moveToMainMenu(MouseEvent mouseEvent) throws Exception
    {
        getSceneChanger().setScene(SceneType.MAIN);
    }

    public void moveToPVP(MouseEvent mouseEvent) throws Exception
    {
        Context context = Context.getInstance();
        for (CustomController customController : context.getCustomControllers())
        {
            if (customController instanceof ShipsPlacingController)
            {
                initializingSceneChanger.addOnInitializeListener((OnInitializeListener) customController);
                break;
            }
        }
        initializingSceneChanger.setScene(SceneType.SHIPS_PLACING_PVP);
    }

    public void moveToPVC(MouseEvent mouseEvent) throws Exception
    {
//        setSceneChanger(SceneChangerFactory.build(SceneChangerType.INITIALIZING));
//        getSceneChanger().setScene(SceneType.SHIPS_PLACING_PVP);
    }
}
