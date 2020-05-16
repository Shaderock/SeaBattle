package sea_battle.business_logic.PVP_PVC;

import sea_battle.business_logic.scene_changer.ISceneChangerFactory;
import sea_battle.business_logic.scene_changer.InitializingSceneChanger;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;
import sea_battle.business_logic.scene_changer.SceneChangerType;

public abstract class Factory implements IFactory
{
    protected InitializingSceneChanger getInitializingSceneChanger()
    {
        ISceneChangerFactory sceneChangerFactory = new SceneChangerFactory();
        InitializingSceneChanger initializingSceneChanger =
                (InitializingSceneChanger) sceneChangerFactory.buildSceneChanger(SceneChangerType.INITIALIZING);
        initializingSceneChanger.setLoaderFactory(this);
        return initializingSceneChanger;
    }
}
