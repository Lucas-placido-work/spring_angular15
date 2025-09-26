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
import com.lucas.back.repository.ToolRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tools")
@AllArgsConstructor
public class ToolController {

  private final ToolRepository toolRepository;

  @GetMapping
  public List<Tool> list() {
    List<Tool> listTools = new ArrayList<Tool>();
    toolRepository.findAll().forEach(listTools::add);
    return listTools;
  } 

  @PostMapping
  public Tool create(@RequestBody Tool tool) {
      if(tool == null) {
          throw new RuntimeException("Ferramenta está vazia");
      }
      return toolRepository.save(tool);
  }

  @GetMapping("/{id}")
  public Tool findById(@PathVariable Long id) {
      return toolRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
      toolRepository.deleteById(id);
  }
}
