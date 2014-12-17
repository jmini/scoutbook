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
package org.eclipsescout.demo.widgets.client.old.ui.forms.internal;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;

/**
 *
 */
public abstract class AbstractTableFieldWithDisabledRows extends AbstractTableField<AbstractTableFieldWithDisabledRows.Table> {

  @Override
  protected boolean getConfiguredLabelVisible() {
    return false;
  }

  @Override
  protected int getConfiguredGridH() {
    return 10;
  }

  @Override
  protected void execInitField() throws ProcessingException {
    reloadTableData();
  }

  @Override
  public void reloadTableData() throws ProcessingException {

    Object[][] data = new Object[][]{{1l, "Anna"}, {2l, "Cleo"}};
    getTable().replaceRowsByMatrix(data);

  }

  @Order(10)
  public class Table extends AbstractTable {

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    public IdColumn getIdColumn() {
      return getColumnSet().getColumnByClass(IdColumn.class);
    }

    public NameColumn getNameColumn() {
      return getColumnSet().getColumnByClass(NameColumn.class);
    }

    @Override
    protected void execDecorateRow(ITableRow row) throws ProcessingException {
      row.setEnabled(row.getRowIndex() % 2 == 0);
      super.execDecorateRow(row);
    }

    @Order(10)
    public class IdColumn extends AbstractLongColumn {
      @Override
      protected boolean getConfiguredVisible() {
        return false;
      }

      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }
    }

    @Order(20)
    public class NameColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return "Name";
      }

    }

    @Order(1000)
    public class StandardMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return getClass().getSimpleName();
      }
    }

    @Order(1010)
    public class AlsoOnDisableRowsMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return getClass().getSimpleName();
      }

      @Override
      protected boolean getConfiguredInheritAccessibility() {
        return false;
      }
    }

  }
}
