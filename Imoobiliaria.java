import java.util.Set;
import java.util.TreeSet;

public class Imoobiliaria {
    
    private boolean sessaoIniciada = false;
    private Utilizador utilizadorIniciado = null;
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
    
    public void setImoveisRegistados(Set<Imovel> imoveisRegistados){
        this.imoveisRegistados.clear();
        for(Imovel im:imoveisRegistados)
            this.imoveisRegistados.add(im.clone());
    }
    
    public boolean getSessaoInicia() {return sessaoIniciada;}

    public void setSessaoInicia(boolean sessaoIniciada) {this.sessaoIniciada = sessaoIniciada;}
    
public void registaImovel(Imovel im)
        throws ImovelExisteException,
               SemAutorizacaoException{
                   if(utilizadorIniciado == null || utilizadorIniciado.getTipo() == 1) {
                       throw new SemAutorizacaoException("Sem direitos");
                       
                   }
                   
                   if(utilizadorIniciado.getTipo() == 0) {
                      for( Imovel i : imoveisRegistados) {
                        if(im.equals(i)) {
                           throw new ImovelExisteException("Imovel existente");
                       }
                   }
                    imoveisRegistados.add(im.clone());
      
                }  
                   
    }

    public void registaUtilizador(Utilizador utilizador)
        throws UtilizadorExistenteException{
        /*RegistaUtilizador r = new RegistaUtilizador();
        r.registar(utilizador);//RegistaUtilizador.java*/
        
        //verificar se o utilizador ja existe
        boolean existe = false;
        
        for(Utilizador user:utilizadoresRegistados)
            if(user.equals(utilizador))    
                existe = true;
        
        if(existe) throw new UtilizadorExistenteException("Este utilizador ja existe!");
        else utilizadoresRegistados.add(utilizador);
    }
    
    public void iniciaSessao(String email, String password)
        throws SemAutorizacaoException{//Exceptions.java
        //Ficheiro f = new Ficheiro();
        
        for(Utilizador utilizador:utilizadoresRegistados){
            if(utilizador.getEmail().equals(email) && !utilizador.getPassword().equals(password))
                throw new SemAutorizacaoException("Password errada!");
            if(utilizador.getEmail().equals(email) && utilizador.getPassword().equals(password)){
                sessaoIniciada = true;
                utilizadorIniciado = utilizador.clone();
                return;
            }
        }
        throw new SemAutorizacaoException("Utilizador nao existe!");
    }
    
    public List <Imovel> getImovel ( String classe , int preco ) {
    List<Imovel> lista = new ArrayList<>();
    if(imoveisRegistados.isEmpty()) return lista;
        for(Imovel i : imoveisRegistados) {
            if(classe.equals(i.getTipoImovel())){
                if(i.getPrecoPedido()<=preco) {
                    lista.add(i.clone());
                }
            }
        }
        return lista;
    }
    
    public void fechaSessao(){
        sessaoIniciada = false;
        utilizadorIniciado = null;
    }
    
    public void initApp(){
        //RegistaUtilizador r = new RegistaUtilizador();//RegistaUtilizador.java
        //Utilizador utilizador = r.recolheDados();
        Utilizador u = new Utilizador();
        try{
            registaUtilizador(u);
        }catch(UtilizadorExistenteException exc){
            System.out.println(exc.toString());
        }
    }

    public static void main(String[] args)
        throws UtilizadorExistenteException{
        //initApp();
        
    }
}
