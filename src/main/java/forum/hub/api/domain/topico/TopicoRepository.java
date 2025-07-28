package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAll(Pageable paginacao);

    @Query("""
            select t from Topico t
            where
            t.curso = :curso
        """)
    Page<Topico> listarPorNomeCurso(Curso curso, Pageable paginacao);
}
