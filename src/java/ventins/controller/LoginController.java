/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import ventins.entities.Usuarios;
import ventins.session.UsuariosFacadeLocal;

/**
 *
 * @author lorena
 */
@ManagedBean
@SessionScoped
public class LoginController extends utiles.utiles {

    @EJB
    private UsuariosFacadeLocal usuarioFacade;

    private String cuenta;
    private String pass;
    private Usuarios usuario;
    private String nombreUsu;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    /*
     * Metodo get() 
     */
    public String getCuenta() {
        return cuenta;
    }

    public String getPass() {
        return pass;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    /*
     * Metodos set()
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    /*
     * Metodos
     */
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = new Usuarios();
        if (cuenta.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage("Debe ingresar Usuario y Contraseña"));
            return "login";
        }
        usuario.setUsuLogin(cuenta.trim());
        usuario = usuarioFacade.getLogin(usuario);
        if (usuario == null) {
            context.addMessage(null, new FacesMessage("Usuario no existe por favor validar"));
            inicializarCampos();
            return "login";
        }
        pass = super.encriptar(pass);
        if (!usuario.getUsuPass().equalsIgnoreCase(pass)) {
            context.addMessage(null, new FacesMessage("Contraseña incorrecta"));
            inicializarCampos();
            return "login";
        }
        if (usuario.getUsuEstado().equalsIgnoreCase("I")) {
            context.addMessage(null, new FacesMessage("No tiene permiso para ingresar, por favor comuniquese con el administrador del sistema"));
            return "login";
        }
        try {
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("usuarioId", usuario);
        } catch (Exception e) {
            System.out.println("ERROR AL INTENTAR CONSTRUIR LA SESION: " + e.toString());
            return "login";
        }
        String[] nom = usuario.getUsuNombre().split(" ");
        String[] ape = usuario.getUsuApellidos().split(" ");
        nombreUsu = nom[0] + " " + ape[0];
        return "principal";
//        generarPermisos();
       // return "/Publicaciones.xhtml?faces-redirect=true";
    }

    public void inicializarCampos() {
        cuenta = null;
        pass = null;
        usuario = null;
    }
    /* public void recuperarPassword() {
        FacesContext context = FacesContext.getCurrentInstance();
        pass = null;
        usuarioObj.setUsuCorreo(email);
        usuarioObj = usuarioFacade.buscarMail(usuarioObj);
        if (usuarioObj == null) {
            context.addMessage(null, new FacesMessage("Su correo ingresado no existe por favor verifique"));
        } else {
            String passnuevo = "sistemadeinformacion";
            pass = encriptar(passnuevo);
            try {
                EnviarMail send = new EnviarMail();
                send.send(usuarioObj.getUsuCorreo(), "RECUPERACION DE CONTRASEÑA SISTEMA DE EGRESADOS", "Su nueva contraseña para el ingreso al sistema de Egresados de la Universidad Distrital Francisco Jose de Caldas es:<br/>"
                        + passnuevo
                        + "<br/><br/>Recuerde cambiar su contraseña.");
            } catch (Exception e) {
                System.out.println("ERROR MAIL: " + e.getMessage());
            }
            context.addMessage(null, new FacesMessage("Su nueva contraseña se ha enviado al correo"));
            RequestContext.getCurrentInstance().execute("PF('recContra').hide();");
        }
    }

    public String loginEmpresa() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage("Debe ingresar Usuario y Contraseña"));
            return null;
        }
        return "/EmpresaInf.xhtml?faces-redirect=true";
    }

    public String cerrarSesion() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.removeAttribute("usuarioId");
        httpSession.invalidate();
        permisos = null;
        usuario = null;
        pass = null;
        return "/faces/index.xhtml?faces-redirect=true";
    }

    public void viewlogin() {
        viewLogin = true;
    }

    public void comprobarPassword() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        usuarioObj = (Usuario) httpSession.getAttribute("usuarioId");
        usuarioObj = usuarioFacade.getUsuario(usuarioObj.getUsuId());
        pass = encriptar(pass);
        if (!usuarioObj.getUsuPass().equalsIgnoreCase(pass)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña Incorrecta", ""));
        }
    }

    public void cambiarPassword() {
        if (!passNuevo.equals(passRep)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden", ""));
        } else {
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            usuarioObj = (Usuario) httpSession.getAttribute("usuarioId");
            passNuevo = encriptar(passNuevo);
            usuarioObj.setUsuPass(passNuevo);
            usuarioObj = usuarioFacade.actualizarUsuario(usuarioObj);
            if (usuarioObj == null) {
                pass = null;
                passNuevo = null;
                passRep = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se actualizo la contraseña", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La contraseña se actualizo con exito"));
            }

        }
    }

    /* public void crearlogin(String pass, Usuario usuario) {
     pass = encriptar(pass);
     System.out.println("usuario: " + usuario.getUsuCorreo());
     boolean res = loginFacade.crearLogin(usuario, pass);
     if (res == false) {
     return;
     } else {
     try {
     EnviarMail send = new EnviarMail();
     send.send(usuario.getUsuCorreo(), "REGISTRO AL SISTEMA DE EGRESADOS", "Bienvenido al sistema de egresados de la universidad Distrital Francisco Jose de Caldas.\n"
     + "Queremos contar con su aporte de ideas y conocimientos a traves de este sistema, ademas que usted como egresado tenga conocimiento\n"
     + "de las actividades realizadas en la universidad y ultimas ofertas laborales publicadas por las empresas.");
     } catch (Exception e) {
     System.out.println("ERROR MAIL: " + e.getMessage());
     }
     }
     }
    public void generarPermisos() {
        Long batId = usuarioObj.getBatPerfil().getBatId();
        Basicatipo basica = new Basicatipo();
        basica.setBatId(batId);
        Permiso permiso = new Permiso();
        permiso.setBatPerfil(basica);
        permiso = permisoLocal.getPermiso(permiso);
        permisos = permiso.getPermPerm();
    }

    public boolean ponerPermisos(String valorMenu) {
        try {
            if (!permisos.isEmpty()) {
                if (permisos.indexOf(valorMenu) != -1) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
     */
}
