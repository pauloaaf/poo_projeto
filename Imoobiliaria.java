import java.util.Set;
import java.util.TreeSet;

public class Imoobiliaria {
    
    private boolean sessaoIniciada = false;
    private Utilizador utilizadorIniciado;
    private Set<Utilizador> utilizadoresRegistados;
    private Set<Imovel> imoveisRegistados;
    
    public Imoobiliaria(){
        utilizadoresRegistados = new TreeSet<>();
        imoveisRegistados = new TreeSet<>();
    }
    
    public Set<Utilizador> getUtilizadoresRegistados(){
        Set<Utilizador> res = new TreeSet<>();
        for(Utilizador u:utilizadoresRegistados)
            res.add(u.clone());
        return res;
    }
    
    public void setUtilizadoresRegistados(Set<Utilizador> u){
        utilizadoresRegistados.clear();
        for(Utilizador ut:u)
            utilizadoresRegistados.add(ut.clone());
    }
    
    public Set<Imovel> getImoveisRegistados(){
        Set<Imovel> res = new TreeSet<>();
        for(Imovel im:imoveisRegistados)
            res.add(im.clone());
        return res;
    }
    
    public void setImoveisRegistados(Set<Imovel> iRegistados){
        imoveisRegistados.clear();
        for(Imovel im:iRegistados)
            imoveisRegistados.add(im.clone());
    }
    
    public boolean getSessaoInicia() {return sessaoIniciada;}

    public void setSessaoInicia(boolean sessaoIniciada) {this.sessaoIniciada = sessaoIniciada;}
    
    public void registaImovel(Imovel im)
        throws ImovelExisteException,
               SemAutorizacaoException{
        
                   
    }

    public void registaUtilizador(Utilizador utilizador)
        throws UtilizadorExistenteException{
        /*RegistaUtilizador r = new RegistaUtilizador();
        r.registar(utilizador);//RegistaUtilizador.java*/
        
        //verificar se o utilizador ja existe
        if(utilizadoresRegistados.contains(utilizador))
            throw new UtilizadorExistenteException("Este utilizador ja existe!");
        
        utilizadoresRegistados.add(utilizador);
        
    }
    
    public void iniciaSessao(String email, String password)
        throws SemAutorizacaoException{//Exceptions.java
        //Ficheiro f = new Ficheiro();
        
        for(Utilizador utilizador:utilizadoresRegistados){
            if(utilizador.getEmail().equals(email) && !utilizador.getPassword().equals(password))
                throw new SemAutorizacaoException("Password errada!");
            if(utilizador.getEmail().equals(email) && utilizador.getPassword().equals(password)){
                sessaoIniciada = true;
                utilizadorIniciado = utilizador;
                return;
            }
        }
    }
    
    public void fechaSessao(){
        sessaoIniciada = false;
        utilizadorIniciado = null;
    }
    
    public static void initApp(){
        //RegistaUtilizador r = new RegistaUtilizador();//RegistaUtilizador.java
        //Utilizador utilizador = r.recolheDados();
        
        
    }

    public static void main(String[] args)
        throws UtilizadorExistenteException{
        //initApp();
        Ficheiro f = new Ficheiro();
    }
}
