package projeto_poo;

public class Apartamento extends Imovel{
	
	private String tipo;
    private double areaTotal;
    private int quartos;
    private int wc;
    private int porta;
    private int andar;
    private boolean garagem;
    
    //get e set apartamento
    
    public String getTipo(){
    	return tipo;
    }
    
    public void setTipo(String tipo){
    	this.tipo = tipo;
    }
	public double getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(double areaTotal) {
		this.areaTotal = areaTotal;
	}

	public int getQuartos() {
		return quartos;
	}

	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	public int getWc() {
		return wc;
	}

	public void setWc(int wc) {
		this.wc = wc;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public boolean getGaragem() {
		return garagem;
	}

	public void setGaragem(boolean garagem) {
		this.garagem = garagem;
	}

	//construtor apartamento
    public Apartamento(String rua, double precoPedido, double precoMinimo, String tipoImovel,String tipo, double areaTotal, int quartos, int wc, int porta
    		, int andar, boolean garagem) {
    	super(rua,precoPedido,precoMinimo,tipoImovel);
    	this.tipo = tipo;
    	this.areaTotal = areaTotal;
    	this.quartos = quartos;
    	this.wc = wc;
    	this.porta = porta;
    	this.andar = andar;
    	this.garagem = garagem;
    }
    
    public Apartamento(Apartamento a) {
    	this(a.getRua(),a.getPrecoPedido(),a.getPrecoMinimo(),a.getTipoImovel(),a.getTipo(),a.getAreaTotal(),a.getQuartos(),a.getWc(),a.getPorta()
    			,a.getAndar(),a.getGaragem());
    }    
    
    public Apartamento clone (){
    	return new Apartamento(this);
    }
    
    public boolean equals(Object o){
    	if(o == this) return true;
		if(o == null || o.getClass()!= this.getClass()) return false;
		Apartamento ap = (Apartamento) o;
		
		return tipo.equals(ap.getTipo()) && areaTotal == ap.getAreaTotal() && quartos == ap.getQuartos()
				&& wc == ap.getWc() && porta == ap.getPorta() && andar == ap.getAndar() && garagem == ap.getGaragem();
		
    }
    public String toString(){
    	StringBuilder str = new StringBuilder();
    	
    	str.append(tipo);
    	str.append(Double.toString(areaTotal));
    	str.append(Integer.toString(quartos));
    	str.append(String.valueOf(wc));
    	str.append(Integer.toString(porta));
    	str.append(Integer.toString(andar));
    	str.append(String.valueOf(garagem));
    	
    	return str.toString();
    	
    	
    }
}
