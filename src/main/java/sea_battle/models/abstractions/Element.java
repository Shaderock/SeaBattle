package sea_battle.models.abstractions;

public class Element implements Focusable
{
    private boolean isFocused;

    @Override
    public void onFocus()
    {
        isFocused = true;
    }

    @Override
    public void onUnFocus()
    {
        isFocused = false;
    }

    public boolean isFocused()
    {
        return isFocused;
    }
}
