/**
 * 
 */
package org.eclipsescout.contacts.shared.services;

import java.security.BasicPermission;

/**
 * @author mzi
 */
public class UpdateLinkedInPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  /**
 * 
 */
  public UpdateLinkedInPermission() {
    super("UpdateLinkedIn");
  }
}
