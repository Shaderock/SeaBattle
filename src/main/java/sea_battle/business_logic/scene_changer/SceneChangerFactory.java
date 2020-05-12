package sea_battle.business_logic.scene_changer;

import sea_battle.Context;

public class SceneChangerFactory
{
    public static ISceneChanger build(SceneChangerType sceneChangerType)
    {
        if (sceneChangerType == SceneChangerType.INITIALIZING)
        {
            return new InitializingSceneChanger(new SceneChanger(Context.getStage()));
        }
        return new SceneChanger(Context.getStage());
    }
}
