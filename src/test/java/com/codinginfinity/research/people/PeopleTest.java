package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.EmailAddressInUse;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by andrew on 2016/04/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PeopleTest.class})
public class PeopleTest {

    @Inject
    private PeopleMock peopleMock;

    @Test(expected = EmailAddressInUse.class)
    public void emailAddressAlreadyInUse() throws Exception{
        peopleMock.setState(PeopleMock.State.emailAddressInUse);
    }

}