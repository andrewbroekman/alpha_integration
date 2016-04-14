package com.codinginfinity.research.publication;

import com.codinginfinity.research.core.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class Publication extends BaseEntity {

    private static final long serialVersionUID = -4388033381507798182L;

    @NotNull
    private List<PublicationState> stateEntries;

    public Publication() {
    }

    public Publication(PublicationState stateEntry) {

        if (stateEntries == null)
            stateEntries = new ArrayList<>();

        addStateEntry(stateEntry);
    }

    public void addStateEntry(PublicationState stateEntry) {
        stateEntries.add(stateEntry);
    }

    public List<PublicationState> getStateEntries() {
        return stateEntries;
    }
}
