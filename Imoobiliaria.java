import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Imoobiliaria {
    
    private boolean sessaoIniciada = false;
    private Utilizador utilizadorIniciado = null;
    private Map<String,Utilizador> utilizadoresRegistados; // map com email como chave e utilizador como valor
    private Map<String,Imovel> imoveisRegistados; //map com idImovel como chave e imovel como valor
    
    public Imoobiliaria(){
        utilizadoresRegistados = new TreeMap<>();
        imoveisRegistados = new TreeMap<>();
    }
    
    /*gets e sets*/
    public Map<String,Utilizador> getUtilizadoresRegistados(){
        Map<String,Utilizador> res = new TreeMap<>();
        for(Map.Entry<String,Utilizador> u:utilizadoresRegistados.entrySet())
            res.put(u.getValue().getEmail(),u.getValue().clone());
        return res;
    }
    
    public void setUtilizadoresRegistados(Map<String,Utilizador> utilizadores){
        utilizadoresRegistados.clear();
        for(Map.Entry<String,Utilizador> u:utilizadores.entrySet())
            utilizadoresRegistados.put(u.getKey(),u.getValue().clone());
    }
    
    public Map<String,Imovel> getImoveisRegistados(){
        Map<String,Imovel> res = new TreeMap<>();
        for(Map.Entry<String,Imovel> im:imoveisRegistados.entrySet()){
            res.put(im.getKey(),im.getValue().clone());
        }
             
        return res;
    }
    
    public void setImoveisRegistados(Map<String,Imovel> imoveisRegistados){
        this.imoveisRegistados.clear();
        for(Map.Entry<String,Imovel> im:imoveisRegistados.entrySet())
            this.imoveisRegistados.put(im.getKey(),im.getValue().clone());
   }
   
    
    public boolean getSessaoInicia() {return sessaoIniciada;}

    public void setSessaoInicia(boolean sessaoIniciada) {this.sessaoIniciada = sessaoIniciada;}
    
    /*Funçoes pdf*/
    public void registaImovel(Imovel im)
        throws ImovelExisteException,
               SemAutorizacaoException{
                     
        if(utilizadorIniciado == null)
            throw new SemAutorizacaoException("Necessario iniciar sessao!");
        if(utilizadorIniciado.getClass().getSimpleName().equals("Comprador"))
            throw new SemAutorizacaoException("Sem direitos");  
        
        if(imoveisRegistados.containsKey(im.getIdentificador()))
            throw new ImovelExisteException("Imovel ja registado!");
        else
            imoveisRegistados.put(im.getIdentificador(),im.clone());
                   
    }

    public void registaUtilizador(Utilizador utilizador)
        throws UtilizadorExistenteException{
        /*RegistaUtilizador r = new RegistaUtilizador();
        r.registar(utilizador);//RegistaUtilizador.java*/
        
        //verificar se o utilizador ja existe
        if(utilizadoresRegistados.containsKey(utilizador.getEmail()))
            throw new UtilizadorExistenteException("Este utilizador ja existe!");
        else
            utilizadoresRegistados.put(utilizador.getEmail(),utilizador.clone()); //VER ESTE PROBLEMA-->FAVORITOS-->CLONE
    }
    
    public void iniciaSessao(String email, String password)
        throws SemAutorizacaoException{//Exceptions.java
        //Ficheiro f = new Ficheiro();
        
        if(!utilizadoresRegistados.containsKey(email))
            throw new SemAutorizacaoException("Utilizador nao existe!");
        
        if(utilizadoresRegistados.containsKey(email) && !utilizadoresRegistados.get(email).getPassword().equals(password))
                throw new SemAutorizacaoException("Password errada!");
        
        sessaoIniciada = true;
        utilizadorIniciado = utilizadoresRegistados.get(email);
    }
    
    public void fechaSessao(){
        sessaoIniciada = false;
        utilizadorIniciado = null;
    }
    
    /*public List<Consulta > getConsultas ()
        throws SemAutorizacaoException{}*/
        
    public void setEstado (String idImovel, String estado)
        throws ImovelInexistenteException,
               SemAutorizacaoException,
               EstadoInvalidoException{
        
        if(utilizadorIniciado == null)
            throw new SemAutorizacaoException("Necessario iniciar sessao!");
        if(utilizadorIniciado.getClass().getSimpleName().equals("Comprador"))
            throw new SemAutorizacaoException("Sem direitos"); 
        
        if(!estado.equals("Venda") || !estado.equals("Reversado") || !estado.equals("Vendido"))
            throw new EstadoInvalidoException("Estado invalido!");
        
        if(!imoveisRegistados.containsKey(idImovel))
            throw new ImovelInexistenteException("Imovel inexistente!");
                
        imoveisRegistados.get(idImovel).setEstado(EstadoImovel.valueOf(estado));
    }
    
    
    
    public List<Imovel> getImovel(String classe, int preco){
        List<Imovel> res = new ArrayList<>();
        for(Imovel im:imoveisRegistados.values()){
            if(im.getClass().getSimpleName().equals(classe) && im.getPrecoPedido()<=preco)
                res.add(im.clone());
        }
        return res;
    }
    
    /*Lista de todos os imoveis habitaveis, ate um certo preço*/
    public List<Habitavel> getHabitaveis(int preco){
        List<Habitavel> res = new ArrayList<>();
        
        for(Imovel im:imoveisRegistados.values()){
            if(im instanceof Habitavel && im.getPrecoPedido() <= preco){
                res.add((Habitavel) im.clone());
            }
        }
        return res;
    }
    
    /**
     * Compradores registados
     */
    
    public void setFavorito(String idImovel)
        throws ImovelInexistenteException,
               SemAutorizacaoException{
                
        if(!sessaoIniciada)
            throw new SemAutorizacaoException("E necessario iniciar sessao!");
        if(utilizadorIniciado instanceof Vendedor)
            throw new SemAutorizacaoException("Precisa de ser um comprador para realizar esta acao!");
        if(!imoveisRegistados.containsKey(idImovel))
            throw new ImovelInexistenteException("Imovel inexistente!");
        
        Comprador c = (Comprador) utilizadorIniciado;
        try{
            c.favorito(imoveisRegistados.get(idImovel));
        }catch(ImovelFavoritoException exc){
            throw new SemAutorizacaoException(exc.toString());
        }
        
    }
    
    public TreeSet < Imovel > getFavoritos ()
            throws SemAutorizacaoException {
        TreeSet fav = new TreeSet<>();
        if(!sessaoIniciada) {
            throw new SemAutorizacaoException("E necessario iniciar sessao!");
        }
        
        if(utilizadorIniciado instanceof Vendedor) {
            throw new SemAutorizacaoException("Precisa de ser um comprador para realizar esta acao!");
        }
        Comprador c = (Comprador) utilizadorIniciado;
        for(Imovel im : c.getFavoritos().values()) {
            fav.add(im.clone());
        }
        return fav;
    }
        
        
        
            
           
        
       
    
    
    public void initApp(){
        //RegistaUtilizador r = new RegistaUtilizador();//RegistaUtilizador.java
        //Utilizador utilizador = r.recolheDados();
        
    }
}
