package com.example.wbdvsp2102sambeckerserverjava.services;

import com.example.wbdvsp2102sambeckerserverjava.models.Widget;
import com.example.wbdvsp2102sambeckerserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {
//  private final List<Widget> widgets = new ArrayList<Widget>();

  @Autowired
  WidgetRepository repository;

  // implement crud operations
  public Widget createWidget(String tid, Widget widget) {
    widget.setTopicId(tid);
    return repository.save(widget);
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
  }

  public Integer updateWidget(String id, Widget widget) {
    Widget originalWidget = findWidgetById(id);
    if (widget.getTopicId() != null) {
      originalWidget.setTopicId(widget.getTopicId());
    }
    if (widget.getText() != null) {
      originalWidget.setText(widget.getText());
    }
    if (widget.getType() != null) {
      originalWidget.setType(widget.getType());
    }
    if (widget.getSrc() != null) {
      originalWidget.setSrc(widget.getSrc());
    }
    if (widget.getSize() != null) {
      originalWidget.setSize(widget.getSize());
    }
    if (widget.getHeight() != null) {
      originalWidget.setHeight(widget.getHeight());
    }
    if (widget.getWidth() != null) {
      originalWidget.setWidth(widget.getWidth());
    }
    if (widget.getIsOrdered() != null) {
      originalWidget.setIsOrdered(widget.getIsOrdered());
    }
    if (widget.getValue() != null) {
      originalWidget.setValue(widget.getValue());
    }
    repository.save(originalWidget);
    return 1;
  }

  public Integer deleteWidget(String wid) {
    int id = Integer.parseInt(wid);
    repository.deleteById(id);
    return 1;
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
  }

  public Widget findWidgetById(String wid) {
    int id = Integer.parseInt(wid);
    Optional<Widget> widget = repository.findById(id);
    return widget.orElse(null);
  }
}