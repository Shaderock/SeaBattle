package sea_battle.business_logic.scene_changers;

import javafx.scene.Parent;
import sea_battle.business_logic.controllers.OnInitializeListener;

import java.util.ArrayList;

public class InitializingSceneChanger   // Proxy
        implements ISceneChanger,
        Initializer
{
    private final ArrayList<OnInitializeListener> onInitializeListeners;
    private final ISceneChanger sceneChanger;

    public InitializingSceneChanger(ISceneChanger sceneChanger)
    {
        this.sceneChanger = sceneChanger;
        onInitializeListeners = new ArrayList<>();
    }

    @Override
    public void setScene() throws Exception
    {
        sceneChanger.setScene();

        for (OnInitializeListener onInitializeListener : onInitializeListeners)
        {
            onInitializeListener.onInitialize(sceneChanger.getRoot());
        }
    }

    @Override
    public Parent getRoot()
    {
        return sceneChanger.getRoot();
    }

    public void addOnInitializeListener(OnInitializeListener onInitializeListener)
    {
        onInitializeListeners.add(onInitializeListener);
    }
}
