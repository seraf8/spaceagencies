package com.spaceagencies.client.input;

import com.spaceagencies.i3d.input.I3dMouseEvent;

import fr.def.iss.vd2.lib_v3d.V3DControllerEvent;
import fr.def.iss.vd2.lib_v3d.V3DKeyEvent;


public interface InputEngineObserver {
    void onMouseEvent(I3dMouseEvent event);

    void onKeyEvent(V3DKeyEvent event);
    
    void onControllerEvent(V3DControllerEvent event);

    void onQuitEvent();
}
