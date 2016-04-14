package com.codinginfinity.research.publication.type;

import com.codinginfinity.research.core.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class PublicationType extends BaseEntity {

    private static final long serialVersionUID = 8371136739555989230L;

    private String name;
    private List<PublicationTypeState> stateEntry;

    public PublicationType() {
    }

    public PublicationType(String name, PublicationTypeState stateEntry) {
        this.name = name;
        addStateEntry(stateEntry);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PublicationTypeState> getStateEntry() {
        return stateEntry;
    }

    public void addStateEntry(PublicationTypeState stateEntry) {

        if (this.stateEntry == null)
            this.stateEntry = new ArrayList<>();

        this.stateEntry.add(stateEntry);

    }
}
