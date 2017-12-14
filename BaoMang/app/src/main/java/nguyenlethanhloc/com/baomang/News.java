package nguyenlethanhloc.com.baomang;


public class News {
    String title, link , urlImage;

    public News(String title, String link, String urlImage) {
        this.title = title;
        this.link = link;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
