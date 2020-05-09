package sea_battle.business_logic.scene_changer;

import sea_battle.Context;

public class SceneChangerFactory
{
    public static ISceneChanger build(SceneChangerType sceneChangerType)
    {
        switch (sceneChangerType)
        {
            case INITIALIZING:
                return new InitializingSceneChanger(new SceneChanger(Context.getStage()));
            default:
                return new SceneChanger(Context.getStage());
        }
    }
}
