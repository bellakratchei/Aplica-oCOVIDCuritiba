package bellakratchei.com.github.arquivo;

import bellakratchei.com.github.models.CSVPessoa;
import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gerenciaExcel {

    public static List<CSVPessoa> ler() throws IOException {

        List<CSVPessoa> pessoas = new ArrayList<>();

        //Recuperando o arquivo
        @Cleanup FileInputStream file = new FileInputStream("resource/2020-10-03_Casos_Covid_19_-_Base_de_Dados.xlsx");
        Workbook workbook = new XSSFWorkbook(file);

        //setando a aba
        Sheet sheet = workbook.getSheetAt(0);

        //setando as linhas que estamos trabalhando
        List<Row> rows = (List<Row>) toList(sheet.iterator());

        //remove o cabeçalho da planilha
        rows.remove(0);

        rows.forEach(row ->{

            //setando as c�lulas
            List<Cell> celulas = (List<Cell>) toList(row.cellIterator());

            //atribui os valores para a classe Pessoa
            CSVPessoa p = CSVPessoa.builder()
                    .posicao((int) celulas.get(0).getNumericCellValue())
                    .dataNotificacao(celulas.get(1).getStringCellValue())
                    .classificacaoFinal(celulas.get(2).getStringCellValue())
                    .idadeAnos((int) celulas.get(3).getNumericCellValue())
                    .sexo(celulas.get(4).getStringCellValue())
                    .evolucao(celulas.get(5).getStringCellValue())
                    .dataObito(celulas.get(6).getStringCellValue())
                    .build();
            pessoas.add(p);

        });

        return pessoas;
    }

    public static List<?> toList(Iterator<?> iterator){
        return IteratorUtils.toList(iterator);

    }

    public void imprimir(List<CSVPessoa> pessoas){
        pessoas.forEach(System.out::println);
    }
}
