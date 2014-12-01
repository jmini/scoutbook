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

import java.math.BigInteger;
import java.text.DecimalFormat;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.IValueField;
import org.eclipse.scout.rt.client.ui.form.fields.bigintegerfield.AbstractBigIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.checkbox.AbstractCheckBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.integerfield.AbstractIntegerField;
import org.eclipse.scout.rt.client.ui.form.fields.labelfield.AbstractLabelField;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;
import org.eclipse.scout.rt.client.ui.form.fields.placeholder.AbstractPlaceholderField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.CloseButton;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.BigIntegerInputField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.FormatField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.GetValue0Field;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.GroupingField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.InputField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.LongInputField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.MaximumValueField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.MinimumValueField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.Place1Field;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.Place2Field;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.Place3Field;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.Place4Field;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ConfigurationBox.Place5Field;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.BigIntDisabledField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.BigIntMandatoryField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.BigIntStyledField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.BigIntegerColumnField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.BigIntegerField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.DisabledField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.IntegerColumnField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.IntegerField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.LongColumnField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.LongDisabledField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.LongField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.LongMandatoryField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.LongStyledField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.MandatoryField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.ExamplesBox.StyledField;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.HighestValueButton;
import org.eclipsescout.demo.widgets.client.ui.forms.NumberFieldsForm.MainBox.SmallestValueButton;

public class NumberFieldsForm extends AbstractForm implements IPageForm {

  public NumberFieldsForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("NumberFields");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  public FormatField getFormatField() {
    return getFieldByClass(FormatField.class);
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  public DisabledField getDisabledField() {
    return getFieldByClass(DisabledField.class);
  }

  public GetValue0Field getGetValue0Field() {
    return getFieldByClass(GetValue0Field.class);
  }

  public GroupingField getGroupingField() {
    return getFieldByClass(GroupingField.class);
  }

  public HighestValueButton getHighestValueButton() {
    return getFieldByClass(HighestValueButton.class);
  }

  public InputField getInputField() {
    return getFieldByClass(InputField.class);
  }

  public IntegerColumnField getIntegerColumnField() {
    return getFieldByClass(IntegerColumnField.class);
  }

  public IntegerField getIntegerField() {
    return getFieldByClass(IntegerField.class);
  }

  public LongColumnField getLongColumnField() {
    return getFieldByClass(LongColumnField.class);
  }

  public LongDisabledField getLongDisabledField() {
    return getFieldByClass(LongDisabledField.class);
  }

  public LongField getLongField() {
    return getFieldByClass(LongField.class);
  }

  public LongInputField getLongInputField() {
    return getFieldByClass(LongInputField.class);
  }

  public LongMandatoryField getLongMandatoryField() {
    return getFieldByClass(LongMandatoryField.class);
  }

  public LongStyledField getLongStyledField() {
    return getFieldByClass(LongStyledField.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public BigIntDisabledField getBigIntDisabledField() {
    return getFieldByClass(BigIntDisabledField.class);
  }

  public BigIntMandatoryField getBigIntMandatoryField() {
    return getFieldByClass(BigIntMandatoryField.class);
  }

  public BigIntStyledField getBigIntStyledField() {
    return getFieldByClass(BigIntStyledField.class);
  }

  public BigIntegerColumnField getBigIntegerColumnField() {
    return getFieldByClass(BigIntegerColumnField.class);
  }

  public BigIntegerField getBigIntegerField() {
    return getFieldByClass(BigIntegerField.class);
  }

  public BigIntegerInputField getBigIntegerInputField() {
    return getFieldByClass(BigIntegerInputField.class);
  }

  public MandatoryField getMandatoryField() {
    return getFieldByClass(MandatoryField.class);
  }

  public MaximumValueField getMaximumValueField() {
    return getFieldByClass(MaximumValueField.class);
  }

  public MinimumValueField getMinimumValueField() {
    return getFieldByClass(MinimumValueField.class);
  }

  public ExamplesBox getExamplesBox() {
    return getFieldByClass(ExamplesBox.class);
  }

  public Place1Field getPlace1Field() {
    return getFieldByClass(Place1Field.class);
  }

  public Place2Field getPlace2Field() {
    return getFieldByClass(Place2Field.class);
  }

  public Place3Field getPlace3Field() {
    return getFieldByClass(Place3Field.class);
  }

  public Place4Field getPlace4Field() {
    return getFieldByClass(Place4Field.class);
  }

  public Place5Field getPlace5Field() {
    return getFieldByClass(Place5Field.class);
  }

  public SmallestValueButton getSmallestValueButton() {
    return getFieldByClass(SmallestValueButton.class);
  }

  public ConfigurationBox getConfigurationBox() {
    return getFieldByClass(ConfigurationBox.class);
  }

  public StyledField getStyledField() {
    return getFieldByClass(StyledField.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class ExamplesBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 3;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Examples");
      }

      @Override
      protected boolean getConfiguredMandatory() {
        return true;
      }

      @Order(10.0)
      public class IntegerColumnField extends AbstractLabelField {

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
          setValue(TEXTS.get("IntegerField"));
        }
      }

      @Order(20.0)
      public class IntegerField extends AbstractIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Default");
        }
      }

      @Order(30.0)
      public class MandatoryField extends AbstractIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Mandatory");
        }

        @Override
        protected boolean getConfiguredMandatory() {
          return true;
        }
      }

      @Order(40.0)
      public class DisabledField extends AbstractIntegerField {

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
          setValue(5);
        }
      }

      @Order(50.0)
      public class StyledField extends AbstractIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Styled");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          if (getValue() < 0) {
            setForegroundColor("FF0000");
          }
          else {
            setForegroundColor("0000FF");
          }
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(-3);
          execChangedValue();
        }
      }

      @Order(60.0)
      public class LongColumnField extends AbstractLabelField {
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
          setValue(TEXTS.get("LongField"));
        }
      }

      @Order(70.0)
      public class LongField extends AbstractLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Default");
        }
      }

      @Order(80.0)
      public class LongMandatoryField extends AbstractLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Mandatory");
        }

        @Override
        protected boolean getConfiguredMandatory() {
          return true;
        }
      }

      @Order(90.0)
      public class LongDisabledField extends AbstractLongField {

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
          setValue(5L);
        }
      }

      @Order(100.0)
      public class LongStyledField extends AbstractLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Styled");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          if (getValue() < 0) {
            setForegroundColor("FF0000");
          }
          else {
            setForegroundColor("0000FF");
          }
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(-3L);
          execChangedValue();
        }
      }

      @Order(110.0)
      public class BigIntegerColumnField extends AbstractLabelField {
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
          setValue(TEXTS.get("BigIntegerField"));
        }
      }

      @Order(120.0)
      public class BigIntegerField extends AbstractBigIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("BigIntegerField");
        }
      }

      @Order(130.0)
      public class BigIntMandatoryField extends AbstractBigIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Mandatory");
        }

        @Override
        protected boolean getConfiguredMandatory() {
          return true;
        }
      }

      @Order(140.0)
      public class BigIntDisabledField extends AbstractBigIntegerField {

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
          setValue(BigInteger.valueOf(5));
        }
      }

      @Order(150.0)
      public class BigIntStyledField extends AbstractBigIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Styled");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          if (getValue().signum() < 0) {
            setForegroundColor("FF0000");
          }
          else {
            setForegroundColor("0000FF");
          }
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(BigInteger.valueOf(-3));
          execChangedValue();
        }
      }
    }

    @Order(20.0)
    public class ConfigurationBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 3;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Configure");
      }

      @Order(10.0)
      public class InputField extends AbstractIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("IntegerFieldInput");
        }
      }

      @Order(20.0)
      public class GetValue0Field extends AbstractStringField {

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("GetValue");
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return NumberFieldsForm.MainBox.ConfigurationBox.InputField.class;
        }

        @Override
        protected void execChangedMasterValue(Object newMasterValue) throws ProcessingException {
          if (newMasterValue != null) {
            setValue(((Integer) newMasterValue).toString());
          }
          else {
            setValue(null);
          }
        }

      }

      @Order(30.0)
      public class MinimumValueField extends AbstractLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("MinimumValue");
        }

        @Override
        protected String getConfiguredLabelFont() {
          return "ITALIC";
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          if (getValue() != null) {
            getInputField().setMinValue(getValue().intValue());
            getLongInputField().setMinValue(getValue());
            getBigIntegerInputField().setMinValue(BigInteger.valueOf(getValue()));
          }
          else {
            getInputField().setMinValue(null);
            getLongInputField().setMinValue(null);
            getBigIntegerInputField().setMinValue(null);
          }

          getInputField().validateContent();
          getLongInputField().validateContent();
          getBigIntegerInputField().validateContent();
        }
      }

      @Order(40.0)
      public class MaximumValueField extends AbstractLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("MaximumValue");
        }

        @Override
        protected String getConfiguredLabelFont() {
          return "ITALIC";
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          if (getValue() != null) {
            getInputField().setMaxValue(getValue().intValue());
            getLongInputField().setMaxValue(getValue());
            getBigIntegerInputField().setMaxValue(BigInteger.valueOf(getValue()));
          }
          else {
            getInputField().setMaxValue(null);
            getLongInputField().setMaxValue(null);
            getBigIntegerInputField().setMaxValue(null);
          }

          getInputField().validateContent();
          getLongInputField().validateContent();
          getBigIntegerInputField().validateContent();
        }
      }

      @Order(50.0)
      public class GroupingField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Grouping");
        }

        @Override
        protected String getConfiguredLabelFont() {
          return "ITALIC";
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getInputField().setGroupingUsed(getValue());
          getLongInputField().setGroupingUsed(getValue());
          getBigIntegerInputField().setGroupingUsed(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(true);
        }
      }

      @Order(60.0)
      public class FormatField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Format");
        }

        @Override
        protected String getConfiguredLabelFont() {
          return "ITALIC";
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          DecimalFormat format = new DecimalFormat();

          if (getValue() != null) {
            format = new DecimalFormat(getValue());
          }

          getInputField().setFormat(format);
          getLongInputField().setFormat(format);
          getBigIntegerInputField().setFormat(format);
        }
      }

      @Order(70.0)
      public class LongInputField extends AbstractLongField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LongFieldInput");
        }
      }

      @Order(80.0)
      public class GetValue1Field extends AbstractStringField {

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("GetValue");
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return NumberFieldsForm.MainBox.ConfigurationBox.LongInputField.class;
        }

        @Override
        protected void execChangedMasterValue(Object newMasterValue) throws ProcessingException {
          if (newMasterValue != null) {
            setValue(((Long) newMasterValue).toString());
          }
          else {
            setValue(null);
          }
        }
      }

      @Order(90.0)
      public class Place1Field extends AbstractPlaceholderField {
      }

      @Order(100.0)
      public class Place2Field extends AbstractPlaceholderField {
      }

      @Order(110.0)
      public class Place3Field extends AbstractPlaceholderField {

        @Override
        protected int getConfiguredGridH() {
          return 2;
        }
      }

      @Order(120.0)
      public class BigIntegerInputField extends AbstractBigIntegerField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("BigIntegerFieldInput");
        }
      }

      @Order(130.0)
      public class GetValue2Field extends AbstractStringField {

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("GetValue");
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return NumberFieldsForm.MainBox.ConfigurationBox.BigIntegerInputField.class;
        }

        @Override
        protected void execChangedMasterValue(Object newMasterValue) throws ProcessingException {
          if (newMasterValue != null) {
            setValue(((BigInteger) newMasterValue).toString());
          }
          else {
            setValue(null);
          }
        }
      }

      @Order(140.0)
      public class Place4Field extends AbstractPlaceholderField {
      }

      @Order(150.0)
      public class Place5Field extends AbstractPlaceholderField {
      }

      @Order(160.0)
      public class Place6Field extends AbstractPlaceholderField {
      }
    }

    @Order(40.0)
    public class HighestValueButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("HighestValue");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        getInputField().setValue(Integer.MAX_VALUE);
        getLongInputField().setValue(Long.MAX_VALUE);
        getBigIntegerInputField().setDisplayText("can get as large as you want");
      }
    }

    @Order(50.0)
    public class SmallestValueButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("SmallestValue");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        getInputField().setValue(Integer.MIN_VALUE);
        getLongInputField().setValue(Long.MIN_VALUE);
        getBigIntegerInputField().setDisplayText("can get as small as you want");
      }
    }

    @Order(60.0)
    public class SampleFormatButton extends AbstractButton {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("SampleFormat");
      }

      @Override
      protected void execClickAction() throws ProcessingException {
        getFormatField().setValue("'Prod-No.' 000,0000");
      }
    }

    @Order(70.0)
    public class CloseButton extends AbstractCloseButton {
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}
