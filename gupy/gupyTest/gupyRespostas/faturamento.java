import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Faturamento {

    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("faturamento.json")));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray faturamentoArray = jsonObject.getJSONArray("faturamento");

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                double valor = faturamentoArray.getDouble(i);
                if (valor > 0) {
                    if (valor < menorFaturamento) {
                        menorFaturamento = valor;
                    }
                    if (valor > maiorFaturamento) {
                        maiorFaturamento = valor;
                    }
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;
            int diasAcimaMedia = 0;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                double valor = faturamentoArray.getDouble(i);
                if (valor > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
