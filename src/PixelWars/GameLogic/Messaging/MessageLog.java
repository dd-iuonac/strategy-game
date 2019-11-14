package PixelWars.GameLogic.Messaging;

import java.util.LinkedList;

public class MessageLog {
    private LinkedList<String> messages;

    public MessageLog() {
        messages = new LinkedList<>();
    }

    public String append(String Who, String What) {
        String message = Who + ": " + What;
        return this.messages.add(message) ? message : null;
    }

    public void clear()
    {
        messages.clear();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String m : messages) {
            res.append(m).append("\n");
        }
        return res.toString();
    }
}