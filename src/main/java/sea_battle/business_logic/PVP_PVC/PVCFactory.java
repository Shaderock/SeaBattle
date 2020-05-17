package sea_battle.business_logic.PVP_PVC;

import sea_battle.Context;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controllers.ControllerType;
import sea_battle.business_logic.controllers.IController;
import sea_battle.business_logic.controllers.OnInitializeListener;
import sea_battle.business_logic.controllers.game.PVCGameController;
import sea_battle.business_logic.controllers.placing.PVCPlacingController;
import sea_battle.business_logic.scene_changers.ISceneChanger;
import sea_battle.business_logic.scene_changers.InitializingSceneChanger;
import sea_battle.business_logic.scene_loaders.ISceneLoader;
import sea_battle.business_logic.scene_loaders.custom.PVCGameLoader;
import sea_battle.business_logic.scene_loaders.custom.PVCPlacingLoader;

public class PVCFactory extends Factory
{
    @Override
    public IController buildController(ControllerType controllerType)
    {
        switch (controllerType)
        {
            case GAME:
                return new PVCGameController();
            case PLACING:
                return new PVCPlacingController();
            default:
                return null;
        }
    }

    @Override
    public ISceneLoader buildSceneLoader(SceneType sceneType)
    {
        switch (sceneType)
        {
            case GAME:
                return new PVCGameLoader();
            case SHIPS_PLACING:
                return new PVCPlacingLoader();
            default:
                return null;
        }
    }

    @Override
    public ISceneChanger buildSceneChanger(SceneType sceneType)
    {
        InitializingSceneChanger initializingSceneChanger = getInitializingSceneChanger(sceneType);

        switch (sceneType)
        {
            case GAME:
                for (OnInitializeListener onInitializeListener : Context.getInstance().getOnInitializeListeners())
                {
                    if (onInitializeListener instanceof PVCGameController)
                    {
                        initializingSceneChanger.addOnInitializeListener(onInitializeListener);
                    }
                }
                break;
            case SHIPS_PLACING:
                for (OnInitializeListener onInitializeListener : Context.getInstance().getOnInitializeListeners())
                {
                    if (onInitializeListener instanceof PVCPlacingController)
                    {
                        initializingSceneChanger.addOnInitializeListener(onInitializeListener);
                    }
                }
                break;
            default:
                break;
        }

        return initializingSceneChanger;
    }
}
