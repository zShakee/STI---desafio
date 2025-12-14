public class RegistroNotas {
    private Disciplina disciplina;
    private Aluno aluno;
    private String semestre;
    private double nota;

    public RegistroNotas(Disciplina disciplina, Aluno aluno, String semestre, double nota){
        this.disciplina = disciplina;
        this.aluno = aluno;
        this.semestre = semestre;
        this.nota = nota;
    }

    public Aluno getAluno(){
        return aluno;
    }
    
    public double getNota(){
        return nota;
    }
    public Disciplina getDisciplina(){
        return disciplina;
    }

    public String getSemestre(){
        return semestre;
    }

}
