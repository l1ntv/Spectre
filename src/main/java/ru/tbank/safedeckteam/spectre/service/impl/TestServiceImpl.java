package ru.tbank.safedeckteam.spectre.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tbank.safedeckteam.spectre.dto.CreatedTestDTO;
import ru.tbank.safedeckteam.spectre.dto.TestDTO;
import ru.tbank.safedeckteam.spectre.dto.UpdatedTestDTO;
import ru.tbank.safedeckteam.spectre.exception.ResourceNotFoundException;
import ru.tbank.safedeckteam.spectre.mapper.TestMapper;
import ru.tbank.safedeckteam.spectre.model.Test;
import ru.tbank.safedeckteam.spectre.repository.AircraftRepository;
import ru.tbank.safedeckteam.spectre.repository.LocationRepository;
import ru.tbank.safedeckteam.spectre.repository.OrganizationRepository;
import ru.tbank.safedeckteam.spectre.repository.TestRepository;
import ru.tbank.safedeckteam.spectre.service.TestService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    private final AircraftRepository aircraftRepository;

    private final OrganizationRepository organizationRepository;

    private final LocationRepository locationRepository;

    private final TestMapper testMapper;

    @Override
    public List<TestDTO> findAllTests() {
        return testMapper.toDtoList(testRepository.findAll());
    }

    @Override
    public TestDTO findTestById(Long id) {
        return testMapper.toDto(testRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Test not found.")));
    }

    @Override
    public TestDTO createTest(CreatedTestDTO dto) {
        return testMapper.toDto(testRepository.save(Test.builder()
                .aircraft(aircraftRepository.findById(dto.getAircraft().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found.")))
                .organization(organizationRepository.findById(dto.getOrganization().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Organization not found.")))
                .location(locationRepository.findById(dto.getLocation().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Location not found.")))
                .date(dto.getDate())
                .description(dto.getDescription())
                .build()));
    }

    @Override
    public TestDTO updateTest(UpdatedTestDTO dto, Long id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Test not found."));
        test.setAircraft(aircraftRepository.findById(dto.getAircraft().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found.")));
        test.setOrganization(organizationRepository.findById(dto.getOrganization().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found.")));
        test.setLocation(locationRepository.findById(dto.getLocation().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Location not found.")));
        test.setDate(dto.getDate());
        test.setDescription(dto.getDescription());
        return testMapper.toDto(testRepository.save(test));
    }

    @Override
    public TestDTO deleteTest(Long id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Test not found."));
        testRepository.delete(test);
        return testMapper.toDto(test);
    }
}
