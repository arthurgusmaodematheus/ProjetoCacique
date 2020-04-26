package org.example.entidades;

public class Carro {
    private long id;
    private String modelo;
    private String marca;
    private int ano;
    private String categoria;

    public Carro(){
        this.setId(-1);
        this.setModelo(null);
        this.setMarca(null);
        this.setAno(0);
        this.setCategoria(null);

    }
    public Carro(long id, String modelo, String marca, int ano, String categoria){
        this.setId(id);
        this.setModelo(modelo);
        this.setMarca(marca);
        this.setAno(ano);
        this.setCategoria(categoria);

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
