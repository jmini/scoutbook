/**
 *
 */
package org.eclipsescout.demo.widgets.client.old;

import java.util.List;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.ISearchForm;
import org.eclipse.scout.rt.extension.client.ui.desktop.outline.pages.AbstractExtensiblePageWithNodes;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.old.ui.desktop.pages.SearchFormTablePage;
import org.eclipsescout.demo.widgets.client.ui.desktop.menu.AbstractViewSourceOnGitHubMenu;

/**
 * @author mzi
 */
public class SearchFormsNodePage extends AbstractExtensiblePageWithNodes {

  @Override
  protected String getConfiguredIconId() {
    return org.eclipse.scout.rt.shared.AbstractIcons.TreeNode;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("SearchForms");
  }

  @Override
  protected void execCreateChildPages(List<IPage> pageList) throws ProcessingException {
    SearchFormTablePage searchFormTablePage = new SearchFormTablePage();
    pageList.add(searchFormTablePage);
    SearchFormTablePage searchFormTablePage0 = new SearchFormTablePage(ISearchForm.VIEW_ID_OUTLINE, "Outline");
    pageList.add(searchFormTablePage0);
    SearchFormTablePage searchFormTablePage1 = new SearchFormTablePage(ISearchForm.VIEW_ID_OUTLINE_SELECTOR, "Outline Selector");
    pageList.add(searchFormTablePage1);
    SearchFormTablePage searchFormTablePage2 = new SearchFormTablePage(ISearchForm.VIEW_ID_PAGE_TABLE, "Page Table");
    pageList.add(searchFormTablePage2);
    SearchFormTablePage searchFormTablePage3 = new SearchFormTablePage(ISearchForm.VIEW_ID_PAGE_SEARCH, "Page Search");
    pageList.add(searchFormTablePage3);
    SearchFormTablePage searchFormTablePage4 = new SearchFormTablePage(ISearchForm.VIEW_ID_PAGE_DETAIL, "Page Detail");
    pageList.add(searchFormTablePage4);
    SearchFormTablePage searchFormTablePage5 = new SearchFormTablePage(ISearchForm.VIEW_ID_N, "North");
    pageList.add(searchFormTablePage5);
    SearchFormTablePage searchFormTablePage6 = new SearchFormTablePage(ISearchForm.VIEW_ID_NE, "North-East");
    pageList.add(searchFormTablePage6);
    SearchFormTablePage searchFormTablePage7 = new SearchFormTablePage(ISearchForm.VIEW_ID_E, "East");
    pageList.add(searchFormTablePage7);
    SearchFormTablePage searchFormTablePage8 = new SearchFormTablePage(ISearchForm.VIEW_ID_SE, "South-East");
    pageList.add(searchFormTablePage8);
    SearchFormTablePage searchFormTablePage9 = new SearchFormTablePage(ISearchForm.VIEW_ID_S, "South");
    pageList.add(searchFormTablePage9);
    SearchFormTablePage searchFormTablePage10 = new SearchFormTablePage(ISearchForm.VIEW_ID_SW, "South-West");
    pageList.add(searchFormTablePage10);
    SearchFormTablePage searchFormTablePage11 = new SearchFormTablePage(ISearchForm.VIEW_ID_W, "West");
    pageList.add(searchFormTablePage11);
    SearchFormTablePage searchFormTablePage12 = new SearchFormTablePage(ISearchForm.VIEW_ID_NW, "North-West");
    pageList.add(searchFormTablePage12);
  }

  @Order(10.0)
  public class ViewSourceOnGitHubMenu extends AbstractViewSourceOnGitHubMenu {

    @Override
    protected Class<?> provideSourceClass() {
      return SearchFormTablePage.class;
    }
  }
}
