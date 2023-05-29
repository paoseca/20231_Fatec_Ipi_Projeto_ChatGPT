import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) throws Exception {

        String opcoes = "1. Tradução\n2. Emojis\n3. Explicação para crianças\n4. Sair";
        int op = 4;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(opcoes));
            switch (op) {
                case 1: 
                    AppTraducao.main(args);
                    break;
                case 2:
                    AppEmoji.main(args);
                    break;
                case 3:
                    AppCrianca.main(args);
                    break;
                default:
                    System.out.println("Opção inválida.");
                break;
            }
        } while (op != 4);
    }
}
