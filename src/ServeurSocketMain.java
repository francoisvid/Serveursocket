
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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
        ServerSocket server = new ServerSocket(12107);
        Socket client = null;
// en attente d'une connexion cliente, retourne le handler du canal
        client = server.accept();
        System.out.println("connexion du client");
// préparation de la gestion du flux entrant
        InputStream in = client.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buffReader = new BufferedReader(reader);
        String ligne = "";

// tant que le client ne retourne pas "q" on lit les messages des clients
        while (!(ligne = buffReader.readLine()).contentEquals("q")) {
            System.out.println(ligne);
        }
// fermeture des canaux
        buffReader.close();
        reader.close();
        in.close();
        client.close();
    }

}
