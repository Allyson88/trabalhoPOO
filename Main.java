import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ControleRemoto controle = new ControleRemoto();
        LinkedList<Canal> canais = new LinkedList<>();
        canais.add(new Canal(10, "Globo", true));
        canais.add(new Canal(12, "SBT", true));
        canais.add(new Canal(8, "Record", false));
        canais.add(new Canal(17, "TV União", false));
        canais.add(new Canal(22, "TV Diário", true));
        int resp, resp1;
        do{
            System.out.println("Selecione uma opção");
            System.out.println("1 - Adicionar TV");
            System.out.println("2 - Adicionar canal na lista");
            System.out.println("3 - Aumentar Volume");
            System.out.println("4 - Diminuir Volume");
            System.out.println("5 - Próximo Canal");
            System.out.println("6 - Canal Anterior");
            System.out.println("7 - Mudar de Canal");
            System.out.println("8 - Informar Dados");
            System.out.println("9 - Mostrar Grade");
            System.out.println("0 - Sair");
            resp = scan.nextInt();
            if(resp == 1){
                Televisao newTV;
                System.out.println("Você deseja criar uma TV HD ou uma Smart TV?");
                System.out.println("1 - TV HD");
                System.out.println("2 - Smart TV");
                resp1 = scan.nextInt();
                System.out.println("Digite o id da TV");
                scan.nextLine();
                String id = scan.nextLine();
                if(resp1 == 1){
                    System.out.println("Digite o modelo da TV");
                    String modelo = scan.nextLine();
                    newTV = new TVHD(id, canais, modelo);
                }else{
                    System.out.println("Digite o número de polegadas da TV");
                    int pol = scan.nextInt();
                    newTV = new SmartTV(id, canais, pol);
                }
                try{
                    newTV.cadastrarCanais();
                    controle.adicionarTV(newTV);
                }catch(TVJaCadastrada e){
                    System.out.println(e.getMessage());
                }
            }else if(resp == 2){
                System.out.println("O canal é HD ou não?");
                System.out.println("1 - É HD");
                System.out.println("2 - Não é TV");
                boolean hd = scan.nextInt() == 1;
                System.out.println("Informe o número do canal");
                int numero = scan.nextInt();
                System.out.println("Informe o nome do canal");
                String nome = scan.nextLine();
                canais.add(new Canal(numero, nome, hd));
            }else if(resp == 3){
                System.out.println("Informe o número da TV");
                int num = scan.nextInt();
                controle.aumentarVolume(num);
            }else if(resp == 4){
                System.out.println("Informe o número da TV");
                int num = scan.nextInt();
                controle.diminuirVolume(num);
            }else if(resp == 5){
                System.out.println("Informe o número da TV");
                int num = scan.nextInt();
                controle.proximoCanal(num);
            }else if(resp == 6){
                System.out.println("Informe o número da TV");
                int num = scan.nextInt();
                controle.canalAnterior(num);
            }else if(resp == 7){
                System.out.println("Informe o número da TV");
                int num = scan.nextInt();
                System.out.println("Informe o número do canal");
                int canal = scan.nextInt();
                controle.sintonizarCanal(num, canal);
            }else if(resp == 8){
                System.out.println("Informe o número da TV");
                int num = scan.nextInt();
                controle.informarDados(num);
            }else if(resp == 9){
                System.out.println("Informe o número da TV");
                int num = scan.nextInt();
                controle.mostrarGrade(num);
            }else if(resp == 0){
                break;
            }else{
                System.out.println("Digite uma opção válida");
                continue;
            }
        }while(true);
        scan.close();
    }
}