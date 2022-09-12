package com.srs.application.resource;

import com.srs.application.constant.AppConstants;
import com.srs.application.dto.CredentialDto;
import com.srs.application.dto.response.api.ApiResponse;
import com.srs.application.service.CredentialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstants.API_CONTEXT_V1 + "/credentials")
@Slf4j
@RequiredArgsConstructor
public class CredentialResource {

    @Autowired
    private final CredentialService credentialService;

    @GetMapping("/username/{username}")
    public ResponseEntity<ApiResponse<CredentialDto>> findByUsername(@PathVariable final String username) {
        return ResponseEntity.ok(new ApiResponse<>(1, HttpStatus.OK, true,
                this.credentialService.findByUsername(username)));
    }
}
