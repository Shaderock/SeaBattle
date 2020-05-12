package sea_battle.business_logic.controller;

public interface IControllerFactory
{
    IController buildController(ControllerType controllerType);
}
