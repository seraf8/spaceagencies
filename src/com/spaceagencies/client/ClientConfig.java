package com.spaceagencies.client;

public class ClientConfig {
    
    static boolean sound_isEnabled() {
        return true;
    }

    public static String getCacheDirectoryPath(String file) {
        return System.getProperty("user.home")+"/.cache/spaceagencies/"+file;
    }

    public static String getSaveDirectoryPath(String file) {
        return System.getProperty("user.home")+"/.local/share/spaceagencies/saves/"+file;
    }
}
