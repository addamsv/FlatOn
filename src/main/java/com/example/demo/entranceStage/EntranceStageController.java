package com.example.demo.entranceStage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "FlatOn")
@RestController
@RequestMapping("api/v1/flat")
@CrossOrigin("*")
public class EntranceStageController {
    private final EntranceStageService flatOnService;

    @Autowired
    public EntranceStageController(EntranceStageService flatOnService) {
        this.flatOnService = flatOnService;
    }

    @Operation(
            description = "Get endpoint",
            summary = "Get the Floor",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            useReturnTypeSchema = true
                    )
            }
    )
    @GetMapping // (path = "{theFloor}")
    public List<EntranceStage> getTheFloor(
//            @PathVariable("theFloor") Long theFloor,
            @RequestParam(required = false) Number theFlat
//            @RequestParam(required = false) Number email
    ) {
        return flatOnService.getTheFloor(theFlat);
    }
    public ResponseEntity<String> getFlat() {
        return ResponseEntity.ok("whoo-hoo");
    }
}
