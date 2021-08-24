package com.example.sanskrit;
public class Word {
    private final String deftran;   //for storing the default translation that is english translation
    private final String santran;
    private final int audid;
    private final int iconid;
    private int id = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;  //Variable name is in All caps because its constant

    public String getDefaultTranslation() {
        return deftran;
    }

    public String getSanskritTranslation() {
        return santran;
    }

    /**
     * Here we will define special constructor for Phrases because it constains text,text and audio
     */
    public Word(String defaultTranslation, String sanskritTranslation,int audioResourceId,int idicon)
    {
        deftran=defaultTranslation;
        santran=sanskritTranslation;
        audid=audioResourceId;
        iconid=idicon;
    }
    /**
     * Create a new Word object.
     * Below constructor is for family, number and colors because they contain text,text,image and audio
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param sanskritTranslation is the word in the Miwok language
     * @param idnumber is the drawable resource ID for the image associated with the word
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    public Word(String defaultTranslation, String sanskritTranslation, int idnumber,
                int audioResourceId, int icid) {
        deftran= defaultTranslation;
        santran = sanskritTranslation;
        id = idnumber;
        audid = audioResourceId;
        iconid=icid;
    }
    /**
     *
     * @return returns the image resource id of the word
     */
    public int getImageResourceId() {
        return id;
    }
    /**
     *
     * @return whether there is image for the word or not
     */

    public boolean hasImage()
    {
    return (id != NO_IMAGE_PROVIDED);
    }

    /**
     *
     * @return returns the audio resource id of the word
     */
    public int getAudioResourceId() { return audid;}
    public int IconResourceId(){ return iconid;}

}
