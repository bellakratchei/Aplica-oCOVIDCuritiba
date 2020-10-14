package bellakratchei.com.github.repositorio;

import bellakratchei.com.github.fabrica.FabricaJDBC;
import bellakratchei.com.github.models.CSVPessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoaDB implements RepositorioInterface {

    public List<CSVPessoa> all() {
        List<CSVPessoa> lista = new ArrayList<>();

        try (Connection conn = FabricaJDBC.criaConn()) {
            String sql = "SELECT * FROM pessoa";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                CSVPessoa u = new CSVPessoa(rs.getInt("posicao"),rs.getString("dataNotificacao"),
                        rs.getString("classificacao"), rs.getInt("idade"),rs.getString("sexo"),
                        rs.getString("evolucao"),rs.getString("dataObito"));
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void insert(CSVPessoa entidade) {
        try(Connection conn = FabricaJDBC.criaConn()){
            String sql = "INSERT INTO pessoa (posicao,dataNotificacao,classificacao,idade,sexo,evolucao,dataObito) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (int) entidade.getPosicao());
            ps.setDate(2, Date.valueOf(entidade.getDataNotificacao()));
            ps.setString(3,entidade.getClassificacaoFinal());
            ps.setInt(4, (int) entidade.getIdadeAnos());
            ps.setString(5,entidade.getSexo());
            ps.setString(6,entidade.getEvolucao());
            ps.setDate(7, Date.valueOf(entidade.getDataObito()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CSVPessoa> allDays(Date date) {

        List<CSVPessoa> lista = new ArrayList<>();
        try(Connection conn = FabricaJDBC.criaConn()){
            String sql = "SELECT * FROM pessoa where dataNotificacao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1,date);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                CSVPessoa p = new CSVPessoa(rs.getInt("posicao"),rs.getString("dataNotificacao"),
                        rs.getString("classificacao"),rs.getInt("idade"),rs.getString("sexo"),
                        rs.getString("evolucao"),rs.getString("dataObito"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<CSVPessoa> allYears(Integer year) {

        List<CSVPessoa> lista = new ArrayList<>();

        try(Connection conn = FabricaJDBC.criaConn()){
            String sql = "SELECT * FROM pessoa where idade = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,year);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                CSVPessoa p = new CSVPessoa(rs.getInt("posicao"),rs.getString("dataNotificacao"),
                        rs.getString("classificacao"),rs.getInt("idade"),rs.getString("sexo"),
                        rs.getString("evolucao"),rs.getString("dataObito"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void mediaF() {

        int totalF = 0;
        int soma = 0;

        try (Connection conn = FabricaJDBC.criaConn()) {
            String evolucaoF = "ÓBITO CONF";
            String sexoF = "F";
            String sqlF = "SELECT COUNT(*) as TOTAL FEMININO FROM pessoa WHERE evolucao = ? AND sexo = ?";
            PreparedStatement ps = conn.prepareStatement(sqlF);
            ps.setString(1,evolucaoF);
            ps.setString(2,sexoF);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                totalF = rs.getInt("TOTAL FEMININO");
            }

            String sqlSUM = "SELECT SUM(*) as SOMA FROM pessoa WHERE evolucao = ? AND sexo = ?";
            PreparedStatement psSUM = conn.prepareStatement(sqlSUM);
            ps.setString(1,evolucaoF);
            ps.setString(2,sexoF);
            ResultSet rsSUM = ps.executeQuery();

            if(rs.next()){
                soma = rs.getInt("SOMA");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Média de óbitos do sexo masculino"+ soma/totalF);
    }

    public void mediaM() {

        int totalM = 0;
        int somaM = 0;

        try (Connection conn = FabricaJDBC.criaConn()) {
            String evolucaoM = "ÓBITO CONF";
            String sexoM = "M";
            String sqlM = "SELECT COUNT(*) as TOTAL MASCULINO FROM pessoa WHERE evolucao = ? AND sexo = ?";
            PreparedStatement ps = conn.prepareStatement(sqlM);
            ps.setString(1,evolucaoM);
            ps.setString(2,sexoM);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                totalM = rs.getInt("TOTAL MASCULINO");
            }

            String sqlSUM = "SELECT SUM(*) as SOMA FROM pessoa WHERE evolucao = ? AND sexo = ?";
            PreparedStatement psSUM = conn.prepareStatement(sqlSUM);
            ps.setString(1,evolucaoM);
            ps.setString(2,sexoM);
            ResultSet rsSUM = ps.executeQuery();

            if(rs.next()){
                somaM = rs.getInt("SOMA");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Média de óbitos do sexo masculino"+ somaM/totalM);
    }

}
