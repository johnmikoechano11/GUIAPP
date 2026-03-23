package config;

public class imageSession {
    private String imagePath;
    private static imageSession instance; // Missing variable declaration

    // Constructor must be private to prevent creating new instances elsewhere
    private imageSession() { }

    public static imageSession getInstance() {
        if (instance == null) {
            instance = new imageSession();
        }
        return instance;
    }

    public String getImagePath() { 
        return imagePath; 
    }
    
    public void setImagePath(String path) { 
        this.imagePath = path; 
    }
}