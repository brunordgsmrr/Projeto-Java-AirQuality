package com.fatec.api_java_airquality.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fatec.api_java_airquality.config.DbConnection;
import com.fatec.api_java_airquality.dtos.CidadeDTO;
import com.fatec.api_java_airquality.dtos.ProviderDTO;
import com.fatec.api_java_airquality.models.Cidade;

public class CidadeDAO implements ICidadeDAO{

	@Override
	public void adicionarCidade(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}
	
	public List<CidadeDTO> consultarCidadesMonitoradas() {
		String sql = """
				SELECT c.id as cidade_id, 
					c.name as cidade_name, 
					c.locality, 
					p.id as id_provider, 
					p.name as provider_name 
				FROM tb_cidade c 
				JOIN tb_provider p 
				ON c.id_provider = p.id;				
				""";
		
		List<CidadeDTO> cidadesDTO = new ArrayList<CidadeDTO>();
		
		try (Connection conn = DbConnection.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
            	CidadeDTO cidadeDTO = new CidadeDTO();
            	ProviderDTO providerDTO = new ProviderDTO();
            	
            	cidadeDTO.setId(rs.getInt("cidade_id"));            	
            	cidadeDTO.setName(rs.getString("cidade_name"));            	
            	cidadeDTO.setLocality(rs.getString("locality"));
            	
            	providerDTO.setId(rs.getInt("id_provider"));
            	providerDTO.setName(rs.getString("provider_name"));
            	
            	cidadeDTO.setProvider(providerDTO);
            	
            	cidadesDTO.add(cidadeDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidadesDTO;
		
	}
	

}
