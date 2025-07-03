package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface PositionService {

    List<PositionDTO> findAllPositions();

    PositionDTO findPositionById(Long id);

    PositionDTO createPosition(CreatedPositionDTO dto);

    PositionDTO renamePosition(RenamedPositionDTO dto, Long id);

    PositionDTO deletePosition(Long id);
}
