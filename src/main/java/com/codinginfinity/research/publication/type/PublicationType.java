package com.codinginfinity.research.publication.type;

import com.codinginfinity.research.core.BaseEntity;

/**
 * Created by andrew on 2016/04/11.
 */
public class PublicationType extends BaseEntity {

    private static final long serialVersionUID = 8371136739555989230L;

    private String name;
    private PublicationTypeState stateEntry;

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

    public PublicationTypeState getStateEntry() {
        return this.stateEntry;
    }

    public void addStateEntry(PublicationTypeState stateEntry) {
        this.stateEntry = stateEntry;
    }
}
