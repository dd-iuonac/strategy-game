package PixelWars.GUI.Events.Capturers;

import PixelWars.GUI.Events.EventCapturer;
import PixelWars.GameLogic.MapLogic.MapEntities.MapEntity;
import PixelWars.GameLogic.MapLogic.MapTile;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Capturer_ImageView extends ImageView implements EventCapturer {
    private static class UpdateHandler {
        private static void handle(MapTile cause, Capturer_ImageView capturer) {
            Platform.runLater(() -> {
                synchronized (cause) {
                    MapEntity me = cause.getMapEntity();
                    capturer.setImage(me != null ? me.getIcon() : null);
                }
            });
        }
    }

    @Override
    public void update(Object cause) {
        if(cause instanceof MapTile)
            UpdateHandler.handle((MapTile)cause,this);
    }
}
