import java.util.*;
public class Curso {
    private String nomeCurso;
    private List<Aluno> alunos; //usar interface
    private int codCurso;
    private double crMedio;

    public Curso(int codCurso){
        this.codCurso = codCurso;
        alunos = new ArrayList<>();
        crMedio = 0.0;
    }

    public Curso(int codCurso,String nome){
        this.codCurso = codCurso;
        this.nomeCurso = nome;
        alunos = new ArrayList<>();
        crMedio = 0.0;
    }

    public int getCodCurso(){
        return codCurso;
    }

     public double getCRMedio(){
        return crMedio;
    }

    public void adicionarAluno(Aluno aluno){
        if(!alunos.contains(aluno))
            alunos.add(aluno);
    }

    public void calculaCRMedio(){
        if(alunos.isEmpty()){
            crMedio = 0.0;
            return;
        }
        double soma = 0.0;
        for(Aluno aluno : alunos){
            soma += aluno.getCR();
        }
        this.crMedio = soma/alunos.size();
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Curso that = (Curso) obj;
        return codCurso == that.codCurso;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(codCurso);
    }
}
