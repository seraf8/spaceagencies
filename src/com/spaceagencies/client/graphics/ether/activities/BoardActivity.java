package com.spaceagencies.client.graphics.ether.activities;

import java.util.List;

import com.spaceagencies.client.LoginManager;
import com.spaceagencies.common.game.Card;
import com.spaceagencies.common.game.Player;
import com.spaceagencies.common.game.Turn;
import com.spaceagencies.i3d.Bundle;
import com.spaceagencies.i3d.Measure;
import com.spaceagencies.i3d.Measure.Axis;
import com.spaceagencies.i3d.SelectionManager;
import com.spaceagencies.i3d.SelectionManager.OnSelectionChangeListener;
import com.spaceagencies.i3d.view.Activity;
import com.spaceagencies.i3d.view.LinearLayout;
import com.spaceagencies.i3d.view.TextView;
import com.spaceagencies.server.Time.Timestamp;

public class BoardActivity extends Activity {

    private Player mPlayer;
    private Turn mTurn;
    private TextView deckDescription;
    private TextView handDescriptionTextView;
    private TextView discardPileTextView;
    private TextView turnMoneyCounterTextView;
    private TextView turnActionCounterTextView;
    private TextView turnBuyCounterTextView;
    private LinearLayout handLinearLayout;
    private SelectionManager<Card> cardSelectionManager;
    private LinearLayout detailZone;

    @Override
    public void onCreate(Bundle bundle) {
        setContentView("main@layout/board");
        
        mPlayer = LoginManager.getLocalPlayer();
        
        deckDescription = (TextView) findViewById("deckDescription@layout/deck_zone");
        handDescriptionTextView = (TextView) findViewById("handDescriptionTextView@layout/hand_zone");
        discardPileTextView = (TextView) findViewById("discardPileTextView@layout/discard_pile_zone");
        
        turnMoneyCounterTextView = (TextView) findViewById("turnMoneyCounterTextView@layout/turn_zone");
        turnActionCounterTextView = (TextView) findViewById("turnActionCounterTextView@layout/turn_zone");
        turnBuyCounterTextView = (TextView) findViewById("turnBuyCounterTextView@layout/turn_zone");
        
        
        handLinearLayout = (LinearLayout) findViewById("handLinearLayout@layout/hand_zone");
        detailZone = (LinearLayout) findViewById("detailZone@layout/board");
        
        
        cardSelectionManager = new SelectionManager<Card>();
        
        
        cardSelectionManager.addOnSelectionChangeListener(new OnSelectionChangeListener<Card>() {

            @Override
            public void onSelectionChange(List<Card> selection) {
                if(selection.size() > 0) {
                    Card card = selection.get(0);
                    detailZone.removeAllView();
                    detailZone.addViewInLayout(new DetailedCardView(card));
                    
                }
            }

            @Override
            public boolean mustClear(Object clearKey) {
                return false;
            }});
    }

    @Override
    public void onResume() {
        mTurn = mPlayer.getTurn();
        updateUi();
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
    
    private void updateUi() {
        int deckSize = mTurn.getPlayer().getDeck().getNbCards();
        deckDescription.setText("Deck: "+deckSize+ " card"+(deckSize > 1 ? "s" : ""));
        
        int handSize = mTurn.getHand().getNbCards();
        handDescriptionTextView.setText("Hand: "+handSize+ " card"+(handSize > 1 ? "s" : ""));
        
        int discardPileSize = mTurn.getPlayer().getDiscardPile().getNbCards();
        discardPileTextView.setText("Discard pile: "+discardPileSize+ " card"+(discardPileSize > 1 ? "s" : ""));
        
        turnMoneyCounterTextView.setText("Money count: "+mTurn.getMoneyCount());
        turnActionCounterTextView.setText("Action count: "+mTurn.getActionCount());
        turnBuyCounterTextView.setText("Buy count: "+mTurn.getBuyCount());
        
        //Display hand
        handLinearLayout.removeAllView();
        
        for(Card card : mTurn.getHand().getCards()) {
            CardView cardView = new CardView(card, cardSelectionManager);
            cardView.getLayoutParams().setMarginLeftMeasure(new Measure(5, false, Axis.HORIZONTAL));
            cardView.getLayoutParams().setMarginRightMeasure(new Measure(5, false, Axis.HORIZONTAL));
            handLinearLayout.addViewInLayout(cardView);
        }
        
//        <View
//        i3d:id="card"
//        i3d:layout_marginLeft="5px"
//        i3d:layout_marginRight="5px"
//        i3d:ref="main@layout/card" />
//       
        
    }

    
}
