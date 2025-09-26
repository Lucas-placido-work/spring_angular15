package com.lucas.back.service;

import org.springframework.stereotype.Service;

import com.lucas.back.entity.Tool;
import com.lucas.back.repository.ToolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToolService {
  
  private final ToolRepository toolRepository;


  private void validateTool(Tool tool) {
    if (tool.getName() == null || tool.getName().isEmpty()) {
      throw new IllegalArgumentException("O nome da ferramenta é obrigatório.");
    }
  }

  public Iterable<Tool> findAll() {
    return toolRepository.findAll();
  }

  public void save(Tool tool) {
    validateTool(tool);
    toolRepository.save(tool);
  }

  public Tool findById(Long id) {
    return toolRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));
  }

  public void deleteById(Long id) {
    toolRepository.deleteById(id);
  }
}
