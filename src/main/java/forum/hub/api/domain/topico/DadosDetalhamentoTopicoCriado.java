package forum.hub.api.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopicoCriado(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao) {

    public DadosDetalhamentoTopicoCriado(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }
}
