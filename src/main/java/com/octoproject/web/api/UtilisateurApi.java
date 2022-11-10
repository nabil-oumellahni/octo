package com.octoproject.web.api;

import com.octoproject.dto.CompteDto;
import com.octoproject.dto.UtilisateurDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.octoproject.util.Constant.*;

public interface UtilisateurApi {

    @PostMapping(
            value = APP_ROOT + UTILISATEUR + ADD,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer un utilisateur",
            description = "Cette methode permet d'enregistrer ou modifier un utilisateur",
            tags = {"utilisateur"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "L'utilisateur cree .",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = UtilisateurDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "L'utilisateur n'est pas valide."
            )
    })
    UtilisateurDto save(@RequestBody UtilisateurDto dto);


    @GetMapping(
            value = APP_ROOT + UTILISATEUR + FILTER + BY_USERNAME + COMPTE_PATH_USERNAME,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un utilisateur.",
            description = "Cette methode permet de rechercher un utilisateur par leur username.",
            tags = { "utilisateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "L'utilisateur a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = UtilisateurDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun utilisateur n'existe dans la BDD avec username fourni."
            )
    })
    UtilisateurDto getByUsername(@PathVariable(COMPTE_PATH_VARIABLE_USERNAME) String username);

    @GetMapping(
            value = APP_ROOT + UTILISATEUR + ALL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Renvoi la liste des utilisateurs",
            description = "Cette methode permet de chercher et renvoyer la liste des utilisateurs qui existent",
            tags = { "utilisateur" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La liste des utilisateurs / Une liste vide",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = UtilisateurDto.class)))
            )
    })
    List<UtilisateurDto> getAll();
}
