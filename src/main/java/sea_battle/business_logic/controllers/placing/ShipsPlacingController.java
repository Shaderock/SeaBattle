package sea_battle.business_logic.controllers.placing;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import sea_battle.business_logic.controllers.NavigationController;
import sea_battle.business_logic.utils.Converter;
import sea_battle.business_logic.utils.NodeFinder;
import sea_battle.models.Constants;
import sea_battle.models.Ship;

import java.util.ArrayList;

public abstract class ShipsPlacingController extends NavigationController
{
//    private IFactory factory;

    @Override
    public void onInitialize(Parent root)
    {
        super.onInitialize(root);

        Button randomizeButton = (Button) NodeFinder.findNodeById(root, Constants.RANDOMIZE_BTN_ID);
        randomizeButton.setOnMouseClicked(event ->
                randomizeBtnAction());

        Converter converter = new Converter();
        ArrayList<Ship> ships = converter.getShips(root);

        for (Ship ship : ships)
        {
            ship.setInitX(ship.getMinX());
            ship.setInitY(ship.getMinY());
        }
    }

    protected abstract void randomizeBtnAction();

//    public IFactory getFactory()
//    {
//        return factory;
//    }
//
//    public void setFactory(IFactory factory)
//    {
//        this.factory = factory;
//    }
}
