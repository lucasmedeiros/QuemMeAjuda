import easyaccept.EasyAccept;

/**
 * 
 * Classe responsável pelos testes de aceitação através da ferramenta
 * EasyAccept.
 * 
 * @authors
 *          <ol>
 *          <i> Diego Gama </i> <i> Jessé Souza </i> <i> Lucas Medeiros </i> <i>
 *          Mikael Amaral </i>
 *          </ol>
 * @since Parte 1
 */
public class Main {
	public static void main(String[] args) {
		args = new String[] { "general.SistemaFacade", "acceptance_tests/us1_test.txt", "acceptance_tests/us2_test.txt",
				"acceptance_tests/us3_test.txt", "acceptance_tests/us4_test.txt", "acceptance_tests/us5_test.txt", "acceptance_tests/us6_test.txt"};
		EasyAccept.main(args);
	}
}
