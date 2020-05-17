package sea_battle.business_logic.scene_loaders.custom;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;

public class PVPGameLoader extends GameLoader
{
    @Override
    public Parent loadScene()
    {
        Pane root = (Pane) super.loadScene();

        Label player1Label = (Label) NodeFinder.findNodeById(root, Constants.PLAYER1_LABEL_ID);
        player1Label.setText("Player ONE");
        Label player2Label = (Label) NodeFinder.findNodeById(root, Constants.PLAYER2_LABEL_ID);
        player2Label.setText("Player TWO");

        return root;
    }
}
