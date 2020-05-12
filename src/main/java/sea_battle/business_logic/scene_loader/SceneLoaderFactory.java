package sea_battle.business_logic.scene_loader;

import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_loader.custom.PVPLoader;
import sea_battle.business_logic.scene_loader.fxml.GameChoiceLoader;
import sea_battle.business_logic.scene_loader.fxml.MainSceneLoader;
import sea_battle.business_logic.scene_loader.fxml.SettingsSceneLoader;

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
            case SHIPS_PLACING_PVP:
                return new PVPLoader();
            default:
                return new MainSceneLoader();
        }
    }
}
