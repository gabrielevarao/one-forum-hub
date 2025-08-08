package one.forumhub.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import one.forumhub.api.domain.usuario.DadosCadastroUsuario;
import one.forumhub.api.domain.usuario.Usuario;
import one.forumhub.api.domain.usuario.UsuarioRepository;
import one.forumhub.api.domain.usuario.UsuarioService;
import one.forumhub.api.usuario.DadosDetalhamentoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cadastro")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dadosUsuario, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dadosUsuario);
        usuarioService.cadastrarUsuario(usuario);

        var uri = uriBuilder.path("/cadastro/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));

    }
}
