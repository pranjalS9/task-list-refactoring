package com.codurance.training.commands.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CommandTypesTest {

    @Test
    public void getCommandTypeReturnsCommandEnumForCorrectCommandPassedTest() {
        CommandTypes commandType = CommandTypes.getCommandType("add");

        assertEquals(commandType, CommandTypes.ADD);
    }

    @Test
    public void getCommandTypeThrowsExceptionForIncorrectCommandPassedTest() {
        assertThrows(IllegalArgumentException.class, () -> CommandTypes.getCommandType("test"));
    }
}
