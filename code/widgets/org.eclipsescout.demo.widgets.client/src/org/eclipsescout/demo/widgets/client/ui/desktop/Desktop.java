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
package org.eclipsescout.demo.widgets.client.ui.desktop;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.commons.CollectionUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.logger.IScoutLogger;
import org.eclipse.scout.commons.logger.ScoutLogManager;
import org.eclipse.scout.rt.client.ClientSyncJob;
import org.eclipse.scout.rt.client.ui.action.keystroke.AbstractKeyStroke;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.desktop.IDesktop;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.client.ui.form.ScoutInfoForm;
import org.eclipse.scout.rt.client.ui.form.outline.DefaultOutlineTableForm;
import org.eclipse.scout.rt.client.ui.form.outline.DefaultOutlineTreeForm;
import org.eclipse.scout.rt.extension.client.ui.desktop.AbstractExtensibleDesktop;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.ui.UserAgentUtility;
import org.eclipsescout.demo.widgets.client.ClientSession;
import org.eclipsescout.demo.widgets.client.ui.desktop.outlines.AdvancedWidgetsOutline;
import org.eclipsescout.demo.widgets.client.ui.desktop.outlines.LayoutWidgetsOutline;
import org.eclipsescout.demo.widgets.client.ui.desktop.outlines.SimpleWidgetsOutline;
import org.eclipsescout.demo.widgets.shared.Icons;

public class Desktop extends AbstractExtensibleDesktop implements IDesktop {
  private static IScoutLogger logger = ScoutLogManager.getLogger(Desktop.class);

  public Desktop() {
  }

  @Override
  protected List<Class<? extends IOutline>> getConfiguredOutlines() {
    List<Class<? extends IOutline>> outlines = new ArrayList<Class<? extends IOutline>>();
    outlines.add(SimpleWidgetsOutline.class);
    outlines.add(AdvancedWidgetsOutline.class);
    outlines.add(LayoutWidgetsOutline.class);
    return outlines;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("ScoutWidgetsDemoApp");
  }

  @Override
  protected boolean getConfiguredTrayVisible() {
    return true;
  }

  @Override
  protected void execOpened() throws ProcessingException {
    //If it is a mobile or tablet device, the DesktopExtension in the mobile plugin takes care of starting the correct forms.
    if (!UserAgentUtility.isDesktopDevice()) {
      return;
    }

    // outline tree
    DefaultOutlineTreeForm treeForm = new DefaultOutlineTreeForm();
    treeForm.setIconId(Icons.EclipseScout);
    treeForm.startView();

    //outline table
    DefaultOutlineTableForm tableForm = new DefaultOutlineTableForm();
    tableForm.setIconId(Icons.EclipseScout);
    tableForm.startView();

    IOutline firstOutline = CollectionUtility.firstElement(getAvailableOutlines());
    if (firstOutline != null) {
      setOutline(firstOutline);
    }

  }

  @Order(10.0)
  public class FileMenu extends AbstractMenu {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("FileMenu");
    }

    @Order(100.0)
    public class ExitMenu extends AbstractMenu {

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("ExitMenu");
      }

      @Override
      protected void execAction() throws ProcessingException {
        ClientSyncJob.getCurrentSession(ClientSession.class).stopSession();
      }
    }
  }

  @Order(20.0)
  public class ToolsMenu extends AbstractMenu {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("ToolsMenu");
    }
  }

  @Order(30.0)
  public class HelpMenu extends AbstractMenu {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("HelpMenu");
    }

    @Order(10.0)
    public class AboutMenu extends AbstractMenu {

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("AboutMenu");
      }

      @Override
      protected void execAction() throws ProcessingException {
        ScoutInfoForm form = new ScoutInfoForm();
        form.startModify();
      }
    }
  }

  @Order(10.0)
  public class RefreshOutlineKeyStroke extends AbstractKeyStroke {

    @Override
    protected String getConfiguredKeyStroke() {
      return "f5";
    }

    @Override
    protected void execAction() throws ProcessingException {
      if (getOutline() != null) {
        IPage page = getOutline().getActivePage();
        if (page != null) {
          page.reloadPage();
        }
      }
    }
  }

  @Order(10.0)
  public class SimpleWidgetsOutlineViewButton extends AbstractOutlineViewButton {
    public SimpleWidgetsOutlineViewButton() {
      super(Desktop.this, SimpleWidgetsOutline.class);
    }
  }

  @Order(20.0)
  public class AdvancedWidgetsOutlineViewButton extends AbstractOutlineViewButton {
    public AdvancedWidgetsOutlineViewButton() {
      super(Desktop.this, AdvancedWidgetsOutline.class);
    }
  }

  @Order(30.0)
  public class LayoutWidgetsOutlineViewButton extends AbstractOutlineViewButton {
    public LayoutWidgetsOutlineViewButton() {
      super(Desktop.this, LayoutWidgetsOutline.class);
    }
  }
}
