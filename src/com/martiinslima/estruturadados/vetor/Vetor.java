package com.martiinslima.estruturadados.vetor;

import java.util.Arrays;

public class Vetor {

	private String[] elementos;
	private int tamanho;

	// Método construtor do vetor, tendo como parametro o seu tamanho. 

	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		tamanho = 0;
	}

	//Faz a adição de um elemento no vetor.

	public boolean adiciona(String elemento) {
		aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	// faz uma adiação em qualquer posição do vetor, passando o parametro, posição e o elemento a ser adicionado. 

	public void adiciona(int posicao, String elemento) {
		aumentaCapacidade();
		validacao(posicao);
		for (int i = tamanho - 1; i >= posicao; i--) {
			elementos[i + 1] = elementos[i];
		}
		elementos[posicao] = elemento;
		tamanho++;
	}
	//faz a remocao de um elemento do vetor e diminui seu tamanho.

	public void remove(int posicao) {
		validacao(posicao);
		for(int i=posicao; i<this.tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}

	private void aumentaCapacidade() {
		if (this.tamanho == this.elementos.length) {
			String[] elementoNovo = new String[this.elementos.length * 2];
			for (int i = 0; i < this.elementos.length; i++) {
				elementoNovo[i] = this.elementos[i];
			}
			this.elementos = elementoNovo;

		}
	}

	public void validacao(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
	}

	// Faz a validação da posição do vetor e exibe uma exceção caso seja negativa a condição. 

	public String busca(int posicao) {
		validacao(posicao);
		return elementos[posicao];
	}

	//Busca por um elemento dentro do vetor e retorna sua posição. 

	public int busca(String elemento) {
		for (int i = 0; i < tamanho; i++) {
			if (elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	public int tamanho() {
		return this.tamanho;
	}

	// faz a concatenação das string para exibição do vetor, utilizando o
	// StringBuilder .append() e toString.

	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.elementos[i]);
			s.append(",");
		}
		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);
		}
		s.append("]");

		return s.toString();
	}

}
