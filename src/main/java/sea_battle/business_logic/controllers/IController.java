package sea_battle.business_logic.controllers;

import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_changers.ISceneChangerFactory;

public interface IController
{
    void setScene(ISceneChangerFactory sceneChangerFactory, SceneType sceneType);
}
