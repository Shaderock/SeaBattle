package sea_battle.business_logic.controller;

import sea_battle.business_logic.controller.custom.ShipsPlacingController;

public class ControllerFactory
{
    public static IController build(ControllerType controllerType)
    {
        switch (controllerType)
        {
            default:
                return new ShipsPlacingController();
        }
    }
}
