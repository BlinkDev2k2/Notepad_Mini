package Model;


public class Nodepad_Model {
    private String nameFile, content;

    public Nodepad_Model(){
        this.nameFile = "";
        this.content = "";
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getContent() {
        return content;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
