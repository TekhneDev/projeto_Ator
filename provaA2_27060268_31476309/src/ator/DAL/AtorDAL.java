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
    public void incluirAtor(AtorDTO ator) throws Exception
    {
        //Prepara a conexão com o MySQL
        abrirBD();
        SQL = "INSERT INTO ator (atorNome, atorIdade) VALUES (?, ?)";
        ps = con.prepareStatement(SQL);
        //Busca os valores da classe AtorDTO
        ps.setString(1, ator.getAtorNome());
        ps.setInt(2, ator.getAtorIdade());
        ps.executeUpdate();
        fecharBD();
    }
    public AtorDTO selecionarAtorPorID(Integer atorID)throws Exception
    {
        abrirBD();
        SQL = "SELECT * FROM ator WHERE atorID = ?";
        ps = con.prepareStatement(SQL);
        ps.setInt(1, atorID);
        rs = ps.executeQuery();
        AtorDTO cliente = new ClienteDTO();
        if(rs.next())
        {
            cliente.setCliID(rs.getInt("cliID"));
            cliente.setCliNome(rs.getString("cliNome"));
            cliente.setCliDtInclusao(rs.getDate("cliDtInclusao").toLocalDate());
            cliente.setCliEndereco(rs.getString("cliEndereco"));
            cliente.setCliBairro(rs.getString("cliBairro"));
            cliente.setCliEmail(rs.getString("cliEmail"));
            cliente.setCliTel(rs.getString("cliTel"));
            cliente.setCliCidade(rs.getString("cliCidade"));
            cliente.setCliUF(rs.getString("cliUF"));
            fecharBD();            
        }
        return cliente;
    }
    //Método que vai selecionar todos os clientes no nosso Banco de Dados
    //e ordenar por nome do cliente
    public List selecionarListaClientes() throws Exception
    {
        abrirBD();
        SQL = "SELECT * FROM clientes ORDER BY cliNome";
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();
        List listaClientes = new ArrayList();
        while(rs.next())
        {
           ClienteDTO cliente = new ClienteDTO();
           cliente.setCliID(rs.getInt("cliID"));
           cliente.setCliNome(rs.getString("cliNome"));
           cliente.setCliDtInclusao(rs.getDate("cliDtInclusao").toLocalDate());
           cliente.setCliEndereco(rs.getString("cliEndereco"));
           cliente.setCliBairro(rs.getString("cliBairro"));
           cliente.setCliEmail(rs.getString("cliEmail"));
           cliente.setCliTel(rs.getString("cliTel"));
           cliente.setCliCidade(rs.getString("cliCidade"));
           cliente.setCliUF(rs.getString("cliUF"));
           listaClientes.add(cliente);         
        }
        fecharBD();
        return listaClientes;
    }
    //Método que vai fazer as alterações necessárias nos dados dos clientes
    //selecionados por seu código no nosso Banco de Dados
    public void alterarCliente(ClienteDTO cliente) throws Exception
    {
        abrirBD();         
        SQL = "UPDATE clientes SET cliNome = ?, cliDtInclusao = ?, cliEndereco = ?, cliBairro = ?, cliEmail = ?, cliTel = ?, cliCidade = ?, cliUF = ? WHERE cliID = ?";
        ps = con.prepareStatement(SQL);        
        ps.setString(1, cliente.getCliNome());
        ps.setDate(2,  java.sql.Date.valueOf(cliente.getCliDtInclusao()));     
        ps.setString(3, cliente.getCliEndereco());
        ps.setString(4, cliente.getCliBairro());
        ps.setString(5, cliente.getCliEmail());
        ps.setString(6, cliente.getCliTel());
        ps.setString(7, cliente.getCliCidade());
        ps.setString(8, cliente.getCliUF());
        ps.setLong(9, cliente.getCliID());
        ps.execute();
        fecharBD();
    }
    public void excluirCliente(Integer cliID) throws Exception
    {
        abrirBD();
        SQL = "DELETE FROM clientes WHERE cliID = ?";
        ps = con.prepareStatement(SQL);
        ps.setInt(1, cliID);
        ps.execute();
        fecharBD();
    }
}
