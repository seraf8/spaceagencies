package com.spaceagencies.client.graphics.ether.activities;

import com.spaceagencies.i3d.Bundle;
import com.spaceagencies.i3d.view.Activity;
import com.spaceagencies.server.Time.Timestamp;

public class BoardActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        setContentView("main@layout/board");
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
