package com.octoproject.web.api;

import com.octoproject.dto.CompteDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.octoproject.util.Constant.*;

@Tag(name = "compte", description = "Compte API")
public interface CompteApi {

    @PostMapping(
            value = APP_ROOT + COMPTE + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer un compte",
            description = "Cette methode permet d'enregistrer ou modifier un compte",
            tags = {"compte"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le compte cree .",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CompteDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Le compte n'est pas valide."
            )
    })
    CompteDto save(@RequestBody  CompteDto dto);



    @GetMapping(
            value = APP_ROOT + COMPTE + FILTER + BY_NUM + COMPTE_PATH_NUM,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un compte.",
            description = "Cette methode permet de rechercher un client par leur numero.",
            tags = { "compte" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le compte a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CompteDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun compte n'existe dans la BDD avec le numero fourni."
            )
    })
    CompteDto getByNrCompte(@PathVariable(COMPTE_PATH_VARIABLE_NUM) String nrCompte);


    @GetMapping(
            value = APP_ROOT + COMPTE + FILTER + BY_RIB + COMPTE_PATH_RIB,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un compte.",
            description = "Cette methode permet de rechercher un client par leur rib.",
            tags = { "compte" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le compte a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CompteDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun compte n'existe dans la BDD avec le rib fourni."
            )
    })
    CompteDto getByRib(@PathVariable(COMPTE_PATH_VARIABLE_RIB) String rib);

    @GetMapping(
            value = APP_ROOT + COMPTE + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des comptes",
            description = "Cette methode permet de chercher et renvoyer la liste des comptes qui existent",
            tags = { "compte" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des comptes / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = CompteDto.class)))
            )
    })
    List<CompteDto> getAll();
}
