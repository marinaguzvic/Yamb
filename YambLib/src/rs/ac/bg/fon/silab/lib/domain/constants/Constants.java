/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.domain.constants;

/**
 *
 * @author MARINA
 */
public class Constants {

    public class Korisnik {

        public static final String CLASS_NAME = "korisnik";
        public static final String KORISNIK_ID = "korisnik_id";
        public static final String KORISNICKO_IME = "korisnicko_ime";
        public static final String SIFRA = "sifra";
    }

    public class Kolona {

        public static final String CLASS_NAME = "kolona";
        public static final String KOLONA_ID = "kolona_id";
        public static final String BROJ = "broj";
        public static final String NAZIV = "naziv";
    }

    public class Red {

        public static final String CLASS_NAME = "red";
        public static final String RED_ID = "red_id";
        public static final String BROJ = "broj";
        public static final String NAZIV = "naziv";
    }

    public class Igra {

        public static final String CLASS_NAME = "igra";
        public static final String IGRA_ID = "igra_id";
        public static final String AKTIVNA = "aktivna";
    }
    
    public class Matrica {

        public static final String CLASS_NAME = "matrica";
        public static final String IGRA_ID_FK = "igra_id_fk";
        public static final String MATRICA_ID = "matrica_id";
        public static final String KRAJNJI_REZULTAT = "krajnji_rezultat";
        public static final String POBEDA = "pobeda";
        public static final String KORISNIK_ID_FK = "korisnik_id_fk";
    }
    
    public class Polje {

        public static final String CLASS_NAME = "polje";
        public static final String IGRA_ID_FK = "igra_id_fk";
        public static final String MATRICA_ID_FK = "matrica_id_fk";
        public static final String POLJE_ID = "polje_id";
        public static final String VREDNOST = "vrednost";
        public static final String KOLONA_ID_FK = "kolona_id_fk";
        public static final String RED_ID_FK = "red_id_fk";
    }
    

}
