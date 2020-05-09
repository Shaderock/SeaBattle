package sea_battle.business_logic.position_changer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import sea_battle.models.Constants;

public class NodeLocator implements INodeLocator
{
    private Button button;
    private Group battleArea;
    private Group ships;

    @Override
    public void placeNodes()
    {
        if (button == null || battleArea == null)
        {
            throw new RuntimeException("Home button, battle area and ships should be injected");
        }

        StackPane.setAlignment(battleArea, Pos.CENTER_LEFT);
        StackPane.setAlignment(button, Pos.TOP_LEFT);
        StackPane.setAlignment(ships, Pos.CENTER_RIGHT);

        setMargin(button);
        setMargin(battleArea);
        setMargin(ships);
    }

    private void setMargin(Node node)
    {
        double margin = (double) Constants.SCENE_INIT_WIDTH / 100;
        StackPane.setMargin(node, new Insets(margin));
    }

    public void setButton(Button button)
    {
        this.button = button;
    }

    public void setBattleArea(Group battleArea)
    {
        this.battleArea = battleArea;
    }

    public void setShips(Group ships)
    {
        this.ships = ships;
    }
}
