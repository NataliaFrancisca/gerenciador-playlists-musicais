import modelo.*;
import servicos.ServicoArtista;
import servicos.ServicoColecao;
import servicos.ServicoUsuario;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ServicoUsuario usuarios = new ServicoUsuario();

        usuarios.adicionar(new Usuario("Natalia", "ntfrancisca"));
        usuarios.adicionar(new Usuario("Luiz", "luizhenrique"));

        ServicoArtista artistas = new ServicoArtista();

        artistas.adicionar(new Artista("Duquesa", "duquesa", "Duquesa é uma rapper baiana, reconhecida na cena por musicas potentes."));
        artistas.adicionar(new Artista("Bad Bunny", "badbunny", "Bad Bunny um dos maiores da america latina, vulgo Porto Rico."));
        artistas.adicionar(new Artista("Tasha e Tracie", "tashaetracie", "irmãs gêmeas, tasha e tracie são rappers, estilistas e criadoras de conteúdo."));

        Musica musicaA = new Musica(3, "Disk P%#$#!", 2.30);
        musicaA.atribuirArtista(artistas.buscarArtistaPorUsername("duquesa"));
        musicaA.atribuirArtista(artistas.buscarArtistaPorUsername("tashaetracie"));

        Musica musicaB = new Musica(1, "Fuso", 1.54);
        musicaB.atribuirArtista(artistas.buscarArtistaPorUsername("duquesa"));

        Musica musicaC = new Musica(2, "Gloria", 2.31);
        musicaC.atribuirArtista(artistas.buscarArtistaPorUsername("duquesa"));

        ServicoColecao albuns = new ServicoColecao();

        albuns.adicionar(new Album(0, "Taurus, Vol.2", LocalDate.of(2024, 5, 10), artistas.buscarArtistaPorUsername("duquesa")));
        albuns.adicionarMusica(musicaA, 0);
        albuns.adicionarMusica(musicaB, 0);
        albuns.adicionarMusica(musicaC, 0);

        Colecao albumTaurusDuquesa = albuns.getColecao(0);
        System.out.println(albumTaurusDuquesa);

        ServicoColecao playlists = new ServicoColecao();
        playlists.adicionar(new Playlist(1, "girls want what???", usuarios.buscarUsuarioPorUsername("ntfrancisca")));
        playlists.adicionarMusica(musicaA, 1);
        playlists.adicionarMusica(musicaB, 1);

        Colecao playlistGirlsWantWhat = playlists.getColecao(1);
        System.out.println(playlistGirlsWantWhat);
    }
}
