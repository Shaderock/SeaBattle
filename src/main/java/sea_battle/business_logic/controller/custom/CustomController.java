package sea_battle.business_logic.controller.custom;

import sea_battle.business_logic.controller.Controller;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;
import sea_battle.business_logic.scene_changer.SceneChangerType;

public class CustomController extends Controller
{
    public CustomController()
    {
        setSceneChanger(SceneChangerFactory.build(SceneChangerType.DEFAULT));
    }
}
