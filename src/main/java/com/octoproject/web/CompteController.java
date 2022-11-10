package com.octoproject.web;

import com.octoproject.dto.CompteDto;
import com.octoproject.service.ICompteService;
import com.octoproject.web.api.CompteApi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompteController implements CompteApi {

    private ICompteService compteService;


    @Override
    public CompteDto save(CompteDto dto) {
        return compteService.save(dto);
    }

    @Override
    public CompteDto getByNrCompte(String nrCompte) {
        return compteService.getByNrCompte(nrCompte);
    }

    @Override
    public CompteDto getByRib(String rib) {
        return compteService.getByRib(rib);
    }

    @Override
    public List<CompteDto> getAll() {
        return compteService.getAll();
    }
}
