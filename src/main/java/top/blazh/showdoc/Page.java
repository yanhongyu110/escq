package top.blazh.showdoc;


public class Page {

    private String title;

    private  String content;

    private Integer number;

    private Page(){}

    private Page(String title,Integer number,String content){
        this.title=title;
        this.content=content;
        this.number=number;
    }

    public static Page build(String title,Integer number,String content){
        return new Page(title,number,content);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
