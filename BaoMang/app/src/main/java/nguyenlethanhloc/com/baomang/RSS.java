package nguyenlethanhloc.com.baomang;

/**
 * Created by thanhlong on 04/11/2017.
 */

public class RSS {
    String title, url;

    public RSS(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
