package ru.haulmont.management.practice.exception;

import io.jmix.core.Messages;
import io.jmix.ui.screen.MessageBundle;
import org.springframework.beans.factory.annotation.Autowired;

public class IncorrectTimeRangeException extends Exception {

    public IncorrectTimeRangeException(String message) {
        super(message);
    }
}
