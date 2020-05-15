package sea_battle.business_logic.PVP_PVC;

import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.ControllerType;
import sea_battle.business_logic.controller.IController;
import sea_battle.business_logic.controller.custom.game.IGameController;
import sea_battle.business_logic.controller.custom.game.PVCGameController;
import sea_battle.business_logic.controller.custom.placing.PVCPlacingController;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.business_logic.scene_loader.custom.PVCPlacingLoader;

public class PVCFactory implements Factory
{
    @Override
    public IController buildPlacingController(ControllerType controllerType)
    {
        PVCPlacingController pvcPlacingController = new PVCPlacingController();
        pvcPlacingController.setFactory(this);
        return pvcPlacingController;
    }

    @Override
    public ISceneLoader buildSceneLoader(SceneType sceneType)
    {
        return new PVCPlacingLoader();
    }

    @Override
    public IGameController buildGameController()
    {
        return new PVCGameController();
    }
}
