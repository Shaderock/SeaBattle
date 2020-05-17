package sea_battle.business_logic.scene_loader.custom;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import sea_battle.business_logic.drawers.BattleAreaDrawer;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.models.Constants;

public class GameLoader extends NavigationLoader
{
    private Pane root;
    private Node battleArea1;
    private Group battleArea2;

    @Override
    public Parent loadScene()
    {
        root = (Pane) super.loadScene();

        createBattleAreas();
        placeBattleAreas();
        addBattleAreasToRoot();

        return root;
    }

    private void createBattleAreas()
    {
        BattleAreaDrawer battleAreaDrawer = (BattleAreaDrawer) DrawerFactory.build(DrawerType.BATTLE_AREA);
        battleAreaDrawer.setTileType(DrawerType.GAME_TILE);

        battleArea1 = battleAreaDrawer.draw();
        battleArea2 = (Group) battleAreaDrawer.draw();

        battleArea1.setId(Constants.PLAYING_BATTLE_AREA1_ID);
        battleArea2.setId(Constants.PLAYING_BATTLE_AREA2_ID);
    }

    private void placeBattleAreas()
    {
        battleArea1.setManaged(false);
        battleArea1.relocate(Constants.TILE_SIZE, Constants.TILE_SIZE * 2.5);

        battleArea2.setManaged(false);
        battleArea2.relocate(Constants.SCENE_INIT_WIDTH - Constants.TILE_SIZE -
                        Constants.TILE_SIZE * 10, Constants.TILE_SIZE * 2.5);
    }

    private void addBattleAreasToRoot()
    {
        root.getChildren().add(battleArea1);
        root.getChildren().add(battleArea2);
    }
}
