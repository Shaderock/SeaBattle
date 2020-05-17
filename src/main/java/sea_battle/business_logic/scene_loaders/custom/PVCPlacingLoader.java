package sea_battle.business_logic.scene_loaders.custom;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;

public class PVCPlacingLoader extends ShipsPlacingLoader
{
    @Override
    public Parent loadScene()
    {
        Pane root = (Pane) super.loadScene();

        Button nextBtn = (Button) NodeFinder.findNodeById(root, Constants.NEXT_BTN_ID);
        nextBtn.setText("Start game");

        return root;
    }
}
