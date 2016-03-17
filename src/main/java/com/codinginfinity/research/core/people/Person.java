package com.codinginfinity.research.core.people
/**
* Person Interface
*
* @author  Brenton Watt (u14032644)
* @version 1.0
* @since   2016-03-17
*/
public class Person extends Entity{
  /**
  * The First names of the Person
  */
  private String firstNames;

  /**
  * The Surname of the Person
  */
  private String surname;

  /**
  * The primary email of the Person
  */
  private Email primaryEmail;

  /**
  * The auxilary emails of the Person
  */
  private ArrayList<Email> auxilaryEmails;

  /**
  * The Organization
  */
  private Organization organization;

  /**
  * Editing a persons details
  * @return The return is boolean, true or false, depending on the success of the function
  */
  public boolean editPersonDetails()
  {
    return false;
  }
  /**
  * Adding a persons details
  * @return The return is boolean, true or false, depending on the success of the function
  */
  public boolean addPerson()
  {
    return false;
  }
}
