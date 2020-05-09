package sea_battle.business_logic.controller.custom;

import javafx.scene.Node;
import javafx.scene.Parent;
import sea_battle.business_logic.SceneType;
import sea_battle.models.Constants;

public class ShipsPlacingController
        extends CustomController
        implements OnInitializeListener
{
    public ShipsPlacingController()
    {
    }

    @Override
    public void onInitialize(Parent root)
    {
        Node homeButton = findNodeById(root, Constants.HOME_BTN_ID);
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
    }
}
