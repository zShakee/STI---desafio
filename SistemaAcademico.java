import java.io.*;
import java.util.*;
public class SistemaAcademico {
    HashMap<String, Aluno> alunos;
    HashMap<String, Disciplina> disciplinas;
    HashMap<Integer, Curso> cursos;

    public SistemaAcademico(){
        alunos = new HashMap<>();
        disciplinas = new HashMap<>();
        cursos = new HashMap<>();
    }

    public void processarArquivo(String nomeArq) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(nomeArq));
        String linha;
        boolean primeiraLinha = true;
        while((linha = br.readLine()) != null ){
            if (primeiraLinha) {
                primeiraLinha = false;
                continue;
            }
            processarLinha(linha);
        }
        br.close();
        calcularTodosCR();
        calcularCRMedioCursos();
    }
    private void processarLinha(String linha) {
        String[] dados = linha.split(",");
         
        if(dados.length < 6){
            System.out.println("Linha inválida");
            return;
        }

        String mat = dados[0].trim();
        String codDisciplina = dados[1].trim();
        int codCurso = Integer.parseInt(dados[2].trim());
        double nota = Double.parseDouble(dados[3].trim());
        int cargaHoraria = Integer.parseInt(dados[4].trim());
        String semestre = dados[5].trim();

        
        Curso curso = cursos.get(codCurso);
        if(curso == null){
            curso = new Curso(codCurso);
            cursos.put(codCurso, curso);
        }
        
        Aluno aluno = alunos.get(mat);
        if(aluno == null ){
            aluno = new Aluno(mat, curso);
            alunos.put(mat,aluno);
        }

        curso.adicionarAluno(aluno);

        Disciplina disciplina = disciplinas.get(codDisciplina);
        if(disciplina == null){
            disciplina = new Disciplina(codDisciplina, cargaHoraria);
            disciplinas.put(codDisciplina,disciplina);
        }

        RegistroNotas historico = new RegistroNotas(disciplina, aluno, semestre,nota);
        aluno.adicionaHistorico(historico);
    }

    private void calcularTodosCR(){
        for(Aluno aluno : alunos.values())
            aluno.calculaCR();
    }
    private void calcularCRMedioCursos(){
        for(Curso curso : cursos.values()){
            curso.calculaCRMedio();
        }
        
    }

    public void imprimirRelatorioFinal(){
        List<Aluno> listaAlunos = new ArrayList<>(alunos.values());
        listaAlunos.sort(Comparator.comparing(Aluno::getMat));
        System.out.println("\n------- O CR dos alunos é: --------\n");

        for(Aluno aluno : listaAlunos){
             System.out.printf("Matrícula: %s - CR: %.2f%n", aluno.getMat(), aluno.getCR());
        }
        System.out.println("-----------------------------------");

        System.out.println("\n----- Média de CR dos cursos -----\n");
        List<Curso> listaCursos = new ArrayList<>(cursos.values());
        listaCursos.sort(Comparator.comparing(Curso::getCodCurso));
        for(Curso curso : listaCursos){
            System.out.printf("Cod: %d - %.2f\n",curso.getCodCurso(), curso.getCRMedio());
        }

    }
}