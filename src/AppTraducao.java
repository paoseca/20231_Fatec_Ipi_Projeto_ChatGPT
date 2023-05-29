import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class AppTraducao {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties")); 
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");
        
        // instanciar o ChatGPTClient
        var chatGPTTrducao = new ChatGPTTraducao();
        //Pegar um assunto junto ao usuário
        String texto = JOptionPane.showInputDialog("Texto?");
        //Chamar o método traduzirTexto, obter o resultado
        String s = chatGPTTrducao.traduzirTexto(OPENAI_API_KEY, texto);
        //e exibir
        JOptionPane.showMessageDialog(null, s);
    }
}
