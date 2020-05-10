package sea_battle.business_logic.utils;

import javafx.scene.Node;
import javafx.scene.Parent;

public class NodeFinder
{
    public static Node findNodeById(Parent root, String id)
    {
        return root.lookup("#" + id);
    }
}
