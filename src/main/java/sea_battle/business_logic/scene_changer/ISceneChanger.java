package sea_battle.business_logic.scene_changer;

import javafx.scene.Parent;
import sea_battle.business_logic.SceneType;

public interface ISceneChanger
{
    void setScene(SceneType sceneType) throws Exception;

    Parent getRoot();
}
