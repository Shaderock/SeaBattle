package sea_battle.business_logic.scene_updater;

import javafx.scene.Parent;

public interface ISceneUpdater
{
    Parent update(Parent oldRoot, Parent newRoot);
}
