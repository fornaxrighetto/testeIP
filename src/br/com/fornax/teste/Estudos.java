package br.com.fornax.teste;

import java.net.*;
import java.util.*;

public class Estudos {
	public static void main(String args[]){
	    String IP = "172.26.26.14";

	    try{
	      String serv = InetAddress.getByName(IP).getHostName();
	      System.out.println("Servidor é: " + serv + "E o IP é: " + IP);
	    }
	    catch(UnknownHostException uhex){
	      System.out.println("Não foi possível resolver o nome do servidor.");
	    }
	  }
}
