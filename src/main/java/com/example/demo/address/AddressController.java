package com.example.demo.address;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Address")
@RestController
@RequestMapping("api/v1/address")
@CrossOrigin("*")
//@SecurityRequirement(name = "BearerAuth")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Operation(
            description = "Get endpoint",
            summary = "Get all addresss",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            useReturnTypeSchema = true
                    )
            }
    )
    @GetMapping
    public List<Address> getAddress() {
        return addressService.getAddress();
    }


    @PostMapping
    @SecurityRequirement(name = "BasicAuth")
    @Operation(
            description = "Post",
            summary = "Add address"
    )
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }


    @DeleteMapping(path = "{addressId}")
    @SecurityRequirement(name = "BasicAuth")
    @Operation(
            description = "Delete",
            summary = "Remove address"
    )
    public void dellAddress(@PathVariable("addressId") Long id) {
        addressService.dellAddress(id);
    }


    @PutMapping(path = "{addressId}")
    @SecurityRequirement(name = "BasicAuth")
    @Operation(
            description = "Update",
            summary = "Update address"
    )
    public void updateAddress(
            @PathVariable("addressId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        addressService.updateAddress(id, name, email);
    }
}
