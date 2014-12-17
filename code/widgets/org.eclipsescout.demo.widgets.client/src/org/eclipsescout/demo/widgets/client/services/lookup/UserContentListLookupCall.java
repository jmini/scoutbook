/*******************************************************************************
 * Copyright (c) 2013 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.widgets.client.services.lookup;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.services.lookup.LocalLookupCall;
import org.eclipse.scout.rt.shared.services.lookup.LookupRow;

/**
 * @author mzi
 */
public class UserContentListLookupCall extends LocalLookupCall<String> {

  private static final long serialVersionUID = 1L;
  private List<LookupRow<String>> m_rows = new ArrayList<LookupRow<String>>();

  public void setLookupRows(List<LookupRow<String>> rows) {
    m_rows = rows;
  }

  @Override
  protected List<LookupRow<String>> execCreateLookupRows() throws ProcessingException {
    return m_rows;
  }
}
