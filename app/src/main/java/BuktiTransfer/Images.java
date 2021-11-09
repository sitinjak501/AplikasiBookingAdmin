package BuktiTransfer;


public class Images {
    public String imageName;
    public String imageURL;

    public Images() {

    }
    public Images(String imageName, String imageURL) {
        this.imageName = imageName;
        this.imageURL = imageURL;
    }

    public String getimageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName ="Nama Rekening : "+imageName;
    }

//    public String getimageURL() {
//        return imageURL;
//    }
//
//    public void setimageURL(String imageURL) {
//        this.imageURL = "test"+imageURL;
//    }
}
