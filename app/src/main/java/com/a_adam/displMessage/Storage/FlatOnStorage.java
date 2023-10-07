package com.a_adam.displMessage.Storage;

import com.a_adam.displMessage.FlatOn.FlatOn;

public class FlatOnStorage {
    private static FlatOn flatOn = null;

    public static FlatOn getFlatOn() {
        if (flatOn == null) {
            flatOn = new FlatOn();
        }
        return flatOn;
    }
}
