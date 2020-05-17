package sea_battle.business_logic.game;

import java.awt.*;
import java.util.ArrayList;

public interface ShootActionListener
{
    void onShipPartHit(Point shipPart, PlayerNumber target);

    void onShipDestroyed(ArrayList<Point> shipParts, PlayerNumber target);

    void onMiss(Point tile, PlayerNumber target);

    void onNextTurn(PlayerNumber turn);

    void onGameOver(PlayerNumber winner);
}
