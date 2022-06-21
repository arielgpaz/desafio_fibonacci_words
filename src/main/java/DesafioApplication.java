import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import com.desafios.service.Desafio;

public class DesafioApplication {
	public static void main(String[] args) throws IOException {

		Desafio desafio = new Desafio();

		String file ="file.txt";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int numeroDeTestes = Integer.parseInt(reader.readLine());

		for (int i = 0; i < numeroDeTestes; i++) {
			String[] ABindex = reader.readLine().split("\\s+");
			System.out.println(desafio.solucao(ABindex[0], ABindex[1], BigInteger.valueOf(Long.parseLong(ABindex[2]))));
		}
	}
}
