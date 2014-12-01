/**
 *
 */
package org.eclipsescout.demo.widgets.client.ui.desktop.outlines;

import java.util.List;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.extension.client.ui.desktop.outline.AbstractExtensibleOutline;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.ui.desktop.pages.FormPage;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm;
import org.eclipsescout.demo.widgets.client.ui.forms.SplitBoxForm;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm;

/**
 * @author mzi
 */
public class LayoutWidgetsOutline extends AbstractExtensibleOutline {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("LayoutWidgets");
  }

  @Override
  protected void execCreateChildPages(List<IPage> pageList) throws ProcessingException {

    FormPage groupBoxPage = new FormPage(GroupBoxForm.class);
    pageList.add(groupBoxPage);

    FormPage sequenceBoxPage = new FormPage(SequenceBoxForm.class);
    pageList.add(sequenceBoxPage);

    FormPage tabBoxPage = new FormPage(TabBoxForm.class);
    pageList.add(tabBoxPage);

    FormPage splitBoxPage = new FormPage(SplitBoxForm.class);
    pageList.add(splitBoxPage);
  }
}
