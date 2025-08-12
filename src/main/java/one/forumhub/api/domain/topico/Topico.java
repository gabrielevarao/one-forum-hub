package one.forumhub.api.domain.topico;

import jakarta.persistence.*;
import lombok.*;
import one.forumhub.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private String curso;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private TopicoStatus status;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    public Topico(DadosCadastroTopico dados, LocalDateTime data){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
        this.dataCriacao = data;
        this.status = TopicoStatus.NAO_RESPONDIDO;
        this.ativo = true;
    }

}
