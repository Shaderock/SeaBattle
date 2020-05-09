package sea_battle.business_logic.scene_loader.custom;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.*;
import sea_battle.business_logic.position_changer.NodeLocator;
import sea_battle.business_logic.position_changer.NodeLocatorFactory;
import sea_battle.business_logic.position_changer.NodeLocatorType;
import sea_battle.business_logic.scene_loader.ISceneLoader;
import sea_battle.models.Constants;

public class ShipsPlacingLoader implements ISceneLoader
{
    @Override
    public Parent loadScene()
    {
        StackPane root = new StackPane();
        root.setPrefSize(Constants.SCENE_INIT_WIDTH, Constants.SCENE_INIT_HEIGHT);
        IDrawer battleAreaDrawer = DrawerFactory.build(DrawerType.BATTLE_AREA);
        IDrawer homeButtonDrawer = DrawerFactory.build(DrawerType.HOME_BUTTON);
        IDrawer shipDrawer = DrawerFactory.build(DrawerType.SHIP);

        ShipsToPlaceDrawer shipsToPlaceDrawer = (ShipsToPlaceDrawer) DrawerFactory.build(DrawerType.SHIPS_TO_PLACE);
        shipsToPlaceDrawer.setShipDrawer((ShipDrawer) shipDrawer);

        Node battleArea = battleAreaDrawer.draw();
        Node homeButton = homeButtonDrawer.draw();
        Node ships = shipsToPlaceDrawer.draw();

        homeButton.setId(Constants.HOME_BTN_ID);

        root.getChildren().add(battleArea);
        root.getChildren().add(homeButton);
        root.getChildren().add(ships);

        NodeLocator nodeLocator = (NodeLocator) NodeLocatorFactory.build(NodeLocatorType.SHIPS_PLACING);
        nodeLocator.setBattleArea((Group) battleArea);
        nodeLocator.setButton((Button) homeButton);
        nodeLocator.setShips((Group) ships);
        nodeLocator.placeNodes();

//        homeButton.setOnMouseClicked(event ->
//        {
//
//        });

        return root;
    }
}
