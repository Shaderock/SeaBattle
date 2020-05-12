package sea_battle.business_logic.scene_changer;

import javafx.scene.Parent;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.controller.custom.OnInitializeListener;
import sea_battle.business_logic.scene_loader.ISceneLoaderFactory;

import java.util.ArrayList;

public class InitializingSceneChanger   // Proxy
        implements ISceneChanger,
        Initializer
{
    private final ArrayList<OnInitializeListener> onInitializeListeners;
    private final ISceneChanger sceneChanger;

    public InitializingSceneChanger(SceneChanger sceneChanger)
    {
        this.sceneChanger = sceneChanger;
        onInitializeListeners = new ArrayList<>();
    }

    @Override
    public void setScene(SceneType sceneType) throws Exception
    {
        sceneChanger.setScene(sceneType);

        for (OnInitializeListener onInitializeListener : onInitializeListeners)
        {
            onInitializeListener.onInitialize(getRoot());
        }
    }

    @Override
    public Parent getRoot()
    {
        return sceneChanger.getRoot();
    }

    @Override
    public void setLoaderFactory(ISceneLoaderFactory loaderFactory)
    {
        sceneChanger.setLoaderFactory(loaderFactory);
    }

    public void addOnInitializeListener(OnInitializeListener onInitializeListener)
    {
        onInitializeListeners.add(onInitializeListener);
    }
}
