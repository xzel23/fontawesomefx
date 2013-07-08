/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.javafx.fontawesome;

/**
 *
 * @author Jens
 */
public enum AwesomeIconsStyle {

  ICONS_STYLE_PLAIN("/styles/icons.css"),
  ICONS_STYLE_DARK("/styles/icons_dark.css"),
  ICONS_STYLE_LIGHT("/styles/icons_light.css"),
  ICONS_STYLE_BLUE("/styles/icons_blue.css"),
  ICONS_STYLE_RED("/styles/icons_red.css");

  private final String stylePath;

  private AwesomeIconsStyle(String stylePath) {
    this.stylePath = stylePath;
  }
  

  @Override
  public String toString() {
    return stylePath;
  }
}
