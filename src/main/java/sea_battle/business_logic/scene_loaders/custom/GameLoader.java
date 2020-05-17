package sea_battle.business_logic.scene_loaders.custom;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import sea_battle.business_logic.drawers.BattleAreaDrawer;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.position_changer.INodeAligner;
import sea_battle.business_logic.position_changer.NodeAlignerFactory;
import sea_battle.models.Constants;

public class GameLoader extends NavigationLoader
{
    private Pane root;
    private Node battleArea1;
    private Group battleArea2;
    private Label winnerLabel;
    private Label turnLabel;
    private Label player1Label;
    private Label player2Label;

    @Override
    public Parent loadScene()
    {
        root = (Pane) super.loadScene();

        createBattleAreas();
        placeBattleAreas();
        addBattleAreasToRoot();

        createLabels();
        placeLabels();
        addLabelsToRoot();

        return root;
    }

    private void addLabelsToRoot()
    {
        root.getChildren().add(winnerLabel);
        root.getChildren().add(turnLabel);
        root.getChildren().add(player1Label);
        root.getChildren().add(player2Label);
    }

    private void placeLabels()
    {
        INodeAligner nodeAligner = NodeAlignerFactory.build();

        nodeAligner.alignNode(winnerLabel, Pos.TOP_CENTER);
        nodeAligner.setNodeMargins(winnerLabel);

        nodeAligner.alignNode(turnLabel, Pos.BOTTOM_CENTER);
        nodeAligner.setNodeMargins(turnLabel);

        nodeAligner.alignNode(player1Label, Pos.BOTTOM_LEFT);
        nodeAligner.setNodeMargins(player1Label);

        nodeAligner.alignNode(player2Label, Pos.BOTTOM_RIGHT);
        nodeAligner.setNodeMargins(player2Label);
    }

    private void createLabels()
    {
        winnerLabel = new Label();
        winnerLabel.setId(Constants.WINNER_LABEL_ID);
        winnerLabel.setFont(Font.font("System", 24));

        turnLabel = new Label();
        turnLabel.setId(Constants.TURN_LABEL_ID);
        turnLabel.setFont(Font.font("System", 60));

        player1Label = new Label();
        player1Label.setId(Constants.PLAYER1_LABEL_ID);
        player1Label.setFont(Font.font("System", 40));

        player2Label = new Label();
        player2Label.setId(Constants.PLAYER2_LABEL_ID);
        player2Label.setFont(Font.font("System", 40));
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
