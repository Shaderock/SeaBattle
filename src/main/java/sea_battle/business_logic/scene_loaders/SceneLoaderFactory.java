package sea_battle.business_logic.scene_loaders;

import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_loaders.fxml.GameChoiceLoader;
import sea_battle.business_logic.scene_loaders.fxml.MainSceneLoader;
import sea_battle.business_logic.scene_loaders.fxml.SettingsSceneLoader;

public class SceneLoaderFactory implements ISceneLoaderFactory
{
    public ISceneLoader buildSceneLoader(SceneType sceneType)
    {
        switch (sceneType)
        {
            case SETTINGS:
                return new SettingsSceneLoader();
            case GAME_TYPE_CHOICE:
                return new GameChoiceLoader();
            case MAIN:
                return new MainSceneLoader();
            default:
                return null;
        }
    }
}
