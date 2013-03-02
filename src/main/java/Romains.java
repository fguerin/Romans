import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

public class Romains {
    Map<String, Integer> romainsVersChiffresArabes = new HashMap<String, Integer>();
    Map<String, String> aPourUnité = new HashMap<String, String>();

    public Romains() {
        constructionDeLAssociationChiffreRomainValeur();
        constructionDesUnités();
    }

    public int enNombreArabe(String nombreRomain) {
        int nombreArabe = 0;
        for (int index = 0; index < nombreRomain.length(); ) {
            if (leChiffreCourantEstPlusPetitQueLeSuivant(nombreRomain, index)) {
                verifieQueLeChiffreCourantEstUneUnitéDuSuivant(nombreRomain, index);
                nombreArabe += chiffreArabeSuivant(nombreRomain, index) - chiffreArabeCourant(nombreRomain, index);
                index += 2;
            } else {
                nombreArabe += chiffreArabeCourant(nombreRomain, index);
                index += 1;
            }
        }
        return nombreArabe;
    }

    private void verifieQueLeChiffreCourantEstUneUnitéDuSuivant(String nombreRomain, int index) {
        Preconditions.checkArgument(vérifieUnitéDe(chiffreRomainCourant(nombreRomain, index), chiffreRomainSuivant(nombreRomain, index)));
    }

    private void constructionDeLAssociationChiffreRomainValeur() {
        romainsVersChiffresArabes.put("I", 1);
        romainsVersChiffresArabes.put("V", 5);
        romainsVersChiffresArabes.put("X", 10);
        romainsVersChiffresArabes.put("L", 50);
        romainsVersChiffresArabes.put("C", 100);
        romainsVersChiffresArabes.put("D", 500);
        romainsVersChiffresArabes.put("M", 1000);
    }

    private void constructionDesUnités() {
        aPourUnité.put("V", "I");
        aPourUnité.put("X", "I");
        aPourUnité.put("L", "X");
        aPourUnité.put("C", "X");
        aPourUnité.put("D", "C");
        aPourUnité.put("M", "C");
    }

    private String chiffreRomainSuivant(String roman, int index) {
        return roman.substring(index + 1, index + 2);
    }

    private String chiffreRomainCourant(String roman, int index) {
        return roman.substring(index, index + 1);
    }

    private boolean leChiffreCourantEstPlusPetitQueLeSuivant(String roman, int index) {
        return leNombreRomainsAChiffreSuivant(roman, index) && chiffreArabeCourant(roman, index) < chiffreArabeSuivant(roman, index);
    }

    private Integer chiffreArabeSuivant(String roman, int index) {
        return romainsVersChiffresArabes.get(chiffreRomainSuivant(roman, index));
    }

    private Integer chiffreArabeCourant(String roman, int index) {
        return romainsVersChiffresArabes.get(chiffreRomainCourant(roman, index));
    }

    private boolean leNombreRomainsAChiffreSuivant(String roman, int index) {
        return index + 1 < roman.length();
    }

    private boolean vérifieUnitéDe(String unité, String chiffre) {
        return unité.equals(aPourUnité.get(chiffre));
    }
}
