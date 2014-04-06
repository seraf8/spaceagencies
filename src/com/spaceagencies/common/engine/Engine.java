package com.spaceagencies.common.engine;

import com.spaceagencies.server.Time.Timestamp;

public interface Engine {
    void init();
    void start();
    void tick(Timestamp time);
    void stop();
    void destroy();
}
