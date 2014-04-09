package com.spaceagencies.client.graphics.ether.activities;

import com.spaceagencies.common.game.Card;
import com.spaceagencies.i3d.I3dRessourceManager;
import com.spaceagencies.i3d.view.ProxyView;
import com.spaceagencies.i3d.view.TextView;

public class CardView extends ProxyView {

    public CardView(Card card) {
        super(I3dRessourceManager.loadView("main@layout/card"));
        
        TextView titleTextView = (TextView) findViewById("titleTextView@layout/card");
        TextView descriptionTextView = (TextView) findViewById("descriptionTextView@layout/card");
        
        titleTextView.setText(card.getTitle());
        descriptionTextView.setText(card.getShortDescription());
        
    }

}
