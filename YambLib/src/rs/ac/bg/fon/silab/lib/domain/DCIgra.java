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
public class DCIgra implements GeneralDObject, CompundDObject, Serializable {

    private static List<DCIgra> igre = new ArrayList<>();

    private Long igraId;
    private EnumAktivna aktivna;
    private List<DCMatrica> matrice = new ArrayList<>();

    private String customWhereCondition;

    @Override
    public String getCustomWhereCondition() {
        return customWhereCondition;
    }

    public void setCustomWhereCondition(String customWhereCondition) {
        this.customWhereCondition = customWhereCondition;
    }

    public static DCIgra getInstance() {
        DCIgra newIgra = new DCIgra(0L);
        if (igre.contains(newIgra)) {
            return igre.get(igre.indexOf(newIgra));
        } else {
            igre.add(newIgra);
            return newIgra;
        }

    }

    public static DCIgra getInstance(Long igraId) {
        DCIgra newIgra = new DCIgra(igraId);
        if (igre.contains(newIgra)) {
            return igre.get(igre.indexOf(newIgra));
        } else {
            igre.add(newIgra);
            return newIgra;
        }
    }

    public static DCIgra getInstance(Long igraId, String aktivna) {
        DCIgra newIgra = new DCIgra(igraId, EnumAktivna.valueOf(aktivna));
        if (igre.contains(newIgra)) {
            DCIgra existingIgra = igre.get(igre.indexOf(newIgra));
            existingIgra.update(newIgra);
            return existingIgra;
        } else {
            igre.add(newIgra);
            return newIgra;
        }
    }

    private DCIgra(Long igraId) {
        this.igraId = igraId;
    }

    private DCIgra(Long igraId, EnumAktivna aktivna) {
        this.igraId = igraId;
        this.aktivna = aktivna;
    }

    private DCIgra() {
    }

    @Override
    public String getAtrValue() {
        return "'" + aktivna.toString() + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.Igra.AKTIVNA + "='" + aktivna.toString() + "'";
    }

    @Override
    public String getClassName() {
        return Constants.Igra.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.Igra.AKTIVNA;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Igra.IGRA_ID + "=" + igraId;
    }

    @Override
    public String getNameByColumn(int column) {
        return new String[]{Constants.Igra.IGRA_ID, Constants.Igra.AKTIVNA}[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        System.out.println("Checking constraints for Igra");
    }

    @Override
    public void setKey(ResultSet rs) throws Exception {
        try {
            if (rs.next()) {
                igraId = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("The key was not returned");
        }
    }

    @Override
    public String[] getColumns() {
        return new String[]{Constants.Igra.IGRA_ID, Constants.Igra.AKTIVNA};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Igra.IGRA_ID:
                return igraId;
            case Constants.Igra.AKTIVNA:
                return aktivna;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Igra.IGRA_ID};
    }

    @Override
    public List<String> classNames() {
        List<String> classNames = new ArrayList<>();
        classNames.add(Constants.Matrica.CLASS_NAME);
        return classNames;
    }

    @Override
    public List<GeneralDObject> getItemsFor(String className) {
        switch (className) {
            case Constants.Matrica.CLASS_NAME:
                return new ArrayList<>(matrice);
            default:
                return null;
        }
    }

    @Override
    public GeneralDObject createChild(String className) {
        switch (className) {
            case Constants.Matrica.CLASS_NAME:
                return DCMatrica.getInstance(this);
            default:
                return null;

        }
    }

    @Override
    public String getWhere(String className) {
        switch (className) {
            case Constants.Matrica.CLASS_NAME:
                return Constants.Matrica.IGRA_ID_FK + "=" + igraId;
            default:
                return null;

        }
    }

    public Long getIgraId() {
        return igraId;
    }

    public void setIgraId(Long igraId) {
        this.igraId = igraId;
    }

    public String getAktivna() {
        return aktivna.toString();
    }

    public void setAktivna(String aktivna) {
        this.aktivna = EnumAktivna.valueOf(aktivna);
    }

    public List<DCMatrica> getMatrice() {
        return matrice;
    }

    public void setMatrice(List<DCMatrica> matrice) {
        this.matrice = matrice;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.igraId);
        hash = 79 * hash + Objects.hashCode(this.matrice);
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
        final DCIgra other = (DCIgra) obj;
        if (!Objects.equals(this.igraId, other.igraId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DCIgra{" + "igraId=" + igraId + ", aktivna=" + aktivna + ", matrice=" + matrice + '}';
    }

    @Override
    public void setValue(String column, ResultSet rs, GeneralDObject gdo) {
        try {
            switch (column) {
                case Constants.Igra.IGRA_ID:
                    igraId = rs.getLong(column);
                    break;
                case Constants.Igra.AKTIVNA:
                    setAktivna(rs.getString(column));
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(GeneralDObject gdo) {
        this.setAktivna(((DCIgra) gdo).getAktivna());
    }

    @Override
    public void addChild(GeneralDObject gdo) {
        switch (gdo.getClassName()) {
            case Constants.Matrica.CLASS_NAME:
                if (!matrice.contains(gdo)) {
                    matrice.add((DCMatrica) gdo);
                }
                break;
        }
    }

    @Override
    public GeneralDObject getInstance(ResultSet rs) {
        try {
            return getInstance(rs.getLong(Constants.Igra.IGRA_ID));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
