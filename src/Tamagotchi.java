import java.util.Random;
import java.util.Scanner;

public class Tamagotchi {
    private String nome;
    private int fome;
    private int felicidade;
    private int higiene;
    private int energia;
    private int saude;
    private boolean vivo;
    private boolean gostaDeBanho;
    private String emoji;

    public Tamagotchi(String nomeEscolhido, String emojiEscolido) {
        this.nome = nomeEscolhido;
        this.fome = 50;
        this.felicidade = 50;
        this.higiene = 50;
        this.energia = 100;
        this.saude = 100;
        this.vivo = true;
        this.emoji = emojiEscolido;
        int gostaOuNao = new Random().nextInt(2);
        if (gostaOuNao == 1){
            gostaDeBanho = true;
        } else {
            gostaDeBanho = false;
        }

    }


    public String getNome() {
        return nome + " " + emoji;
    }


    public void getStatus(){
        System.out.println("Status de " + getNome() + ":");
        System.out.println("Fome: " + fome + " / 100");
        System.out.println("Felicidade: " + felicidade + " / 100");
        System.out.println("Higiene: " + higiene + " / 100");
        System.out.println("Energia: " + energia + " / 100");
        System.out.println("Saúde: " + saude + " / 100");
    }


    private void verificarVivo() {
        if (fome <= 0 || felicidade <= 0 || saude <= 0 || energia <= 0) {
            vivo = false;
            System.out.println(this.getNome() + " morreu por falta de cuidado. 😭");
        }
        if (fome >= 100) fome = 100;
        if (felicidade >= 100) felicidade = 100;
        if (saude >= 100) saude = 100;
        if (energia >= 100) energia = 100;
        if (higiene >= 100) higiene = 100;
    }


    public void alimentar(){
        if (vivo){
            Scanner alimento = new Scanner(System.in);
            System.out.println("Escolha um alimento!");
            System.out.println("1- Morango 🍓");
            System.out.println("2- Hamburguer 🍔");
            System.out.println("3- Cupcake 🧁");
            System.out.println("4- Berinjela 🍆");
            int comida = alimento.nextInt();

            switch (comida){
                case 1: {
                    System.out.println("Você escolheu morango! 🍓");
                    System.out.println(getNome() + " adora morangos! 🥰");
                    System.out.println("FOME +5 ✅| FELICIDADE +5 ✅| SAÚDE +5 ✅");
                    fome += 5;
                    felicidade += 5;
                    saude += 5;
                    break;
                }
                case 2: {
                    System.out.println("Você escolheu hamburguer! 🍔");
                    System.out.println(getNome() + " adora hamburguer! 🥰");
                    System.out.println("FOME +10 ✅| FELICIDADE +10 ✅| SAÚDE -10 ⛔");
                    fome += 10;
                    felicidade += 10;
                    saude -= 10;
                    break;
                }
                case 3: {
                    System.out.println("Você escolheu cupcake! 🧁");
                    System.out.println("Cupcake é a comida favorita de " + getNome() + "!");
                    System.out.println("FOME +10 ✅| FELICIDADE +15 ✅| SAÚDE -15 ⛔");
                    fome += 10;
                    felicidade += 15;
                    saude -= 15;
                    break;
                }
                case 4: {
                    System.out.println("Você escolheu berinjela! 🍆");
                    System.out.println(getNome() + " detesta berinjela 😭");
                    System.out.println("FOME +15 ✅| FELICIDADE -15 ⛔| SAÚDE +15 ✅");
                    fome += 15;
                    felicidade -= 15;
                    saude += 15;
                    break;
                }
                default: {
                    System.out.println("Opção inválida :/ tente de novo.");
                }
            }
        } else {
            System.out.println("Você não pode alimentá-lo(a), " + getNome() + " está morto.");
        }
    }


    public void brincar() {
        if (vivo){
            Scanner atividade = new Scanner(System.in);
            System.out.println("Escolha uma atividade!");
            System.out.println("1- Andar de bike 🚲");
            System.out.println("2- Surfar 🌊");
            System.out.println("3- Ping-Pong 🏓");
            int escolha = atividade.nextInt();
            switch (escolha){
                case 1: {
                    this.andarDeBike();
                    break;
                }
                case 2: {
                    this.surfar();
                    break;
                }
                case 3: {
                    this.pingPong();
                    break;
                }
                default:{
                    System.out.println("Opção inválida");
                }
            }
        } else {
            System.out.println("Você não pode bricar com ele(a), " + getNome() + " está morto.");
        }
    }


    private void andarDeBike() {
        System.out.println("Você está levando " + getNome() + " para andar de bike!");
        for (int i = 0; i < 7; i++) {
            System.out.println("🚴‍♂️");
        }

        int caso = new Random().nextInt(2);
        if (caso == 1) {
            System.out.println(getNome() + " se divertiu muito passeando de bike!");
            System.out.println("FOME -15 ⛔| FELICIDADE +15 ✅| SAÚDE +5 ✅");
            fome -= 15;
            felicidade += 15;
            saude += 5;
        } else {
            System.out.println("Houve um acidente, e " + getNome() + " se machucou caindo de bicicleta 😭");
            System.out.println("FOME -15 ⛔| FELICIDADE -10 ⛔| SAÚDE -20 ⛔");
            fome -= 15;
            felicidade -=10;
            saude -= 20;
        }

    }


    private void surfar() {
        System.out.println(getNome() + " está indo pegar uma onda");
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⠾⠿⠿⠯⣷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣾⠛⠁⠀⠀⠀⠀⠀⠀⠈⢻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠿⠁⠀⠀⠀⢀⣤⣾⣟⣛⣛⣶⣬⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⠟⠃⠀⠀⠀⠀⠀⣾⣿⠟⠉⠉⠉⠉⠛⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡟⠋⠀⠀⠀⠀⠀⠀⠀⣿⡏⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⣠⡿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣷⡍⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣤⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⣠⣼⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠷⣤⣤⣠⣤⣤⡤⡶⣶⢿⠟⠹⠿⠄⣿⣿⠏⠀⣀⣤⡦⠀⠀⠀⠀⣀⡄
                ⢀⣄⣠⣶⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠓⠚⠋⠉⠀⠀⠀⠀⠀⠀⠈⠛⡛⡻⠿⠿⠙⠓⢒⣺⡿⠋⠁
                ⠉⠉⠉⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀
                """);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++){
            System.out.println("🏄‍♂️");
        }
        System.out.println(getNome() + " adora surfar!");
        System.out.println("FOME -15 ⛔| FELICIDADE +15 ✅| SAÚDE +5 ✅");
        fome -= 15;
        felicidade += 15;
        saude += 5;
    }


    private void pingPong(){
        System.out.println("Vamos jogar Ping Pong!");
        System.out.println("DIGITE 1 PARA JOGAR");
        Scanner scanner = new Scanner(System.in);
        int jogar = scanner.nextInt();
        if (jogar == 1) {
            for (int i = 0; i < 10; i++){
                if (this.rebateu()){
                    System.out.println(getNome() + " rebateu a bola");
                    System.out.println("DIGITE 1");
                    int jogadorRebateu = scanner.nextInt();

                    if (jogadorRebateu == 1){
                        System.out.println("Você rebateu a bola!");
                    } else {
                        System.out.println("Você errou.");
                        i += 10;
                    }

                } else {
                    System.out.println(getNome() + " errou a bola 😆");
                    i += 10;
                }

            }
            System.out.println("Fim de jogo");
            System.out.println(getNome() + " gostou muito de jogar com você 😊");
            System.out.println("FOME -15 ⛔| FELICIDADE +15 ✅| SAÚDE +5 ✅");
            fome =+ 15;
            felicidade += 15;
            saude += 5;
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private boolean rebateu() {
        int aleatorio = new Random().nextInt(10);
                if (aleatorio <= 3){
                    return false;
                } else {
                    return true;
                }
    }


    public void darBanho() {
        if (vivo){
            System.out.println("Você deu banho 🚿🧼 em " + getNome());
            higiene += 20;
            energia -= 10;
            if (gostaDeBanho){
                felicidade += 10;
                System.out.println(getNome() + " adora banhos! 😊");
            } else {
                felicidade -= 10;
                System.out.println(getNome() + " não gosta muito de banhos... 😤");
            }
        } else {
            System.out.println("Você não pode banhá-lo(a), " + getNome() + " está morto.");
        }
    }

    public void porParaDormir(){
        if (vivo) {
            System.out.println(getNome() + " tirou uma sonequinha 😴💤");
            energia += 50;
            fome -= 20;
        } else {
            System.out.println(getNome() + " está morto. Ele(a) já dorme (para sempre).");
        }
    }

    public boolean estaVivo() {
        verificarVivo();
        return vivo;
    }

    public void matarTamagotchi() {
        vivo = false;
    }
}