package pt.uc00605.pratica2.enums;

public enum Category {
    
    FRONTEND("front-end"), 
    BACKEND("back-end");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.label;
    }

}