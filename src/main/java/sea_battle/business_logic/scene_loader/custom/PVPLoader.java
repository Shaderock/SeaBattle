package sea_battle.business_logic.scene_loader.custom;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import sea_battle.business_logic.drawers.DrawerFactory;
import sea_battle.business_logic.drawers.DrawerType;
import sea_battle.business_logic.drawers.button.ButtonDrawer;
import sea_battle.business_logic.position_changer.INodeAligner;
import sea_battle.business_logic.position_changer.NodeAlignerFactory;

public class PVPLoader extends ShipsPlacingLoader
{
    @Override
    public Parent loadScene()
    {
        StackPane root = (StackPane) super.loadScene();

        ButtonDrawer buttonDrawer = (ButtonDrawer) DrawerFactory.build(DrawerType.BUTTON);
        INodeAligner nodeAligner = NodeAlignerFactory.build();

        buttonDrawer.setText("Next player");
        Button nextPlayerButton = (Button) buttonDrawer.draw();
        nextPlayerButton.relocate(600, 200);

        getChildren().add(nextPlayerButton);
        nodeAligner.alignNode(nextPlayerButton, Pos.TOP_RIGHT);
        nodeAligner.setNodeMargins(nextPlayerButton);

        return root;
    }
}
