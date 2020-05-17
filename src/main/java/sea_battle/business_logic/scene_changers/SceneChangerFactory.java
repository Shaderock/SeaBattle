package sea_battle.business_logic.scene_changers;

import sea_battle.Context;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_loaders.ISceneLoader;
import sea_battle.business_logic.scene_loaders.ISceneLoaderFactory;
import sea_battle.business_logic.scene_loaders.SceneLoaderFactory;

public class SceneChangerFactory implements ISceneChangerFactory
{
    private final ISceneLoaderFactory sceneLoaderFactory = new SceneLoaderFactory();

    public ISceneChanger buildSceneChanger(SceneType sceneType)
    {
        return createSceneChanger(sceneLoaderFactory.buildSceneLoader(sceneType));
    }

    private ISceneChanger createSceneChanger(ISceneLoader sceneLoader)
    {
        return new SceneChanger(Context.getStage(), sceneLoader);
    }
}
