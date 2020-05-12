package sea_battle.business_logic.scene_loader;

import javafx.scene.Parent;

import java.io.IOException;

public interface ISceneLoader   // Strategy
{
    Parent loadScene() throws IOException;
}
