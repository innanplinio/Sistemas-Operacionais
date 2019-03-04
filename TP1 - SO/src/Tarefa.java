/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Innan
 */
public class Tarefa {

    private String nome;//Nome da tarefa
    private int duracao;//Duração da tarefa em milissegundos

    public Tarefa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    //Método para imprimir os dados de uma tarefa
    public void Imprimir() {
        System.out.println("Nome: " + getNome() + "\nDuração(ms): " + getDuracao());
    }

}
