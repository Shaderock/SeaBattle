package sea_battle.business_logic.controller;

import javafx.scene.Parent;
import sea_battle.business_logic.scene_changer.ISceneChanger;

public interface IController
{
    ISceneChanger getSceneChanger();

    Parent getRoot();
}
