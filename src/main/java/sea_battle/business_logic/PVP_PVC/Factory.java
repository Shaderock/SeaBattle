package sea_battle.business_logic.PVP_PVC;

import sea_battle.business_logic.controller.IControllerFactory;
import sea_battle.business_logic.scene_loader.ISceneLoaderFactory;

public interface Factory
        extends ISceneLoaderFactory,
        IControllerFactory
{
}
