package org.example.entidades;

public class Jogo {
    private long id;
    private String nome_time_a;
    private String nome_time_b;
    private int gols_time_a;
    private int gols_time_b;

    public Jogo(long id, String nome_time_a, String nome_time_b, int gols_time_a, int gols_time_b) {
        this.setId(id);
        this.setNome_time_a(nome_time_a);
        this.setNome_time_b(nome_time_b);
        this.setGols_time_a(gols_time_a);
        this.setGols_time_b(gols_time_b);
    }
    public Jogo(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_time_a() {
        return nome_time_a;
    }

    public void setNome_time_a(String nome_time_a) {
        this.nome_time_a = nome_time_a;
    }

    public String getNome_time_b() {
        return nome_time_b;
    }

    public void setNome_time_b(String nome_time_b) {
        this.nome_time_b = nome_time_b;
    }

    public int getGols_time_a() {
        return gols_time_a;
    }

    public void setGols_time_a(int gols_time_a) {
        this.gols_time_a = gols_time_a;
    }

    public int getGols_time_b() {
        return gols_time_b;
    }

    public void setGols_time_b(int gols_time_b) {
        this.gols_time_b = gols_time_b;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome_time_a='" + nome_time_a + '\'' +
                ", nome_time_b='" + nome_time_b + '\'' +
                ", gols_time_a=" + gols_time_a +
                ", gols_time_b=" + gols_time_b +
                '}';
    }
}
