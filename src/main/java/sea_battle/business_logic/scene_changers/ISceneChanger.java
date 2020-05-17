package sea_battle.business_logic.scene_changers;

import javafx.scene.Parent;

public interface ISceneChanger
{
    void setScene() throws Exception;

    Parent getRoot();
}
