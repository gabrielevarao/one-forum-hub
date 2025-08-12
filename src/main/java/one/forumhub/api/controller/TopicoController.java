package one.forumhub.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.forumhub.api.domain.topico.DadosCadastroTopico;
import one.forumhub.api.domain.topico.DadosDetalhamentoTopico;
import one.forumhub.api.domain.topico.TopicoService;
import one.forumhub.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity postar(
            @RequestBody @Valid DadosCadastroTopico dadosCadastro,
            @AuthenticationPrincipal Usuario usuarioAutenticado,
            UriComponentsBuilder uriBuilder){

        DadosDetalhamentoTopico dadosDetalhamento = service.postar(dadosCadastro, usuarioAutenticado.getNome());

        var uri = uriBuilder.path("/topicos/{id}")
                .buildAndExpand(dadosDetalhamento.id()).toUri();

        return ResponseEntity.created(uri).body(dadosDetalhamento);
    }
}
