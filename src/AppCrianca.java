import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class AppCrianca {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties")); 
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");
        
        // instanciar o ChatGPTClient
        var chatGPTCrianca = new ChatGPTCrianca();
        //Pegar um assunto junto ao usuário
        String texto = JOptionPane.showInputDialog("Assunto: ");
        //Chamar o método explicarCrianca, obter o resultado
        String s = chatGPTCrianca.explicarCrianca(OPENAI_API_KEY, texto);
        //e exibir
        JOptionPane.showMessageDialog(null, s);// n
    }
}