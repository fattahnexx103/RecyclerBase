package restappss.neehad.recyclerbase.entities;



public class ObjectClass {

    private String Title;
    private String desc;
    private String imagePic;

    public ObjectClass(String Title, String desc, String imagePic) {
        this.Title = Title;
        this.desc = desc;
        this.imagePic = imagePic;

    }

    public String getTitle() {
        return Title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPic() {
        return imagePic;
    }
}
