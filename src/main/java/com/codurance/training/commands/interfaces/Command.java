package com.codurance.training.commands.interfaces;

import java.io.IOException;

public interface Command {
    void execute(String args) throws IOException;
}
