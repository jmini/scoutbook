/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.scout.docs.publish.task;

import java.io.File;
import java.io.IOException;

import org.eclipse.scout.docs.publish.PublishUtility;
import org.junit.Test;

/**
 * Task as JUnit Test to prepare publications of downloads (book).
 * Output folder: target/published-docs/downloads
 * Corresponding Git Repository: http://git.eclipse.org/c/scout/org.eclipse.scout.sdk.git/
 */
public class PublishDownloadsTest {

  private static final String HTML_OUT = "html";
  private static final String PDF_OUT = "pdf";
  private static final String ZIP_OUT = "zip";
  private File outFolder = new File("target/published-docs/downloads");

  private File outHelloWorld = new File(outFolder, "article_helloworld");
  private File outInstall = new File(outFolder, "article_install");
  private File outBookIntro = new File(outFolder, "book_scout_intro");
  private File outBookFrontend = new File(outFolder, "book_scout_frontend");

  @Test
  public void publishHelloWorldAsHtmlAndZip() throws IOException {
    File inFolder = new File("../../build/scout_helloworld/target/generated-docs");
    String inFileName = "scout_helloworld.html";

    PublishUtility.publishHtmlFile(inFolder, inFileName, new File(outHelloWorld, HTML_OUT));

    //TODO: create a zip.
  }

  @Test
  public void publishHelloWorldAsPdf() throws IOException {
    File inFolder = new File("../../build/scout_helloworld/target/generated-docs");
    String inFileName = "scout_helloworld.pdf";

    PublishUtility.publishPdfFile(inFolder, inFileName, new File(outHelloWorld, PDF_OUT));
  }

  @Test
  public void publishScoutInstallAsHtmlAndZip() throws IOException {
    File inFolder = new File("../../build/scout_install/target/generated-docs");
    String inFileName = "scout_install.html";

    PublishUtility.publishHtmlFile(inFolder, inFileName, new File(outInstall, HTML_OUT));

    //TODO: create a zip.
  }

  @Test
  public void publishScoutInstallAsPdf() throws IOException {
    File inFolder = new File("../../build/scout_install/target/generated-docs");
    String inFileName = "scout_install.pdf";

    PublishUtility.publishPdfFile(inFolder, inFileName, new File(outInstall, PDF_OUT));
  }

  @Test
  public void publishBookIntroAsHtmlAndZip() throws IOException {
    File inFolder = new File("../../build/book_scout_intro/target/generated-docs");
    String inFileName = "scout_intro.html";

    PublishUtility.publishHtmlFile(inFolder, inFileName, new File(outBookIntro, HTML_OUT));

    //TODO: create a zip.
  }

  @Test
  public void publishBookIntroAsPdf() throws IOException {
    File inFolder = new File("../../build/book_scout_intro/target/generated-docs");
    String inFileName = "scout_intro.pdf";

    PublishUtility.publishPdfFile(inFolder, inFileName, new File(outBookIntro, PDF_OUT));
  }

  @Test
  public void publishBookFrontEndAsHtmlAndZip() throws IOException {
    File inFolder = new File("../../build/book_scout_frontend/target/generated-docs");
    String inFileName = "scout_frontend.html";

    PublishUtility.publishHtmlFile(inFolder, inFileName, new File(outBookFrontend, HTML_OUT));

    //TODO: create a zip.
  }

  @Test
  public void publishBookFrontEndAsPdf() throws IOException {
    File inFolder = new File("../../build/book_scout_frontend/target/generated-docs");
    String inFileName = "scout_frontend.pdf";

    PublishUtility.publishPdfFile(inFolder, inFileName, new File(outBookFrontend, PDF_OUT));
  }
}
