package com.postoffice.subscriber;

public class SubscriberImpl implements Subscriber {

    private String name;
    private String address;

    public SubscriberImpl(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void update(String content) {
        System.out.println(name + " living at " + address + ". Has received a new " + content);
    }
}
