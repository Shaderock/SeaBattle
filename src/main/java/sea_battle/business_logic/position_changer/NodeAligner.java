package sea_battle.business_logic.position_changer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import sea_battle.models.Constants;

public class NodeAligner implements INodeAligner
{
    @Override
    public void alignNode(Node node, Pos pos)
    {
        StackPane.setAlignment(node, pos);
    }

    public void setNodeMargins(Node node)
    {
        double margin = (double) Constants.SCENE_INIT_WIDTH / 100;
        StackPane.setMargin(node, new Insets(margin));
    }
}
