package personnages;

public class Druide {
    private String nom;
    private int effetPotionMin;
    private int effetPotionMax;
    private int forcePotion;

    public Druide(String nom, int effetPotionMin, int effetPotionMax) {
        this.nom = nom;
        this.effetPotionMin = effetPotionMin;
        this.effetPotionMax = effetPotionMax;
        parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
                + effetPotionMax + ".");
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + "»");
    }

    private String prendreParole() {
        return "Le druide " + nom + " : ";
    }

    public void preparerPotion() {
        // Implementation of preparerPotion method as before
    }

    public void booster(Gaulois gaulois) {
        if (gaulois.getNom().equals("Obélix")) {
            parler("Non, Obélix !... Tu n’auras pas de potion magique !");
        } else {
            gaulois.boirePotion(forcePotion);
        }
    }

    public static void main(String[] args) {
        // Test booster method
        Druide panoramix = new Druide("Panoramix", 5, 10);
        Gaulois asterix = new Gaulois("Asterix", 8);
        Gaulois obelix = new Gaulois("Obélix", 10);

        panoramix.booster(asterix); // Asterix receives potion
        panoramix.booster(obelix); // Obelix is denied potion
    }
}
