/**
 *
 */
package org.eclipsescout.demo.widgets.shared.services.code;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;
import org.eclipse.scout.rt.shared.services.common.code.CodeRow;
import org.eclipse.scout.rt.shared.services.common.code.ICodeRow;

/**
 * @author mzi
 */
public class ColorsCodeType extends AbstractCodeType<Long, Color> {

  private static final long serialVersionUID = 1L;
  public static final Long ID = 20000L;

  public ColorsCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("Colors");
  }

  @Override
  public Long getId() {
    return ID;
  }

  @Override
  protected List<? extends ICodeRow<Color>> execLoadCodes(Class<? extends ICodeRow<Color>> codeRowType) throws ProcessingException {
    List<ICodeRow<Color>> codes = new ArrayList<>();

    codes.add(new CodeRow<Color>(Color.PINK, TEXTS.get("Pink")));
    codes.add(new CodeRow<Color>(Color.RED, TEXTS.get("Red")));
    codes.add(new CodeRow<Color>(Color.WHITE, TEXTS.get("White")));
    codes.add(new CodeRow<Color>(Color.YELLOW, TEXTS.get("YellowDynamic")));

    return codes;
  }

  @Order(10.0)
  public static class BlackCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.BLACK;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Black");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(80.0)
  public static class BlueCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.BLUE;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Blue");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(90.0)
  public static class CyanCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.CYAN;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Cyan");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class DarkGrayCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.DARK_GRAY;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("DarkGray");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class GrayCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.GRAY;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Gray");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(70.0)
  public static class GreenCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.GREEN;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Green");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(40.0)
  public static class LightGrayCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.LIGHT_GRAY;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("LightGray");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(100.0)
  public static class MagentaCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.MAGENTA;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Magenta");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(110.0)
  public static class OrangeCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.ORANGE;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Orange");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }

  @Order(120.0)
  public static class YellowCode extends AbstractCode<Color> {
    private static final long serialVersionUID = 1L;
    public static final Color ID = Color.YELLOW;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Yellow");
    }

    @Override
    public Color getId() {
      return ID;
    }
  }
}
