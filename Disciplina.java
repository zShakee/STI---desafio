

public class Disciplina {
    private String nome_disciplina;
    private String cod_disciplina;
    private int cargaHoraria;

    public Disciplina(String cod_disciplina, int cargaHoraria){
        this.cod_disciplina = cod_disciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(String cod_disciplina, int cargaHoraria, String nome_disciplina){
        this.cod_disciplina = cod_disciplina;
        this.cargaHoraria = cargaHoraria;
        this.nome_disciplina = nome_disciplina;
    }

    public int getCargaHoraria(){
        return cargaHoraria;
    }

    public String getCodDisciplina(){
        return cod_disciplina;
    }
}
