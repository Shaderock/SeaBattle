package sea_battle.models.abstractions;

public interface Element
        extends Highlightable
{
    void onHighlight();

    @Override
    void onUnHighlight();

    boolean isHighlighted();
}
