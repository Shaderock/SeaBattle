package sea_battle.business_logic.utils;

import javafx.scene.input.MouseEvent;
import sea_battle.models.abstractions.Accessible;

public class ElementHandler
{
    public static boolean eventInsideElementArea(Accessible accessibleElement, MouseEvent mouseEvent)
    {
        return mouseEvent.getX() > accessibleElement.getMinX() &&
                mouseEvent.getX() < accessibleElement.getMaxX() &&
                mouseEvent.getY() > accessibleElement.getMinY() &&
                mouseEvent.getY() < accessibleElement.getMaxY();
    }
}
