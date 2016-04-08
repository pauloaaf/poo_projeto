package projeto_poo;

import java.util.List;  
import java.util.ArrayList;


public class Vendedor extends Utilizador {

	private List<Imovel> vender; 
	private List<Imovel> vendidos; 
	
	public Vendedor(){
		super();
		vender=new ArrayList<Imovel>(); 
		vendidos= new ArrayList<Imovel>(); 
	}
	
	public Vendedor(Vendedor a){
		super(a.getEmail(),a.getNome(),a.getPassword(),a.getData(),a.getMorada(),a.getTipo());
		this.vender = a.getVender(); 
		this.vendidos = a.getVendidos();
	}

	public Vendedor(List<Imovel>vender , List<Imovel> vendidos){
		this();
		setVender(vender);
		setVendidos(vendidos);
	}
	
	public List<Imovel> getVender(){ 
		List<Imovel> res = new ArrayList<Imovel>(); 
		for(Imovel a: vender){
			res.add(a.clone());
		} 
			
		return res;
	}
	
	public List<Imovel> getVendidos(){ 
		List<Imovel> res = new ArrayList<Imovel>(); 
		for(Imovel a: vendidos){
			res.add(a.clone());
		} 
			
		return res;
	}
	
	public void setVender(List<Imovel> vender){
		this.vender.clear(); 
		for(Imovel a: vender) 
			this.vender.add(a.clone());
		}
	
	public void setVendidos(List<Imovel> vendidos){
		this.vendidos.clear(); 
		for(Imovel a: vendidos) 
			this.vendidos.add(a.clone());
		}
	
	
	  public boolean equals(Object o){
		    if(o==this) return true; 
		    if(o==null || o.getClass()!= this.getClass()){
		    return false; 
		    }
		    
		    
		    Vendedor p = (Vendedor) o; 
		    
		    if(vender.size()!=p.getVender().size()){
		    return false;
		    } 
		    if(vendidos.size()!=p.getVendidos().size()){return false;}
		    for(int i=0;i<vender.size();i++){
		    if(!vender.get(i).equals(p.getVender().get(i))){ return false; }
		    if(!vendidos.get(i).equals(p.getVendidos().get(i))){ return false; }
		    } 
		    
		    
		    
		    return true;
		    }
		    
		    public String toString(){ 
		        StringBuilder sb= new StringBuilder();
		        for(Imovel a: vender){
		         sb.append(a.toString());
		        } 
		        for(Imovel c: vendidos){
			         sb.append(c.toString());
			        } 
		        return sb.toString();
		    }
		    
		    public Vendedor clone(){
		    return new Vendedor(vender,vendidos); 
		    }
	
	
	
	}
