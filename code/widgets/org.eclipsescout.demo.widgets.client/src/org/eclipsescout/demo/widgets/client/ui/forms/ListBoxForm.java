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

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.scout.commons.StringUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.IValueField;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractLinkButton;
import org.eclipse.scout.rt.client.ui.form.fields.checkbox.AbstractCheckBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.labelfield.AbstractLabelField;
import org.eclipse.scout.rt.client.ui.form.fields.listbox.AbstractListBox;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.CODES;
import org.eclipse.scout.rt.shared.services.common.code.ICode;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;
import org.eclipse.scout.rt.shared.services.lookup.LookupRow;
import org.eclipsescout.demo.widgets.client.services.lookup.FontStyleLookupCall;
import org.eclipsescout.demo.widgets.client.services.lookup.UserContentListLookupCall;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.CloseButton;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ConfigurationBox;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ConfigurationBox.CheckUncheckBox;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ConfigurationBox.CheckUncheckBox.CheckAllButton;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ConfigurationBox.CheckUncheckBox.UncheckAllButton;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ConfigurationBox.FilterCheckedRowsValueField;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ConfigurationBox.ListBoxField;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ConfigurationBox.ListEntriesField;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ExamplesBox;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ExamplesBox.DefaultField;
import org.eclipsescout.demo.widgets.client.ui.forms.ListBoxForm.MainBox.ExamplesBox.DisabledField;
import org.eclipsescout.demo.widgets.client.ui.template.formfield.AbstractUserTreeField;
import org.eclipsescout.demo.widgets.shared.services.code.ColorsCodeType;

public class ListBoxForm extends AbstractForm implements IPageForm {

  public ListBoxForm() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("ListBox");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  /**
   * @return the CheckAllButton
   */
  public CheckAllButton getCheckAllButton() {
    return getFieldByClass(CheckAllButton.class);
  }

  /**
   * @return the CheckUncheckBox
   */
  public CheckUncheckBox getCheckUncheckBox() {
    return getFieldByClass(CheckUncheckBox.class);
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  public ExamplesBox getExamplesBox() {
    return getFieldByClass(ExamplesBox.class);
  }

  public DefaultField getDefaultField() {
    return getFieldByClass(DefaultField.class);
  }

  public DisabledField getDisabledField() {
    return getFieldByClass(DisabledField.class);
  }

  public ConfigurationBox getConfigurationBox() {
    return getFieldByClass(ConfigurationBox.class);
  }

  /**
   * @return the FilterCheckedRowsValueField
   */
  public FilterCheckedRowsValueField getFilterCheckedRowsValueField() {
    return getFieldByClass(FilterCheckedRowsValueField.class);
  }

  /**
   * @return the TreeField
   */
  public ListBoxField getListBoxField() {
    return getFieldByClass(ListBoxField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  /**
   * @return the TreeEntriesField
   */
  public ListEntriesField getListEntriesField() {
    return getFieldByClass(ListEntriesField.class);
  }

  /**
   * @return the UncheckAllButton
   */
  public UncheckAllButton getUncheckAllButton() {
    return getFieldByClass(UncheckAllButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class ExamplesBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Examples");
      }

      @Order(10.0)
      public class ListBoxWithCodeTypeContentField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("EmptyString");
        }

        @Override
        protected String getConfiguredFont() {
          return "BOLD";
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(TEXTS.get("ListBoxWithCodeTypeContent"));
        }
      }

      @Order(20.0)
      public class DefaultField extends AbstractListBox<Color> {

        @Override
        protected Class<? extends ICodeType<?, Color>> getConfiguredCodeType() {
          return ColorsCodeType.class;
        }

        @Override
        protected int getConfiguredGridH() {
          return 5;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Default");
        }
      }

      @Order(30.0)
      public class DisabledField extends AbstractListBox<Color> {

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }

        @Override
        protected int getConfiguredGridH() {
          return 3;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Disabled");
        }

        @Override
        protected Class<? extends ICodeType<?, Color>> getConfiguredCodeType() {
          return ColorsCodeType.class;
        }

        @Override
        protected void execInitField() throws ProcessingException {
          Set<Color> colors = new HashSet<>();

          colors.add(ColorsCodeType.GreenCode.ID);
          colors.add(ColorsCodeType.BlueCode.ID);
          // get a dynamically added code
          ICode<Color> red = CODES.getCodeType(ColorsCodeType.class).getCode(Color.RED);
          colors.add(red.getId());

          setValue(colors);
          setFilterCheckedRowsValue(true);
        }
      }

      @Order(40.0)
      public class ListBoxWithLookupCallContentField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("EmptyString");
        }

        @Override
        protected String getConfiguredFont() {
          return "BOLD";
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(TEXTS.get("ListBoxWithLookupCallContent"));
        }
      }

      @Order(50.0)
      public class DefaultListBox extends AbstractListBox<Integer> {

        @Override
        protected int getConfiguredGridH() {
          return 5;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Default");
        }

        @Override
        protected Class<? extends ILookupCall<Integer>> getConfiguredLookupCall() {
          return (Class<? extends ILookupCall<Integer>>) FontStyleLookupCall.class;
        }
      }

      @Order(60.0)
      public class DisabledListBox extends AbstractListBox<Integer> {

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }

        @Override
        protected int getConfiguredGridH() {
          return 3;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Disabled");
        }

        @Override
        protected Class<? extends ILookupCall<Integer>> getConfiguredLookupCall() {
          return (Class<? extends ILookupCall<Integer>>) FontStyleLookupCall.class;
        }

        @Override
        protected void execInitField() throws ProcessingException {
          Set<Integer> set = new HashSet<>();
          set.add(2);
          set.add(3);
          setValue(set);
          setFilterCheckedRowsValue(true);
        }
      }
    }

    @Order(20.0)
    public class ConfigurationBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Configure");
      }

      @Order(10.0)
      public class ListBoxField extends AbstractListBox<String> {

        @Override
        protected int getConfiguredGridH() {
          return 4;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ListBox");
        }

        @Override
        protected Class<? extends ILookupCall<String>> getConfiguredLookupCall() {
          return (Class<? extends ILookupCall<String>>) UserContentListLookupCall.class;
        }
      }

      @Order(20.0)
      public class CheckUncheckBox extends AbstractSequenceBox {

        @Order(10.0)
        public class CheckAllButton extends AbstractLinkButton {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("CheckAll");
          }

          @Override
          protected void execClickAction() throws ProcessingException {
            getListBoxField().checkAllKeys();
          }
        }

        @Order(20.0)
        public class UncheckAllButton extends AbstractLinkButton {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("UncheckAll");
          }

          @Override
          protected void execClickAction() throws ProcessingException {
            getListBoxField().uncheckAllKeys();
          }
        }
      }

      @Order(30.0)
      public class GetCheckedKeysField extends AbstractStringField {

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("getCheckedKeys");
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return ListBoxForm.MainBox.ConfigurationBox.ListBoxField.class;
        }

        @Override
        protected void execChangedMasterValue(Object newMasterValue) throws ProcessingException {
          Set<String> keys = getListBoxField().getCheckedKeys();
          setValue(StringUtility.join(";", keys.toArray(new String[0])));
        }
      }

      @Order(40.0)
      public class ListEntriesField extends AbstractUserTreeField {

        @Override
        protected int getConfiguredGridH() {
          return 5;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ListContent");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          List<Node> nodes = parseFieldValue(false);
          List<LookupRow<String>> rows = new ArrayList<>();

          addNodesToLookupRows(nodes, rows);
          ((UserContentListLookupCall) getListBoxField().getLookupCall()).setLookupRows(rows);

          try {
            getListBoxField().initField();
          }
          catch (ProcessingException e) {
            e.printStackTrace();
          }
        }
      }

      @Order(50.0)
      public class FilterCheckedRowsValueField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FilterCheckedRowsValue");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getListBoxField().setFilterCheckedRowsValue(getValue());
        }
      }
    }

    @Order(30.0)
    public class SampleContentButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("SampleContent");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        ListEntriesField listEntries = getListEntriesField();
        listEntries.setValue(TEXTS.get("ListBoxUserContent"));
      }
    }

    @Order(40.0)
    public class CloseButton extends AbstractCloseButton {
    }

  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}
