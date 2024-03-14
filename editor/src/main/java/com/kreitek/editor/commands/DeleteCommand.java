package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.commands.memento.EditorCareTaker;
import com.kreitek.editor.commands.memento.Memento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;
    private final EditorCareTaker careTaker;

    public DeleteCommand(int lineNumber, EditorCareTaker careTaker) {
        this.lineNumber = lineNumber;
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {

        Memento memento = new Memento(new ArrayList<>(documentLines));
        careTaker.push(memento);

        documentLines.remove(lineNumber);
    }
}
