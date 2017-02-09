/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sun.misc.BASE64Encoder;

/**
 *
 * @author lorena
 */
public class utiles {

    private String rutaImg;
    private String nombreAdj;
    private String rutaTemporal;
    private boolean viewImagen = false;
    byte[] byData;
    Properties properties = new Properties();

    public void utiles() {
    }

    /*
     * set
     */
    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public void setNombreAdj(String nombreAdj) {
        this.nombreAdj = nombreAdj;
    }

    public void setViewImagen(boolean viewImagen) {
        this.viewImagen = viewImagen;
    }

    public void setByData(byte[] byData) {
        this.byData = byData;
    }

    public void setRutaTemporal(String rutaTemporal) {
        this.rutaTemporal = rutaTemporal;
    }

    /*
     * get
     */
    public String getRutaImg() throws IOException {
        properties.load(Thread.currentThread().getContextClassLoader().getResource("/Egresados/packages/resources/properties.properties").openStream());
        rutaImg = properties.getProperty("ruta_imagen");
        return rutaImg;
    }

    public String getRutaTemporal() throws IOException {
        return rutaTemporal;
    }

    public String getNombreAdj() {
        return nombreAdj;
    }

    public boolean isViewImagen() {
        return viewImagen;
    }

    public byte[] getByData() {
        return byData;
    }

    public String encriptar(String pass) {
        MessageDigest me;
        String s = null;
        try {
            me = MessageDigest.getInstance("SHA-1");
            me.update(pass.getBytes());
            byte en[] = me.digest();
            s = (new BASE64Encoder().encode(en));
        } catch (Exception e) {
            System.out.println("ERROR ENCRIPTAR: " + e.getMessage());
        }
        return s;
    }

    public boolean verificarCorreo(String correo) {
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(correo);
        if (!mat.matches()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Correo Invalido"));
            return false;
        } else {
            return true;
        }
    }

    public boolean handleFileUpload(FileUploadEvent event) {
        UploadedFile fileAdj = event.getFile();
        try {
            byData = IOUtils.toByteArray(fileAdj.getInputstream());
            nombreAdj = fileAdj.getFileName();
            properties.load(Thread.currentThread().getContextClassLoader().getResource("/Egresados/packages/resources/properties.properties").openStream());
            rutaTemporal = properties.getProperty("ruta_imagen_temporal");
            clearFolder();
            rutaTemporal = getRutaTemporal() + "/" + nombreAdj;
            File(rutaTemporal);
        } catch (Exception e) {
            System.out.println("ERROR AL SUBIR IMAGEN: " + e.toString());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("ERROR ADJUNTAR LA IMAGEN"));
            return false;
        }
        viewImagen = true;
        return true;
    }

    public void File(String ruta) throws IOException {
        FileOutputStream imagenNueva = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            File file = new File(ruta);
            eliminarFile(ruta);
            imagenNueva = new FileOutputStream(file);
            imagenNueva.write(byData);
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR AL CREAR IMAGEN: " + ex.toString());
            context.addMessage(null, new FacesMessage("ERROR AL CREAR IMAGEN"));
            return;
        } finally {
            try {
                imagenNueva.close();
            } catch (IOException ex) {
                context.addMessage(null, new FacesMessage("Error al cerrar la imagen"));
            }
        }
    }

    public void eliminarFile(String ruta) {
        try {
            File file = new File(ruta);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar archivo: " + e.toString());
        }
    }

    public void clearFolder() {
        File folder = new File(rutaTemporal);
        File[] ficheros = folder.listFiles();
        File elim;
        if (folder.exists()) {
            for (int i = 0; i < ficheros.length; i++) {
                elim = new File(ficheros[i].toString());
                elim.delete();
            }
        }
    }

    public void clear() {
        nombreAdj = null;
        rutaImg = null;
        viewImagen = false;
        byData = null;
        rutaTemporal = null;
    }
}
