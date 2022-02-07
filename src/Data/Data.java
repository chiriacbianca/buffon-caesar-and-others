package Data;

public class Data {
    private int zi, luna, an;

    Data(int zi, int luna, int an)
    {
        this.an = an;
        this.luna = luna;
        this.zi = zi;
    }

    boolean bisect(int an)
    {
        if(an % 100 == 0 && an%400 != 0)
            return false;
        return an%4 == 0;
    }

    public void addDay()
    {
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(zi < days[luna])
            zi++;
        else {
            if (luna == 2 && bisect(an)) {
                zi++;
            }
            else {
                if (luna == 12) {
                    zi = 1;
                    luna = 1;
                    an++;
                }
                else {
                    zi=1;
                    luna++;
                }
            }

        }
    }
    public void substractDay()
    {
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (zi>1){
            zi--;
        }
        else{
            if (luna==3&&bisect(an)){
                zi=29;
                luna--;
            }
            else {
                if (luna==12) {
                    luna=1;
                    an--;
                    zi=31;
                }
                else{
                    zi=days[luna--];
                }
            }
        }
    }

    public static int compare(Data d1, Data d2)
    {
        if(d1.an < d2.an)
            return -1;
        if(d1.an > d2.an)
            return 1;
        if(d1.luna < d2.luna)
            return -1;
        if(d1.luna > d2.luna)
            return 1;

        return d1.zi < d2.zi ? -1 : (d1.zi > d2.zi ? 1 : 0);

    }

    //d1<d2 => nr pozitiv
    //d2<d1 => nr negativ
    public static int diffDays(Data d1, Data d2)
    {
        int diferentaDeZile=0;
        while (compare(d1,d2)!=0){
            if (compare(d1,d2)==1){
                d1.addDay();
            }
            else
                d2.addDay();;
            diferentaDeZile++;
        }
        return diferentaDeZile;
    }

    public void addMonth()
    {
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(zi < days[luna]&&luna!=12) {
            luna++;
        }
        else {
            if (luna==12) {
                luna=1;
                an++;
            }
            else
            {
                luna++;
                zi=days[luna];
            }
        }
    }

    //diferenta dintre date ca ani, luni, zile
    public static Data diff(Data d1, Data d2)
    {
        Data r = new Data(0,0,0);
        while(d1.an + 1 < d2.an) {
            d1.an++;
            r.an++;
        }
        while (d1.luna+1<d2.luna){
            d1.luna++;
            r.luna++;
        }
        while(d1.zi<d2.zi){
            d1.zi++;
            r.zi++;
        }
        return r;
    }

    //adaug n zile la data curenta
    //n poate fi si negativ
    public void addDays(int n){
        if (n>0){
            for (int i=0; i<n; i++)
                addDay();
        }
        else {
            for (int i=0;i<Math.abs(n);i++)
                substractDay();
        }

    }

    //1 - Luni, 2 - Marti, etc.
    public int dayOfWeek()
    {
        Data ref = new Data(1,1,1900);// Luni
        int x = diffDays(ref, this);
        return x % 7 + 1;
    }

    @Override
    public String toString() {
        return "Data.Data{" +
                "zi=" + zi +
                ", luna=" + luna +
                ", an=" + an +
                '}';
    }
}
