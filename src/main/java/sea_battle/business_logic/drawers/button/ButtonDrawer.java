package sea_battle.business_logic.drawers.button;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import sea_battle.business_logic.drawers.IDrawer;

public class ButtonDrawer implements IDrawer
{
    private String text;

    @Override
    public Node draw()
    {
        if (text == null)
        {
            throw new RuntimeException("Test should be given to draw a button");
        }
        Button button = new Button();

        button.setPrefHeight(50);
        button.setText(text);
        button.setFont(Font.font(24));

        return button;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
