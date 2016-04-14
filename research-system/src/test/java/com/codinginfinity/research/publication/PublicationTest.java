package com.codinginfinity.research.publication;


import com.codinginfinity.research.publication.exception.GroupDoesNotExist;
import com.codinginfinity.research.publication.exception.PersonDoesNotExist;
import com.codinginfinity.research.publication.exception.PublicationTypeExistsException;
import com.codinginfinity.research.publication.exception.PublicationWithTitleExistsForAuthorsException;
import com.codinginfinity.research.publication.lifecycle.InProgress;
import com.codinginfinity.research.publication.request.*;
import com.codinginfinity.research.publication.response.*;
import com.codinginfinity.research.publication.type.PublicationType;
import com.codinginfinity.research.publication.type.PublicationTypeState;
import com.codinginfinity.research.publication.type.exception.PublicationTypeDoesntExist;
import com.codinginfinity.research.services.RequestNotValidException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;


/**
 * Created by andrew on 2016/04/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PublicationTest.class})
@ComponentScan("com.codinginfinity.research")

public class PublicationTest {

    @Inject
    IPublication publicationMock;

    //AddPublication
    @Test
    public void addPublicationValidRequest() throws RequestNotValidException, PublicationWithTitleExistsForAuthorsException {
        AddPublicationRequest req = new AddPublicationRequest();
        req.setInitialState(createPublicationMock().getStateEntries().get(0));
        publicationMock.addPublication(req);
        assert true;
    }

    @Test(expected = PublicationWithTitleExistsForAuthorsException.class)
    public void addPublicationWhenTitleExistsForAuthor() throws RequestNotValidException, PublicationWithTitleExistsForAuthorsException{
        AddPublicationRequest req = new AddPublicationRequest();
        PublicationState state = createPublicationMock().getStateEntries().get(0);
        state.setOwner(3);
        req.setInitialState(state);
        publicationMock.addPublication(req);
    }


    //calcAccreditationPointsForPerson
    @Test(expected = RequestNotValidException.class)
    public void calcAccreditationPointsForInvalidPerson() throws PersonDoesNotExist, RequestNotValidException {
        CalcAccreditationPointsForPersonRequest req = new CalcAccreditationPointsForPersonRequest(-1, new Period(createOlderDate(), createNewerDate()));
        publicationMock.calcAccreditationPointsForPerson(req);
    }

    @Test(expected = PersonDoesNotExist.class)
    public void calcAccreditationPointsForNoExistentPerson() throws PersonDoesNotExist, RequestNotValidException {
        CalcAccreditationPointsForPersonRequest req = new CalcAccreditationPointsForPersonRequest(6, new Period(createOlderDate(), createNewerDate()));
        publicationMock.calcAccreditationPointsForPerson(req);
    }

    @Test
    public void calcAccreditationPointsForNormalPerson() throws PersonDoesNotExist, RequestNotValidException {
        CalcAccreditationPointsForPersonRequest req = new CalcAccreditationPointsForPersonRequest(111, new Period(createOlderDate(), createNewerDate()));
        CalcAccreditationPointsForPersonResponse resp = publicationMock.calcAccreditationPointsForPerson(req);
        assert resp.getPoints() == 10;
    }

    //calcAccreditationPointsForGroup
    @Test(expected = RequestNotValidException.class)
    public void calcAccreditationPointsForInvalidGroup() throws RequestNotValidException, GroupDoesNotExist {
        CalcAccreditationPointsForGroupRequest req = new CalcAccreditationPointsForGroupRequest(-1, new Period(createOlderDate(), createNewerDate()));
        publicationMock.calcAccreditationPointsForGroup(req);
    }

    @Test(expected = GroupDoesNotExist.class)
    public void calcAccreditationPointsForNoExistentGroup() throws RequestNotValidException, GroupDoesNotExist {
        CalcAccreditationPointsForGroupRequest req = new CalcAccreditationPointsForGroupRequest(6, new Period(createOlderDate(), createNewerDate()));
        publicationMock.calcAccreditationPointsForGroup(req);
    }

    @Test
    public void calcAccreditationPointsForNormalGroup() throws RequestNotValidException, GroupDoesNotExist {
        CalcAccreditationPointsForGroupRequest req = new CalcAccreditationPointsForGroupRequest(222, new Period(createOlderDate(), createNewerDate()));
        CalcAccreditationPointsForGroupResponse resp = publicationMock.calcAccreditationPointsForGroup(req);
        assert resp.getPoints() == 26;
    }

    //getPublicationsForPerson
    @Test(expected = RequestNotValidException.class)
    public void getPublicationsForInvalidPerson() throws RequestNotValidException{
        GetPublicationsForPersonRequest req = new GetPublicationsForPersonRequest();
        req.setConfidenceLevel(PublicationConfidenceLevel.ACCEPTED);
        req.setPerson(-1);
        req.setPublicationPeriod(new Period(createOlderDate(), createNewerDate()));
        publicationMock.getPublicationsForPerson(req);
    }

    @Test
    public void getPublicationsForNonExistentPerson() throws RequestNotValidException{
        GetPublicationsForPersonRequest req = new GetPublicationsForPersonRequest();
        req.setConfidenceLevel(PublicationConfidenceLevel.ACCEPTED);
        req.setPerson(6);
        req.setPublicationPeriod(new Period(createOlderDate(), createNewerDate()));
        GetPublicationsForPersonResponse resp = publicationMock.getPublicationsForPerson(req);
        assert resp.getMatchingPublications().size() == 0;
    }

    @Test
    public void getPublicationsForNormalPerson() throws RequestNotValidException{
        GetPublicationsForPersonRequest req = new GetPublicationsForPersonRequest();
        req.setConfidenceLevel(PublicationConfidenceLevel.ACCEPTED);
        req.setPerson(111);
        req.setPublicationPeriod(new Period(createOlderDate(), createNewerDate()));
        GetPublicationsForPersonResponse resp = publicationMock.getPublicationsForPerson(req);
        assert resp.getMatchingPublications().size() == 1 && resp.getMatchingPublications().get(0).getId() == 174;
    }

    //AddPublicationType
    @Test
    public void addPublicationTypeForNormalType() throws RequestNotValidException, PublicationTypeExistsException {
        AddPublicationTypeRequest req = new AddPublicationTypeRequest("e-book");
        PublicationTypeState p = new PublicationTypeState(LocalDate.of(2016, Month.APRIL, 14));
        p.setId(76);
        req.addStateEntry(p);
        AddPublicationTypeResponse resp = publicationMock.addPublicationType(req);
        assert true;
    }

    @Test (expected = PublicationTypeExistsException.class)
    public void addPublicationTypeForExistingType() throws RequestNotValidException, PublicationTypeExistsException{
        AddPublicationTypeRequest req = new AddPublicationTypeRequest("e-journal");
        PublicationTypeState p = new PublicationTypeState(LocalDate.of(2016, Month.APRIL, 14));
        p.setId(25);
        req.addStateEntry(p);
        AddPublicationTypeResponse resp = publicationMock.addPublicationType(req);
    }

    //GetPublicationType
    @Test
    public void getPublicationTypeForNormalType() throws RequestNotValidException, PublicationTypeDoesntExist {
        GetPublicationTypeRequest req = new GetPublicationTypeRequest();
        GetPublicationTypeResponse resp = publicationMock.getPublicationType(req);
        assert resp.equals("e-journal");
    }

    public Date createOlderDate(){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String input = "2010-10-21";
        Date t;
        try{
            t = ft.parse(input);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Date createNewerDate() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String input = "2015-03-05";
        Date t;
        try {
            t = ft.parse(input);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Publication createPublicationMock() {
        //String title, LocalDate envisagedPublicationDate
        PublicationDetails details = new PublicationDetails("A Guided Approach to Agile Software Engineering", LocalDate.now());
        //LocalDate date, String reason, PublicationDetails publicationDetails, LifeCycleState lifeCycleState, long publicationTarget, long publicationType, long owner
        PublicationState state = new PublicationState(LocalDate.now(), "FOMO on YOLO", details, new InProgress(), 1, 1, 1);
        Publication p = new Publication(state);
        return p;
    }
}
