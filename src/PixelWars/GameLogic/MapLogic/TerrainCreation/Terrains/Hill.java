package PixelWars.GameLogic.MapLogic.TerrainCreation.Terrains;

import javafx.scene.paint.Color;

public class Hill extends Terrain {
    protected Color myColor() {
        return Color.DARKGREEN;
    }

    public boolean isOperational() {
        return true;
    }
}
