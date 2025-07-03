package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.*;
import ru.tbank.safedeckteam.spectre.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public ResponseEntity<List<TestDTO>> getAllTests() {
        return ResponseEntity.ok(testService.findAllTests());
    }

    @GetMapping("/{testId}")
    public ResponseEntity<TestDTO> getTest(@PathVariable Long testId) {
        return ResponseEntity.ok(testService.findTestById(testId));
    }

    @PostMapping
    public ResponseEntity<TestDTO> createTest(@RequestBody CreatedTestDTO createdTestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(testService.createTest(createdTestDTO));
    }

    @PutMapping("/{testId}")
    public ResponseEntity<TestDTO> updateTest(@RequestBody UpdatedTestDTO updatedTestDTO,
                                              @PathVariable Long testId) {
        return ResponseEntity.ok(testService.updateTest(updatedTestDTO, testId));
    }

    @DeleteMapping("/{testId}")
    public ResponseEntity<TestDTO> deleteTest(@PathVariable Long testId) {
        return ResponseEntity.ok(testService.deleteTest(testId));
    }
}
