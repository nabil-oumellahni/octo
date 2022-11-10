package com.octoproject.web;

import com.octoproject.dto.UtilisateurDto;
import com.octoproject.service.IUtilisateurService;
import com.octoproject.web.api.UtilisateurApi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisateurController implements UtilisateurApi {

    private IUtilisateurService utilisateurService;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto getByUsername(String username) {
        return utilisateurService.getByUsername(username);
    }

    @Override
    public List<UtilisateurDto> getAll() {
        return utilisateurService.getAll();
    }
}
