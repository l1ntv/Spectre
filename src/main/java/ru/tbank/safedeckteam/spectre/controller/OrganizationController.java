package ru.tbank.safedeckteam.spectre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tbank.safedeckteam.spectre.dto.CreatedOrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.OrganizationDTO;
import ru.tbank.safedeckteam.spectre.dto.RenamedOrganizationDTO;
import ru.tbank.safedeckteam.spectre.service.OrganizationsService;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationsService organizationsService;

    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        return ResponseEntity.ok(organizationsService.findAllOrganizations());
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(organizationsService.findOrganizationById(organizationId));
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody CreatedOrganizationDTO organizationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organizationsService.createOrganization(organizationDTO));
    }

    @PutMapping("/{organizationId}")
    public ResponseEntity<OrganizationDTO> renameOrganization(@RequestBody RenamedOrganizationDTO organizationDTO,
                                                              @PathVariable Long organizationId) {
        return ResponseEntity.ok(organizationsService.renameOrganization(organizationDTO, organizationId));
    }

    @DeleteMapping("/{organizationId}")
    public ResponseEntity<OrganizationDTO> deleteOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(organizationsService.deleteOrganization(organizationId));
    }
}
