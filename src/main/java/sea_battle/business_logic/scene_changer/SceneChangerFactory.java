package sea_battle.business_logic.scene_changer;

import sea_battle.Context;

public class SceneChangerFactory
{
    public static SceneChanger build()
    {
        return new SceneChanger(Context.getStage());
    }
}
