package br.uece.sgg.v1.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import br.uece.sgg.v1.persistencia.RepositorioGame;


@Service
public class ServicoGame {

	private RepositorioGame repositorioGame;

	public ServicoGame(RepositorioGame repositorioGame) {
		this.repositorioGame = repositorioGame;
	}

	public List<Game> listarGames() {
		List<Game> games = repositorioGame.listarGames();
		if (games.isEmpty()) {
			throw new NegocioException("Nenhum game encontrado.");
		}
		return games;
	}

	public Game criarGame(Game novaGame) {
		return repositorioGame.salvarGame(novaGame);
	}

	public Game atualizarGame(Game game) {
		repositorioGame.atualizarGame(game);
		return buscarGamePorId(game.getId());
	}
		
	public void removerGame(Game game) {
		Game gameExistente = this.buscarGamePorId(game.getId());
		repositorioGame.excluirGame(gameExistente);
	}
	
	public Game buscarGamePorId(Long id) {
		Game gameExistente = repositorioGame.buscarGamePorId(id);
		
		if (gameExistente == null) {
			throw new NegocioException("Game não encontrado.");
		}
		
		return gameExistente;
	}

}
