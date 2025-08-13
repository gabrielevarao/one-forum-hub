package one.forumhub.api.domain.topico.validacoes;

import one.forumhub.api.domain.ValidacaoException;
import one.forumhub.api.domain.topico.Topico;
import one.forumhub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorTopicoExcluido")
public class ValidadorTopicoExcluido {

    @Autowired
    private TopicoRepository repository;

    public void validar(Long id){

        Topico topico = repository.getReferenceById(id);

        if(!topico.isAtivo()){
            throw new ValidacaoException("Operação não executada. \nMotivo: não é possível acessar tópico excluído.");
        }

    }
}
