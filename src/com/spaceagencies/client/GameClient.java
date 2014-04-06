package com.spaceagencies.client;

import com.spaceagencies.client.graphics.UiEngine;
import com.spaceagencies.client.graphics.UiEngineObserver;
import com.spaceagencies.client.input.InputEngine;
import com.spaceagencies.client.input.InputEngineObserver;
import com.spaceagencies.common.engine.EngineManager;
import com.spaceagencies.common.tools.Log;
import com.spaceagencies.i3d.input.I3dMouseEvent;
import com.spaceagencies.server.ParameterAnalyser;
import com.spaceagencies.server.game.GameManager;

import fr.def.iss.vd2.lib_v3d.V3DControllerEvent;
import fr.def.iss.vd2.lib_v3d.V3DKeyEvent;

public class GameClient {
   
    private EngineManager mEngineManager;

    private InputEngine mInputEngine;

    private GameManager mGameManager;

    public static GameClient sInstance = null;

    public static GameClient getInstance() {
        return sInstance;
    }

    public GameClient(ParameterAnalyser parameterAnalyser) {
        sInstance = this;

        mGameManager = new GameManager();
        mEngineManager = new EngineManager();
        
        mInputEngine = new InputEngine();
        mInputEngine.getInputEnginObservable().register(this, new InputEngineObserver() {
            
            @Override
            public void onQuitEvent() {
                mEngineManager.stop();
            }
            
            @Override
            public void onMouseEvent(I3dMouseEvent event) {
            }
            
            @Override
            public void onKeyEvent(V3DKeyEvent event) {
            }

            @Override
            public void onControllerEvent(V3DControllerEvent event) {
            }
        });
        
        UiEngine uiEngine = new UiEngine();
        
        uiEngine.getUiEnginObservable().register(this, new UiEngineObserver() {
            
            @Override
            public void onQuitEvent() {
                mEngineManager.stop();
            }
        });
        
        
        mEngineManager.add(mInputEngine);
        
        mEngineManager.add(uiEngine);
    }

    public void run() {

        java.lang.System.out.println("Space agencies Client - v0.1a");

        mEngineManager.run();
        
        Log.perfEnd(); // Finish Start

        java.lang.System.out.println("Game Client: Stopped");

    }

    public void stop() {

    }

    public EngineManager getEngineManager() {
        return mEngineManager;
    }

    public InputEngine getInputEngine() {
        return mInputEngine;
    }

    public GameManager getGameManager() {
        return mGameManager;
    }
}
