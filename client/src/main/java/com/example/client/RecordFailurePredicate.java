package com.example.client;

import java.util.function.Predicate;

public class RecordFailurePredicate implements Predicate<Exception> {
    @Override
    public boolean test(Exception e) {
        if (!e.getMessage().isEmpty()) {
            return true;
        }
        return false;
    }
}
