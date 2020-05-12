package sea_battle.business_logic.scene_changer;

import javafx.scene.Parent;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.scene_loader.ISceneLoaderFactory;

public interface ISceneChanger
{
    void setScene(SceneType sceneType) throws Exception;

    Parent getRoot();

    void setLoaderFactory(ISceneLoaderFactory loaderFactory);
}
