package sea_battle.business_logic.controller.custom;

import javafx.scene.Node;
import javafx.scene.Parent;
import sea_battle.business_logic.controller.Controller;
import sea_battle.business_logic.scene_changer.SceneChangerFactory;
import sea_battle.business_logic.scene_changer.SceneChangerType;

public class CustomController extends Controller
{
    public CustomController()
    {
        setSceneChanger(SceneChangerFactory.build(SceneChangerType.DEFAULT));
    }

    protected Node findNodeById(Parent root, String id)
    {
        return root.lookup("#" + id);
    }
}
