package one.forumhub.api.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        String curso,
        TopicoStatus status
        ) {

    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor().getNome(), topico.getCurso(),topico.getStatus());
    }
}
