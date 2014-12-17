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
package org.eclipsescout.demo.widgets.ui.swt;

import org.eclipse.scout.rt.ui.swt.ISwtEnvironment;
import org.eclipsescout.demo.widgets.client.ClientSession;
import org.eclipsescout.demo.widgets.ui.swt.perspective.Perspective;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  // the plugin id
  public static final String BUNDLE_ID = "org.eclipsescout.demo.widgets.ui.swt";

  private ISwtEnvironment m_environment;

  // the shared instance
  private static Activator m_bundle;

  @Override
  public void start(BundleContext context) throws Exception {
    m_bundle = this;
    m_environment = new SwtEnvironment(context.getBundle(), Perspective.ID, ClientSession.class);
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    m_bundle = null;
  }

  public static Activator getDefault() {
    return m_bundle;
  }

  public ISwtEnvironment getEnvironment() {
    return m_environment;
  }
}
