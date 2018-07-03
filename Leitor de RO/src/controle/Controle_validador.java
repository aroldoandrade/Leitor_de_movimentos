package controle;

import java.util.ArrayList;

import model.Arquivo;
import model.Arquivo_10;
import model.Arquivo_20;
import model.Linha_10;
import model.Linha_20;
import view.View_Tipos;

public class Controle_validador {

	private static Controle_validador instancia;

	public static Controle_validador getInstance() {

		if (instancia == null) {
			instancia = new Controle_validador();
			return instancia;
		} else {
			return instancia;
		}

	}
	public void trataArquivo(Arquivo arquivo) {
		arquivo.setResumo("\n\nArquivo Valido");
		boolean valido = true;
		try {
			if (arquivo.getTipo().equals("10")) {

				Arquivo_10 arq10 = (Arquivo_10) arquivo;
				ArrayList<Linha_10> con = arq10.getLinhas();

				for (int linha = 0; linha < con.size(); linha++) {

					con.get(linha).getLinha().substring(0, 2);
					con.get(linha).getLinha().substring(2, 13);
					con.get(linha).getLinha().substring(13, 24);
					con.get(linha).getLinha().substring(24, 30);
					con.get(linha).getLinha().substring(30, 34);
					con.get(linha).getLinha().substring(34, 38);
					con.get(linha).getLinha().substring(38, 42);
					con.get(linha).getLinha().substring(42, 46);
					con.get(linha).getLinha().substring(46, 51);
					con.get(linha).getLinha().substring(51, 59);
					con.get(linha).getLinha().substring(59, 67);
					con.get(linha).getLinha().substring(67, 68);
					con.get(linha).getLinha().substring(68, 88);
					con.get(linha).getLinha().substring(88, 92);
					con.get(linha).getLinha().substring(92, 592);
					Integer.parseInt(con.get(linha).getLinha().substring(592, 607));
					con.get(linha).getLinha().substring(607, 615);
					con.get(linha).getLinha().substring(615, 645);
					con.get(linha).getLinha().substring(645, 647);
					con.get(linha).getLinha().substring(647, 697);
					con.get(linha).getLinha().substring(697, 705);
					con.get(linha).getLinha().substring(705, 706);
					con.get(linha).getLinha().substring(706, 721);
					con.get(linha).getLinha().substring(721, 821);
					con.get(linha).getLinha().substring(821, 826);
					con.get(linha).getLinha().substring(826, 866);
					con.get(linha).getLinha().substring(866, 896);
					con.get(linha).getLinha().substring(896, 926);
					con.get(linha).getLinha().substring(926, 928);
					con.get(linha).getLinha().substring(928, 932);
				}

			} else if (arquivo.getTipo().equals("20")) {

				Arquivo_20 arq20 = (Arquivo_20) arquivo;
				ArrayList<Linha_20> con = arq20.getLinhas();

				for (int linha = 0; linha < con.size(); linha++) {

					con.get(linha).getLinha().substring(0, 2);
					con.get(linha).getLinha().substring(2, 13);
					con.get(linha).getLinha().substring(13, 17);
					con.get(linha).getLinha().substring(17, 21);
					con.get(linha).getLinha().substring(21, 25);
					con.get(linha).getLinha().substring(25, 29);
					con.get(linha).getLinha().substring(29, 31);
					con.get(linha).getLinha().substring(31, 36);
					con.get(linha).getLinha().substring(36, 41);
					con.get(linha).getLinha().substring(41, 49);
					con.get(linha).getLinha().substring(49, 99);
					con.get(linha).getLinha().substring(99, 114);
					Integer.parseInt(con.get(linha).getLinha().substring(114, 132));
					con.get(linha).getLinha().substring(132, 150);
					con.get(linha).getLinha().substring(150, 167);
					con.get(linha).getLinha().substring(167, 186);
					con.get(linha).getLinha().substring(186, 206);
					con.get(linha).getLinha().substring(206, 207);
					con.get(linha).getLinha().substring(207, 932);

				}

			}
		} catch (Exception e) {

			Controle.getInstance().logErro(e.toString(), "trataArquivo nome Arquivo: " + arquivo.getNome(),
					"Controle_validador");
			arquivo.setResumo("\n\nArquivo Invalido, registrado no Log");
			valido = false;
		}

		new View_Tipos(arquivo,valido);

	}

}
