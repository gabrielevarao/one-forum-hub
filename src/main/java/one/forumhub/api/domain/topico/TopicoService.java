package one.forumhub.api.domain.topico;

import one.forumhub.api.domain.usuario.Usuario;
import one.forumhub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public DadosDetalhamentoTopico postar(DadosCadastroTopico dados, String nomeAutor){
        Usuario autor = usuarioRepository.findByNome(nomeAutor);
        Topico topico = new Topico(dados, LocalDateTime.now());

        topico.setAutor(autor);

        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);

    }

    public Page<DadosListagemTopico> listar(Pageable pageable) {
        return topicoRepository.findAll(pageable)
                .map(DadosListagemTopico::new);
    }

}
