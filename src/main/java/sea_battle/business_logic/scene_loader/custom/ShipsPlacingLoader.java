package sea_battle.business_logic.scene_loader.custom;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.IDrawer;
import sea_battle.business_logic.position_changer.NodeAligner;
import sea_battle.business_logic.position_changer.NodeAlignerFactory;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.models.Constants;

public class ShipsPlacingLoader implements ISceneLoader
{
    private ObservableList<Node> children;
    private Node battleArea;
    private Node homeButton;

    @Override
    public Parent loadScene()
    {
        StackPane root = new StackPane();
        root.setPrefSize(Constants.SCENE_INIT_WIDTH, Constants.SCENE_INIT_HEIGHT);

        createNodes();
        addNodesToRoot(root);

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
    }

    private void marginNodes(NodeAligner nodeAligner)
    {
        nodeAligner.setNodeMargins(homeButton);
    }

    private void placeNodes()
    {
        battleArea.setManaged(false);

        battleArea.relocate(Constants.TILE_SIZE, Constants.TILE_SIZE * 2.5);
    }

    private void createNodes()
    {
        IDrawer battleAreaDrawer = DrawerFactory.build(DrawerType.BATTLE_AREA);
        IDrawer homeButtonDrawer = DrawerFactory.build(DrawerType.HOME_BUTTON);
//        IDrawer shipDrawer = DrawerFactory.build(DrawerType.SHIP);

//        ShipsDrawer shipsDrawer = new ShipsDrawer();
//        shipsDrawer.setShipDrawer((ShipDrawer) shipDrawer);

        battleArea = battleAreaDrawer.draw();
        homeButton = homeButtonDrawer.draw();
//        shipsDrawer.draw(root);

        homeButton.setId(Constants.HOME_BTN_ID);
        battleArea.setId(Constants.BATTLE_AREA_ID);
    }

    private void addNodesToRoot(Pane root)
    {
        root.getChildren().add(battleArea);
        root.getChildren().add(homeButton);
    }
}
