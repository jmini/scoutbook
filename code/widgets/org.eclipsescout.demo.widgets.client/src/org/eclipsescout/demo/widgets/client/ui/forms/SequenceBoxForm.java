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

import java.util.Date;

import org.eclipse.scout.commons.StringUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.checkbox.AbstractCheckBox;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateField;
import org.eclipse.scout.rt.client.ui.form.fields.doublefield.AbstractDoubleField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.imagebox.AbstractImageField;
import org.eclipse.scout.rt.client.ui.form.fields.integerfield.AbstractIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.placeholder.AbstractPlaceholderField;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.messagebox.MessageBox;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.CloseButton;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.CompanySearchBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.CompanySearchBox.CompanyField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.CompanySearchBox.CompanySearchButton;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.CompanySearchBox.EmployeesField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.CompanySearchBox.IndustryField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.DefaultBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.DefaultBox.FromField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.DefaultBox.ToField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.DisabledBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.DisabledBox.DisabledFrom;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.DisabledBox.DisabledTo;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.MandatoryBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.MandatoryBox.MandatoryFrom;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.FromToBox.MandatoryBox.MandatoryTo;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.HorizontalFieldGroupBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.HorizontalFieldGroupBox.SearchBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.HorizontalFieldGroupBox.SearchBox.FirstNameField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.HorizontalFieldGroupBox.SearchBox.FormResetButton;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.HorizontalFieldGroupBox.SearchBox.IconField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.HorizontalFieldGroupBox.SearchBox.LastNameField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.HorizontalFieldGroupBox.SearchBox.SearchButton;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.ExamplesBox.Placeholder1Field;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.FieldVisibilityBox;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.FieldVisibilityBox.VisibleCompanyField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.FieldVisibilityBox.VisibleEmployeeField;
import org.eclipsescout.demo.widgets.client.ui.forms.SequenceBoxForm.MainBox.FieldVisibilityBox.VisibleIndustryField;
import org.eclipsescout.demo.widgets.shared.Icons;
import org.eclipsescout.demo.widgets.shared.services.code.IndustryICBCodeType;

public class SequenceBoxForm extends AbstractForm implements IPageForm {

  public SequenceBoxForm() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("SequenceBox");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  /**
   * @return the DefaultBox
   */
  public DefaultBox getDefaultBox() {
    return getFieldByClass(DefaultBox.class);
  }

  /**
   * @return the DisabledBox
   */
  public DisabledBox getDisabledBox() {
    return getFieldByClass(DisabledBox.class);
  }

  /**
   * @return the DisabledFrom
   */
  public DisabledFrom getDisabledFrom() {
    return getFieldByClass(DisabledFrom.class);
  }

  /**
   * @return the DisabledTo
   */
  public DisabledTo getDisabledTo() {
    return getFieldByClass(DisabledTo.class);
  }

  /**
   * @return the EmployeesField
   */
  public EmployeesField getEmployeesField() {
    return getFieldByClass(EmployeesField.class);
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
   * @return the FirstNameField
   */
  public FirstNameField getFirstNameField() {
    return getFieldByClass(FirstNameField.class);
  }

  /**
   * @return the FormResetButton
   */
  public FormResetButton getFormResetButton() {
    return getFieldByClass(FormResetButton.class);
  }

  /**
   * @return the FromField
   */
  public FromField getFromField() {
    return getFieldByClass(FromField.class);
  }

  /**
   * @return the FromToBox
   */
  public FromToBox getFromToBox() {
    return getFieldByClass(FromToBox.class);
  }

  /**
   * @return the IconField
   */
  public IconField getIconField() {
    return getFieldByClass(IconField.class);
  }

  /**
   * @return the IndustryField
   */
  public IndustryField getIndustryField() {
    return getFieldByClass(IndustryField.class);
  }

  /**
   * @return the LastNameField
   */
  public LastNameField getLastNameField() {
    return getFieldByClass(LastNameField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  /**
   * @return the CompanyField
   */
  public CompanyField getCompanyField() {
    return getFieldByClass(CompanyField.class);
  }

  /**
   * @return the CompanySearchBox
   */
  public CompanySearchBox getCompanySearchBox() {
    return getFieldByClass(CompanySearchBox.class);
  }

  /**
   * @return the CompanySearchButton
   */
  public CompanySearchButton getCompanySearchButton() {
    return getFieldByClass(CompanySearchButton.class);
  }

  /**
   * @return the MandatoryBox
   */
  public MandatoryBox getMandatoryBox() {
    return getFieldByClass(MandatoryBox.class);
  }

  /**
   * @return the MandatoryFrom
   */
  public MandatoryFrom getMandatoryFrom() {
    return getFieldByClass(MandatoryFrom.class);
  }

  /**
   * @return the MandatoryTo
   */
  public MandatoryTo getMandatoryTo() {
    return getFieldByClass(MandatoryTo.class);
  }

  /**
   * @return the HorizontalFieldGroupBox
   */
  public HorizontalFieldGroupBox getHorizontalFieldGroupBox() {
    return getFieldByClass(HorizontalFieldGroupBox.class);
  }

  /**
   * @return the Placeholder1Field
   */
  public Placeholder1Field getPlaceholder1Field() {
    return getFieldByClass(Placeholder1Field.class);
  }

  /**
   * @return the SearchBox
   */
  public SearchBox getSearchBox() {
    return getFieldByClass(SearchBox.class);
  }

  /**
   * @return the SearchButton
   */
  public SearchButton getSearchButton() {
    return getFieldByClass(SearchButton.class);
  }

  /**
   * @return the ToField
   */
  public ToField getToField() {
    return getFieldByClass(ToField.class);
  }

  /**
   * @return the VisibleCompanyField
   */
  public VisibleCompanyField getVisibleCompanyField() {
    return getFieldByClass(VisibleCompanyField.class);
  }

  /**
   * @return the VisibleMonthsField
   */
  public VisibleEmployeeField getVisibleEmployeeField() {
    return getFieldByClass(VisibleEmployeeField.class);
  }

  /**
   * @return the VisibleCommentsField
   */
  public VisibleIndustryField getVisibleIndustryField() {
    return getFieldByClass(VisibleIndustryField.class);
  }

  /**
   * @return the undefined
   */
  public FromField getfromField() {
    return getFieldByClass(FromField.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(20.0)
    public class ExamplesBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 1;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Examples");
      }

      @Order(10.0)
      public class FromToBox extends AbstractGroupBox {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FromToUsage");
        }

        @Order(10.0)
        public class DefaultBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Default");
          }

          @Order(10.0)
          public class FromField extends AbstractDoubleField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("from");
            }
          }

          @Order(20.0)
          public class ToField extends AbstractDoubleField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("to");
            }
          }
        }

        @Order(20.0)
        public class MandatoryBox extends AbstractSequenceBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Mandatory");
          }

          @Order(10.0)
          public class MandatoryFrom extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("from");
            }

            @Override
            protected boolean getConfiguredMandatory() {
              return true;
            }
          }

          @Order(20.0)
          public class MandatoryTo extends AbstractDateField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("to");
            }
          }
        }

        @Order(30.0)
        public class DisabledBox extends AbstractSequenceBox {

          @Override
          protected boolean getConfiguredEnabled() {
            return false;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Disabled");
          }

          @Override
          protected void execInitField() throws ProcessingException {
            Date now = new Date();
            Date nineteen70 = new Date();
            nineteen70.setTime(0);

            getDisabledFrom().setValue(nineteen70);
            getDisabledTo().setValue(now);
          }

          @Order(10.0)
          public class DisabledFrom extends AbstractDateField {

            @Override
            protected boolean getConfiguredEnabled() {
              return false;
            }

            @Override
            protected boolean getConfiguredHasTime() {
              return true;
            }

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("from");
            }
          }

          @Order(20.0)
          public class DisabledTo extends AbstractDateField {

            @Override
            protected boolean getConfiguredEnabled() {
              return false;
            }

            @Override
            protected boolean getConfiguredHasTime() {
              return true;
            }

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("to");
            }
          }
        }
      }

      @Order(20.0)
      public class HorizontalFieldGroupBox extends AbstractGroupBox {

        @Override
        protected int getConfiguredGridW() {
          return 1;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("HorizontalFieldGroupUsage");
        }

        @Order(10.0)
        public class SearchBox extends AbstractSequenceBox {

          @Override
          protected boolean getConfiguredAutoCheckFromTo() {
            return false;
          }

          // TODO: [BUG] this property seems to be pretty broken
          @Override
          protected boolean getConfiguredEqualColumnWidths() {
            return false;
          }

          @Override
          protected boolean getConfiguredLabelVisible() {
            return false;
          }

          @Order(10.0)
          public class IconField extends AbstractImageField {

            @Override
            protected int getConfiguredHorizontalAlignment() {
              return 1;
            }

            @Override
            protected String getConfiguredImageId() {
              return Icons.Eye;
            }

            @Override
            protected int getConfiguredWidthInPixel() {
              return 150;
            }
          }

          @Order(20.0)
          public class FirstNameField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("FirstName");
            }

            @Override
            protected int getConfiguredLabelPosition() {
              return LABEL_POSITION_ON_FIELD;
            }
          }

          @Order(30.0)
          public class LastNameField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("LastName");
            }

            @Override
            protected int getConfiguredLabelPosition() {
              return LABEL_POSITION_ON_FIELD;
            }
          }

          @Order(40.0)
          public class SearchButton extends AbstractButton {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Search");
            }

            @Override
            protected void execClickAction() throws ProcessingException {
              String name = StringUtility.concatenateTokens(getFirstNameField().getValue(), " ", getLastNameField().getValue());

              if (name.length() > 0) {
                MessageBox msgbox = new MessageBox(null, TEXTS.get("SearchPerson", name), null, null, null, null, null, null);
                msgbox.setAutoCloseMillis(2500);
                msgbox.startMessageBox(0);
              }
            }
          }

          @Order(50.0)
          public class FormResetButton extends AbstractButton {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("FormReset");
            }

            @Override
            protected void execClickAction() throws ProcessingException {
              getFirstNameField().setValue(null);
              getLastNameField().setValue(null);
            }
          }
        }

      }

      @Order(30.0)
      public class Placeholder1Field extends AbstractPlaceholderField {
      }

      @Order(40.0)
      public class CompanySearchBox extends AbstractSequenceBox {

        @Override
        protected boolean getConfiguredAutoCheckFromTo() {
          return false;
        }

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Order(10.0)
        public class CompanyField extends AbstractStringField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Company");
          }
        }

        @Order(20.0)
        public class EmployeesField extends AbstractIntegerField {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Employees");
          }
        }

        @Order(30.0)
        public class IndustryField extends AbstractSmartField<Long> {

          @Override
          protected Class<? extends ICodeType<?, Long>> getConfiguredCodeType() {
            return IndustryICBCodeType.class;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Industry");
          }
        }

        @Order(40.0)
        public class CompanySearchButton extends AbstractButton {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Retrieve");
          }
        }
      }
    }

    @Order(20.0)
    public class FieldVisibilityBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 1;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("FieldVisibility");
      }

      @Order(40.0)
      public class VisibleCompanyField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleCompany");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getCompanyField().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getCompanyField().isVisible());
        }
      }

      @Order(50.0)
      public class VisibleEmployeeField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleEmployee");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getEmployeesField().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getEmployeesField().isVisible());
        }
      }

      @Order(60.0)
      public class VisibleIndustryField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleIndustry0");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getIndustryField().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getIndustryField().isVisible());
        }
      }
    }

    @Order(30.0)
    public class CloseButton extends AbstractCloseButton {
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}
