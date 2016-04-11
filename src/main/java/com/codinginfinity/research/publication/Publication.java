package com.codinginfinity.research.publication;

import com.codinginfinity.research.core.BaseEntity;

import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class Publication extends BaseEntity {

    private static final long serialVersionUID = -4388033381507798182L;

    private List<PublicationState> stateEntries;

    public void addStateEntry(PublicationState stateEntry) {

    }
}
