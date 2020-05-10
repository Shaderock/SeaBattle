package sea_battle.business_logic.position_changer;

import javafx.geometry.Pos;
import javafx.scene.Node;

public interface INodeAligner
{
    void alignNode(Node node, Pos pos);

    void setNodeMargins(Node node);
}
