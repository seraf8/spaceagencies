package com.spaceagencies.client.graphics;

import com.spaceagencies.i3d.scene.element.I3dElement;

public abstract class GenericGraphicalElement implements GraphicalElement {

    public GenericGraphicalElement() {
    }
    
    public abstract boolean isAnimated();
    
    public abstract I3dElement getV3DElement();
    
    public void destroy() {
    }
}
