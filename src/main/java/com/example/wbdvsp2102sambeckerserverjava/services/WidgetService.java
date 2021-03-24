package com.example.wbdvsp2102sambeckerserverjava.services;

import com.example.wbdvsp2102sambeckerserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
  private final List<Widget> widgets = new ArrayList<Widget>();

  // implement crud operations
  public Widget createWidget(String tid, Widget widget) {
    widget.setTopicId(tid);
    Integer id = (int)((new Date()).getTime());
    widget.setId(id);
    widgets.add(widget);
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> ws = new ArrayList<Widget>();
    for(Widget w: widgets) {
      if(w.getTopicId().equals(topicId)) {
        ws.add(w);
      }
    }
    return ws;
  }

  public Integer updateWidget(String id, Widget newWidget) {
    for(int i=0; i<widgets.size(); i++) {
      Widget w = widgets.get(i);
      if(w.getId().equals(Integer.parseInt(id))) {
        widgets.set(i, newWidget);
        return 1;
      }
    }
    return -1;
  }
  public Integer deleteWidget(String id) {
    int index = -1;
    for(int i=0; i<widgets.size(); i++) {
      Widget w = widgets.get(i);
      if(w.getId().equals(Integer.parseInt(id))) {
        index = i;
      }
    }
    if(index >= 0) {
      widgets.remove(index);
      return 1;
    }
    return -1;
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget findWidgetById(String id) {
    for(Widget w: widgets) {
      if(w.getId().equals(Integer.parseInt(id))) {
        return w;
      }
    }
    return null;
  }
}