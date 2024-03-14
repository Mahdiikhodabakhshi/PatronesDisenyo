package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.commands.memento.EditorCareTaker;
import com.kreitek.editor.commands.memento.Memento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;

    private final EditorCareTaker careTaker;

    public UpdateCommand(String text, int lineNumber, EditorCareTaker careTaker) {
        this.text = text;
        this.lineNumber = lineNumber;
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        Memento memento = new Memento(new ArrayList<>(documentLines));
        careTaker.push(memento);
        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
    }
}
