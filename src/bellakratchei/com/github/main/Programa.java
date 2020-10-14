package bellakratchei.com.github.main;

import bellakratchei.com.github.arquivo.gerenciaExcel;

import java.io.IOException;

public class Programa {

    public static void main(String args[]) {

        try {
            gerenciaExcel.ler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
