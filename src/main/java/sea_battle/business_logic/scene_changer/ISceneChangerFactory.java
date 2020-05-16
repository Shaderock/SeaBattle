package sea_battle.business_logic.scene_changer;

public interface ISceneChangerFactory
{
    ISceneChanger buildSceneChanger(SceneChangerType sceneChangerType);
}
