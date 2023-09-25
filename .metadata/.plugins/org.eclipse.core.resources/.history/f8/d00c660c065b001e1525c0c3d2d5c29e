package br.uece.sgg.v1.apresentacao.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.uece.sgg.v1.negocio.Game;

public class GameDtoMapper {

    public static GameDto toDto(Game game) {
        GameDto dto = new GameDto();
        dto.setId(game.getId());
        dto.setValor1(game.getValor1());
        dto.setValor2(game.getValor2());
        dto.setValor3(game.getValor3());
        dto.setValor4(game.getValor4());
        dto.setValor5(game.getValor5());
        dto.setValor6(game.getValor6());
        return dto;
    }
    
    public static Game fromDto(GameDto dto) {
        Game game = new Game();
        game.setId(dto.getId());
        game.setValor1(dto.getValor1());
        game.setValor2(dto.getValor2());
        game.setValor3(dto.getValor3());
        game.setValor4(dto.getValor4());
        game.setValor5(dto.getValor5());
        game.setValor6(dto.getValor6());
        return game;
    }

    public static List<GameDto> toDtoList(List<Game> games) {
        return games.stream()
                .map(GameDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public static List<Game> fromDtoList(List<GameDto> dtos) {
        return dtos.stream()
                .map(GameDtoMapper::fromDto)
                .collect(Collectors.toList());
    }
}
