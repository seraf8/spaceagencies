package com.spaceagencies.common.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final List<Player> players = new ArrayList<>();
    
    private final Map<Long, Player> playerIdMap = new HashMap<Long, Player>();
    
    public void addPlayer(Player player) {
        players.add(player);
        playerIdMap.put(player.getId(), player);
    }
}
