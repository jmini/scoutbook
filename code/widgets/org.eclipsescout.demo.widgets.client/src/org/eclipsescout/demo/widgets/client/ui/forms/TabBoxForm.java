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
package org.eclipsescout.demo.widgets.client.ui.forms;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.checkbox.AbstractCheckBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.placeholder.AbstractPlaceholderField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.form.fields.tabbox.AbstractTabBox;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.ui.UserAgentUtility;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.CloseButton;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.ExamplesBox;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.FieldVisibilityBox;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.FieldVisibilityBox.Placeholder1Field;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.FieldVisibilityBox.VisibleDocumentsField;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox.CommentsBox;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox.CommentsBox.CommentsField;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox.DocumentsBox;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox.DocumentsBox.AddFileButton;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox.DocumentsBox.FileTableField;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox.MonthsBox;
import org.eclipsescout.demo.widgets.client.ui.forms.TabBoxForm.MainBox.TabBox.MonthsBox.MonthDetailsBox;
import org.eclipsescout.demo.widgets.client.ui.template.formfield.AbstractFileTableField;
import org.eclipsescout.demo.widgets.client.ui.template.formfield.AbstractFileTableField.Table.AddMenu;
import org.eclipsescout.demo.widgets.client.ui.template.formfield.AbstractMonthsBox;

public class TabBoxForm extends AbstractForm implements IPageForm {

  public TabBoxForm() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("TabBox");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  /**
   * @return the AddFileButton
   */
  public AddFileButton getAddFileButton() {
    return getFieldByClass(AddFileButton.class);
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  /**
   * @return the DocumentsBox
   */
  public DocumentsBox getDocumentsBox() {
    return getFieldByClass(DocumentsBox.class);
  }

  public ExamplesBox getExamplesBox() {
    return getFieldByClass(ExamplesBox.class);
  }

  /**
   * @return the FieldVisibilityBox
   */
  public FieldVisibilityBox getFieldVisibilityBox() {
    return getFieldByClass(FieldVisibilityBox.class);
  }

  /**
   * @return the FileTableField
   */
  public FileTableField getFileTableField() {
    return getFieldByClass(FileTableField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  /**
   * @return the CommentsBox
   */
  public CommentsBox getCommentsBox() {
    return getFieldByClass(CommentsBox.class);
  }

  /**
   * @return the CommentsField
   */
  public CommentsField getCommentsField() {
    return getFieldByClass(CommentsField.class);
  }

  /**
   * @return the VisibleDocumentsField
   */
  public VisibleDocumentsField getVisibleDocumentsField() {
    return getFieldByClass(VisibleDocumentsField.class);
  }

  /**
   * @return the MonthDetailsBox
   */
  public MonthDetailsBox getMonthDetailsBox() {
    return getFieldByClass(MonthDetailsBox.class);
  }

  /**
   * @return the MonthsBox
   */
  public MonthsBox getMonthsBox() {
    return getFieldByClass(MonthsBox.class);
  }

  /**
   * @return the Placeholder1Field
   */
  public Placeholder1Field getPlaceholder1Field() {
    return getFieldByClass(Placeholder1Field.class);
  }

  /**
   * @return the TabBox
   */
  public TabBox getTabBox() {
    return getFieldByClass(TabBox.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class ExamplesBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 1;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Examples");
      }

      @Override
      protected void execInitField() throws ProcessingException {
        if (UserAgentUtility.isSwtUi()) {
          setBorderVisible(false);
        }
      }

    }

    @Order(20.0)
    public class TabBox extends AbstractTabBox {

      @Order(10.0)
      public class MonthsBox extends AbstractGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Months");
        }

        @Order(10.0)
        public class MonthDetailsBox extends AbstractMonthsBox {

          @Override
          protected int getConfiguredGridH() {
            return 5;
          }
        }
      }

      @Order(20.0)
      public class CommentsBox extends AbstractGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Comments");
        }

        @Order(10.0)
        public class CommentsField extends AbstractStringField {

          @Override
          protected int getConfiguredGridH() {
            return 5;
          }

          @Override
          protected boolean getConfiguredLabelVisible() {
            return false;
          }

          @Override
          protected boolean getConfiguredMultilineText() {
            return true;
          }
        }
      }

      @Order(30.0)
      public class DocumentsBox extends AbstractGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Documents");
        }

        @Order(10.0)
        public class FileTableField extends AbstractFileTableField {

          @Override
          protected int getConfiguredGridH() {
            return 5;
          }

          @Override
          protected boolean getConfiguredLabelVisible() {
            return false;
          }
        }

        @Order(20.0)
        public class AddFileButton extends AbstractButton {

          @Override
          protected int getConfiguredDisplayStyle() {
            return DISPLAY_STYLE_LINK;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("AddFile");
          }

          @Override
          protected void execClickAction() throws ProcessingException {
            getFileTableField().getTable().getMenu(AddMenu.class).doAction();
          }
        }
      }
    }

    @Order(30.0)
    public class FieldVisibilityBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 1;
      }

      @Override
      protected double getConfiguredGridWeightY() {
        return 0.0;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("TabVisibility");
      }

      @Order(10.0)
      public class VisibleMonthsField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleMonths");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getMonthsBox().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getMonthsBox().isVisible());
        }
      }

      @Order(20.0)
      public class VisibleCommentsField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleComments0");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getCommentsBox().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getCommentsBox().isVisible());
        }

      }

      @Order(30.0)
      public class VisibleDocumentsField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleDocuments0");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getDocumentsBox().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getDocumentsBox().isVisible());
        }
      }

      @Order(40.0)
      public class Placeholder1Field extends AbstractPlaceholderField {
      }

    }

    @Order(40.0)
    public class CloseButton extends AbstractCloseButton {
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}
