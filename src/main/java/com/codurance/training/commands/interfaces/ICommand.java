package com.codurance.training.commands.interfaces;

import java.io.IOException;

public interface ICommand {
    void execute(String args) throws IOException;
}
