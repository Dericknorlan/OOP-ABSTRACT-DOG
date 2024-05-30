public abstract class Dog {
    private String ukuran;
    private int jadwalMakan;
    private boolean isSudahMakan;
    private String nama;
    private String jenis;

    public Dog() {
    }

    public Dog(String nama, String ukuran, String jenis, boolean isSudahMakan) {
        int jadwalMakan;
        switch(ukuran){
            case "Small":
                jadwalMakan = 1;
                break;
            case "Medium":
                jadwalMakan = 2;
                break;
            case "Large":
                jadwalMakan = 3;
                break;
            default:
                jadwalMakan = 0;
        }
        this.ukuran = ukuran;
        this.jadwalMakan = jadwalMakan;
        this.isSudahMakan = isSudahMakan;
        this.nama = nama;
        this.jenis = jenis;
    }

    public void wesManganTah(){
        if(isSudahMakan){
            System.out.println(nama + " tidur dan masuk kandang");
        } else{
            System.out.println(nama + " menggonggong");
        }
    }

    public String getUkuran() {
        return this.ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getJadwalMakan() {
        return this.jadwalMakan;
    }

    public void setJadwalMakan(int jadwalMakan) {
        this.jadwalMakan = jadwalMakan;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getJenis() {
        return this.jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public boolean getIsSudahMakan() {
        return this.isSudahMakan;
    }

    public void setIsSudahMakan(boolean isSudahMakan) {
        this.isSudahMakan = isSudahMakan;
    }

}