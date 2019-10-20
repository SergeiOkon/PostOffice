package com.postoffice;

import com.postoffice.content.ContentType;
import com.postoffice.observer.Observer;
import com.postoffice.observer.ObserverImpl;
import com.postoffice.subscriber.SubscriberImpl;

public class Main {
    public static void main(String[] args) {
        Observer postOffice = new ObserverImpl();

        SubscriberImpl vitaliy = new SubscriberImpl("Vitaliy", "Vatutina street, 9");

        postOffice.subscribe(ContentType.NEWSPAPER,
                new SubscriberImpl("Dmitry", "Tampere street, 8"));

        postOffice.subscribe(ContentType.NEWSPAPER,
                new SubscriberImpl("Danil", "Glushkova street, 4"));

        postOffice.subscribe(ContentType.NEWSPAPER,
                new SubscriberImpl("David", "Lesi Ukrainki street, 48"));

        postOffice.subscribe(ContentType.MAGAZINE, vitaliy);

        postOffice.subscribe(ContentType.MAGAZINE,
                new SubscriberImpl("Ivan", "Shevchenka avenue, 23"));

        postOffice.notify(ContentType.NEWSPAPER, "Focus UA");

        postOffice.unsubscribe(ContentType.MAGAZINE, vitaliy);//Vitaliy will not receive the magazine

        postOffice.notify(ContentType.MAGAZINE, "Skateboarding Magazine");
    }
}
