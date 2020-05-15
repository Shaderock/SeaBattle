package sea_battle.business_logic.controller;

public interface IControllerFactory
{
    IController buildPlacingController(ControllerType controllerType);
}
