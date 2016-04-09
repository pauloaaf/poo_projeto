package projeto_poo;

public class Terreno extends Imovel{
	
    private double areaConstrucao;
    private boolean tipoConstrucao; // True para habita�ao e armazem, False apenas para armazem 
    private double diametro; // milimetros
    private double kwh; // kilowats da rede eletrica
    private boolean redeEletrica, redeEsgotos;
	
    //get e set terreno

	public double getAreaConstrucao() {
		return areaConstrucao;
	}

	public void setAreaConstrucao(double areaConstrucao) {
		this.areaConstrucao = areaConstrucao;
	}

	public boolean getTipoConstrucao() {
		return tipoConstrucao;
	}

	public void setTipoConstrucao(boolean tipoConstrucao) {
		this.tipoConstrucao = tipoConstrucao;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public double getKwh() {
		return kwh;
	}

	public void setKwh(double kwh) {
		this.kwh = kwh;
	}

	public boolean getRedeEletrica() {
		return redeEletrica;
	}

	public void setRedeEletrica(boolean redeEletrica) {
		this.redeEletrica = redeEletrica;
	}

	public boolean getRedeEsgotos() {
		return redeEsgotos;
	}

	public void setRedeEsgotos(boolean redeEsgotos) {
		this.redeEsgotos = redeEsgotos;
	}

    //construtor terreno
    public Terreno(String rua, double precoPedido, double precoMinimo,String tipoImovel, double areaConstrucao
    		, boolean tipoConstrucao, double diametro, double kwh, boolean redeEletrica, boolean redeEsgotos) {
    	super(rua,precoPedido,precoMinimo,tipoImovel);
    	this.areaConstrucao = areaConstrucao;
    	this.tipoConstrucao = tipoConstrucao;
    	this.diametro = diametro;
    	this.kwh = kwh;
    	this.redeEletrica = redeEletrica;
    	this.redeEsgotos = redeEsgotos;
    }
    
    public Terreno(Terreno t) {
    	this(t.getRua(),t.getPrecoPedido(),t.getPrecoMinimo(),t.getTipoImovel(),t.getAreaConstrucao(),t.getTipoConstrucao()
    			,t.getDiametro(),t.getKwh(),t.getRedeEletrica(),t.getRedeEsgotos());
    }    
    
    public Terreno clone(){
    	return new Terreno(this);
    }
    
    public boolean equals(Object o){
    	if(o == this) return true;
		if(o == null || o.getClass()!= this.getClass()) return false;
		Terreno t = (Terreno) o;
		
		return areaConstrucao == t.getAreaConstrucao() && tipoConstrucao == t.getTipoConstrucao() && diametro == t.getDiametro() 
				&& kwh == t.getKwh() && redeEletrica == t.getRedeEletrica() && redeEsgotos == t.getRedeEsgotos();
    }
    
    public String toString(){
    	StringBuilder str = new StringBuilder();
    	
    	str.append(Double.toString(areaConstrucao));
    	str.append(String.valueOf(tipoConstrucao));
    	str.append(Double.toString(diametro));
    	str.append(Double.toString(kwh));
    	str.append(String.valueOf(redeEletrica));
    	str.append(String.valueOf(redeEsgotos));
    	
    	return str.toString();
    	}
    
    
}

