/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ator.DAL;

import ator.DTO.AtorDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carla && taui
 */
public class AtorDAL extends ConexaoMySQL {
    public void incluirAtor(AtorDTO ator) throws Exception {
        // Prepara a conexão com o MySQL
        abrirBD();
        SQL = "INSERT INTO ator (atorNome, atorIdade) VALUES (?, ?)";
        ps = con.prepareStatement(SQL);
        // Busca os valores da classe AtorDTO
        ps.setString(1, ator.getAtorNome());
        ps.setInt(2, ator.getAtorIdade());
        ps.executeUpdate();
        fecharBD();
    }

    public AtorDTO selecionarAtorPorID(Integer atorID) throws Exception {
        abrirBD();
        SQL = "SELECT * FROM ator WHERE atorID = ?";
        ps = con.prepareStatement(SQL);
        ps.setInt(1, atorID);
        rs = ps.executeQuery();
        AtorDTO ator = new Ator();
        if (rs.next()) {
            ator.setAtorID(rs.getInt("atorID"));
            ator.setAtorNome(rs.getString("atorNome"));
            ator.setIdade(rs.getInt("atorIdade"));
            fecharBD();
        }
        return cliente;
    }

    // Método que vai selecionar todos os clientes no nosso Banco de Dados
    // e ordenar por nome do cliente
    public List listAtor() throws Exception {
        abrirBD();
        SQL = "SELECT * FROM ator ORDER BY atorNome";
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();
        List listaAtor = new ArrayList();
        while (rs.next()) {
            AtorDTO ator = new Ator();
            ator.setAtorID(rs.getInt("atorID"));
            ator.setAtorNome(rs.getString("atorNome"));
            ator.setIdade(rs.getInt("atorIdade"));
            listaAtor.add(ator);
        }
        fecharBD();
        return listaAtor;
    }

    // Método que vai fazer as alterações necessárias nos dados dos clientes
    // selecionados por seu código no nosso Banco de Dados
    public void alterarAtor(AtorDTO ator) throws Exception {
        abrirBD();
        SQL = "UPDATE ator SET atorNome = ?, atorIdade = ? WHERE cliID = ?";
        ps = con.prepareStatement(SQL);
        ps.setString(1, ator.getAtorNome());
        ps.setInt(2, ator.getAtorIdade());
        ps.setLong(3, ator.getAtorID());
        ps.execute();
        fecharBD();
    }

    public void excluirAtor(Integer atorID) throws Exception {
        abrirBD();
        SQL = "DELETE FROM ator WHERE atorID = ?";
        ps = con.prepareStatement(SQL);
        ps.setInt(1, atorID);
        ps.execute();
        fecharBD();
    }
}
