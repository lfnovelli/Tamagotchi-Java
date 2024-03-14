import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeEscolhido = null;
        String emojiEscolido = null;
        int escolheu = 0;
        int numero = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seja bem vindo!");
        System.out.println("Digite o nome de seu Tamagotchi:");
        nomeEscolhido = scanner.nextLine();

        while (escolheu != 1){
            System.out.println("Agora escolha seu bichinho!");
            System.out.println("1- 🐱 Gatinho");
            System.out.println("2- 🦉 Coruja");
            System.out.println("3- 🐯 Tigrinho");
            System.out.println("4- 🐹 Hamster ");
            System.out.println("5- 🦊 Raposa");
            System.out.println("6- 🦥 Preguiça");
            numero = scanner.nextInt();

            switch (numero){
                case 1:{
                    System.out.println("Você escolheu o gatinho!");
                    emojiEscolido = "🐱";
                    escolheu++;
                    break;
                }
                case 2: {
                    System.out.println("Você escolheu a coruja!");
                    emojiEscolido = "🦉";
                    escolheu++;
                    break;
                }
                case 3: {
                    System.out.println("Você escolheu o tigrinho! 🤑");
                    emojiEscolido = "🐯";
                    escolheu++;
                    break;
                }
                case 4: {
                    System.out.println("Você escolheu o hamster!");
                    emojiEscolido = "🐹";
                    escolheu++;
                    break;
                }
                case 5: {
                    System.out.println("Você escolheu a raposa!");
                    emojiEscolido = "🦊";
                    escolheu++;
                    break;
                }
                case 6: {
                    System.out.println("Você escolheu a preguiça! Tão lindinha 😭");
                    emojiEscolido = "🦥";
                    escolheu++;
                    break;
                }
                default: {
                    System.out.println("Opção inválida. Tente novamente");
                }
            }
        }

        Tamagotchi meuTamagotchi = new Tamagotchi(nomeEscolhido, emojiEscolido);

        while (meuTamagotchi.estaVivo()){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n--------------------------");
            meuTamagotchi.getStatus();
            System.out.println("\n--------------------------");
            System.out.println("\nOque você quer fazer?");
            System.out.println("1- Alimentar " + meuTamagotchi.getNome());
            System.out.println("2- Brincar com " + meuTamagotchi.getNome());
            System.out.println("3- Dar banho em " + meuTamagotchi.getNome());
            System.out.println("4- Por " + meuTamagotchi.getNome() + " para dormir");
            System.out.println("5- Sair");

            int acao = scanner.nextInt();
            switch (acao) {
                case 1: {
                    meuTamagotchi.alimentar();
                    break;
                }
                case 2: {
                    meuTamagotchi.brincar();
                    break;
                }
                case 3: {
                    meuTamagotchi.darBanho();
                    break;
                }
                case 4: {
                    meuTamagotchi.porParaDormir();
                    break;
                }
                case 5: {
                    System.out.println("Você abandonou seu tamagotchi 😥");
                    meuTamagotchi.matarTamagotchi();
                    break;
                }
                default: {
                    System.out.println("Opção inválida, tente novamente.");
                }
            }
        }

        System.out.println("Fim de jogo.");
    }
}