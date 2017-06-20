package com.lea87crzz.AutoPublish.view;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class StreamCapturer extends OutputStream {

    private StringBuilder buffer;
    private Consumer consumer;
    private PrintStream old;

    public StreamCapturer(Consumer consumer, PrintStream old) {

        buffer = new StringBuilder(128);
        this.old = old;
        this.consumer = consumer;
    }

    @Override
    public void write(int b) throws IOException {
        char c = (char) b;
        String value = Character.toString(c);
        buffer.append(value);
        if (value.equals("\n")) {
            consumer.appendText(buffer.toString());
            buffer.delete(0, buffer.length());
        }
        old.print(c);
    }        
}    