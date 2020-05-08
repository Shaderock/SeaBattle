package sea_battle.business_logic.position_changer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import sea_battle.models.Constants;

public class NodeLocator implements INodeLocator
{
    private Button button;
    private Group battleArea;

    @Override
    public void placeNodes()
    {
        if (button == null || battleArea == null)
        {
            throw new RuntimeException("Button and Group should be injected");
        }
        StackPane.setAlignment(battleArea, Pos.CENTER);
        StackPane.setAlignment(button, Pos.TOP_LEFT);
        StackPane.setMargin(button,
                new Insets((double) Constants.SCENE_INIT_WIDTH / 100,
                        0,
                        0,
                        (double) Constants.SCENE_INIT_WIDTH / 100));
    }

    public void setButton(Button button)
    {
        this.button = button;
    }

    public void setBattleArea(Group battleArea)
    {
        this.battleArea = battleArea;
    }
}
