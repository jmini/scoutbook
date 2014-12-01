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
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.labelfield.AbstractLabelField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.ui.UserAgentUtility;
import org.eclipsescout.demo.widgets.client.ui.forms.LabelFieldForm.MainBox.CloseButton;

public class LabelFieldForm extends AbstractForm implements IPageForm {

  public LabelFieldForm() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("LabelField");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Override
    protected int getConfiguredGridColumnCount() {
      return 1;
    }

    @Order(10.0)
    public class ExamplesBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Examples");
      }

      @Order(10.0)
      public class LabelField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Default");
        }
      }

      @Order(20.0)
      public class DisabledField extends AbstractLabelField {

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Disabled");
        }
      }

      @Order(30.0)
      public class StyledField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Styled");
        }

        @Override
        protected String getConfiguredLabelFont() {
          return "BOLD-ITALIC";
        }

        @Override
        protected String getConfiguredLabelForegroundColor() {
          return "FF0000";
        }
      }
    }

    @Order(30.0)
    public class ConfigurationBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Configure");
      }

      @Order(10.0)
      public class TooLongLabelTextGetsTruncatedField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("TooLongLabelTextGetsTruncated");
        }
      }

      @Order(20.0)
      public class SetValueTextField extends AbstractLabelField {

        @Override
        protected String getConfiguredLabel() {
          return " ";
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(TEXTS.get("SetValueText"));
        }
      }

      @Order(30.0)
      public class MultilineLabelField extends AbstractLabelField {

        @Override
        protected int getConfiguredGridH() {
          return 2;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("MultilineLabel");
        }

        @Override
        protected boolean getConfiguredWrapText() {
          return true;
        }

        @Override
        protected void execInitField() {
          String value = TEXTS.get("Lorem");
          if (UserAgentUtility.isSwingUi()) {
            value = "<html>" + value + "</html>";
          }
          this.setValue(value);
        }
      }

      @Order(40.0)
      public class VeryLongLabelTextField extends AbstractLabelField {

        @Override
        protected int getConfiguredGridH() {
          return 2;
        }

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Override
        protected boolean getConfiguredWrapText() {
          return true;
        }

        @Override
        protected void execInitField() throws ProcessingException {
          if (UserAgentUtility.isSwingUi()) {
            setValue("<html>" + TEXTS.get("Lorem") + "</html>");
          }
          else {
            setValue(TEXTS.get("Lorem"));
          }
        }
      }
    }

    @Order(40.0)
    public class CloseButton extends AbstractCloseButton {
    }
  }

  public class PageFormHandler extends AbstractFormHandler {
  }
}
