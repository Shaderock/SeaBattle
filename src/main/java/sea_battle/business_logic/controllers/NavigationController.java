package sea_battle.business_logic.controllers;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;

public abstract class NavigationController  // Template method
        extends Controller
        implements OnInitializeListener
{
    @Override
    public void onInitialize(Parent root)
    {
        setHomeButton(root);
        setNextButton(root);
    }

    private void setNextButton(Parent root)
    {
        Button nextBtn = (Button) NodeFinder.findNodeById(root, Constants.NEXT_BTN_ID);
        nextBtn.setDisable(true);
        nextBtn.setOnMouseClicked(event ->
                nextBtnAction());
    }

    protected abstract void nextBtnAction();

    protected void setHomeButton(Parent root)
    {
        Node homeButton = NodeFinder.findNodeById(root, Constants.HOME_BTN_ID);
        homeButton.setOnMouseClicked(event ->
                setFXMLScene(SceneType.MAIN));
    }
}
