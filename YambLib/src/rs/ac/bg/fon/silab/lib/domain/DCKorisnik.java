/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.lib.domain.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCKorisnik implements GeneralDObject, Serializable {

        static List<DCKorisnik> korisnici = new ArrayList<>();
        
    private Long korisnikId;
    private String korisnickoIme;
    private String sifra;
    
        private String customWhereCondition;



        @Override
    public String getCustomWhereCondition() {
        return customWhereCondition;
    }

    public void setCustomWhereCondition(String customWhereCondition) {
        this.customWhereCondition = customWhereCondition;
    }

    public static DCKorisnik getInstance() {
        DCKorisnik newKorisnik = new DCKorisnik(0L);
        if (korisnici.contains(newKorisnik)) {
            return korisnici.get(korisnici.indexOf(newKorisnik));
        } else {
            korisnici.add(newKorisnik);
            return newKorisnik;
        }

    }

    public static DCKorisnik getInstance(Long kolonaId) {
        DCKorisnik newKorisnik = new DCKorisnik(kolonaId);
        if (korisnici.contains(newKorisnik)) {
            return korisnici.get(korisnici.indexOf(newKorisnik));
        } else {
            korisnici.add(newKorisnik);
            return newKorisnik;
        }
    }

    public static DCKorisnik getInstance(Long korisnikId, String korisnickoIme, String sifra) {
        DCKorisnik newKorisnik = new DCKorisnik(korisnikId, korisnickoIme, sifra);
        if (korisnici.contains(newKorisnik)) {
            DCKorisnik existingKorisnik = korisnici.get(korisnici.indexOf(newKorisnik));
            existingKorisnik.update(newKorisnik);
            return existingKorisnik;
        } else {
            korisnici.add(newKorisnik);
            return newKorisnik;
        }
    }
    
    private DCKorisnik(Long korisnikId) {
        this.korisnikId = korisnikId;
    }


    private DCKorisnik(Long korisnikId, String korisnickoIme, String sifra) {
        this.korisnikId = korisnikId;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    @Override
    public String getAtrValue() {
        return "'" + korisnickoIme + "', '" + sifra + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.Korisnik.KORISNICKO_IME + "='" + korisnickoIme + "', "
                + Constants.Korisnik.SIFRA + "='" + sifra + "'";
    }

    @Override
    public String getClassName() {
        return Constants.Korisnik.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.Korisnik.KORISNICKO_IME + ", " + Constants.Korisnik.SIFRA;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Korisnik.KORISNIK_ID + "=" + korisnikId;
    }

    @Override
    public String getNameByColumn(int column) {
        return new String[]{Constants.Korisnik.KORISNIK_ID, Constants.Korisnik.KORISNICKO_IME, Constants.Korisnik.SIFRA}[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        System.out.println("Checking constratints for Korisnik");
    }

    @Override
    public void setKey(ResultSet rs) throws Exception {
        try {
            if (rs.next()) {
                korisnikId = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("The key was not returned");
        }
    }

    @Override
    public String[] getColumns() {
        return new String[]{Constants.Korisnik.KORISNIK_ID, Constants.Korisnik.KORISNICKO_IME, Constants.Korisnik.SIFRA};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Korisnik.KORISNIK_ID:
                return korisnikId;
            case Constants.Korisnik.KORISNICKO_IME:
                return korisnickoIme;
            case Constants.Korisnik.SIFRA:
                return sifra;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Korisnik.KORISNIK_ID};
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.korisnikId);
        hash = 59 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 59 * hash + Objects.hashCode(this.sifra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DCKorisnik other = (DCKorisnik) obj;
        if (!(Objects.equals(this.korisnikId, other.korisnikId) || Objects.equals(this.korisnickoIme, other.korisnickoIme))) {
            return false;
        }
        return true;
    }

    @Override
    public void setValue(String column, ResultSet rs, GeneralDObject gdo) {
        try {
            switch (column) {
                case Constants.Korisnik.KORISNIK_ID:
                    korisnikId = rs.getLong(column);
                    break;
                case Constants.Korisnik.KORISNICKO_IME:
                    korisnickoIme = rs.getString(column);
                    break;
                case Constants.Korisnik.SIFRA:
                    sifra = rs.getString(column);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(GeneralDObject gdo) {
        korisnickoIme = ((DCKorisnik)gdo).getKorisnickoIme();
        sifra = ((DCKorisnik)gdo).getSifra();
    }

    @Override
    public GeneralDObject getInstance(ResultSet rs) {
            try {
                return getInstance(rs.getLong(Constants.Korisnik.KORISNIK_ID));
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
        
    }

}
