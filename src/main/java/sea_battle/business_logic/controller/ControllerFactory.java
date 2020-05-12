package sea_battle.business_logic.controller;

import sea_battle.business_logic.controller.custom.GameController;

public class ControllerFactory implements IControllerFactory
{
    public IController buildController(ControllerType controllerType)
    {
        return new GameController();
    }
}
