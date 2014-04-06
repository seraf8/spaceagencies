package com.spaceagencies.client;

import com.spaceagencies.common.game.Player;


public class LoginManager {
    
    public static Player localPlayer = null;
    
    public static boolean  isLogged() {
        return localPlayer != null;
    }
    
    public static Player getLocalPlayer() {
        return localPlayer;
    }
}
