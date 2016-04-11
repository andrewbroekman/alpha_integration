package com.codinginfinity.research.publication;

import com.codinginfinity.research.publication.lifecycle.LifeCycleState;

import java.util.Date;

/**
 * Created by andrew on 2016/04/11.
 */
public class PublicationState {

    private Date date;
    private String reason;
    private PublicationDetails publicationDetails;
    private LifeCycleState lifeCycleState;
    private Long publicationTarget;
    private Long publicationType;
    private Long owner;
}
