package com.example.wbdvsp2102sambeckerserverjava.controllers;

import com.example.wbdvsp2102sambeckerserverjava.models.Widget;
import com.example.wbdvsp2102sambeckerserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  @Autowired
  WidgetService service;// = new WidgetService();

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(
          @PathVariable("tid") String topicId,
          @RequestBody Widget widget) {
    // widget.setTopicId(topicId);
    return service.createWidget(topicId, widget);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(
          @PathVariable("tid") String topicId
  ) {
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(
          @PathVariable("wid") String id) {
    return service.findWidgetById(id);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public Integer deleteWidget(@PathVariable("wid") String id) {
    return service.deleteWidget(id);
  }

  @PutMapping("/api/widgets/{wid}")
  public Integer updateWidget(
          @PathVariable("wid") String id,
          @RequestBody Widget widget) {
    return service.updateWidget(id, widget);
  }
}