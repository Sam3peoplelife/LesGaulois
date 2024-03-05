package villagegaulois;

import personnages.*;


public class Musee {
    private Trophee[] trophees = new Trophee[200];
    private int nbTrophees = 0;

    public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
        trophees[nbTrophees] = new Trophee(gaulois, equipement);
        nbTrophees++;
    }

    public String extraireInstructionsOCaml() {
        StringBuilder instructionsOCaml = new StringBuilder();
        instructionsOCaml.append("let musee = [\n");
        for (int i = 0; i < nbTrophees; i++) {
            Trophee trophee = trophees[i];
            instructionsOCaml.append("\"").append(trophee.getGaulois().getNom()).append("\", \"").append(trophee.getEquipement().toString()).append("\";\n");
        }
        instructionsOCaml.append("]");
        return instructionsOCaml.toString();
    }

    public static void main(String[] args) {
        Musee musee = new Musee();
        Gaulois asterix = new Gaulois("Asterix", 10);
        Equipement bouclier = Equipement.BOUCLIER;
        Equipement casque1 = Equipement.CASQUE;
        Equipement casque2 = Equipement.CASQUE;
        musee.donnerTrophee(asterix, bouclier);
        musee.donnerTrophee(asterix, casque1);
        musee.donnerTrophee(asterix, casque2);
        System.out.println(musee.extraireInstructionsOCaml());
    }
}

