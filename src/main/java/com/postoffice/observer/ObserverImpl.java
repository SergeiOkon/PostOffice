package com.postoffice.observer;

import com.postoffice.content.ContentType;
import com.postoffice.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObserverImpl implements Observer {

    private Map<ContentType, List<Subscriber>> subscribers;

    public ObserverImpl() {
        this.subscribers = new HashMap<>();
    }

    @Override
    public void subscribe(ContentType contentType, Subscriber subscriber) {
        if (subscribers.containsKey(contentType)) {
            subscribers.get(contentType).add(subscriber);
        } else {
            List<Subscriber> list = new ArrayList<>();
            list.add(subscriber);
            subscribers.put(contentType, list);
        }
    }

    @Override
    public void unsubscribe(ContentType contentType, Subscriber subscriber) {
        if (subscribers.containsKey(contentType)) {
            subscribers.get(contentType).remove(subscriber);
        }
    }

    @Override
    public void notify(ContentType contentType, String data) {
        if (subscribers.containsKey(contentType)) {
            for (Subscriber subscriber : subscribers.get(contentType)) {
                subscriber.update(data);
            }
        }
    }
}
