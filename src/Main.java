import model.Player;
import service.Game_service;

import java.util.*;

public class Main {
    private static Player player = new Player("Player", 0, new ArrayList<>());
    private static Player cpu = new Player("Cpu", 0, new ArrayList<>());
    private static Game_service service = new Game_service();

    public static void main(String[] args) {
        service.createPatternWin();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose your position [1-" + service.getMaxState() + "] : ");
            player.setTempState(sc.nextInt());
            while (player.getFullState().contains(player.getTempState()) || cpu.getFullState().contains(player.getTempState())) {
                System.out.println("your position is filled\n");
                System.out.println("Reselect position\n");
                player.setTempState(sc.nextInt());
            }
            player.getFullState().add(player.getTempState());
            System.out.println(player.getName() + " select position " + player.getTempState());
            System.out.println(player.getFullState() + "\n");
            String hasil = service.checkWin(service.getListPatternWin(), player.getFullState(), cpu.getFullState(), service.getMaxState());
            if (hasil.length() > 0) {
                System.out.println(hasil);
                break;
            }

            Random random = new Random();
            cpu.setTempState(random.nextInt(service.getMaxState()) + 1);
            while (player.getFullState().contains(cpu.getTempState()) || cpu.getFullState().contains(cpu.getTempState())) {
                cpu.setTempState(random.nextInt(service.getMaxState()) + 1);
            }
            cpu.getFullState().add(cpu.getTempState());
            System.out.println(cpu.getName() + " select position " + cpu.getTempState());
            System.out.println(cpu.getFullState() + "\n");
            hasil = service.checkWin(service.getListPatternWin(), player.getFullState(), cpu.getFullState(), service.getMaxState());
            if (hasil.length() > 0) {
                System.out.println(hasil);
                break;
            }
        }
    }
}
