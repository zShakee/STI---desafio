import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            SistemaAcademico sistema = new SistemaAcademico();
            sistema.processarArquivo("notas.csv");
            sistema.imprimirRelatorioFinal();            
        } catch(IOException e){
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            e.printStackTrace();
        } catch(Exception e){
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
