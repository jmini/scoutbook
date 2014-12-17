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
package org.eclipsescout.demo.widgets.client.old.ui.desktop;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktopExtension;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractFormToolButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.old.ui.desktop.outlines.PagesSearchFormsOutline;
import org.eclipsescout.demo.widgets.client.old.ui.desktop.outlines.WidgetsOutline;
import org.eclipsescout.demo.widgets.client.old.ui.forms.ToolButton1Form;
import org.eclipsescout.demo.widgets.client.old.ui.forms.ToolButton2Form;
import org.eclipsescout.demo.widgets.shared.Icons;

public class DesktopExtension extends AbstractDesktopExtension {
  public DesktopExtension() {
  }

  @Override
  protected List<Class<? extends IOutline>> getConfiguredOutlines() {
    List<Class<? extends IOutline>> outlines = new ArrayList<Class<? extends IOutline>>();
    outlines.add(WidgetsOutline.class);
    outlines.add(PagesSearchFormsOutline.class);
    return outlines;
  }

  @Order(40.0)
  public class WidgetsOutlineViewButton extends AbstractOutlineViewButton {
    public WidgetsOutlineViewButton() {
      super(getCoreDesktop(), WidgetsOutline.class);
    }
  }

  @Order(50.0)
  public class PagesSearchFormsOutlineViewButton extends AbstractOutlineViewButton {
    public PagesSearchFormsOutlineViewButton() {
      super(getCoreDesktop(), PagesSearchFormsOutline.class);
    }
  }

  @Order(10.0)
  public class ToolButton1Tool extends AbstractFormToolButton<ToolButton1Form> {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("ToolButton1");
    }

    @Override
    protected String getConfiguredIconId() {
      return Icons.StarYellow;
    }

    @Override
    protected void execAction() throws ProcessingException {
      ToolButton1Form form = new ToolButton1Form();
      decorateForm(form);
      form.startTool();
      setForm(form);
    }
  }

  @Order(20.0)
  public class ToolButton2Tool extends AbstractFormToolButton<ToolButton2Form> {

    @Override
    protected String getConfiguredIconId() {
      return Icons.StarRed;
    }

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("ToolButton2");
    }

    @Override
    protected void execAction() throws ProcessingException {
      ToolButton2Form form = new ToolButton2Form();
      decorateForm(form);
      form.startTool();
      setForm(form);
    }
  }
}
