package one.forumhub.api.domain.topico.validacoes;

import one.forumhub.api.domain.ValidacaoException;
import one.forumhub.api.domain.topico.Topico;
import one.forumhub.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ValidadorAutorDiferente")
public class ValidadorAutorDiferente {

    @Autowired
    private TopicoRepository repository;

    public void validar(Long id, Long idUsuario){

        Topico topico = repository.getReferenceById(id);

        if(topico.getAutor().getId() != idUsuario){
            throw new ValidacaoException("Operação não executada. \nMotivo: não é possível alterar o tópico de outro autor.");
        }

    }
}
