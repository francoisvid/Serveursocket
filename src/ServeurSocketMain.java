
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author francois
 */
public class ServeurSocketMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

// Socket spéciale serveur ecoute sur 127.0.0.1:12107
        ServerSocket server = new ServerSocket(4000);
        Socket client = null;
        System.out.println("lancement du serveur");
        Scanner check = new Scanner(System.in);
        String hey = "";
        
// en attente d'une connexion cliente, retourne le handler du canal
        client = server.accept();
        System.out.println("connexion du client");
        
// préparation de la gestion du flux entrant
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        out.println("je t'écoute");
        out.flush();
        out.println("saisissez du texte ou quittez (q)");
        out.flush();
        
//preparation de la question u flux entrant
        String ligne = "";

// tant que le client ne retourne pas "q" on lit les messages des clients
        while (!(ligne = in.readLine()).contentEquals("q")) {
            System.out.println(ligne);
        
        if(check.hasNext()){
            hey = check.nextLine();
            out.println(hey);
            out.flush();
        }
    }
        
// fermeture des canaux
        out.println("Vous allez etre déconnecté");
        out.flush();
        client.close();
        server.close();      
        in.close();
        out.close();
    }

}
