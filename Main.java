import Main.MainMenu;
import Sub.Loading;

public class Main {
    public static void main(String[] args) {
        Loading loading = new Loading();
        MainMenu firstPage = new MainMenu();
        loading.setVisible(true);
        loading.setResizable(false);
        loading.iterate();
        loading.dispose();
        firstPage.setVisible(true);
        firstPage.setResizable(false);
    }
}
