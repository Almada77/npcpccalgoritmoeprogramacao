package br.uece.sgg.v1.persistencia;

import java.util.List;

import br.uece.sgg.v1.negocio.Game;

public interface RepositorioGame{//Porta de Saída
    Game salvarGame(Game game);
    Game buscarGamePorId(Long id);
    List<Game> listarGames();
    void atualizarGame(Game game);
    void excluirGame(Game game);
}
