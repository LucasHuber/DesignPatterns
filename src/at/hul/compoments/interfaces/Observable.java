package at.hul.compoments.interfaces;

public interface Observable {
    void addObserver(Observer observer);
    void informAll();
}
