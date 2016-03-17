package com.codinginfinity.research.core.people
/**
* Group Interface
*
* @author  Brenton Watt (u14032644)
* @version 1.0
* @since   2016-03-17
*/
public class Group extends Entity{
  /**
  * The Name of the Group
  */
  private String name;

  /**
  * The member variable to facilitate with the composite design pattern
  */
  private ArrayList<Entity> children;
}
