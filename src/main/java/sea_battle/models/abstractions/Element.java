package sea_battle.models.abstractions;

public interface Element
        extends HighLightable
{
    void onHighLight();

    @Override
    void onUnHighLight();

    boolean isHighLighted();
}
