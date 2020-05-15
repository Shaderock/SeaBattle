package sea_battle.business_logic.scene_loader.custom;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.ButtonDrawer;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.IDrawer;
import sea_battle.business_logic.drawers.ships.ShipDrawer;
import sea_battle.business_logic.drawers.ships.ShipsDrawer;
import sea_battle.business_logic.position_changer.NodeAligner;
import sea_battle.business_logic.position_changer.NodeAlignerFactory;
import sea_battle.models.Constants;

public class ShipsPlacingLoader
        extends NavigationLoader
{
    private Node battleArea;
    private Node rotateButton;

    @Override
    public Parent loadScene()
    {
        super.loadScene();
        StackPane root = getRoot();

        createNodes();
        addNodesToRoot(root);
        createShips(root);

        NodeAligner nodeAligner = (NodeAligner) NodeAlignerFactory.build();
        alignNodes(nodeAligner);
        marginNodes(nodeAligner);

        placeNodes();

        return root;
    }

    private void alignNodes(NodeAligner nodeAligner)
    {
        nodeAligner.alignNode(rotateButton, Pos.BOTTOM_CENTER);
    }

    private void marginNodes(NodeAligner nodeAligner)
    {
        nodeAligner.setNodeMargins(rotateButton);
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
        battleArea = battleAreaDrawer.draw();
        battleArea.setId(Constants.BATTLE_AREA_ID);

        ButtonDrawer buttonDrawer = (ButtonDrawer) DrawerFactory.build(DrawerType.BUTTON);
        buttonDrawer.setText("Rotate");
        rotateButton = buttonDrawer.draw();
        rotateButton.setId(Constants.ROTATE_BTN_ID);
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
//        root.getChildren().add(homeButton);
        root.getChildren().add(battleArea);
        root.getChildren().add(rotateButton);
//        root.getChildren().add(nextButton);
    }

//    protected StackPane getRoot()
//    {
//        return root;
//    }
}
