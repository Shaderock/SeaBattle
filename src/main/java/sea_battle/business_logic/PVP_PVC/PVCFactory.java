package sea_battle.business_logic.PVP_PVC;

import sea_battle.Context;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.ControllerType;
import sea_battle.business_logic.controller.IController;
import sea_battle.business_logic.controller.custom.CustomController;
import sea_battle.business_logic.controller.custom.OnInitializeListener;
import sea_battle.business_logic.controller.custom.game.PVCGameController;
import sea_battle.business_logic.controller.custom.game.PVPGameController;
import sea_battle.business_logic.controller.custom.placing.PVCPlacingController;
import sea_battle.business_logic.scene_changer.ISceneChanger;
import sea_battle.business_logic.scene_changer.InitializingSceneChanger;
import sea_battle.business_logic.scene_changer.SceneChangerType;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.business_logic.scene_loader.custom.PVCGameLoader;
import sea_battle.business_logic.scene_loader.custom.PVCPlacingLoader;

public class PVCFactory extends Factory
{
    @Override
    public IController buildController(ControllerType controllerType)
    {
        if (controllerType == ControllerType.PVC_PLACING)
        {
            PVCPlacingController pvcPlacingController = new PVCPlacingController();
            pvcPlacingController.setFactory(this);
            return pvcPlacingController;
        }
        else
        {
            return new PVCGameController();
        }
    }

    @Override
    public ISceneLoader buildSceneLoader(SceneType sceneType)
    {
        if (sceneType == SceneType.SHIPS_PLACING_PVC)
        {
            return new PVCPlacingLoader();
        }
        else
        {
            return new PVCGameLoader();
        }
    }

    @Override
    public ISceneChanger buildSceneChanger(SceneChangerType sceneChangerType)
    {
        InitializingSceneChanger initializingSceneChanger = getInitializingSceneChanger();

        for (CustomController customController : Context.getInstance().getCustomControllers())
        {
            if (customController instanceof PVPGameController)
            {
                initializingSceneChanger.addOnInitializeListener((OnInitializeListener) customController);
                break;
            }
        }

        return initializingSceneChanger;
    }
}
