package com.lucas.back.service;

import com.lucas.back.entity.Employee;
import com.lucas.back.entity.Lend;
import com.lucas.back.entity.Tool;
import com.lucas.back.repository.LendRepository;
import com.lucas.back.repository.ToolRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LendServiceTest {

    @Mock
    private LendRepository lendRepository;

    @Mock
    private ToolRepository toolRepository;

    @InjectMocks
    private LendService lendService;

    private Tool tool;
    private Employee employee;
    private Lend lend;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        tool = new Tool();
        tool.setAvailable(true);
        tool.setId(1L);
        tool.setName("Martelo");

        employee = new Employee();
        employee.setId(1L);
        employee.setName("Lucas");

        lend = new Lend();
        lend.setId(1L);
        lend.setTool(tool);
        lend.setEmployee(employee);

    }

    @Test
    void shouldRegisterLendWhenToolIsAvailable() {
        when(toolRepository.save(any(Tool.class))).thenReturn(tool);
        when(lendRepository.save(any(Lend.class))).thenReturn(lend);

        Lend result = lendService.registerLend(lend);

        assertNotNull(result);
        assertFalse(result.getTool().getAvailable());
        verify(toolRepository, times(1)).save(tool);
        verify(lendRepository, times(1)).save(lend);
    }

    @Test
    void shouldThrowExceptionWhenToolIsNotAvailable() {
        tool.setAvailable(false); // simula ferramenta já emprestada
        lend.setTool(tool);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            lendService.registerLend(lend);
        });

        assertEquals("Ferramenta já está emprestada!", exception.getMessage());
        verify(lendRepository, never()).save(any(Lend.class));
    }
}
