package PixelWars.GameLogic;

import PixelWars.GameLogic.MapLogic.Map;
import PixelWars.GameLogic.MapLogic.MapBuilder;
import PixelWars.GameLogic.MapLogic.MapEntities.Player;
import PixelWars.GameLogic.Messaging.GlobalSpeaker;

import java.util.List;

public final class Game implements GlobalSpeaker {
    private final List<Player> players;
    private final Map map;

    public Game(List<Player> players,String mapSize, String resDensity) {
        speak("Welcome to the PIXEL Wars!\nA number of " + players.size() + " emperors have joined the battlefield!\nClick BEGIN when you are ready.");
        this.players=players;
        this.map = MapBuilder.createMap(mapSize,resDensity,players);
    }

    private boolean started=false;
    public void begin() {
        if(!started)
            started=true;
        {
            for (Player player : players) {
                player.startPlayerThread();
            }
        }
    }

    public void stop() {
        if(started) {
            started=false;
            for (Player p : players) {
                p.interruptPlayerThread();
                p.joinPlayerthread();
            }
        }
    }

    public void speak(String s) {
        GlobalSpeaker.super.speak(s);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Map getMap() { return map; }

    public static int getPlayersNrMin() {
        return 2;
    }

    public static int getPlayersNrMax() {
        return 8;
    }

    public static String[] getNeededObjectives() {
        return new String[]{"Colosseum","Mosque","Sphinx"};
    }
}
