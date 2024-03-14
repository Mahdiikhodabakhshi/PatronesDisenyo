package com.kreitek.editor.commands.memento;

import java.util.ArrayList;
import java.util.List;

public class EditorCareTaker {
    List<Memento> mementos = new ArrayList<>();
    public void push(Memento memento){
        mementos.add(memento);
    }

    public Memento pop(){
        if (!mementos.isEmpty()){
            Memento memento = mementos.get(mementos.size() - 1);
            mementos.remove(mementos.size() - 1);
            return memento;
        }
        return null;
    }
}
