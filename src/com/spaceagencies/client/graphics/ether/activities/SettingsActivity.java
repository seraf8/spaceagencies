package com.spaceagencies.client.graphics.ether.activities;

import com.spaceagencies.i3d.Bundle;
import com.spaceagencies.i3d.Intent;
import com.spaceagencies.i3d.Measure;
import com.spaceagencies.i3d.Measure.Axis;
import com.spaceagencies.i3d.input.I3dMouseEvent;
import com.spaceagencies.i3d.view.Activity;
import com.spaceagencies.i3d.view.Button;
import com.spaceagencies.i3d.view.View;
import com.spaceagencies.i3d.view.View.OnClickListener;
import com.spaceagencies.server.Duration;
import com.spaceagencies.server.Time;
import com.spaceagencies.server.Time.Timestamp;

public class SettingsActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        setContentView("main@layout/settings");
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {

    }
    
    @Override
    public void onDestroy() {
    }

    @Override
    protected void onUpdate(Timestamp time) {
    }

}
