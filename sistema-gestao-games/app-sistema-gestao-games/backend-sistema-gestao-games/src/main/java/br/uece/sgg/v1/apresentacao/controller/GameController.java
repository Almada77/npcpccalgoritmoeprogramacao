package br.uece.sgg.v1.apresentacao.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uece.sgg.v1.apresentacao.dto.GameDto;
import br.uece.sgg.v1.apresentacao.dto.GameDtoMapper;
import br.uece.sgg.v1.negocio.Game;
import br.uece.sgg.v1.negocio.ServicoGame;

@RestController
@RequestMapping("/v1/games")
public class GameController { // Antiga classe "InterfaceUsuario.java"

	private final ServicoGame gameService;

	public GameController(ServicoGame gameService) {
		this.gameService = gameService;
	}

	@GetMapping
	public List<GameDto> listarTodos() {
		List<Game> games = gameService.listarGames();
		return GameDtoMapper.toDtoList(games);
	}
	
	@GetMapping("/{id}")
	public GameDto obterPorId(@PathVariable Long id) {
		Game game = gameService.buscarGamePorId(id);
		return GameDtoMapper.toDto(game);
	}

//	@GetMapping("/letra/{letra}")
//	public List<gameDto> listarPorLetraInicial(@PathVariable String letra) {
//		List<game> games = gameService.listarPorLetraInicial(letra);
//		return gameDtoMapper.toDtoList(games);
//	}

//	@GetMapping("/nome/{nome}")
//	public gameDto buscarPorNome(@PathVariable String nome) {
//		game game = gameService.buscarPorNome(nome);
//		return gameDtoMapper.toDto(game);
//	}

//	@GetMapping("/telefone/{telefone}")
//	public gameDto buscarPorTelefone(@PathVariable String telefone) {
//		game game = gameService.buscarPorTelefone(telefone);
//		return gameDtoMapper.toDto(game);
//	}

	@PostMapping
	public GameDto criargame(@RequestBody GameDto gameDto) {
		Game game = GameDtoMapper.fromDto(gameDto);
		game = gameService.criarGame(game);
		return GameDtoMapper.toDto(game);
	}

	@DeleteMapping("/{id}")
	public void deletarGame(@PathVariable Long id) {
		gameService.removerGame(new Game(id));
	}
	
	@PutMapping("/{id}")
	public GameDto editargame(@PathVariable Long id, @RequestBody GameDto gameDto) {
		gameDto.setId(id);
		Game game = GameDtoMapper.fromDto(gameDto);
		Game gameAtualizado = gameService.atualizarGame(game);
	    return GameDtoMapper.toDto(gameAtualizado);
	}

//    @PostMapping("/json/importar")
//    public void importargames(@RequestBody List<gameDto> gamesImportados) {
//        gameService.importargames(gameDtoMapper.fromDtoList(gamesImportados));
//    }

//	@PostMapping("/csv/importar")
//	public void importargames(@RequestParam("file") MultipartFile arquivo) throws IOException {
//		try (BufferedReader reader = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
//
//			List<gameDto> gamesDto = new ArrayList<>();
//			String linha;
//
//			for (int numLinha = 1; (linha = reader.readLine()) != null; numLinha++) {
//				// Divida a linha em campos usando a vírgula como delimitador
//
//				String[] campos = linha.split(";");
//				if (numLinha > 1 && campos.length == 3) { // Certifique-se de que há 3 campos: ID, Nome e Telefone
//					String id = campos[0].trim();
//					String nome = campos[1].trim();
//					String telefone = campos[2].trim();
//
//					// Crie um objeto gameDto com os dados lidos
//					gameDto gameDto = new gameDto();
//					gameDto.setId(Long.parseLong(id));
//					gameDto.setNome(nome);
//					gameDto.setTelefone(telefone);
//					gamesDto.add(gameDto);
//
//				}
//			}
//
//			// Chame o serviço para importar o game
//			gameService.importargames(gamesDto);
//
//		} catch (IOException e) {
//			throw e;
//		}
//	}
//
//	@GetMapping("/csv/exportar")
//	public void exportar(HttpServletResponse response) {
//		response.setContentType("text/csv");
//		response.setHeader("Content-Disposition", "attachment; filename=\"games.csv\"");
//
//		List<game> games = gameService.listarTodos();
//
//		try (PrintWriter writer = response.getWriter()) {
//			// Escreve o cabeçalho do CSV
//			writer.println("ID;Nome;Telefone");
//
//			// Escreve os dados dos games no CSV
//			for (game game : games) {
//				writer.println(game.getId() + ";" + game.getNome() + ";" + game.getTelefone());
//			}
//		} catch (IOException e) {
//			// Trate exceções, se necessário
//		}
//	}
}
