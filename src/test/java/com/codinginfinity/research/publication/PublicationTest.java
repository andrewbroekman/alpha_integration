package com.codinginfinity.research.publication;

import com.codinginfinity.research.publication.exception.GroupDoesNotExist;
import com.codinginfinity.research.publication.exception.PersonDoesNotExist;
import com.codinginfinity.research.publication.request.CalcAccreditationPointsForGroupRequest;
import com.codinginfinity.research.publication.request.CalcAccreditationPointsForPersonRequest;
import com.codinginfinity.research.publication.response.CalcAccreditationPointsForGroupResponse;
import com.codinginfinity.research.publication.response.CalcAccreditationPointsForPersonResponse;
import com.codinginfinity.research.services.RequestNotValidException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
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

    public Date createNewerDate(){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String input = "2015-03-05";
        Date t;
        try{
            t = ft.parse(input);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
