package sea_battle.business_logic.scene_loader.custom;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.IDrawer;
import sea_battle.business_logic.drawers.ShipDrawer;
import sea_battle.business_logic.drawers.button.ButtonDrawer;
import sea_battle.business_logic.position_changer.NodeAligner;
import sea_battle.business_logic.position_changer.NodeAlignerFactory;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.models.Constants;

public class ShipsPlacingLoader
        implements ISceneLoader
{
    private ObservableList<Node> children;
    private Node battleArea;
    private Node homeButton;
    private Node rotateButton;
    private Button nextButton;

    @Override
    public Parent loadScene()
    {
        StackPane root = new StackPane();
        root.setPrefSize(Constants.SCENE_INIT_WIDTH, Constants.SCENE_INIT_HEIGHT);

        createNodes();
        addNodesToRoot(root);
        createShips(root);

        NodeAligner nodeAligner = (NodeAligner) NodeAlignerFactory.build();
        alignNodes(nodeAligner);
        marginNodes(nodeAligner);

        placeNodes();

        children = root.getChildren();

        return root;
    }

    public ObservableList<Node> getChildren()
    {
        return children;
    }

    private void alignNodes(NodeAligner nodeAligner)
    {
        nodeAligner.alignNode(homeButton, Pos.TOP_LEFT);
        nodeAligner.alignNode(rotateButton, Pos.BOTTOM_CENTER);
        nodeAligner.alignNode(nextButton, Pos.TOP_RIGHT);
    }

    private void marginNodes(NodeAligner nodeAligner)
    {
        nodeAligner.setNodeMargins(rotateButton);
        nodeAligner.setNodeMargins(homeButton);
        nodeAligner.setNodeMargins(nextButton);
    }

    private void placeNodes()
    {
        battleArea.setManaged(false);
        battleArea.setTranslateX(Constants.TILE_SIZE);
        battleArea.setTranslateY(Constants.TILE_SIZE * 2.5);
    }

    private void createNodes()
    {
        IDrawer battleAreaDrawer = DrawerFactory.build(DrawerType.BATTLE_AREA);
        IDrawer homeButtonDrawer = DrawerFactory.build(DrawerType.HOME_BUTTON);
        ButtonDrawer buttonDrawer = (ButtonDrawer) DrawerFactory.build(DrawerType.BUTTON);
        buttonDrawer.setText("Rotate");

        rotateButton = buttonDrawer.draw();
        buttonDrawer.setText("Next");
        nextButton = (Button) buttonDrawer.draw();

        battleArea = battleAreaDrawer.draw();
        homeButton = homeButtonDrawer.draw();

        homeButton.setId(Constants.HOME_BTN_ID);
        battleArea.setId(Constants.BATTLE_AREA_ID);
        rotateButton.setId(Constants.ROTATE_BTN_ID);
        nextButton.setId(Constants.NEXT_BTN_ID);
    }

    private void createShips(Pane root)
    {
        IDrawer shipDrawer = DrawerFactory.build(DrawerType.SHIP);

        ShipsDrawer shipsDrawer = new ShipsDrawer();
        shipsDrawer.setShipDrawer((ShipDrawer) shipDrawer);

        shipsDrawer.draw(root,
                battleArea.localToScene(battleArea.getBoundsInLocal()).getMaxX() + Constants.TILE_SIZE * 2,
                battleArea.localToScene(battleArea.getBoundsInLocal()).getMinY() + Constants.TILE_SIZE * 2.5);
    }

    private void addNodesToRoot(Pane root)
    {
        root.getChildren().add(homeButton);
        root.getChildren().add(battleArea);
        root.getChildren().add(rotateButton);
        root.getChildren().add(nextButton);
    }
}
