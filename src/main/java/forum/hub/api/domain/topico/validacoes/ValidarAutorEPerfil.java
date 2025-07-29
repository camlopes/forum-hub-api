package forum.hub.api.domain.topico.validacoes;

import forum.hub.api.domain.ValidacaoException;
import forum.hub.api.domain.topico.DadosCriacaoTopico;
import forum.hub.api.domain.topico.Topico;
import forum.hub.api.domain.usuario.Perfil;
import forum.hub.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarAutorEPerfil implements ValidarAtualizacaoTopico {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DadosCriacaoTopico dados, Topico topico) {
        var topicoNomeSalvo = topico.getAutor().getNome();
        var supostoNomeAutor = dados.autor().nome();
        var topicoEmailSalvo = topico.getAutor().getEmail();
        var supostoEmailAutor = dados.autor().email();
        var perfil = usuarioRepository.findByNomeAndEmail(dados.autor().nome(), dados.autor().email()).getPerfil();

        if (perfil != Perfil.ADMIN_ROLE) {
            if (!(topicoNomeSalvo.equals(supostoNomeAutor) && topicoEmailSalvo.equals(supostoEmailAutor))) {
                throw new ValidacaoException("Somente o administrador ou o dono do topico pode fazer modificações");
            }
        }
    }
}
