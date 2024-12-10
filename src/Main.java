import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File file = new File("./src/diario.txt");

        if (file.exists()) {
            List<String> linhas = new ArrayList<>();

            // Passo 1: Ler o conteúdo do arquivo e armazenar em uma lista
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = br.readLine()) != null) {
                    linhas.add(line.toUpperCase()); // Armazena a linha em maiúsculas
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
                return; // Encerra o programa em caso de erro
            }

            // Passo 2: Escrever o conteúdo modificado de volta no arquivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (String linha : linhas) {
                    bw.write(linha);
                    bw.newLine(); // Adiciona uma quebra de linha
                }
                System.out.println("Conteúdo convertido para maiúsculas com sucesso!");

            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

        } else {
            System.out.println("File not exists");
        }
    }
}
