package com.codinginfinity.research.publication;

import com.codinginfinity.research.publication.lifecycle.InProgress;
import com.codinginfinity.research.publication.lifecycle.LifeCycleState;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.time.LocalDate;

/**
 * Created by andrew on 2016/04/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PublicationTest.class})
@ComponentScan("com.codinginfinity.research")
public class PublicationTest {

    @Inject
    private PublicationMock publicationMock;


    private static Publication createPublicationMock(){
        //String title, LocalDate envisagedPublicationDate
        PublicationDetails details = new PublicationDetails("A Guided Approach to Agile Software Engineering", LocalDate.now());
        //LocalDate date, String reason, PublicationDetails publicationDetails, LifeCycleState lifeCycleState, long publicationTarget, long publicationType, long owner
        PublicationState state = new PublicationState(LocalDate.now(), "FOMO on YOLO",details, new InProgress(), 1,1,3);
        Publication p = new Publication(state);
        return p;
    }
}
