package modelo;

public class Fecha{

    // ---------
    // Atributos
    // ---------
    private int dia;
    private int mes;
    private int anio;

    // -------
    // Métodos
    // -------

    // ------------------
    // Método Constructor
    // ------------------

    public Fecha(int pDia, int pMes, int pAnio){
        this.dia = pDia;
        this.mes = pMes;
        this.anio = pAnio;
    }

    public Fecha(){

    }

    public Fecha(String s)
    {
        //buscamos la primera ocurrencia de '/'
        int pos1 = s.indexOf('/');
        
        //buscamos la ultima ocurrencia de '/'
        int pos2 = s.lastIndexOf('/');
        
        //Procesamos el dia
        String sDia = s.substring(0,pos1);
        dia = Integer.parseInt(sDia);
        
        //Procesamos el mes
        String sMes = s.substring(pos1+1, pos2);
        mes = Integer.parseInt(sMes);
        
        //Procesamos el año
        String sAnio = s.substring(pos2+1);
        anio = Integer.parseInt(sAnio);
    }

    /// -----------------------------------
    /// Métodos de acceso (setter & getter)
    /// -----------------------------------

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /// --------------------------------------
    /// Método sobreescrito de la clase Object
    /// --------------------------------------
    public String toString(){
        return dia + "/" + mes + "/" + anio;
    }

    /// --------------------------------------
    /// Método sobreescrito de la clase Object
    /// --------------------------------------
    
    public boolean equals(Object o){
        Fecha otra = (Fecha)o;
        return (dia==otra.dia) && (mes==otra.mes) && (anio==otra.anio);
    }

    /// ----------------------
    /// Método para sumar días 
    /// ----------------------

    private int fechaToDias()
    {
        return anio * 360 + mes * 30 + dia;
    }

    //asigna la fecha expresada en dias a los atributos
    private void diasToFecha(int pD)
    {
        //Dividimos por 360 y obtenemos el año
        anio = (int)(pD/360);
        
        //Del residuo de la división anterior
        //obtenemos el mes y el dia
        int residuo = pD%360;
        
        mes = (int)(residuo/30);
        
        dia = residuo%30;
        
        //Ajuste por si el día quedó en cero
        if(dia==0)
        {
            dia = 30;
            mes--;
        }
        
        //Ajuste por si el mes quedó en cero
        if(mes == 0)
        {
            mes = 12;
            anio--;
        }
    }

    public void addDias(int d)
    {
        int sum = fechaToDias()+d;
        diasToFecha(sum);
    }

}
