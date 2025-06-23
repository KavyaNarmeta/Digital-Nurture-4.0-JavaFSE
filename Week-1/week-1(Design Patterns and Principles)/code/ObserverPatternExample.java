import java.util.*;

interface Observer {
    void update(String stock, double price);
}

interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stock;
    private double price;

    public void setStockData(String stock, double price) {
        this.stock = stock;
        this.price = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stock, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("Mobile App: " + stock + " updated to $" + price);
    }
}

class WebApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("Web App: " + stock + " updated to $" + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setStockData("AAPL", 195.25);
        market.setStockData("GOOG", 2880.90);
    }
}
