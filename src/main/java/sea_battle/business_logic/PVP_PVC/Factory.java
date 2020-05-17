package sea_battle.business_logic.PVP_PVC;

import sea_battle.Context;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_changers.ISceneChanger;
import sea_battle.business_logic.scene_changers.InitializingSceneChanger;
import sea_battle.business_logic.scene_changers.SceneChanger;
import sea_battle.business_logic.scene_loaders.ISceneLoader;

public abstract class Factory implements IFactory
{
    protected InitializingSceneChanger getInitializingSceneChanger(SceneType sceneType)
    {
        return new InitializingSceneChanger(createSceneChanger(buildSceneLoader(sceneType)));
    }

    private ISceneChanger createSceneChanger(ISceneLoader sceneLoader)
    {
        return new SceneChanger(Context.getStage(), sceneLoader);
    }
}
