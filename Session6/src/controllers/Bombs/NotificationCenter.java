package controllers.Bombs;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 8/10/2016.
 */


public class NotificationCenter {
    private Vector<BombSubscriber> subscribers;
    private Vector<FreezzeSubcriber> freezzeSubcribers;

    public NotificationCenter() {
        subscribers = new Vector<BombSubscriber>();
        freezzeSubcribers = new Vector<FreezzeSubcriber>();
    }

    public void subsribe(BombSubscriber bombSubscriber) {
        subscribers.add(bombSubscriber);
    }

    public void subsribeFrezze(FreezzeSubcriber bombSubscriber) {
        freezzeSubcribers.add(bombSubscriber);
    }

    public void onBomExpode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = subscribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if(!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public void onFrezze(int x, int y) {
        Iterator<FreezzeSubcriber> bombSubscriberIterator = freezzeSubcribers.iterator();
        while(bombSubscriberIterator.hasNext()) {
            FreezzeSubcriber freezzeSubcriber = bombSubscriberIterator.next();
            if(!freezzeSubcriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                freezzeSubcriber.onFrezze(x, y);
            }
        }
    }

    public static final NotificationCenter instance = new NotificationCenter();
}
