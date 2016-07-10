package com.nsg.dp;

/**
 * Created by varshika on 10/07/16.
 */
public class UpdateStatusEvent {

    private final String message;

    public UpdateStatusEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
