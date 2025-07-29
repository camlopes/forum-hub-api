package forum.hub.api.domain.topico.validacoes;

import forum.hub.api.domain.topico.DadosCriacaoTopico;
import forum.hub.api.domain.topico.Topico;

public interface ValidarAtualizacaoTopico {
    void validar(DadosCriacaoTopico dados, Topico topico);
}
