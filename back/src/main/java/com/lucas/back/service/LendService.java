package com.lucas.back.service;

import com.lucas.back.entity.Employee;
import com.lucas.back.entity.Lend;
import com.lucas.back.entity.Tool;
import com.lucas.back.repository.EmployeeRepository;
import com.lucas.back.repository.LendRepository;
import com.lucas.back.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LendService {
    private final LendRepository lendRepository;
    private final ToolRepository toolRepository;
    private final EmployeeRepository employeeRepository;

    public Lend registerLend(Lend lend) {
      Tool tool = toolRepository.findById(lend.getTool().getId())
            .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));

      if (!tool.getAvailable()) {
          throw new RuntimeException("Ferramenta já está emprestada!");
      }
 
      Employee employee = employeeRepository.findByName(lend.getEmployee().getName())
      .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
      
      tool.setAvailable(false);
      toolRepository.save(tool);
     
      lend.setTool(tool);
      lend.setEmployee(employee);

      lend.setDateLend(LocalDate.now());

      return lendRepository.save(lend);
    }


    public Lend returnTool(Long id) {
        Lend lend = lendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        Tool tool = lend.getTool();
        tool.setAvailable(true);
        toolRepository.save(tool);
        lend.setDateReturn(LocalDate.now());
        return lendRepository.save(lend);
    }

    public List<Lend> listarLends() {
        return lendRepository.findAll();
    }
}
