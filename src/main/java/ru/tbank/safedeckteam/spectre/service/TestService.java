package ru.tbank.safedeckteam.spectre.service;

import ru.tbank.safedeckteam.spectre.dto.*;

import java.util.List;

public interface TestService {

    List<TestDTO> findAllTests();

    TestDTO findTestById(Long id);

    TestDTO createTest(CreatedTestDTO dto);

    TestDTO updateTest(UpdatedTestDTO dto, Long id);

    TestDTO deleteTest(Long id);
}
