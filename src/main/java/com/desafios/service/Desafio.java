package com.desafios.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Desafio {

	public static char solucao(String A, String B, BigInteger index) {

		// Salva numa lista todos os tamanhos das strings após cada concatenação
		List<BigInteger> historicoTamanhos = new ArrayList<>();
		historicoTamanhos.add(BigInteger.valueOf(A.length()));
		historicoTamanhos.add(BigInteger.valueOf(B.length()));
		while (historicoTamanhos.get(historicoTamanhos.size() - 1)
				.compareTo(index) < 0) {

			historicoTamanhos.add(historicoTamanhos.get(historicoTamanhos.size() - 2)
					.add(historicoTamanhos.get(historicoTamanhos.size() - 1)));
		}

		// Calcula a partir da "desconcatenação" em qual string inicial (A ou B) estará
		// o caractere desejado.
		// Também calcula qual será o índice deste caractere.
		char lastString = '*';
		for (int i = historicoTamanhos.size() - 1; i > 1; i--) {
			if (index.compareTo(historicoTamanhos.get(i - 2)) < 0) {
				i--;
				lastString = 'A';
			} else {
				index = index.subtract(historicoTamanhos.get(i - 2));
				lastString = 'B';
			}
		}

		// Busca na string inicial o caractere desejado conforme o índice
		if (lastString == 'A') {
			return A.charAt(Integer.parseInt(index.toString()) - 1);
		} else {
			return B.charAt(Integer.parseInt(index.toString()) - 1);
		}
	}
}
