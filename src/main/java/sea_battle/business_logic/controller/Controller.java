package sea_battle.business_logic.controller;

import javafx.scene.Parent;
import sea_battle.business_logic.scene_changer.ISceneChanger;

public class Controller implements IController
{
    private ISceneChanger sceneChanger;

    @Override
    public ISceneChanger getSceneChanger()
    {
        return sceneChanger;
    }

    @Override
    public Parent getRoot()
    {
        return sceneChanger.getRoot();
    }

    protected void setSceneChanger(ISceneChanger sceneChanger)
    {
        this.sceneChanger = sceneChanger;
    }
}
