/*
 * This file is part of the Weborganic XMLDoclet library.
 *
 * For licensing information please see the file license.txt included in the release.
 * A copy of this licence can also be found at
 *   http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.weborganic.xmldoclet;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;

/**
 * A collection of taglets to support the standard javadoc inline tags.
 *
 * <p>These will replace text within comments using XHTML for links.
 *
 * @author Christophe Lauret
 * @version 3 April 2010
 */
public enum InlineTag implements Taglet {

  CODE("code") {

    @Override
    public String toString(Tag tag) {
      return "<code><![CDATA["+tag.text()+"]]></code>";
    }

  },

  DOCROOT("docRoot") {

    @Override
    public String toString(Tag tag) {
      return "";
    }

  },

  INHERITDOC("inheritDoc") {

    @Override
    public String toString(Tag tag) {
      return "<div class=\"inherited\">"+tag.text()+"</div>";
    }

  },

  LINK("link"){

    @Override
    public String toString(Tag tag) {
      // TODO compute link
      return "<a href='#' title='"+tag.text()+"'>"+tag.text()+"</a>";
    }

  },

  LINKPLAIN("linkplain") {

    @Override
    public String toString(Tag tag) {
      // TODO
      return tag.text();
    }

  },

  LITERAL("literal") {

    @Override
    public String toString(Tag tag) {
      return "<![CDATA["+tag.text()+"]]>";
    }

  },

  VALUE("value"){

    @Override
    public String toString(Tag tag) {
      return "<var>"+tag.text()+"</var>";
    }

  };

  // enum class methods ===============================================================================================

  /**
   * The name of the tag
   */
  private final String _name;

  /**
   * Creates a new tag.
   *
   * @param name   The name of the tag.
   */
  InlineTag(String name) {
    this._name = name;
  }

  @Override
  public String getName() {
    return this._name;
  }

  @Override
  public boolean isInlineTag() {
    return true;
  }

  @Override
  public boolean inConstructor() {
    return true;
  }

  @Override
  public boolean inField(){
    return true;
  }

  @Override
  public boolean inMethod() {
    return true;
  }

  @Override
  public boolean inOverview() {
    return true;
  }

  @Override
  public boolean inPackage() {
    return true;
  }

  @Override
  public boolean inType() {
    return true;
  }

  @Override
  public String toString(Tag[] tags) {
    StringBuilder out = new StringBuilder();
    for (Tag t : tags) {
      out.append(toString(t));
    }
    return out.toString();
  }
}
