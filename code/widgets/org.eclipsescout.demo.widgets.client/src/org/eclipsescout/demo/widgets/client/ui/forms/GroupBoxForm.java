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
import org.eclipse.scout.rt.client.ui.form.fields.checkbox.AbstractCheckBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.IGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.internal.HorizontalGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.internal.VerticalSmartGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.placeholder.AbstractPlaceholderField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.CloseButton;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example1Box;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example1Box.DefaultBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example1Box.SingleColumnBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example1Box.SingleColumnBox.CityField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example1Box.SingleColumnBox.CountryField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example2Box;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example2Box.HorizontalMonthsBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example2Box.VerticalMonthsBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example3Box;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example3Box.ScrollableBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example3Box.SectionBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example3Box.SectionBox.CommentField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example3Box.SectionBox.CompanyField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example3Box.SectionBox.FirstNameField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.ExamplesBox.Example3Box.SectionBox.LastNameField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.VisibilityBox;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.VisibilityBox.Placeholder2Field;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.VisibilityBox.VisibleCompanyField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.VisibilityBox.VisibleFirstNameField;
import org.eclipsescout.demo.widgets.client.ui.forms.GroupBoxForm.MainBox.VisibilityBox.VisibleLastNameField;
import org.eclipsescout.demo.widgets.client.ui.template.formfield.AbstractMonthsBox;

public class GroupBoxForm extends AbstractForm implements IPageForm {

  public GroupBoxForm() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredAskIfNeedSave() {
    return false;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("GroupBox");
  }

  @Override
  public void startPageForm() throws ProcessingException {
    startInternal(new PageFormHandler());
  }

  /**
   * @return the CityField
   */
  public CityField getCityField() {
    return getFieldByClass(CityField.class);
  }

  @Override
  public CloseButton getCloseButton() {
    return getFieldByClass(CloseButton.class);
  }

  /**
   * @return the CommentField
   */
  public CommentField getCommentField() {
    return getFieldByClass(CommentField.class);
  }

  /**
   * @return the CompanyField
   */
  public CompanyField getCompanyField() {
    return getFieldByClass(CompanyField.class);
  }

  /**
   * @return the CountryField
   */
  public CountryField getCountryField() {
    return getFieldByClass(CountryField.class);
  }

  /**
   * @return the DefaultBox
   */
  public DefaultBox getDefaultBox() {
    return getFieldByClass(DefaultBox.class);
  }

  /**
   * @return the Example1Box
   */
  public Example1Box getExample1Box() {
    return getFieldByClass(Example1Box.class);
  }

  /**
   * @return the Example2Box
   */
  public Example2Box getExample2Box() {
    return getFieldByClass(Example2Box.class);
  }

  //  /**
  //   * @return the Config1Box
  //   */
  //  public Config1Box getConfig1Box() {
  //    return getFieldByClass(Config1Box.class);
  //  }

  public ExamplesBox getExamplesBox() {
    return getFieldByClass(ExamplesBox.class);
  }

  /**
   * @return the FirstNameField
   */
  public FirstNameField getFirstNameField() {
    return getFieldByClass(FirstNameField.class);
  }

  /**
   * @return the HorizontalMonthsBox
   */
  public HorizontalMonthsBox getHorizontalMonthsBox() {
    return getFieldByClass(HorizontalMonthsBox.class);
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

  public Example3Box getExample3Box() {
    return getFieldByClass(Example3Box.class);
  }

  /**
   * @return the Placeholder2Field
   */
  public Placeholder2Field getPlaceholder2Field() {
    return getFieldByClass(Placeholder2Field.class);
  }

  /**
   * @return the ScrollableBox
   */
  public ScrollableBox getScrollableBox() {
    return getFieldByClass(ScrollableBox.class);
  }

  /**
   * @return the SectionBox
   */
  public SectionBox getSectionBox() {
    return getFieldByClass(SectionBox.class);
  }

  /**
   * @return the SingleColumnBox
   */
  public SingleColumnBox getSingleColumnBox() {
    return getFieldByClass(SingleColumnBox.class);
  }

  /**
   * @return the VerticalMonthsBox
   */
  public VerticalMonthsBox getVerticalMonthsBox() {
    return getFieldByClass(VerticalMonthsBox.class);
  }

  /**
   * @return the VisibilityBox
   */
  public VisibilityBox getVisibilityBox() {
    return getFieldByClass(VisibilityBox.class);
  }

  /**
   * @return the VisibleCompanyField
   */
  public VisibleCompanyField getVisibleCompanyField() {
    return getFieldByClass(VisibleCompanyField.class);
  }

  /**
   * @return the VisibleFirstNameField
   */
  public VisibleFirstNameField getVisibleFirstNameField() {
    return getFieldByClass(VisibleFirstNameField.class);
  }

  /**
   * @return the VisibleLastNameField
   */
  public VisibleLastNameField getVisibleLastNameField() {
    return getFieldByClass(VisibleLastNameField.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class ExamplesBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 5;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Examples");
      }

      @Order(10.0)
      public class Example1Box extends AbstractGroupBox {

        @Override
        protected boolean getConfiguredBorderVisible() {
          return false;
        }

        @Override
        protected int getConfiguredGridColumnCount() {
          return 5;
        }

        @Order(10.0)
        public class DefaultBox extends AbstractGroupBox {

          @Override
          protected int getConfiguredGridColumnCount() {
            return 2;
          }

          @Override
          protected int getConfiguredGridW() {
            return 3;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Default");
          }

          @Order(10.0)
          public class FirstNameField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("FirstName");
            }
          }

          @Order(20.0)
          public class LastNameField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("LastName");
            }
          }

          @Order(30.0)
          public class CompanyField extends AbstractStringField {

            @Override
            protected int getConfiguredGridH() {
              return 2;
            }

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Company");
            }

            @Override
            protected boolean getConfiguredMultilineText() {
              return true;
            }
          }

          @Order(50.0)
          public class CommentField extends AbstractStringField {

            @Override
            protected int getConfiguredGridW() {
              return 2;
            }

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Comments");
            }
          }
        }

        @Order(20.0)
        public class SingleColumnBox extends AbstractGroupBox {

          @Override
          protected int getConfiguredGridColumnCount() {
            return 1;
          }

          @Override
          protected int getConfiguredGridW() {
            return 2;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("SingleColumnBox");
          }

          @Order(10.0)
          public class CityField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("City");
            }
          }

          @Order(20.0)
          public class CountryField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Country");
            }
          }
        }
      }

      @Order(20.0)
      public class Example2Box extends AbstractGroupBox {

        @Override
        protected boolean getConfiguredBorderVisible() {
          return false;
        }

        @Override
        protected int getConfiguredGridColumnCount() {
          return 5;
        }

        @Order(10.0)
        public class VerticalMonthsBox extends AbstractMonthsBox {
          @Override
          protected Class<? extends IGroupBoxBodyGrid> getConfiguredBodyGrid() {
            return VerticalSmartGroupBoxBodyGrid.class;
          }

          @Override
          protected int getConfiguredGridColumnCount() {
            return 2;
          }

          @Override
          protected int getConfiguredGridW() {
            return 2;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("VertcalLayout");
          }
        }

        @Order(20.0)
        public class HorizontalMonthsBox extends AbstractMonthsBox {
          @Override
          protected Class<? extends IGroupBoxBodyGrid> getConfiguredBodyGrid() {
            return HorizontalGroupBoxBodyGrid.class;
          }

          @Override
          protected int getConfiguredGridColumnCount() {
            return 3;
          }

          @Override
          protected int getConfiguredGridW() {
            return 3;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("HorizontalLayout");
          }
        }

      }

      //    }

      @Order(30.0)
      public class Example3Box extends AbstractGroupBox {

        @Override
        protected boolean getConfiguredBorderVisible() {
          return false;
        }

        /**
         * @return the FirstNameField
         */
        public FirstNameField getFirstNameField() {
          return getFieldByClass(FirstNameField.class);
        }

        /**
         * @return the LastNameField
         */
        public LastNameField getLastNameField() {
          return getFieldByClass(LastNameField.class);
        }

        @Override
        protected int getConfiguredGridColumnCount() {
          return 5;
        }

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        /**
         * @return the CompanyField
         */
        public CompanyField getCompanyField() {
          return getFieldByClass(CompanyField.class);
        }

        @Order(10.0)
        public class SectionBox extends AbstractGroupBox {

          @Override
          protected String getConfiguredBorderDecoration() {
            return BORDER_DECORATION_SECTION;
          }

          @Override
          protected boolean getConfiguredExpandable() {
            return true;
          }

          @Override
          protected int getConfiguredGridH() {
            return 3;
          }

          @Override
          protected int getConfiguredGridW() {
            return 3;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Section");
          }

          @Override
          protected boolean getConfiguredFillVertical() {
            return false;
          }

          @Override
          protected int getConfiguredGridColumnCount() {
            return 2;
          }

          @Order(10.0)
          public class FirstNameField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("FirstName");
            }
          }

          @Order(20.0)
          public class LastNameField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("LastName");
            }
          }

          @Order(30.0)
          public class CompanyField extends AbstractStringField {

            @Override
            protected int getConfiguredGridH() {
              return 2;
            }

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Company");
            }

            @Override
            protected boolean getConfiguredMultilineText() {
              return true;
            }
          }

          @Order(50.0)
          public class CommentField extends AbstractStringField {

            @Override
            protected int getConfiguredGridW() {
              return 2;
            }

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Comments");
            }
          }
        }

        @Order(60.0)
        public class ScrollableBox extends AbstractMonthsBox {

          @Override
          protected int getConfiguredGridColumnCount() {
            return 1;
          }

          @Override
          protected boolean getConfiguredGridUseUiHeight() {
            return false;
          }

          @Override
          protected int getConfiguredGridW() {
            return 2;
          }

          @Override
          protected int getConfiguredHeightInPixel() {
            return 150;
          }

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Scrollable");
          }

          @Override
          protected boolean getConfiguredScrollable() {
            return true;
          }
        }
      }
    }

    @Order(20.0)
    public class VisibilityBox extends AbstractGroupBox {

      @Override
      protected double getConfiguredGridWeightY() {
        return 0.0;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("FieldVisibility");
      }

      @Order(10.0)
      public class VisibleFirstNameField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleFirstName");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getFirstNameField().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getFirstNameField().isVisible());
        }
      }

      @Order(20.0)
      public class VisibleLastNameField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleLastName");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getLastNameField().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getLastNameField().isVisible());
        }
      }

      @Order(30.0)
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

      @Order(40.0)
      public class Placeholder1Field extends AbstractPlaceholderField {
      }

      @Order(60.0)
      public class VisibleField extends AbstractCheckBox {

        @Override
        protected String getConfiguredFont() {
          return "ITALIC";
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("VisibleScrollable");
        }

        @Override
        protected void execChangedValue() throws ProcessingException {
          getScrollableBox().setVisible(getValue());
        }

        @Override
        protected void execInitField() throws ProcessingException {
          setValue(getScrollableBox().isVisible());
        }
      }

      @Order(70.0)
      public class Placeholder2Field extends AbstractPlaceholderField {

        @Override
        protected int getConfiguredGridH() {
          return 3;
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
