package sea_battle.business_logic.PVP_PVC;

import sea_battle.Context;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controllers.ControllerType;
import sea_battle.business_logic.controllers.IController;
import sea_battle.business_logic.controllers.OnInitializeListener;
import sea_battle.business_logic.controllers.game.PVPGameController;
import sea_battle.business_logic.controllers.placing.PVPPlacingController;
import sea_battle.business_logic.scene_changers.ISceneChanger;
import sea_battle.business_logic.scene_changers.InitializingSceneChanger;
import sea_battle.business_logic.scene_loaders.ISceneLoader;
import sea_battle.business_logic.scene_loaders.custom.PVPGameLoader;
import sea_battle.business_logic.scene_loaders.custom.PVPPlacingLoader;

public class PVPFactory extends Factory
{
    @Override
    public IController buildController(ControllerType controllerType)
    {
        switch (controllerType)
        {
            case GAME:
                return new PVPGameController();
            case PLACING:
                return new PVPPlacingController();
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
                return new PVPGameLoader();
            case SHIPS_PLACING:
                return new PVPPlacingLoader();
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
                    if (onInitializeListener instanceof PVPGameController)
                    {
                        initializingSceneChanger.addOnInitializeListener(onInitializeListener);
                    }
                }
                break;
            case SHIPS_PLACING:
                for (OnInitializeListener onInitializeListener : Context.getInstance().getOnInitializeListeners())
                {
                    if (onInitializeListener instanceof PVPPlacingController)
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
