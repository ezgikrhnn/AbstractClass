public class abstractClass {
    public static void main(String[] args) {

        GeometrikSekil k1 = new Kare(5);  //bu sekilde alt sınıf nesnesini üst sınıf nesnesine bağlamış oldum
        k1.cevreHesapla();
        k1.alanHesapla();// gibi bir ust sınıfa ait olan tum metotları cagırabilirim
        //k1.adiniSoyle() diyerek metodu cagıramam hata verir downcasting yapacagım:
        ((Kare)k1).adiniSoyle();


        Dikdortgen d1 = new Dikdortgen(10,20);
        d1.alanHesapla();
        d1.cevreHesapla(); //bir ust sınıfa ait olan tüm metotları cagırabilirim
        d1.adiniSoyle();   //bu sefer goruldugu gibi sınıfa ozgu metodu cagırabiliyorum cunkü:
        //Değişkenin tipini GeometrikSekil değil Dikdortgen yaptım.

        GeometrikSekil daire1 = new Daire(5);
        daire1.alanHesapla();
        daire1.cevreHesapla();


    }
}

abstract class GeometrikSekil{
    private int birinciKenar;  //ikinci kenarı eklemiyorum cunku mesela dairede 2. kenar yoktur.
    //elimden geldğince soyut bir yapı yazmaya çalışıyorum.

    abstract public void cevreHesapla();

    abstract public void alanHesapla();

    public int getBirinciKenar() {
        return birinciKenar;
    }

    public void setBirinciKenar(int birinciKenar) {
        this.birinciKenar = birinciKenar;
    }
}

 class Kare extends GeometrikSekil{ //tamamdır kare somut sınıfımı GeometrikSekilden turettim.

     public Kare(int kenar) {
         this.setBirinciKenar(kenar);
     }

     @Override
    public void cevreHesapla(){
        System.out.println("karenin cevresi: " +getBirinciKenar()*4);
        ;

    }
     @Override
     public void alanHesapla(){
         System.out.println("karenin alani: " +getBirinciKenar()*getBirinciKenar());

     }


     public void adiniSoyle(){ //kareye ozgu bir metot yazalım:
         System.out.println("ben bir kare nesnesiyim");
     }
}

class Dikdortgen extends GeometrikSekil{  //somut sınıf

    private int ikinciKenar;


    public Dikdortgen(int birinciKenar, int ikinciKenar) {
        setBirinciKenar(birinciKenar);
        this.ikinciKenar = ikinciKenar;
    }



    public int getIkinciKenar() {
        return ikinciKenar;
    }

    public void setIkinciKenar(int ikinciKenar) {
        this.ikinciKenar = ikinciKenar;
    }

    @Override
    public void cevreHesapla() {
        System.out.println("dikdortgenin cevresi: "  +2*(getBirinciKenar() + ikinciKenar));

    }
    @Override
    public void alanHesapla() {
        System.out.println("dikdortgenin alani: " +getBirinciKenar()*ikinciKenar);

    }

    public void adiniSoyle(){ //dikdortgene özgü bir metot yazalım
        System.out.println("ben bir dikdortgen nesnesiyim.");
    }
}


class Daire extends GeometrikSekil{
    public Daire(int yaricap) {
        setBirinciKenar(yaricap);  //
    }

    @Override
    public void alanHesapla() {
        System.out.println("dairenin alani: " + 2* 3.14* getBirinciKenar()* getBirinciKenar());

    }

    @Override
    public void cevreHesapla() {
        System.out.println("dairenin cevresi: " +2*3.14*getBirinciKenar());

    }
}
