package sea_battle.business_logic.controllers;

public interface IControllerFactory
{
    IController buildController(ControllerType controllerType);
}
