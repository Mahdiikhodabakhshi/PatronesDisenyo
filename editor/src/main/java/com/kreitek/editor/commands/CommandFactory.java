package com.kreitek.editor.commands;

import com.kreitek.editor.*;
import com.kreitek.editor.commands.memento.EditorCareTaker;
import com.kreitek.editor.commands.memento.Memento;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();

    private final EditorCareTaker editorCareTaker;

    public CommandFactory(EditorCareTaker editorCareTaker) {
        this.editorCareTaker = editorCareTaker;
    }

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand();
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand() {
        Memento memento = editorCareTaker.pop();
        // TODO create undo command
        return new UndoCommand(memento);
    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number , editorCareTaker);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number , editorCareTaker);
    }

    private Command createAppendCommand(String text) {
        return new AppendCommand(text , editorCareTaker);
    }

}
