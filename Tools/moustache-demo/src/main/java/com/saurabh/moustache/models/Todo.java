package com.saurabh.moustache.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String title;
    private String text;
    private boolean done;
    private Instant createdOn;
    private Instant completedOn;

    public Todo(String title, String text) {
        this.title = title;
        this.text = text;
        createdOn = Instant.now();
    }

    public void markAsDone() {
        done = true;
        completedOn = Instant.now();
    }

    public long doneSince() {
        if (done) {
            return Duration
                    .between(createdOn, completedOn)
                    .toMinutes();
        }

        return 0;
    }

    public Function<Object, Object> handleDone() {
        return obj -> done ? String.format("<small>Done %s minutes ago<small>", obj) : "";

    }
}
