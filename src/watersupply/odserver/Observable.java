package watersupply.odserver;

import watersupply.consumers.WaterUser;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Observable {
    ArrayList<Observer> subscribers = null;
    public void notifySubscribers(){//Ethernet/Radio connection
        for(Observer subscriber: subscribers){
            subscriber.applyChanges();
        }
    }
    public void subscribe(Observer... subscribers){
        if(this.subscribers == null) {
            this.subscribers = new ArrayList<>(Arrays.asList(subscribers));
        }else
            for (Observer subscriber: subscribers)
                if(!this.subscribers.contains(subscriber)) this.subscribers.add(subscriber);
    }
    public void unsubscribe(Observer subscriber){
        subscribers.remove(subscriber);
    }
}
