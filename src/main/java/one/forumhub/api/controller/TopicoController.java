package one.forumhub.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.forumhub.api.domain.topico.*;
import one.forumhub.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @Autowired
    private TopicoRepository repository;

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

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        return ResponseEntity.ok(service.detalhar(id));
    }


}
