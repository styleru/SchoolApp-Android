package style.ru.schoolapp.Model.Entity;

public class Notification {

    private String Title;
    private String Date;
    private String Content;

    public Notification(String title, String date, String content) {
        Title = title;
        Date = date;
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
