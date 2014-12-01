/**
 *
 */
package org.eclipsescout.demo.widgets.shared;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

/**
 * @author mzi
 */
public class FileCodeType extends AbstractCodeType<String, String> {

  private static final long serialVersionUID = 1L;
  /**
   *
   */
  public static final String ID = "File Types";

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public FileCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("File");
  }

  @Override
  public String getId() {
    return ID;
  }

  @Order(10.0)
  public static class HtmlCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;
    public static final String ID = "html";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("HTMLDocument");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class TextCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;
    public static final String ID = "txt";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("TextDocument");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class JpgCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;
    public static final String ID = "jpg";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("JpgImage");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(40.0)
  public static class PngCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;
    public static final String ID = "png";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("PngImage");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(50.0)
  public static class JavaCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;
    public static final String ID = "java";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("JavaFile");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(60.0)
  public static class PdfCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;

    public static final String ID = "pdf";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("PdfDocument");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(70.0)
  public static class UknownCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;

    public static final String ID = "__UNKNOWN__";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Unknown");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(80.0)
  public static class DirectoryCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;

    public static final String ID = "__DIR__";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Directory");
    }

    @Override
    public String getId() {
      return ID;
    }
  }
}
