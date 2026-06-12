package pt.uc00605.pratica2.enums;

public enum Status {
    
    ACTIVE("ativo"),
    INATIVO("inativo");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}