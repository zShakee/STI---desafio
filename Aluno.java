import java.util.*;

public class Aluno {
    private String mat;
    private Curso curso;
    private List<RegistroNotas> historico;
    private double cr;

    public Aluno(String mat, Curso curso){
        this.mat = mat;
        this.curso = curso;
        this.cr = 0.0;
        this.historico = new ArrayList<>();
        //this.disciplinas = new ArrayList<>();
    }

    public String getMat(){
        return mat;
    }

    public Double getCR(){
        return cr;
    }

    public Curso getCurso(){
        return curso;
    }
    

     //observação importante para mat 102 e 115, alunos cursando a mesma disciplina duas vezes no mesmo semestre

    public void adicionaHistorico(RegistroNotas novoRegistro){
        for(RegistroNotas registroExistente : historico){
            if(registroExistente.getDisciplina().getCodDisciplina().equals(novoRegistro.getDisciplina().getCodDisciplina())
               && (registroExistente.getSemestre().equals(novoRegistro.getSemestre()))) 
            return;
        }
        this.historico.add(novoRegistro);
    }

    public void calculaCR(){
        if(historico.isEmpty()){
            this.cr = 0.0;
            return;
        }
        int totalCargaHoraria = 0;
        double nota_ponderada = 0.0;
        for(RegistroNotas registro : historico){
            Double nota = registro.getNota();
            Disciplina disciplina = registro.getDisciplina();
            nota_ponderada += nota * disciplina.getCargaHoraria();
            totalCargaHoraria += disciplina.getCargaHoraria();
        }
        
        if(totalCargaHoraria > 0){
            this.cr = nota_ponderada / totalCargaHoraria;
        }else{
            this.cr = 0.0;
        }
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return mat.equals(aluno.mat);  // Compara pela matrícula
    }

    @Override
    public int hashCode(){
        return mat.hashCode();  // IMPORTANTE: sempre override hashCode junto com equals
    }
}

