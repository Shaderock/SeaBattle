package sea_battle.business_logic.utils;

import java.util.Arrays;

public class ArrayHandler
{
    public static boolean[][] deepCopy2DArray(boolean[][] original)
    {
        if (original == null)
        {
            return null;
        }

        final boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++)
        {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
