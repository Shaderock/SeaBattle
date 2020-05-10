package sea_battle.business_logic.scene_loader.custom;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.*;
import sea_battle.business_logic.position_changer.NodeAligner;
import sea_battle.business_logic.position_changer.NodeAlignerFactory;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.models.Constants;

public class ShipsPlacingLoader implements ISceneLoader
{
    private ObservableList<Node> children;
    private Node battleArea;
    private Node homeButton;
    private Node ships;

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

        children = root.getChildren();
        return root;
    }

    public ObservableList<Node> getChildren()
    {
        return children;
    }

    private void alignNodes(NodeAligner nodeAligner)
    {
        nodeAligner.alignNode(battleArea, Pos.CENTER_LEFT);
        nodeAligner.alignNode(homeButton, Pos.TOP_LEFT);
        nodeAligner.alignNode(ships, Pos.CENTER_RIGHT);
    }

    private void marginNodes(NodeAligner nodeAligner)
    {
        nodeAligner.setNodeMargins(battleArea);
        nodeAligner.setNodeMargins(homeButton);
        nodeAligner.setNodeMargins(ships);
    }


    private void createNodes()
    {
        IDrawer battleAreaDrawer = DrawerFactory.build(DrawerType.BATTLE_AREA);
        IDrawer homeButtonDrawer = DrawerFactory.build(DrawerType.HOME_BUTTON);
        IDrawer shipDrawer = DrawerFactory.build(DrawerType.SHIP);

        ShipsToPlaceDrawer shipsToPlaceDrawer = (ShipsToPlaceDrawer) DrawerFactory.build(DrawerType.SHIPS_TO_PLACE);
        shipsToPlaceDrawer.setShipDrawer((ShipDrawer) shipDrawer);

        battleArea = battleAreaDrawer.draw();
        homeButton = homeButtonDrawer.draw();
        ships = shipsToPlaceDrawer.draw();

        homeButton.setId(Constants.HOME_BTN_ID);
        battleArea.setId(Constants.BATTLE_AREA_ID);
        ships.setId(Constants.SHIPS_ID);
    }

    private void addNodesToRoot(StackPane root)
    {
        root.getChildren().add(battleArea);
        root.getChildren().add(homeButton);
        root.getChildren().add(ships);
    }
}
