package src.count.data;

public enum Extension {
    DOC("doc"),
    DOCX("docx"),
    PDF("pdf");

    private final String type;

    Extension(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
