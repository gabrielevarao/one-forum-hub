package one.forumhub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaçãoTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem
) {
}
