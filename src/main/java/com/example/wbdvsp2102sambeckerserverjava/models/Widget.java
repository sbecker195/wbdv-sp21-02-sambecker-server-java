package com.example.wbdvsp2102sambeckerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String topicId;
  private String name;
  private String type;
  private Integer widgetOrder;
  private String text;
  private Integer size;
  private String url;
  private String src;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private Boolean isOrdered;


  public Widget(Integer id, String topicId, String type, Integer size, String text, String name,
                Integer widgetOrder, String url, String src, Integer width, Integer height, String cssClass,
                String style, String value) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
    this.name = name;
    this.widgetOrder = widgetOrder;
    this.url = url;
    this.src = src;
    this.height = height;
    this.width = width;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.isOrdered = false;
  }

  public Widget() {
  }

  public Boolean getIsOrdered() {
    return isOrdered;
  }

  public void setIsOrdered(Boolean isOrdered) {
    this.isOrdered = isOrdered;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}