package sea_battle.business_logic.position_changer;

public class NodeLocatorFactory
{
    public static INodeLocator build(NodeLocatorType nodeLocatorType)
    {
        return new NodeLocator();
    }
}
