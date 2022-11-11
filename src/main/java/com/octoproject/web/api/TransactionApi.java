package com.octoproject.web.api;

import com.octoproject.dto.DepositDto;
import com.octoproject.dto.TransferDto;
import com.octoproject.exception.CompteNonExistantException;
import com.octoproject.exception.SoldeDisponibleInsuffisantException;
import com.octoproject.exception.TransactionException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.octoproject.util.Constant.*;

@Tag(name = "Transaction", description = "Transaction API")
public interface TransactionApi {

    @GetMapping(
            value = APP_ROOT + TRANSFERT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Afficher les transfers .",
            description = "Cette methode permet d'afficher les transfers'.",
            tags = {"transfert"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "La transfers a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = TransferDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun transfert n'existe dans la BDD ."
            )
    })
    List<TransferDto> listerTranferts();


    @GetMapping(
            value = APP_ROOT + DEPOSIT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Afficher les Deposits .",
            description = "Cette methode permet d'afficher les deposits'.",
            tags = {"deposit"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le deposit a ete trouve dans la BDD.",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = DepositDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Aucun deposit n'existe dans la BDD ."
            )
    })
    List<DepositDto> listerDeposits();


    @PostMapping(
            value = APP_ROOT + TRANSFERT + EXECUTE_TRANSFERT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "executer un transfert",
            description = "Cette methode permet d'executer un transfert",
            tags = {"transfert"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le transfert executer .",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = TransferDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Le transfert n'est pas valide."
            )
    })
    public void executerTransfert(@RequestBody TransferDto transferDto)
            throws SoldeDisponibleInsuffisantException, CompteNonExistantException, TransactionException;


    @PostMapping(
            value = APP_ROOT + DEPOSIT + EXECUTE_DEPOSIT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "executer un deposit",
            description = "Cette methode permet d'executer un deposit",
            tags = {"deposit"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Le deposit executer .",
                    content = @Content(array = @ArraySchema(
                            schema = @Schema(implementation = DepositDto.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Le deposit n'est pas valide."
            )
    })
    public void executerDeposit(@RequestBody DepositDto depositDto)
            throws CompteNonExistantException, TransactionException;
}
