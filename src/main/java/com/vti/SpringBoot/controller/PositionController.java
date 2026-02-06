package com.vti.SpringBoot.controller;

import com.vti.SpringBoot.entity.Position;
import com.vti.SpringBoot.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @DeleteMapping("/{positionId}")
    public void deletePosition(@PathVariable("positionId") Integer positionId) {
        positionService.deletePosition(positionId);
    }
}
