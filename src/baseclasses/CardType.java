package baseclasses;

/**
 * Enumerated type containing all possible cards in the game.
 * 
 * This enum is primarily useful as a way to facilitate the creation of multiple 
 * card types without having redundant classes for every card type. All logic 
 * based on the type of <code>Card</code> is done client-side, so this enum 
 * is a much more efficient way to represent the different cards possible.
 * 
 * @author Jacky Tian
 */
public enum CardType {
    D25 ("25 Miles", "25.png"),
    D50 ("50 Miles", "50.png"),
    D75 ("75 Miles", "75.png"),
    D100 ("100 Miles", "100.png"),
    D200 ("200 Miles", "200.png"),
    STOP ("Stop", "stop.png"),
    EMPTY ("Out of Gas", "empty.png"),
    FLAT ("Flat Tire", "flat.png"),
    ACCIDENT ("Accident", "crash.png"),
    LIMIT ("Speed Limit", "limit.png"),
    ROLL ("Go", "roll.png"),
    GAS ("Gas Refill", "gas.png"),
    SPARE ("Spare Tire", "spare.png"),
    REPAIR ("Repair", "repair.png"),
    END_LIMIT ("End Limit", "unlimited.png"),
    EXTRA_TANK ("Extra Tank Safety", "tanker.png"),
    PUNCTURE_PROOF ("Puncture-Proof Safety", "sealant.png"),
    DRIVING_ACE ("Diving Ace Safety", "ace.png"),
    RIGHT_OF_WAY ("Right-of-Way Safety", "row.png");
    
    private final String name;
    private final String path;
    
    CardType(String name, String path) {
        this.name = name;
        this.path = path;
    }
    
    /**
     * Returns the path to the sprite of the card.
     * 
     * The path is only the filename and extension - the images are actually under 
     * \images\ under the home directory.
     * 
     * @return the filename and extension of the sprite.
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Returns the name of the card as a string.
     * 
     * @return the name of the card without preceeding or following whitespace.
     */
    @Override
    public String toString() {
        return name;
    }
}
