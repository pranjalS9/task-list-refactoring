package com.codurance.training.commands.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTypesTest {

    @Test
    public void getCommandTypeReturnsCommandEnumForCorrectCommandPassedTest() {
        CommandTypes commandType = CommandTypes.getCommandType("add");

        assertEquals(commandType, CommandTypes.ADD);
    }
}
