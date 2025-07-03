package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tbank.safedeckteam.spectre.dto.CreatedPositionDTO;
import ru.tbank.safedeckteam.spectre.dto.PositionDTO;
import ru.tbank.safedeckteam.spectre.dto.RenamedPositionDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.PositionMapper;
import ru.tbank.safedeckteam.spectre.model.Position;
import ru.tbank.safedeckteam.spectre.repository.PositionRepository;
import ru.tbank.safedeckteam.spectre.service.PositionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final PositionMapper positionMapper;

    @Override
    public List<PositionDTO> findAllPositions() {
        return positionMapper.toDtoList(positionRepository.findAll());
    }

    @Override
    public PositionDTO findPositionById(Long id) {
        return positionMapper.toDto(positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found.")));
    }

    @Override
    public PositionDTO createPosition(CreatedPositionDTO dto) {
        return positionMapper.toDto(positionRepository.save(Position.builder()
                .title(dto.getTitle())
                .build()));
    }

    @Override
    public PositionDTO renamePosition(RenamedPositionDTO dto, Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found."));
        position.setTitle(dto.getTitle());
        return positionMapper.toDto(positionRepository.save(position));
    }

    @Override
    public PositionDTO deletePosition(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found."));
        positionRepository.delete(position);
        return positionMapper.toDto(position);
    }
}
