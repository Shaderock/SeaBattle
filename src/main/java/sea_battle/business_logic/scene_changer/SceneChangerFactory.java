package sea_battle.business_logic.scene_changer;

import sea_battle.Context;

public class SceneChangerFactory implements ISceneChangerFactory
{
    public ISceneChanger buildSceneChanger(SceneChangerType sceneChangerType)
    {
        if (sceneChangerType == SceneChangerType.INITIALIZING)
        {
            return new InitializingSceneChanger(createSceneChanger());
        }
        return createSceneChanger();
    }

    private ISceneChanger createSceneChanger()
    {
        return new SceneChanger(Context.getStage());
    }
}
