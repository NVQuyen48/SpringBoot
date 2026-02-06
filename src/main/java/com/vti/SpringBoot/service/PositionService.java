package com.vti.SpringBoot.service;

import com.vti.SpringBoot.entity.Position;
import com.vti.SpringBoot.repository.IPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PositionService {
    private IPositionRepository iPositionRepository;

    public List<Position> getAllPositions() {
        return iPositionRepository.findAll();
    }

    public void deletePosition(Integer positionId) {
        iPositionRepository.deleteById(positionId);
    }
}
