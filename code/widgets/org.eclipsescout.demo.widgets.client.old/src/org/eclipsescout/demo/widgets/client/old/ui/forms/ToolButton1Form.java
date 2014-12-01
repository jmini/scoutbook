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
package org.eclipsescout.demo.widgets.client.old.ui.forms;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateField;
import org.eclipse.scout.rt.client.ui.form.fields.filechooserfield.AbstractFileChooserField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.integerfield.AbstractIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.old.ui.forms.ToolButton1Form.MainBox.GroupBox;
import org.eclipsescout.demo.widgets.client.old.ui.forms.ToolButton1Form.MainBox.GroupBox.FileChooserField;
import org.eclipsescout.demo.widgets.client.old.ui.forms.ToolButton1Form.MainBox.GroupBox.IntegerField;
import org.eclipsescout.demo.widgets.client.old.ui.forms.ToolButton1Form.MainBox.GroupBox.SequenceBox;
import org.eclipsescout.demo.widgets.client.old.ui.forms.ToolButton1Form.MainBox.GroupBox.StringField;

public class ToolButton1Form extends AbstractForm {

  public ToolButton1Form() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("ToolButton1");
  }

  public void startTool() throws ProcessingException {
    startInternal(new ToolHandler());
  }

  public FileChooserField getFileChooserField() {
    return getFieldByClass(FileChooserField.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public IntegerField getIntegerField() {
    return getFieldByClass(IntegerField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public SequenceBox getSequenceBox() {
    return getFieldByClass(SequenceBox.class);
  }

  public StringField getStringField() {
    return getFieldByClass(StringField.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Override
    protected int getConfiguredGridColumnCount() {
      return 1;
    }

    @Order(50.0)
    public class GroupBox extends AbstractGroupBox {

      @Order(10.0)
      public class StringField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("StringField");
        }
      }

      @Order(20.0)
      public class SequenceBox extends AbstractSequenceBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("SequenceBox");
        }

        @Order(10.0)
        public class SequenceFrom extends AbstractDateField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("from");
          }
        }

        @Order(20.0)
        public class SequenceTo extends AbstractDateField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("to");
          }
        }
      }

      @Order(30.0)
      public class FileChooserField extends AbstractFileChooserField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FileChooserField");
        }

        @Override
        protected boolean getConfiguredTypeLoad() {
          return true;
        }
      }

      @Order(40.0)
      public class IntegerField extends AbstractIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("IntegerField");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_ON_FIELD;
        }
      }
    }
  }

  public class ToolHandler extends AbstractFormHandler {
  }
}
