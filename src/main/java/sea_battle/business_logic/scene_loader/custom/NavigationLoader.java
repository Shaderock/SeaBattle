package sea_battle.business_logic.scene_loader.custom;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.ButtonDrawer;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.position_changer.NodeAligner;
import sea_battle.business_logic.position_changer.NodeAlignerFactory;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.models.Constants;

public class NavigationLoader implements ISceneLoader
{
    private StackPane root;
    private Node homeButton;
    private Node nextButton;
    private final NodeAligner nodeAligner = (NodeAligner) NodeAlignerFactory.build();

    @Override
    public Parent loadScene()
    {
        root = new StackPane();
        root.setPrefSize(Constants.SCENE_INIT_WIDTH, Constants.SCENE_INIT_HEIGHT);

        createButtons();
        alignButtons();
        marginButtons();
        addButtonsToRoot();

        return root;
    }

    private void createButtons()
    {
        ButtonDrawer buttonDrawer = (ButtonDrawer) DrawerFactory.build(DrawerType.BUTTON);

        buttonDrawer.setText("Next");
        nextButton = buttonDrawer.draw();

        buttonDrawer.setText("Back to main menu");
        homeButton = buttonDrawer.draw();

        nextButton.setId(Constants.NEXT_BTN_ID);
        homeButton.setId(Constants.HOME_BTN_ID);
    }

    private void alignButtons()
    {
        nodeAligner.alignNode(homeButton, Pos.TOP_LEFT);
        nodeAligner.alignNode(nextButton, Pos.TOP_RIGHT);
    }

    private void marginButtons()
    {
        nodeAligner.setNodeMargins(homeButton);
        nodeAligner.setNodeMargins(nextButton);
    }

    private void addButtonsToRoot()
    {
        root.getChildren().add(homeButton);
        root.getChildren().add(nextButton);
    }

    public StackPane getRoot()
    {
        return root;
    }
}
