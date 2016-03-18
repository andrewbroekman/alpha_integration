package com.codinginfinity.research.core.notification

/**
* ReminderRequest Interface
*
* @author  Claudio Da Silva (u14205892)
* @version 1.0
* @since   2016-03-18
*/

public class ReminderRequest extends UserNotificationRequest {

	/**
	* The name of the Organization
	*/
	private String message;

	/**
	* Sets the date for the reminder to go out
	*/
	private LocalDate date;

}