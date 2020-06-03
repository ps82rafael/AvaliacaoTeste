package utils;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Filme Sem Estoque");

		NotaAluguel nota = new NotaAluguel();

		switch (tipo) {
		case COMUM:
			nota.setPreco(filme.getAluguel());
			nota.setDataEntrega(DateUtils.obterdataDiferencaDias(1));
			nota.setPontuacao(1);
			break;
		case EXTENDIDO:
			nota.setPreco(filme.getAluguel() * 2);
			nota.setDataEntrega(DateUtils.obterdataDiferencaDias(3));
			nota.setPontuacao(2);
			break;
		case SEMANAL:
			nota.setPreco(filme.getAluguel() * 3);
			nota.setDataEntrega(DateUtils.obterdataDiferencaDias(7));
			nota.setPontuacao(3);
			break;
		}

		filme.setEstoque(filme.getEstoque() - 1);
		return nota;

	}

}
