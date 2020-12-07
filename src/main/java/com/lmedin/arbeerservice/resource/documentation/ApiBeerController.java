package com.lmedin.arbeerservice.resource.documentation;

import com.lmedin.arbeerservice.model.BeerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.UUID;


public interface ApiBeerController{

    @Operation(summary = "Get Beer by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BeerDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Beer UUID format"),
            @ApiResponse(responseCode = "404", description = "Beer not found") })
    public ResponseEntity<BeerDto> getBeerById(@Parameter(description = "Beer UUID. ",required=true) @PathVariable("beerId") UUID beerId);

    @Operation(summary = "Add new beer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "creation successful")})
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto);

    @Operation(summary = "Update an existing beer")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto);

    @Operation(summary = "Delete an existing beer")
    public void deleteBeerById(@PathVariable("beerId") UUID beerId);
}
