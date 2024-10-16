package net.ensah.eventdriven.commun.events;

import lombok.Getter;

public abstract class BaseEvent<T> {

    @Getter
    T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
