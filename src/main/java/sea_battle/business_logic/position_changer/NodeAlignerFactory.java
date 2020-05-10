package sea_battle.business_logic.position_changer;

public class NodeAlignerFactory
{
    public static INodeAligner build()
    {
        return new NodeAligner();
    }
}
