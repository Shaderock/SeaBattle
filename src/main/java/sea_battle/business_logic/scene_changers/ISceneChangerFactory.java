package sea_battle.business_logic.scene_changers;

import sea_battle.business_logic.SceneType;

public interface ISceneChangerFactory
{
    ISceneChanger buildSceneChanger(SceneType sceneType);
}
