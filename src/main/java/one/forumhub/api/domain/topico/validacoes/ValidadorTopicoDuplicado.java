package one.forumhub.api.domain.topico.validacoes;

import one.forumhub.api.domain.ValidacaoException;
import one.forumhub.api.domain.topico.Topico;
import one.forumhub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("ValidadorTopicoDuplicado")
public class ValidadorTopicoDuplicado {

    @Autowired
    private TopicoRepository repository;

    public void validar (String titulo, String mensagem){

        Optional<Topico> topico = repository.findByTituloAndMensagem(titulo, mensagem);

        if(topico.isPresent()) {
            throw new ValidacaoException("Operação não executada. \nMotivo: esse tópico já existe.");
        }

    }
}
