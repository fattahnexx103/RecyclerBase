package restappss.neehad.recyclerbase.entities;



public class ObjectClass {

    private String Title;
    private String desc;
    private String Pic;

    public ObjectClass(String Title, String desc) {
        this.Title = Title;
        this.desc = desc;

    }

    public String getTitle() {
        return Title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPic() {
        return Pic;
    }
}
