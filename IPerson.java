
public interface IPerson {
    String getDescription();

    int getRespers();

    int getPulse();

    boolean isResponsive();

    boolean isTriaged();

    String getTriage();

    void setTriage(String newTriage);
}
