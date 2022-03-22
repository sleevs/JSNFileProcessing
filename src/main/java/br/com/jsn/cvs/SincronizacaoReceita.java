package br.com.jsn.cvs;


import java.io.FileNotFoundException;

//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReader;
public class SincronizacaoReceita {
   
	

    public static void main(String[] args) throws CsvException, FileNotFoundException   {
    	
    	
    	ReceitaService receitaService = new ReceitaService();
    	

    	Reader in = new FileReader("cvs_file.csv");
    	try(CSVReader csvReader = new CSVReader(in)) {
    		String[] HEADERS = { "agencia", "conta" , "saldo" , "status"};

	        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
	        strategy.setType(CvsModel.class);
	        strategy.setColumnMapping(HEADERS);
    		
    		List<CvsModel> reader =  (List<CvsModel>) new CsvToBeanBuilder(new FileReader("cvs_file.csv"))
    				.withMappingStrategy(strategy)
	                 .withSkipLines(1)
	                 .withIgnoreLeadingWhiteSpace(true)
	                 .build();
    		
    		 for (CvsModel user : reader) {
 	         
 	          receitaService.atualizarConta( user.getAgencia(),user.getConta() ,Double.parseDouble(user.getSaldo()),user.getStatus() );
 	        }
    		 
    		 
 
        }catch(IOException e) {
        	  System.out.println("---------------");
        	  System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
			System.out.println("---------------");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println("---------------");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("---------------");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
    }
}
