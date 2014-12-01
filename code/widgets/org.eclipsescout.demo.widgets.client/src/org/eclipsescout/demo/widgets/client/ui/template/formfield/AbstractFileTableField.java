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
package org.eclipsescout.demo.widgets.client.ui.template.formfield;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.scout.commons.CollectionUtility;
import org.eclipse.scout.commons.IOUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.dnd.FileListTransferObject;
import org.eclipse.scout.commons.dnd.TransferObject;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.action.keystroke.AbstractKeyStroke;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.filechooser.FileChooser;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractBooleanColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractDateTimeColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractObjectColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractSmartColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;
import org.eclipse.scout.rt.extension.client.ui.action.menu.AbstractExtensibleMenu;
import org.eclipse.scout.rt.extension.client.ui.basic.table.AbstractExtensibleTable;
import org.eclipse.scout.rt.shared.AbstractIcons;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.CODES;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.common.shell.IShellService;
import org.eclipse.scout.service.SERVICES;
import org.eclipsescout.demo.widgets.client.Activator;
import org.eclipsescout.demo.widgets.client.ui.forms.TableFieldForm;
import org.eclipsescout.demo.widgets.client.ui.template.formfield.AbstractFileTableField.Table.DeleteMenu;
import org.eclipsescout.demo.widgets.shared.FileCodeType;

public abstract class AbstractFileTableField extends AbstractTableField {
  protected static final String FILE_SIZE_FORMAT = "#,### KB";
  protected static final long FILE_SIZE_FACTOR = 1024;

  @Override
  protected void execInitField() throws ProcessingException {
    URL url = Activator.getDefault().getBundle().getResource("/resources/images/bird_1008.jpg");

    try {
      byte[] content = IOUtility.getContent(new BufferedInputStream(url.openStream()));
      File file = IOUtility.createTempFile("bird.jpg", (byte[]) content);
      getTable().addRowByArray(fileToArray(file));
    }
    catch (Exception e) {
      throw new ProcessingException("", e);
    }
  }

  /**
   * Allows user of this template field to react to row selection events
   *
   * @param file
   *          the file that is represented by the clicked row
   * @throws ProcessingException
   */
  protected void execFileRowClick(File file) throws ProcessingException {
  }

  private Object[] fileToArray(File file) {
    String type = IOUtility.getFileExtension(file.getName());
    Long size = file.length();

    if (file.isDirectory()) {
      type = FileCodeType.DirectoryCode.ID;
      size = null;
    }
    else {
      if (CODES.getCodeType(FileCodeType.class).getCode(type) == null) {
        type = FileCodeType.UknownCode.ID;
      }

      size /= FILE_SIZE_FACTOR;
    }

    return new Object[]{file, file.getName(), size, type, new Date(file.lastModified()), !file.canWrite()};
  }

  @Order(10.0)
  public class DeleteKeyStroke extends AbstractKeyStroke {

    @Override
    protected String getConfiguredKeyStroke() {
      return "delete";
    }

    @Override
    protected void execAction() throws ProcessingException {
      getTable().getMenu(DeleteMenu.class).execAction();
    }
  }

  @Order(10.0)
  public class Table extends AbstractExtensibleTable {

    private Set<File> m_keys = new HashSet<File>();

    public SizeColumn getSizeColumn() {
      return getColumnSet().getColumnByClass(SizeColumn.class);
    }

    public TypeColumn getTypeColumn() {
      return getColumnSet().getColumnByClass(TypeColumn.class);
    }

    public ReadOnlyColumn getReadOnlyColumn() {
      return getColumnSet().getColumnByClass(ReadOnlyColumn.class);
    }

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    @Override
    protected String getConfiguredDefaultIconId() {
      return AbstractIcons.ComposerFieldEntity;
    }

    @Override
    protected int getConfiguredDragType() {
      return TYPE_FILE_TRANSFER;
    }

    @Override
    protected int getConfiguredDropType() {
      return TYPE_FILE_TRANSFER;
    }

    @Override
    protected TransferObject execCopy(List<? extends ITableRow> rows) throws ProcessingException {
      //TODO [BUG] method call leads to runtime exceptions: tunnel is null ??
      return super.execCopy(rows);
    }

    @Override
    protected TransferObject execDrag(List<ITableRow> rows) throws ProcessingException {
      List<File> files = new ArrayList<File>();

      for (ITableRow row : rows) {
        files.add((File) row.getKeyValues().get(0));
      }

      return new FileListTransferObject(files);
    }

    @Override
    protected void execDrop(ITableRow row, TransferObject t) throws ProcessingException {
      clearErrorStatus();

      try {
        if (t.isFileList()) {
          for (File file : ((FileListTransferObject) t).getFiles()) {
            addFile(file);
          }
        }
      }
      catch (Exception e) {
        setErrorStatus(e.getMessage());
        throw e;
      }
    }

    protected void addFile(File file) throws ProcessingException {
      if (m_keys.contains(file)) {
        return;
      }

      ITableRow addedRow = addRowByArray(fileToArray(file));

      if (file.isDirectory()) {
        addedRow.setIconId(AbstractIcons.TreeNode);
      }

      m_keys.add(file);
    }

    @Override
    protected void execRowAction(ITableRow row) throws ProcessingException {
      getMenu(OpenMenu.class).execAction();
    }

    @Override
    protected void execRowClick(ITableRow row) throws ProcessingException {
      execFileRowClick((File) row.getKeyValues().get(0));
    }

    public DateModifiedColumn getDateModifiedColumn() {
      return getColumnSet().getColumnByClass(DateModifiedColumn.class);
    }

    public FileColumn getFileColumn() {
      return getColumnSet().getColumnByClass(TableFieldForm.MainBox.ExamplesBox.DefaultField.Table.FileColumn.class);
    }

    public NameColumn getNameColumn() {
      return getColumnSet().getColumnByClass(NameColumn.class);
    }

    @Order(10.0)
    public class FileColumn extends AbstractObjectColumn {

      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }

      @Override
      protected boolean getConfiguredPrimaryKey() {
        return true;
      }

      @Override
      protected boolean getConfiguredVisible() {
        return false;
      }
    }

    @Order(20.0)
    public class NameColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Name");
      }

      @Override
      protected int getConfiguredSortIndex() {
        return 0;
      }
    }

    @Order(30.0)
    public class SizeColumn extends AbstractLongColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Size");
      }

      @Override
      protected void execInitColumn() throws ProcessingException {
        setFormat(new DecimalFormat(FILE_SIZE_FORMAT));
      }
    }

    @Order(40.0)
    public class TypeColumn extends AbstractSmartColumn<String> {

      @Override
      protected Class<? extends ICodeType<?, String>> getConfiguredCodeType() {
        return FileCodeType.class;
      }

      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Type");
      }
    }

    @Order(50.0)
    public class DateModifiedColumn extends AbstractDateTimeColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("DateModified");
      }
    }

    @Order(60.0)
    public class ReadOnlyColumn extends AbstractBooleanColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("ReadOnly");
      }
    }

    @Order(10.0)
    public class OpenMenu extends AbstractExtensibleMenu {

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("OpenFile");
      }

      @Override
      protected void execAction() throws ProcessingException {
        for (ITableRow row : getSelectedRows()) {
          File file = (File) row.getKeyValues().get(0);
          SERVICES.getService(IShellService.class).shellOpen(file.getPath());
        }
      }
    }

    @Order(20.0)
    public class AddMenu extends AbstractExtensibleMenu {

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.<IMenuType> hashSet(TableMenuType.EmptySpace, TableMenuType.Header, TableMenuType.SingleSelection);
      }

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("AddFile");
      }

      @Override
      protected void execAction() throws ProcessingException {
        FileChooser fc = new FileChooser();

        fc.setTypeLoad(true);
        fc.setMultiSelect(true);
        List<File> files = fc.startChooser();

        for (File file : files) {
          addFile(file);
        }
      }

    }

    @Order(30.0)
    public class DeleteMenu extends AbstractExtensibleMenu {

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.<IMenuType> hashSet(TableMenuType.MultiSelection, TableMenuType.SingleSelection);
      }

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("DeleteFile");
      }

      @Override
      protected void execAction() throws ProcessingException {
        for (ITableRow row : getSelectedRows()) {
          m_keys.remove(row.getKeyValues().get(0));
          row.delete();
        }
      }
    }
  }
}
