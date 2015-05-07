package br.com.fornax.teste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IpLocal {
	public void say() {
		try {
			
			/*Leia o arquivo "hosts_fornax.txt" para que possamos pegar os nomes das maquinas*/
			Reader r2 = new FileReader("hosts_fornax.txt");
			BufferedReader br2 = new BufferedReader(r2);
			/*Joga os dados do arquivo dentro de um ArrayList*/
			List<String> valores = new ArrayList<String>();


			String texto2;
			while ((texto2 = br2.readLine()) != null) {
				valores.add(texto2);
			}

			r2.close();
			br2.close();

			/*java.net.InetAddress i = java.net.InetAddress.getLocalHost();
			String ip = i.getHostAddress();
			ip = i.getHostName();
			
			System.out.println(ip);*/

			for (int t = 1; t < 392; t++) {
				try {
//					traz o endereço IP da maquina para cada linha que o FOR interar
					InetAddress address = InetAddress.getByName(valores.get(t));
					System.out.println(address);
				} catch (UnknownHostException e) {
					continue;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
			public void pinga(String hosts){
//				List<String> enderecoIP = new ArrayList<String>();
				try {  
					if (InetAddress.getByName(hosts).isReachable(5000)){ 
						System.out.println("Ping OK: " + hosts);
					}else{ 
						System.out.println("Ping FALHOU: " + hosts);  
//							return hosts;
					}
				} catch (Exception e) {  
					System.err.println("Ping FALHOU: " + hosts + " - " + e);  
				}
			}
			
			public void criarClasseA() throws IOException{
				int a = 0;
				int b = 0;
				int c = 0;
				int d = 0;
//				System.out.println(a + "." + b + "." + c + "." + d);
				
				FileWriter arq = new FileWriter("e:\\tabuada.txt"); 
				PrintWriter gravarArq = new PrintWriter(arq); 
				while(true){
					System.out.println(a + "." + b + "." + c + "." + d);
					gravarArq.printf(a + "." + b + "." + c + "." + d); 
					d++;
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
						break;
					}
					if(a == 127 && d == 255){
						break;
					}
				}
				gravarArq.printf("+-------------+%n"); 
				arq.close();
				}
			
			public void verificaServidorFornax() throws IOException{
				String IP = "";
				
				int a = 0;
				int b = 0;
				int c = 0;
				int d = 0;
				
				FileWriter arq = new FileWriter("e:\\ips.txt"); 
				PrintWriter gravarArq = new PrintWriter(arq); 
				
				while(d < 255){
					d++;
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
					
					
//					if(a == 127 && d == 255){
//						break;
//					}
					IP = a + "." + b + "." + c + "." + d;
					
					if(verificaNomeServidor(IP).equals("0.0.0.0")){
						continue;
					}else{
						gravarArq.printf(verificaNomeServidor(IP) + "/" + IP);
					}
//				 
				}
				/* Fecha o Arquivo*/
				gravarArq.printf("+-------------+%n"); 
				arq.close();
				System.out.println("---------------- FIM ----------------");
			}
			
			public String verificaNomeServidor(String IP) throws IOException{
//				List<String> enderecos = new ArrayList<String>();
				String serv = "0.0.0.0";
				
				try {  
					if (InetAddress.getByName(IP).isReachable(5000)){ 
//						System.out.println("Ping OK: " + enderecos);
						try{
						      serv = InetAddress.getByName(IP).getHostName();
						      /* Adiciona o IP no Array e Grava no Arquivo */
//						      enderecos.add(IP);
						      System.out.println("Servidor é: " + serv + "E o IP é: " + IP);
						    }
						    catch(UnknownHostException uhex){
						    	return "0.0.0.0";
//						      System.out.println("Não foi possível resolver o nome do servidor.");
						    }
					}else{ 
//						System.out.println("Ping FALHOU: " + enderecos); 
						return "0.0.0.0";
//							return hosts;
					}
				} catch (Exception e) { 
					return "0.0.0.0";
				}
				return serv;
				}
			
//			public String verificaServidor(String IP) throws IOException{
//				
//				if(verificaNomeServidor(IP).equals("0.0.0.0")){
//					return verificaNomeServidor(IP);
//				}else{
//					return verificaNomeServidor(IP);
//				}
//			}
		}
			


