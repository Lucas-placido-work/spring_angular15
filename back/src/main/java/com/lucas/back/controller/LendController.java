package com.lucas.back.controller;

import com.lucas.back.entity.Lend;
import com.lucas.back.service.LendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lends")
@RequiredArgsConstructor
public class LendController {

    private final LendService lendService;

    @GetMapping
    public List<Lend> findAll() {
        return lendService.findAll();
    }

    @PostMapping
    public Lend create(@RequestBody Lend lend) {
        return lendService.registerLend(lend);
    }

    @PutMapping("/{id}/return")
    public Lend returnTool(@PathVariable Long id) {
        return lendService.returnTool(id);
    }
}
