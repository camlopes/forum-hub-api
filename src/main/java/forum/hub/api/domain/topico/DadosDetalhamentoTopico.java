package forum.hub.api.domain.topico;

import forum.hub.api.domain.curso.Curso;
import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean status,
        String nomeAutor,
        Curso curso) {

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor().getNome(), topico.getCurso());
    }
}
