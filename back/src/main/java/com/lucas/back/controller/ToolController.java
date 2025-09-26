package com.lucas.back.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.back.entity.Tool;
import com.lucas.back.service.ToolService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tools")
@AllArgsConstructor
public class ToolController {

  private final ToolService toolService;

  @GetMapping
  public List<Tool> list() {
    List<Tool> listTools = new ArrayList<Tool>();
    toolService.findAll().forEach(listTools::add);
    return listTools;
  } 

  @PostMapping
  public void create(@RequestBody Tool tool) {
      toolService.save(tool);
  }

  @GetMapping("/{id}")
  public Tool findById(@PathVariable Long id) {
      return toolService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
      toolService.deleteById(id);
  }
}
