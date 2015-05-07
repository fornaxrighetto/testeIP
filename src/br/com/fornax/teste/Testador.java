package br.com.fornax.teste;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Testador {
	public static void main(String[] args) throws IOException {
//		Testa os Host para a FORNAX
//		new IpLocal().say();
//		new IpLocal().pinga("u28");
		verificaServidorFornax();
		
	}
	
	public static void verificaServidorFornax() throws IOException{
		String IP = "";
		String writeServer = "";
		
		int a = 172;
		int b = 15;
		int c = 0;
		int d = 0;
		
		FileWriter arq = new FileWriter("e:\\ips.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq); 
		
		while(!(IP.equals("172.15.114.300"))){
			
			if(d == 255){
				d = 0;
				c++;
			}
			if(c == 255){
				c = 0;
				b++;
			}
			if(b == 255){
				b = 0;
				a++;
			}
			
			
//			if(a == 172 && d == 255){
//				break;
//			}
			IP = a + "." + b + "." + c + "." + d;
			d++;
//			IP = "172.26.162.148";
			writeServer = verificaNomeServidor(IP);
			if(writeServer.equals("0.0.0.0")){
				System.out.println("Não foi possível resolver o nome do servidor: " + IP);
//				gravarArq.printf("Não foi possível resolver o nome do servidor: " + IP);
				continue;
			}else{
				gravarArq.printf(IP + " " + writeServer + "\n");
			}
//		 
		}
		/* Fecha o Arquivo*/
		gravarArq.printf("\n---------------- FIM ----------------"); 
		arq.close();
		
		
		System.out.println("---------------- FIM ----------------");
	}
	
	public static String verificaNomeServidor(String IP) throws IOException{
//		List<String> enderecos = new ArrayList<String>();
		String serv2 = "";
		
		try {  
			if (InetAddress.getByName(IP).isReachable(2000)){ 
//				System.out.println("Ping OK: " + enderecos);
				try{
					String serv = InetAddress.getByName(IP).getHostName();
				      /* Adiciona o IP no Array e Grava no Arquivo */
//				      enderecos.add(IP);
					serv2 = serv;
				      System.out.println("Servidor é: " + serv + "E o IP é: " + IP);
				    }
				    catch(UnknownHostException uhex){
				    	return "0.0.0.0";
//				      System.out.println("Não foi possível resolver o nome do servidor.");
				    }
			}else{ 
//				System.out.println("Ping FALHOU: " + enderecos); 
				return "0.0.0.0";
//					return hosts;
			}
		} catch (Exception e) { 
			return "0.0.0.0";
		}
		return serv2;
		}
}
