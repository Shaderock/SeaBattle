package sea_battle.business_logic.controllers;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.SceneType;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;

public abstract class NavigationController  // Template method
        extends Controller
        implements OnInitializeListener
{
    private Button nextButton;
    private Pane root;

    @Override
    public void onInitialize(Parent root)
    {
        this.root = (Pane) root;
        setHomeButton(root);
        setNextButton(root);
    }

    private void setNextButton(Parent root)
    {
        nextButton = (Button) NodeFinder.findNodeById(root, Constants.NEXT_BTN_ID);
        nextButton.setDisable(true);
        nextButton.setOnMouseClicked(event ->
                nextBtnAction());
    }

    protected abstract void nextBtnAction();

    protected void setHomeButton(Parent root)
    {
        Button homeButton = (Button) NodeFinder.findNodeById(root, Constants.HOME_BTN_ID);
        homeButton.setOnMouseClicked(event ->
                setFXMLScene(SceneType.MAIN));
    }

    protected Button getNextButton()
    {
        return nextButton;
    }

    public Pane getRoot()
    {
        return root;
    }
}
