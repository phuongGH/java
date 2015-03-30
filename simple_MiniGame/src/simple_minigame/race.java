package simple_minigame;

import data.fileManager;
import data.logManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import materials.Car;
import materials.marginRoad;

public class race extends JPanel implements gamesControl {

    private ArrayList<marginRoad> Road = new ArrayList<>();
    private JPanel screen = this;
    private Car car = new Car();
    private int level;
    private int speedMainCar;
    private int speedOtherCar;
    private int timeRance;
    private long currentTime;
    private long lStart;
    private Timer timer;
    private int carNumber;
    private int ranking;
    private int code;
    private int oldCode;
    private int live;
    private HashMap hmInfo = new HashMap();
    private fileManager fm = new fileManager();
    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<Car> carsPass = new ArrayList<Car>();
    private int timeAddCar;
    private int timeAddNextCar;
    private JTextField txtInfo = new JTextField();
    private boolean isOver = false;
    ActionListener Transfer;
    private int highCode;

    private void initBase() {
        code = 0;
        level = 1;
        live = 3;

    }

    private void init() {

        if (!fm.cheackFile("src/data/rance.dat")) {
            highCode = 0;
            initBase();
            save();
        }
        loadFileInfo();
        if (live <= 0) {
            initBase();
            save();
        }
        timeRance = 60;
        carNumber = 14;
        ranking = carNumber + 1;
        timeAddCar = timeRance / (carNumber);
        timeAddNextCar = timeAddCar;
        txtInfo.setLocation(60, 140);
        txtInfo.setSize(80, 50);
        oldCode = code;
        speedMainCar = 30 + level * 2;
        speedOtherCar = speedMainCar - speedMainCar * 40 / 100 + level;
    }

    public race() {
        logManager.writeLog("Rance game");
        setSize(205, 340);
        setLayout(null);
        setOpaque(false);
        setLocation(0, 5);
        car.setLocation(80, 280);
        this.add(car);
        init();
//        addCar();
        gameLoop();
        timer = new Timer(100, Transfer);
        timer.setRepeats(true);
        timer.start();
    }

    private void save() {
        hmInfo.put("rootKey", "rance");
        hmInfo.put("level", level);
        hmInfo.put("live", live);
        hmInfo.put("code", code);
        if(code > highCode)
        {
            hmInfo.put("highCode", code);
        }
        else
        {
            hmInfo.put("highCode", highCode);
        }
        fm.writeInfo(hmInfo);
        logManager.writeLog("save file");
    }

    private void loadFileInfo() {
        hmInfo = fm.readInfo("rance");
        live = Integer.parseInt((String) hmInfo.get("live"));
        level = Integer.parseInt((String) hmInfo.get("level"));
        code = Integer.parseInt((String) hmInfo.get("code"));
        highCode = Integer.parseInt((String) hmInfo.get("highCode"));
        logManager.writeLog("load file");
        logManager.writeLog(hmInfo);
    }

    private void gameLoop() {

        Transfer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code += level;
                cheackTimeOver();
                gamesManager.getGamesManager().changeInfo();
                addRoad();
                addCar();
                checkCollision();
                passCar();
            }

        };

        lStart = System.currentTimeMillis();
    }

    private void cheackTimeOver() {
        currentTime = (System.currentTimeMillis() - lStart) / 1000;
        if (currentTime >= timeRance) {
            timer.stop();
            level++;
            if (level >= 14) {
                initBase();
                save();
                txtInfo.setText("VICTORY!");
                add(txtInfo);
                logManager.writeLog("victory");
            } else {
                txtInfo.setText("FINISH");
                add(txtInfo);
                logManager.writeLog("finish");
                save();
            }
            isOver = true;
            
        }
    }

    private void addRoad() {
        if (Road.isEmpty()) {
            addMarginRoad();
        }
        if (Road.get(Road.size() - 1).getLocation().y >= 15) {
            addMarginRoad();
        }

        for (int i = 0; i < Road.size(); i++) {
            Road.get(i).setLocation(Road.get(i).getLocation().x, Road.get(i).getLocation().y + speedMainCar);
            if (Road.get(i).getLocation().y > 345) {
                Road.remove(Road.get(i));
            }
        }
    }

    private void addMarginRoad() {
        marginRoad m = new marginRoad();
        m.setLocation(5, -60);
        screen.add(m);
        Road.add(m);
//                numberMarginRoad++;
    }

    private void addCar() {
        if (currentTime == timeAddNextCar) {
            if (cars.size() < carNumber) {
                Car c = new Car();
                Random rand = new Random();
                int r = rand.nextInt(3);
                int r1 = rand.nextInt(5);
                int r2 = rand.nextInt(5);
                boolean twoCar = false;
                if (r1 == 1) {
                    if (cars.size()<carNumber-1) {
                        twoCar = true;
                    }
                }
                System.out.println("random r " + r);
                System.out.println("random r1 " + r1);
                if (r == 0) {
                    c.setLocation(25, -62);
                    if (twoCar) {
                        Car c1 = new Car();
                        c1.setLocation(80, -20 * r2);
                        screen.add(c1);
                        cars.add(c1);
                    }
                }
                if (r == 1) {
                    c.setLocation(80, -62);
                    if (twoCar) {
                        Car c1 = new Car();
                        c1.setLocation(135, -20 * r2);
                        screen.add(c1);
                        cars.add(c1);
                    }
                }
                if (r == 2) {
                    c.setLocation(135, -62);
                    if (twoCar) {
                        Car c1 = new Car();
                        c1.setLocation(25, -20 * r2);
                        screen.add(c1);
                        cars.add(c1);
                    }
                }
                screen.add(c);
                cars.add(c);
                timeAddNextCar = (cars.size() + 1) * timeAddCar;
            }
        }
    }

    private void checkCollision() {
        cars.stream().forEach((car1) -> {
            if (car.hitTestObject(car1)) {
                timer.stop();
                live--;
                code = oldCode;
                save();
                txtInfo.setText("GAME OVER");
                add(txtInfo);
                isOver = true;
                logManager.writeLog("game over");
            }
            car1.setLocation(car1.getLocation().x, car1.getLocation().y + speedOtherCar);
        });
    }

    private void passCar() {
        cars.stream().forEach((car1) -> {
            int isPass = 0;
            for (int i = 0; i < carsPass.size(); i++) {
                if (car1.equals(carsPass.get(i))) {
                    isPass = 1;
                }
            }
            if (isPass == 0) {
                if (car.getLocation().y < car1.getLocation().y) {
                    ranking--;
                    carsPass.add(car1);
                    code += 100;
                }
                car1.setLocation(car1.getLocation().x, car1.getLocation().y + speedOtherCar);
            }
        });
    }

    private synchronized void removeAllObj() {
        remove(txtInfo);
        for (int i = 0; i < Road.size(); i++) {
            remove(Road.get(i));
        }
        Road.clear();
        for (int i = 0; i < cars.size(); i++) {
            remove(cars.get(i));
        }
        cars.clear();

    }

    @Override
    public void leftClick() {
        if (car.getLocation().x > 25) {
            car.setLocation(car.getLocation().x - 55, car.getLocation().y);
        }
    }

    @Override
    public void rightClick() {
        if (car.getLocation().x < 135) {
            car.setLocation(car.getLocation().x + 55, car.getLocation().y);
        }
    }

    @Override
    public void downClick() {
    }

    @Override
    public void upClick() {
    }

    @Override
    public void okClick() {
        if (isOver) {
            removeAllObj();
            init();
            addCar();
            gameLoop();
            timer.setRepeats(true);
            timer.start();
        }

    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int getRanking() {
        return ranking;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getLive() {
        return live;
    }

    @Override
    public int getHighCode() {
        return highCode;
    }

}
