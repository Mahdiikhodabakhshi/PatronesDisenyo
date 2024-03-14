package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.commands.memento.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {

    private final Memento memento;

    public UndoCommand(Memento memento) {
        this.memento = memento;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (memento != null) {
            documentLines.clear();
            documentLines.addAll(memento.getState());
        }
    }
}
