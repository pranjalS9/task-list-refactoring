package com.codurance.training.tasks;

public final class Task {
    private final long id;
    private final String description;
    private boolean done;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public String getFormattedTaskString() {
        return String.format("[%c] %d: %s%n", (this.isDone() ? 'x' : ' '), this.getId(), this.getDescription());
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setStatus(boolean done) {
        this.done = done;
    }

    public boolean isIdSame(int id) {
        return this.id == id;
    }
}