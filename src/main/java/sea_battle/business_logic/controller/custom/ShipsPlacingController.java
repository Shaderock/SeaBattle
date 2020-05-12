package sea_battle.business_logic.controller.custom;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;

public abstract class ShipsPlacingController    // Template method
        extends CustomController
        implements OnInitializeListener
{
    @Override
    public void onInitialize(Parent root)
    {
        Node homeButton = NodeFinder.findNodeById(root, Constants.HOME_BTN_ID);
        homeButton.setOnMouseClicked(event ->
        {
            try
            {
                getSceneChanger().setScene(SceneType.MAIN);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });

        Button nextBtn = (Button) NodeFinder.findNodeById(root, Constants.NEXT_BTN_ID);
        nextBtn.setDisable(true);
        nextBtn.setOnMouseClicked(event ->
                nextBtnAction());
    }

    protected abstract void nextBtnAction();
}
