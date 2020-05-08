package sea_battle.business_logic.scene_loader;

import sea_battle.business_logic.SceneType;

public class SceneLoaderFactory
{
    public static ISceneLoader build(SceneType sceneType)
    {
        switch (sceneType)
        {
            case SETTINGS:
                return new SettingsSceneLoader();
            case GAME_TYPE_CHOICE:
                return new GameChoiceLoader();
            case SHIPS_PLACING_PVP:
                return new ShipsPlacingLoader();
            default:
                return new MainSceneLoader();
        }
    }
}
