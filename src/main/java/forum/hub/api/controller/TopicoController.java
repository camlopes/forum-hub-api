package forum.hub.api.controller;

import forum.hub.api.domain.curso.Curso;
import forum.hub.api.domain.topico.*;
import forum.hub.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCriacaoTopico dados, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = usuarioRepository.findByNomeAndEmail(dados.autor().nome(), dados.autor().email());
        var topico = new Topico(dados, usuario);
        topicoRepository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = topicoRepository.findAll(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{nomeCurso}")
    public ResponseEntity<Page<DadosListagemTopicos>> listarPorCurso(@PathVariable Curso nomeCurso, @PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = topicoRepository.listarPorNomeCurso(nomeCurso, paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }
}
