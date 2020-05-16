package sea_battle.business_logic.PVP_PVC;

import sea_battle.business_logic.controller.IControllerFactory;
import sea_battle.business_logic.scene_changer.ISceneChangerFactory;
import sea_battle.business_logic.scene_loader.ISceneLoaderFactory;

public interface IFactory    // Abstract factory
        extends ISceneLoaderFactory,
        IControllerFactory,
        ISceneChangerFactory
{
}
