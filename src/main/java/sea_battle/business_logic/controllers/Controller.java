package sea_battle.business_logic.controllers;

import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_changers.ISceneChanger;
import sea_battle.business_logic.scene_changers.ISceneChangerFactory;
import sea_battle.business_logic.scene_changers.SceneChangerFactory;

public class Controller implements IController
{
    @Override
    public void setScene(ISceneChangerFactory sceneChangerFactory, SceneType sceneType)
    {
        ISceneChanger sceneChanger = sceneChangerFactory.buildSceneChanger(sceneType);
        try
        {
            sceneChanger.setScene();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected void setFXMLScene(SceneType gameTypeChoice)
    {
        setScene(new SceneChangerFactory(), gameTypeChoice);
    }
}
