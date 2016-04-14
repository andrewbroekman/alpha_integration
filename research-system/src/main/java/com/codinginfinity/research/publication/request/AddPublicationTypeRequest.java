package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.type.PublicationType;
import com.codinginfinity.research.publication.type.PublicationTypeState;
import com.codinginfinity.research.services.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddPublicationTypeRequest implements Request {

    private static final long serialVersionUID = 2133483889995619156L;

    private PublicationType newPublicationType;
    private List<PublicationTypeState> stateEntry;

    public AddPublicationTypeRequest() {
    }

    public PublicationType getNewPublicationType() {
        return newPublicationType;
    }

    public void setNewPublicationType(PublicationType newPublicationType) {
        this.newPublicationType = newPublicationType;
    }

    public void addStateEntry(PublicationTypeState entry) {

        if (stateEntry == null)
            stateEntry = new ArrayList<>();

        stateEntry.add(entry);
    }

    public PublicationTypeState getStateEntry() {
        return stateEntry.get(stateEntry.size()-1);
    }
}
