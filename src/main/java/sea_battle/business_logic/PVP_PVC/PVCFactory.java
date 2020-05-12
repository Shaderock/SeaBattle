package sea_battle.business_logic.PVP_PVC;

import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.ControllerType;
import sea_battle.business_logic.controller.IController;
import sea_battle.business_logic.controller.custom.PVCController;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.business_logic.scene_loader.custom.PVCLoader;

public class PVCFactory implements Factory
{
    @Override
    public IController buildController(ControllerType controllerType)
    {
        return new PVCController();
    }

    @Override
    public ISceneLoader buildSceneLoader(SceneType sceneType)
    {
        return new PVCLoader();
    }
}
