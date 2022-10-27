package pl.jrdev.bot.input;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputCommandTest {

    @Test
    void shouldBuildCorrectUserInputCommand() {
//        given
        String input = "category_add_CategoryName";
//        when
        UserInputCommand userInputCommand = new UserInputCommand(input);
//        then
        assertEquals("category", userInputCommand.getCommand());
        assertEquals("add", userInputCommand.getAction().getValue());
        assertLinesMatch(List.of("CategoryName"), userInputCommand.getParam());
    }

    @Test
    void shouldBuildCorrectUserInputCommandWithMultipleParams() {
//        given
        String input = "command_add_param1_param2_param3";
//        when
        UserInputCommand userInputCommand = new UserInputCommand(input);
//        then
        assertEquals("command", userInputCommand.getCommand());
        assertEquals("add", userInputCommand.getAction().getValue());
        assertLinesMatch(List.of("param1", "param2", "param3"), userInputCommand.getParam());
    }

    @Test
    void shouldBuildCorrectUserInputCommandWithoutParams() {
//        given
        String input = "command_add";
//        when
        UserInputCommand userInputCommand = new UserInputCommand(input);
//        then
        assertEquals("command", userInputCommand.getCommand());
        assertEquals("add", userInputCommand.getAction().getValue());
        assertEquals(0, userInputCommand.getParam().size());
    }
}