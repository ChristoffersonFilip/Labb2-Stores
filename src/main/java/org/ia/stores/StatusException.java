package org.ia.stores;

public class StatusException extends RuntimeException {
    String e;

    public StatusException(String e){
        this.e = e;
    }

}
