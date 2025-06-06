package SistemaDeBiblioteca;

public class Biblioteca {
    private int id;
    private String titulo;
    private String autor;
    private String ano;
    private boolean disponibilidade;

    public Biblioteca(int id,String titulo, String autor, String ano,boolean disponibilidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        Metodos.Separador();
        return "Id do livro: " + id + "\nTítulo do livro: " + titulo + "\nAutor(a):" + autor + "\nAno: " + ano + "\nDisponibilidade: " + disponibilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
