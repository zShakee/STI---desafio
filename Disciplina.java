

public class Disciplina {
    private String nome_disciplina;
    private String cod_disciplina;
    private int cargaHoraria;
    //private HashMap<String,HashMap<String, Double>> notas; // matricula -> (semestre -> nota)

    //observação importante para mat 102 e 115, alunos cursando a mesma disciplina duas vezes no mesmo semestre

    public Disciplina(String cod_disciplina, int cargaHoraria){
        this.cod_disciplina = cod_disciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(String cod_disciplina, int cargaHoraria, String nome_discplina){
        this.cod_disciplina = cod_disciplina;
        this.cargaHoraria = cargaHoraria;
        this.nome_disciplina = nome_discplina;
    }

    public int getCargaHoraria(){
        return cargaHoraria;
    }

    public String getCodDisciplina(){
        return cod_disciplina;
    }
}
