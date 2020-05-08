package sea_battle.business_logic.scene_changer;

import sea_battle.business_logic.SceneType;

public interface ISceneChanger
{
    void setScene(SceneType sceneType) throws Exception;
}
