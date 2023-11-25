class Clock {
    int hours = 12;
    int minutes = 0;
    void next() {
        if (hours < 0 || hours > 12){
            throw new RuntimeException();
        } else if (minutes < 0 || minutes > 59) {
            throw new RuntimeException();
        }
        if (minutes == 59 & hours == 12) {
            hours = 1;
            minutes = 0;
        } else if (minutes == 59) {
            minutes = 0;
            hours++;
        } else {
            minutes++;
        }
    }
}