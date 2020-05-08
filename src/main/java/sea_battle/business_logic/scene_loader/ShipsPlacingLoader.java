package sea_battle.business_logic.scene_loader;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.IDrawer;
import sea_battle.business_logic.position_changer.NodeLocator;
import sea_battle.business_logic.position_changer.NodeLocatorFactory;
import sea_battle.business_logic.position_changer.NodeLocatorType;
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

        Group battleArea = (Group) battleAreaDrawer.draw();
        Button homeButton = (Button) homeButtonDrawer.draw();

        root.getChildren().add(battleArea);
        root.getChildren().add(homeButton);

        NodeLocator nodeLocator = (NodeLocator) NodeLocatorFactory.build(NodeLocatorType.SHIPS_PLACING);
        nodeLocator.setBattleArea(battleArea);
        nodeLocator.setButton(homeButton);
        nodeLocator.placeNodes();

//        homeButton.setOnMouseClicked(event ->
//        {
//
//        });

        return root;
    }
}
