package com.spaceagencies.client.graphics;

import com.spaceagencies.i3d.scene.element.I3dElement;
import com.spaceagencies.server.Time.Timestamp;


public interface GraphicalElement {

    public boolean isAnimated();
    
    public void update(Timestamp time);
    
    public void destroy();

    public boolean isDisplayable();

    public I3dElement getV3DElement();

    void init(Timestamp time);
    
}
