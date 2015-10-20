package edu.mum.soaclient;

import edu.mum.rmi.service.RMIServiceJsp;
import edu.mum.soa.Person;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bipin
 */
public class ProxyClient {

    String host = "localhost";
    int portNumber = 1199;
    String lookupName = "//" + host + ":" + portNumber + "/" + "ServerObject";
    RMIServiceJsp rMIServiceJsp;

    public ProxyClient() throws NotBoundException, MalformedURLException, RemoteException {
        rMIServiceJsp = (RMIServiceJsp) Naming.lookup(lookupName);
    }

    
    public List<Person> findAll() {
        System.out.println("client is calling proxy method");
        List<Person> list = new ArrayList<>();
        try {
            Person p;
            for (Object o : rMIServiceJsp.findAll()) {
                p = (Person) o;
                list.add(p);
            }
            return list;
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Person findById(int id) {
        try {
            System.out.println("client is calling proxy method");
            return rMIServiceJsp.findById(id);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
