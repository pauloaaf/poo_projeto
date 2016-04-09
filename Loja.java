package projeto_poo;

public class Loja extends Imovel{
	
    private double area;
    private boolean wc;
    private String tipoNegocio;
    private int porta;
    
    //get e set loja
    
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public boolean getWc() {
		return wc;
	}

	public void setWc(boolean wc) {
		this.wc = wc;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}


    // Para parte habitacional - informa��o guardada para os apartamentos
	// construtor loja
    public Loja(String rua, double precoPedido, double precoMinimo,String tipoImovel, double area, boolean wc, String tipoNegocio, int porta) {
    	super(rua,precoPedido,precoMinimo,tipoImovel);
    	this.area = area;
    	this.wc = wc;
    	this.tipoNegocio = tipoNegocio;
    	this.porta = porta;
    }
    
    public Loja(Loja l) {
    	this(l.getRua(),l.getPrecoPedido(),l.getPrecoMinimo(),l.getTipoImovel(),l.getArea(),l.getWc(),l.getTipoNegocio(),l.getPorta());
    }
    
    public Loja clone(){
    	return new Loja(this);
    }
    
    public boolean equals(Object o){
    	if(o == this) return true;
		if(o == null || o.getClass()!= this.getClass()) return false;
		Loja loja = (Loja) o;
		
		return area == loja.getArea() && wc == loja.getWc() && tipoNegocio.equals(loja.getTipoNegocio()) && porta == loja.getPorta();
    }
    
    public String toString(){
    	StringBuilder str = new StringBuilder();
    	
    	str.append(Double.toString(area));
    	str.append(String.valueOf(wc));
    	str.append(tipoNegocio);
    	str.append(Integer.toString(porta));
    	
    	return str.toString();
    	
    }
   
}




