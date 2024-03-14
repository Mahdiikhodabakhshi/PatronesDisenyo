package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.commands.memento.EditorCareTaker;
import com.kreitek.editor.commands.memento.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private final EditorCareTaker careTaker;

    public AppendCommand(String text, EditorCareTaker careTaker) {
        this.text = text;
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {

        Memento memento = new Memento(new ArrayList<>(documentLines));
        careTaker.push(memento);

        documentLines.add(text);

    }
}
