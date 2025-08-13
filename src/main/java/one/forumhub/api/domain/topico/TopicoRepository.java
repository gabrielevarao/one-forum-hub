package one.forumhub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAllByAtivoTrue(Pageable pageable);

    Optional<Topico> findByTituloAndMensagem(String titulo, String message);
}
