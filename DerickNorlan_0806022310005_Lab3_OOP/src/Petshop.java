import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Petshop {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static public void main(String[] args) {
        Petshop.clearScreen();
        
        ArrayList<Dog> dogList = new ArrayList<Dog>();
        Scanner scanner = new Scanner (System.in);
        FileWriter writer = null;
        try {
            writer = new FileWriter("PetshopOutput.txt");
            for (int count = 0; count < 5; count++) {
                try {
                        System.out.println("Masukkan Nama Anjing: ");
                        String nama = scanner.nextLine();
                        System.out.println("Masukkan Ukuran Anjing: ");
                        String ukuran = scanner.nextLine();
                        System.out.println("Masukkan Jenis Anjing: ");
                        String jenis = scanner.nextLine();
                        System.out.println("Apakah Anjing Sudah makan?");
                        boolean isSudahMakan = scanner.nextBoolean();
                        scanner.nextLine(); // Consume the newline left-over

                        Dog newdog;
                        switch (jenis.toLowerCase()) {
                            case "herder":
                                newdog = new Herder(nama, ukuran, jenis, isSudahMakan);
                                break;
                            case "shiba":
                                newdog = new Shiba(nama, ukuran, jenis, isSudahMakan);
                                break;
                            case "bulldog":
                                newdog = new Bulldog(nama, ukuran, jenis, isSudahMakan);
                                break;
                            case "corgy":
                                newdog = new Corgy(nama, ukuran, jenis, isSudahMakan);
                                break;
                            case "germanshepherd":
                                newdog = new GermanShepherd(nama, ukuran, jenis, isSudahMakan);
                                break;
                            default:
                                System.out.println("Jenis Anjing Tidak Ditemukan");
                                count--;
                                continue;
                        }
                        dogList.add(newdog);
                    }
                
                catch (Exception e) {
                    System.out.println("Input tidak valid. Harap masukkan data yang benar.");
                    scanner.close();
                }
            }
           

            int i = 1;
            
            String header = String.format("----------------------------------------------------------------------------------------%n") +
                            String.format("| Pet Shop                                                                             |%n") +
                            String.format("+--------------------------------------------------------------------------------------+%n") +
                            String.format("| %-3s | %-10s | %-20s | %8s | %-15s | %-13s |%n", "No.", "Nama", "Jenis", "Ukuran", "Jadwal Makan", "Status Makan") +
                            String.format("+--------------------------------------------------------------------------------------+%n");
            writer.write(header);
            
            for(Dog dog:dogList){
                String dogInfo = String.format("| %-3s | %-10s | %-20s | %8s | %-15s | %-13s |%n", i, (dog.getNama()), (dog.getJenis()), dog.getUkuran(), dog.getJadwalMakan() + " Kali Sehari ",(dog.getIsSudahMakan()) ? "Sudah Makan" : "Belum Makan");
                writer.write(dogInfo);
                i++;
            }
            writer.write("+--------------------------------------------------------------------------------------+%n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file writer.");
            }
        }
    }
}


