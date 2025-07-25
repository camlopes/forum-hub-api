package forum.hub.api.controller;

import forum.hub.api.domain.topico.DadosCriacaoTopico;
import forum.hub.api.domain.topico.DadosDetalhamentoTopico;
import forum.hub.api.domain.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCriacaoTopico dados, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(dados);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        System.out.println("\n" + new DadosDetalhamentoTopico(topico));

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }
}
