package one.forumhub.api.usuario;

import one.forumhub.api.domain.usuario.Usuario;

public record DadosDetalhamentoUsuario(String nome, String email) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail());
    }

}
