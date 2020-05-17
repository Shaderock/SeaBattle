package sea_battle.business_logic.PVP_PVC;

import sea_battle.business_logic.controllers.IControllerFactory;
import sea_battle.business_logic.scene_changers.ISceneChangerFactory;
import sea_battle.business_logic.scene_loaders.ISceneLoaderFactory;

public interface IFactory    // Abstract factory
        extends ISceneLoaderFactory,
        IControllerFactory,
        ISceneChangerFactory
{
}
