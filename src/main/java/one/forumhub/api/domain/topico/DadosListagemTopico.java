package one.forumhub.api.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        String curso,
        TopicoStatus status
) {
    public DadosListagemTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor().getNome(), topico.getCurso(),topico.getStatus());
    }

}
