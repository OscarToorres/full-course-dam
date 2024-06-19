/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimpleGestion;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author solda
 */
public class GestionClientes {

    public List<ClienteG> generarListaClientes() {
        List<ClienteG> clientes = new ArrayList<>();

        clientes.add(new ClienteG("11111111A", "Borja", "Silva Martinez"));
        clientes.add(new ClienteG("22222222B", "Ivan", "Fernandez Trinhans"));
        clientes.add(new ClienteG("33333333C", "Alvaro", "Outeiral Pinherio"));
        clientes.add(new ClienteG("44444444D", "Hugo", "Silva Rodriguez"));
        clientes.add(new ClienteG("55555555E", "Luis", "Lustres Ilustrado"));

        return clientes;
    }

    public List<Contacto> generarLisstaContactos(String ruta) {
        List<ClienteG> clientes = this.leJSonClientes(ruta);
        List<Enderezo> enderezos = new ArrayList<>();

        enderezos.add(new Enderezo("localidad01", "calle01", 1));
        enderezos.add(new Enderezo("localidad02", "calle02", 2));
        enderezos.add(new Enderezo("localidad03", "calle03", 3));
        enderezos.add(new Enderezo("localidad04", "calle04", 4));
        enderezos.add(new Enderezo("localidad05", "calle05", 5));

        List<Contacto> contactos = new ArrayList<>();

        int i = 0;
        for (ClienteG cle : clientes) {
            ClienteG cliente = clientes.get(i);
            contactos.add(new Contacto(enderezos.get(i), cle.getDni(), cle.getNombre(), cle.getApellidos()));
            i++;
        }
        return contactos;
    }

    public JSONArray crearObjetosJsonCliente(List<ClienteG> clientes) {
        JSONArray jarrayClientes = new JSONArray();
        for (ClienteG cle : clientes) {
            JSONObject obj = new JSONObject();
            obj.put("dni", cle.getDni());
            obj.put("nombre", cle.getNombre());
            obj.put("apellidos", cle.getApellidos());
            jarrayClientes.add(obj);
        }
        return jarrayClientes;
    }

    public void guardaJSonClientes(String ruta, JSONArray jarray) {
        try {
            FileWriter fw = new FileWriter(ruta);
            fw.write(jarray.toJSONString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ClienteG> leJSonClientes(String ruta) {
        JSONParser parser = new JSONParser();
        List<ClienteG> clientes = new ArrayList<>();

        try {
            FileReader fr = new FileReader(ruta);
            JSONArray jarrayClientes = (JSONArray) parser.parse(fr);

            for (int i = 0; i < jarrayClientes.size(); i++) {
                JSONObject objCliente = (JSONObject) jarrayClientes.get(i);
                clientes.add(this.recuperarJSonClientes(objCliente));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    private ClienteG recuperarJSonClientes(JSONObject objCliente) {
        ClienteG cliente = new ClienteG();

        cliente.setApellidos((String) objCliente.get("apellidos"));
        cliente.setDni((String) objCliente.get("dni"));
        cliente.setNombre((String) objCliente.get("nombre"));

        return cliente;
    }

    public void mostrarJsonClientes(String ruta) {
        List<ClienteG> clientes = this.leJSonClientes(ruta);
        for (int i = 0; i < clientes.size(); i++) {
            ClienteG cliente = clientes.get(i);
            System.out.println(cliente.toString());
        }
    }

    public JSONArray crearObjectsContacto(List<Contacto> contactos) {
        JSONArray jarrayContacto = new JSONArray();

        for (Contacto con : contactos) {
            JSONObject objCOntacto = new JSONObject();

            objCOntacto.put("dni", con.getDni());
            objCOntacto.put("nombre", con.getNombre());
            objCOntacto.put("apellidos", con.getApellidos());

            objCOntacto.put("enderezo", this.crearObjectEnderezo(con.getEnderezo()));

            jarrayContacto.add(objCOntacto);
        }

        return jarrayContacto;
    }

    private JSONObject crearObjectEnderezo(Enderezo enderezo) {
        JSONObject objEnderezo = new JSONObject();

        objEnderezo.put("localidad", enderezo.getLocalidad());
        objEnderezo.put("calle", enderezo.getCalle());
        objEnderezo.put("numero", enderezo.getNumero());

        return objEnderezo;
    }

    public void guardarJSonContactos(JSONArray jarray, String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            fw.write(jarray.toJSONString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Contacto> leeJSonContactos(String ruta) {
        JSONParser parser = new JSONParser();
        List<Contacto> contactos = new ArrayList<>();

        try {
            FileReader fr = new FileReader(ruta);
            JSONArray jarrayContactos = (JSONArray) parser.parse(fr);
            for (int i = 0; i < jarrayContactos.size(); i++) {
                JSONObject objContacto = (JSONObject) jarrayContactos.get(i);
                contactos.add(this.leeJSonContacto(objContacto));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contactos;
    }

    private Contacto leeJSonContacto(JSONObject objContacto) {
        Contacto contacto = new Contacto();

        contacto.setApellidos((String) objContacto.get("apellidos"));
        contacto.setDni((String) objContacto.get("dni"));
        contacto.setNombre((String) objContacto.get("nombre"));

        JSONObject objEnderezo = (JSONObject) objContacto.get("enderezo");

        contacto.setEnderezo(this.leeJSonEnderezo(objEnderezo));

        return contacto;
    }

    private Enderezo leeJSonEnderezo(JSONObject objEnderezo) {
        Enderezo enderezo = new Enderezo();

        enderezo.setCalle((String) objEnderezo.get("calle"));
        enderezo.setLocalidad((String) objEnderezo.get("localidad"));
        enderezo.setNumero((long) objEnderezo.get("numero"));

        return enderezo;
    }

    public void mostrarJSonContactos(String ruta) {
        List<Contacto> contactos = this.leeJSonContactos(ruta);
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            System.out.println(contacto.toString());
        }
    }

    public void guardaXmlJSonContactos(String rutaJsonClientes, String rutaXml) {
        File file = new File(rutaXml);

        ListaContacto listaContacto = new ListaContacto();
        listaContacto.setContactos(this.generarLisstaContactos(rutaJsonClientes));

        try {
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("contacto", Contacto.class);
            xs.alias("listaContacto", ListaContacto.class);
            xs.alias("Enderezo", Enderezo.class);

            xs.toXML(listaContacto, new FileOutputStream(file));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leMostrarCmlContactos(String ruta) {
        File file = new File(ruta);

        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("contacto", Contacto.class);
        xs.alias("listaContacto", ListaContacto.class);
        xs.alias("Enderezo", Enderezo.class);
        xs.addPermission(AnyTypePermission.ANY);

        ListaContacto listaContactoLeida = new ListaContacto();

        try {
            xs.fromXML(new FileInputStream(ruta), listaContactoLeida);
            System.out.println("\nLista de Contactos:\n" + listaContactoLeida);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarDatJsonContactos(List<Contacto> contactos, String ruta) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Contacto cont : contactos) {
                oos.writeObject(cont);
            }
            oos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leMostrarDatContactos(String ruta) {
        List<Contacto> contactos = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Contacto contacto = null;
            while (fis.available() > 0) {
                contacto = (Contacto) ois.readObject();
                contactos.add(contacto);
                System.out.println(contacto.toString());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
