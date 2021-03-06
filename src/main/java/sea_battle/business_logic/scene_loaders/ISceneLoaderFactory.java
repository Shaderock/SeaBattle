package sea_battle.business_logic.scene_loaders;

import sea_battle.business_logic.SceneType;

public interface ISceneLoaderFactory
{
    ISceneLoader buildSceneLoader(SceneType sceneType);
}
