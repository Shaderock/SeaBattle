package sea_battle.business_logic.drawers;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class HomeButtonDrawer implements IDrawer
{
    @Override
    public Node draw()
    {
        Button homeButton = new Button();

        homeButton.setPrefHeight(50);
        homeButton.setText("Back to main menu");
        homeButton.setFont(Font.font(24));

        return homeButton;
    }
}
