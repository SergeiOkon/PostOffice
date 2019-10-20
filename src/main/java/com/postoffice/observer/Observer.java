package com.postoffice.observer;

import com.postoffice.content.ContentType;
import com.postoffice.subscriber.Subscriber;

public interface Observer {
    void subscribe(ContentType ContentType, Subscriber subscriber);

    void unsubscribe(ContentType ContentType, Subscriber subscriber);

    void notify(ContentType ContentType, String content);
}
