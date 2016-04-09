package projeto_poo;

class Moradia extends Imovel{
	
    private String tipo;
    private double areaImplantacao;
    private double areaCoberta;
    private double areaEnvolvente;
    private int quartos;
    private int wc;
    private int porta;
    private int identificador;
    
    //get e sets de moradia 
    
    public int getIdentificador(){
    	return identificador;
    }
    
    public void setIdentificador(int identificador){
    	this.identificador = identificador;
    }
    
    public String getTipo(){
    	return tipo;
    }
    
    public void setTipo(String tipo){
    	this.tipo = tipo;
    }

	public double getAreaImp() {
		return areaImplantacao;
	}

	public void setAreaImp(double areaImplantacao) {
		this.areaImplantacao = areaImplantacao;
	}

	public double getAreaCob() {
		return areaCoberta;
	}

	public void setAreaCob(double areaCoberta) {
		this.areaCoberta = areaCoberta;
	}

	public double getAreaEnv() {
		return areaEnvolvente;
	}

	public void setAreaEnv(double areaEnvolvente) {
		this.areaEnvolvente = areaEnvolvente;
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

	
    //construtor moradia
    public Moradia(int identificador,String rua, double precoPedido, double precoMinimo, String tipoImovel,String tipo, double areaImplantacao, double areaCoberta, double areaEnvolvente
    , int quartos, int wc, int porta) {
        super(rua,precoPedido,precoMinimo,tipoImovel);
        this.tipo = tipo;
        this.areaImplantacao = areaImplantacao;
        this.areaCoberta = areaCoberta;
        this.areaEnvolvente = areaEnvolvente;
        this.quartos = quartos;
        this.wc = wc;
        this.porta = porta;
        this.identificador = identificador;
    }
    
    public Moradia (Moradia m) {
        this(m.getIdentificador(),m.getRua(),m.getPrecoPedido(),m.getPrecoMinimo(),m.getTipoImovel(),m.getTipo(),m.getAreaImp(),
        		m.getAreaCob(),m.getAreaEnv(),m.getQuartos(),m.getWc(),m.getPorta());
    }
    
    public Moradia clone(){
    	return new Moradia (this);
    }

    public boolean equals(Object o){
    	if(o == this) return true;
		if(o == null || o.getClass()!= this.getClass()) return false;
		Moradia m = (Moradia) o;
		
		return identificador == m.getIdentificador() && porta == m.getPorta() && wc == m.getWc() && quartos == m.getQuartos() && 
				areaEnvolvente == m.getAreaEnv() && areaCoberta == m.getAreaCob() && areaImplantacao == m.getAreaImp() && tipo.equals(m.getTipo());
    	
    }
    
    public String toString(){
    	StringBuilder str = new StringBuilder();
    	
    	str.append(tipo);
    	str.append(Double.toString(areaImplantacao));
    	str.append(Double.toString(areaCoberta));
    	str.append(Double.toString(areaEnvolvente));
    	str.append(Integer.toString(quartos));
    	str.append(Integer.toString(wc));
    	str.append(Integer.toString(porta));
    	str.append(Integer.toString(identificador));
    	
    	return str.toString();
    }
    
}