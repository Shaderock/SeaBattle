package sea_battle.business_logic.PVP_PVC;

import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.ControllerType;
import sea_battle.business_logic.controller.IController;
import sea_battle.business_logic.controller.custom.game.IGameController;
import sea_battle.business_logic.controller.custom.game.PVPGameController;
import sea_battle.business_logic.controller.custom.placing.PVPPlacingController;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.business_logic.scene_loader.custom.PVPGameLoader;
import sea_battle.business_logic.scene_loader.custom.PVPPlacingLoader;

public class PVPFactory implements Factory
{
    @Override
    public IController buildPlacingController(ControllerType controllerType)
    {
        PVPPlacingController pvpPlacingController = new PVPPlacingController();
        pvpPlacingController.setFactory(this);
        return pvpPlacingController;
    }

    @Override
    public ISceneLoader buildSceneLoader(SceneType sceneType)
    {
        if (sceneType == SceneType.SHIPS_PLACING_PVP)
        {
            return new PVPPlacingLoader();
        }
        else
        {
            return new PVPGameLoader();
        }
    }

    @Override
    public IGameController buildGameController()
    {
        return new PVPGameController();
    }
}
