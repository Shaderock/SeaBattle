package sea_battle.scenes.game_type_choice;

import javafx.scene.input.MouseEvent;
import sea_battle.Context;
import sea_battle.business_logic.PVP_PVC.PVCFactory;
import sea_battle.business_logic.PVP_PVC.PVPFactory;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.custom.CustomController;
import sea_battle.business_logic.controller.custom.OnInitializeListener;
import sea_battle.business_logic.controller.custom.placing.PVCPlacingController;
import sea_battle.business_logic.controller.custom.placing.PVPPlacingController;
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
        SceneChangerFactory sceneChangerFactory = new SceneChangerFactory();
        initializingSceneChanger = (InitializingSceneChanger) sceneChangerFactory
                .buildSceneChanger(SceneChangerType.INITIALIZING);
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
            if (customController instanceof PVPPlacingController)
            {
                initializingSceneChanger.addOnInitializeListener((OnInitializeListener) customController);
                break;
            }
        }

        initializingSceneChanger.setLoaderFactory(new PVPFactory());
        initializingSceneChanger.setScene(SceneType.SHIPS_PLACING_PVP);
    }

    public void moveToPVC(MouseEvent mouseEvent) throws Exception
    {
        Context context = Context.getInstance();
        for (CustomController customController : context.getCustomControllers())
        {
            if (customController instanceof PVCPlacingController)
            {
                initializingSceneChanger.addOnInitializeListener((OnInitializeListener) customController);
                break;
            }
        }

        initializingSceneChanger.setLoaderFactory(new PVCFactory());
        initializingSceneChanger.setScene(SceneType.SHIPS_PLACING_PVC);
    }
}
